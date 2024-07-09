import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. 사용자로부터 합계 및 동전 배열 입력 받음

        // 1.1. 합계: 정수로 입력 받음
        // 1.1.1. 버퍼 비우기: 남아있는 줄바꿈 문자를 제거하여 이후의 입력 오류 발생 예방
        System.out.print("합계를 입력하세요: ");
        int sum = scanner.nextInt();
        scanner.nextLine();

        // 1.2. 동전 배열: 문자열로 입력 받음
        System.out.print("동전 배열을 입력하세요 (Ex. 1 2 3 or 1,2,3): ");
        String coinsInput = scanner.nextLine();

        // coins 배열 스트림으로 변환
        // 1.2.1. 문자열 앞뒤 공백 제거
        // 1.2.2. 쉼표(,) 및 공백( ) 기준으로 문자열 분리
        // 1.2.3. 문자열을 정수로 변환 (내부반복 처리를 통해 coins 배열의 모든 요소를 정수로 변환함)
        // 1.2.4. 다시 coins 스트림에서 배열로 변환
        int[] coins = Stream.of(coinsInput.trim().split("[,\\s]+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        System.out.printf("%n입력: 합계 = %d, coins[] = %s%n", sum, Arrays.toString(coins));

        // 최종 확인된 coin 조합 경우의 수 solutionCnt
        int solutionCnt = countWaysToMakeSum(sum, coins);
        System.out.println("출력: " + solutionCnt);
        System.out.printf("설명: %d가지 솔루션이 있습니다.%n", solutionCnt);

        // 경우의 수 리스트가 저장된 리스트 allCombination
        List<List<Integer>> allCombinations = getAllCombinations(sum, coins);
        for (List<Integer> combination : allCombinations) {
            System.out.println(combination);
        }
    }

    // 경우의 수를 구하는 메서드
    // 주어진 coin 유형을 가진 coins 배열과 정수 합계 sum 을 매개변수로 받아서 계산
    public static int countWaysToMakeSum(int sum, int[] coins) {
        // 1. dp 배열 초기화
        // 1.1. dp 배열: 주어진 합계(sum)를 만드는 coin 조합의 개수를 저장하기 위한 배열 dp
        // 1.2. index 가 합계를 의미하기 때문에 sum + 1 으로 지정
        int[] dp = new int[sum + 1];

        // 2. dp[0] 초기화
        // 2.1. 현재 coin 유형만 사용한 경우: 1가지
        dp[0] = 1;

        // dp[sum]: sum 을 만드는데 사용된 coin 조합 경우의 수
        // 3. sum 이라는 수를 만드는데 가능한 경우의 수를 dp 배열 내 sum 인덱스 위치에 저장
        // 3.1. 각 동전 유형별 경우의 수 확인 및 합산
        // 3.1.1. 이미 계산된 동전 유형의 경우의 수에 누적 합산
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // 3.2. 최종 카운트된 경우의 수 dp[sum] 반환
        return dp[sum];
    }

    // 매개변수로 받은 합계 및 coins 를 통해 전체 조합 리스트 반환
    // findCombinations 메서드를 사용하여 받은 조합 리스트를 전체 조합 리스트 results 에 추가
    public static List<List<Integer>> getAllCombinations(int sum, int[] coins) {
        List<List<Integer>> results = new ArrayList<>();
        findCombinations(sum, coins, new ArrayList<>(), results, 0);
        return results;
    }

    // 재귀 로직을 활용하여 조합 찾아서 results 리스트에 저장
    // 매개변수: 합계, 코인 배열, 현재 조합 리스트, 최종 결과 리스트, 탐색을 시작할 index 시작점
    private static void findCombinations(int sum, int[] coins, List<Integer> current, List<List<Integer>> results, int start) {
        // 반복문에서 sum = sum-coin[i] 으로 선언
        // 현재 조합이 주어진 sum 을 만족한 경우, 현재 조합 리스트를 results 리스트에 저장
        if (sum == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        // 1. 코인과 sum 을 비교하여 현재 조합 리스트에 추가할지 결정
        // 1.1. sum - coins[i] >= 현재 코인: 현재 조합 리스트에 추가(동전이 무한히 공급되기 때문)
        // 1.2. sum - coins[i] < 현재 코인: 다음 순서의 코인과 비교하여 조건에 맞으면 현재 조합 리스트에 추가
        // 2. 마지막에 추가한 코인 삭제하여 새로운 조합 찾기 시작
        for (int i = start; i < coins.length; i++) {
            if (coins[i] <= sum) {
                current.add(coins[i]);
                findCombinations(sum - coins[i], coins, current, results, i);
                current.remove(current.size() - 1);
            }
        }
    }

}