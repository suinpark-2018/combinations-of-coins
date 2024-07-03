# 동전 조합으로 합계 만들기

<br>

## 기능 요구사항
- 서로 다른 종류의 통화를 나타내는 N 크기의 coin[] 정수 배열과 정수 합계가 주어졌을 때, coin[]의 다양한 조합을 사용하여 합계를 만드는 방법의 수 구하기
  - 각 유형의 동전이 무한정 공급된다고 가정

<br>

### 입출력 결과
#### 입력
- 정수 배열은 space( ) 또는 comma(,) 로 기준으로 구분
```
합계를 입력하세요: 4
동전 배열을 입력하세요 (Ex. 1 2 3 or 1,2,3): 1 2 3
```
#### 출력
- 정수 합계 및 배열 입력 값
```
입력: 합계 = 4, coins[] = [1, 2, 3]
```
- 합계를 구하는 숫자 조합 개수
```
출력: 4
```
- 합계를 구하는 숫자 조합 목록
```
설명: 4가지 솔루션이 있습니다.
[1, 1, 1, 1]
[1, 1, 2]
[1, 3]
[2, 2]
```

#### 실행 결과 예시
```
합계를 입력하세요: 4
동전 배열을 입력하세요 (Ex. 1 2 3 or 1,2,3): 1 2 3

입력: 합계 = 4, coins[] = [1, 2, 3]
출력: 4
설명: 4가지 솔루션이 있습니다.
[1, 1, 1, 1]
[1, 1, 2]
[1, 3]
[2, 2]
```

<br>

## 기술 스택
#### Programming Language
- Java SDK 20

#### IDE
- Intelli J

#### Version Control Systems
- Git
- Github

<br>

## Commit Message Convention
### 규칙
```
- 제목 첫글자는 대문자 사용
- 제목 마침표 미포함
- 제목과 본문은 빈 행으로 구분
- 제목 명령문으로 작성
- 제목 50자 이내로 간결하게 작성
```

### 유형
```
[Feat]        :     새로운 기능 추가
[Test]        :     테스트 코드 완료
[Docs]        :     문서 추가 또는 수정 (ex. README 변경)
[Chore]       :     패키지 매니저(ex. gitignore 수정), 빌드 업무 수정 
[Refactor]    :     리팩토링, 코드 개선
[Fix]         :     버그 수정
[Style]       :     코드 스타일 변경 (포맷팅, 세미콜론 누락 등 코드 변경이 없는 경우)
[Comment]     :     주석 추가 및 수정
[Rename]      :     파일 또는 폴더명을 수정하거나 이동하는 작업만 수행한 경우
[Remove]      :     파일을 삭제하는 작업만 수행한 경우
[Conflict]    :     합병 시 발생한 충돌 수정
```
