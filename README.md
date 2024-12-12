# java-convenience-store-precourse
---
# 🎯 구현 기능 목록
<details>
<summary>일반</summary>

- [x] 법정 공휴일 정보 읽어서 요일 정보 업데이트 하기
- [x] 요일 정보와 순번 정보를 토대로 근무표 작성하기

</details>

<details>
<summary>입출력</summary>

- [x] 월과 시작 요일 입력
  - [x] 검증, 재입력
- [x] 평일 순번, 휴일 순번 입력
  - [x] 검증, 휴일 틀려도 평일부터 재입력


</details>

---
# 📚 클래스 구조
### MVC Pattern
store
- Application.java
- controller
  - OncallController
- domain
  - Month
- model
  - OncallTable
- util
    - ERROR_MESSAGE
    - FILE_CONSTANT
    - DAY_CONStANT
    - NUMBER_CONSTANT
    - OTHER_CONSTANT
    - OUTPUT_MESSAGE
    - REGEX_PATTERN
- view
    - OutputView.java
    - UserInputView.java
    - FileInputView
- hollydays.md
  - 법정 공휴일 정보
---
# 🔧 예외 처리 테스트 케이스

## 1. Application

<details>
<summary>Application</summary>

- [x] 
- [x] 

</details>


## 2. Domain

<details>
<summary>CustomerTest</summary>

- [x] 


</details>


## 3. Service

<details>
<summary>ConvenienceStoreTest</summary>

- [x] 

</details>

---

# 💻 사용 방법

### 1. 시작
- 재고와 함께 구매할 상품명과 수량 입력을 요구하는 문구가 출력된다.

### 2. 사용자 입력 - 주문
- 주문을 입력한다.

---

# ✅ 프로젝트 체크 사항

## 1. 공통 피드백
<details>
<summary>
1, 2, 3주차 공통 피드백
</summary>

- [x] 요구 사항을 정확하게 준수한다.
- [x] 기본적인 Git 명령어를 숙지한다.
- [x] Git으로 관리할 자원을 고려한다.
- [x] 커밋 메시지를 의미 있게 작성한다.
- [x] 커밋 메시지에 이슈 또는 풀 리퀘스트 번호를 포함하지 않는다.
- [x] 풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다.
- [x] 오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
- [x] 이름을 통해 의도를 드러낸다.
- [x] 변수, 클래스, 메서드 이름을 축약하지 않는다.
- [x] 공백을 의미 있게 사용하고, 스페이스와 탭을 혼용하지 않는다.
- [x] 의미 없는 주석을 달지 않는다.
- [x] 코드 포매팅을 사용한다.
- [x] Java에서 제공하는 API를 적극 활용한다.
- [x] 배열 대신 컬렉션을 사용한다.
- [x] README.md를 상세히 작성한다.
- [x] 기능 목록을 재검토하고 업데이트한다.
- [x] 값을 하드 코딩하지 않는다.
- [x] 구현 순서를 상수, 멤버 변수, 생성자, 메서드 순으로 한다.
- [x] 변수 이름에 자료형을 포함하지 않는다.
- [x] 한 메서드가 한 가지 기능만 담당하게 한다.
- [x] 메서드가 한 가지 기능을 하는지 확인하는 기준을 세운다.
- [x] 테스트를 작성하는 이유를 정리한다.
- [x] 처음부터 큰 단위의 테스트를 만들지 않는다.
- [x] 메서드 라인에 대한 기준도 적용한다.
- [x] 예외 상황에 대해 고민한다.
- [x] 비즈니스 로직과 UI 로직을 분리한다.
- [x] 연관성이 있는 상수는 static final 대신 Enum을 활용한다.
- [x] final 키워드를 사용해 값의 변경을 막는다.
- [x] 객체의 상태 접근을 제한한다.
- [x] 객체 데이터를 외부에서 처리하는 것이 아니라, 객체가 자신의 데이터를 스스로 처리하도록 한다.
- [x] 함수화를 통해 객체의 수를 줄이기 위해 노력한다.
- [x] 테스트 코드도 리팩터링한다.
- [x] 테스트를 위해 접근 제어자를 바꾸거나, 테스트만을 위한 메서드를 추가하지 않는다.
- [x] private 함수를 테스트하고 싶다면 클래스 분리를 고려한다.

</details>


## 2. 피어 리뷰 피드백

<details>
<summary>
README.me
</summary>

- [x] 입력값에 대한 상세한 조건을 추가적으로 기록하였는가?
- [x] 사용방법을 상세하게 명시하였는가?
- [x] 프로젝트의 전체적 구조를 명시하였는가?
- [x] 구체적인 테스트 케이스를 명시하였는가?
- [x] `<details>`, `<summary>` 를 통해 토글 형식을 사용하였는가?
- [x] 이모티콘을 사용해 이쁘게 꾸몄는가?
</details>

<details>
<summary>리팩토링(주석)</summary>

- [x] given/when/then 주석을 사용하였는가?
- [x] 불필요한 주석없이 함수명으로 기능을 알 수 있는가?

</details>

<details>
<summary>리팩토링(분류)</summary>

- [x] 메인 비즈니스 로직이 여러 개일 경우 service 모듈을 도입하였는가?
- [x] View도 Input, Output 구분하였는가?
- [x] 에러 메시지를 enum 또는 클래스로 관리하였는가?
- [x] 테스트 코드를 클래스를 나누어 관리하였는가?
- [x] 테스트 코드를 모듈별로 작성하였는가?

</details>

<details>
<summary>리팩토링(디테일)</summary>

- [x] 최대한 세밀하게 함수화 하였는가?
- [x] 안내문(print) 등을 상수로 표현하여 내부 enum으로 관리하였는가?
- [x] 매직넘버를 모두 상수화하였는가?

</details>

## 3. 2024 우아콘 피드백
<details>
<summary>BE 세션</summary>

- [x] 각 변수와 함수들의 스펙을 사전 형식으로 명시하였는가?
- [x] Getter Setter를 지양하였는가?
- [x] 개발 과정에서 패키지를 적절히 분할하였는가?

</details>