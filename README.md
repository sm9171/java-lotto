# 로또

* [x] 1단계: 문자열 덧셈 계산기
* [x] 2단계: 로또(자동)
* [ ] 3단계: 로또(2등)
* [ ] 4단계: 로또(수동)



## 3단계 로또(2등)

### 기능 요구사항

- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- **java enum을 적용해 프로그래밍을 구현한다.**
- **규칙 8: 일급 콜렉션을 쓴다.**
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.

### 기능분석

LottoNumber

* LottoNumber 는 1에서 45사이의 값을 받아 자신을 생성할 수 있다.
* LottoNumber 는 1에서 45사이의 값과 보너스 유무를 받아 자신을 생성할 수 있다.

Lotto

* Lotto 는 자동번호로 자신을 생성할 수 있다.
* Lotto 는 6개의 번호를 받아 자신을 생성할 수 있다.

LottoResult

* LottoResult 는 6 개의 일반 번호와 1개의 보너스 번호로 자신을 생성할 수 있다.
* LottoResult 는 Lotto 와 비교하여 일반번호 중 몇개가 일치하는지 반환할 수 있다.
* LottoResult 는 Lotto 와 비교하여 보너스 번호를 가지고 있는지 반환할 수 있다.

Prize

* Prize 는 맞춘개수와 보너스 여부를 판단하여 알맞은 상금을 반환할 수 있다.

Wallet

* Wallet 은 돈을 입력 받아 자신을 생성할 수 있다.
* Wallet 은 Lotto 를 여러장 구매할 수 있다.
* Wallet 은 LottoResult 와 Prize 파라미터로 받아 Prize 에 해당하는 결과의 수를 반환할 수 있다.

Money

* Money 는 0원을 기본으로 자신을 생성할 수 있다.
* Money 는 다른 Money 로 나는 몫을 반환할 수 있다.





## 2단계 로또

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능분석

Bag

 * 가방은 돈을 저장 할 수 있다. (돈을 입력 받는다)
 * 가방은 최대한 많이 로또를 구매할 수 있다. (로또 한장당 가격을 입력 받는다)
 * 가방은 로또를 살 돈이 충분하지 않으면 로또 구매가 불가능하다
 * 가방은 로또의 당첨 결과를 알 수 있다. (당첨번호를 입력 받는다)
 * 가방은 총 수익을 계산할 수 있다. (각 등수의 금액과 당첨번호를 입력 받는다)

Lotto

 * 로또는 랜덤번호로 로또를 생성할 수 있다.
 * 로또는 수동번호로 로또를 생성할 수 있다.
 * 로또는 당첨로또와 비교하여 몇개 맞추었는지 계산할 수 있다.

LottoNumber

* 로또번호는 1이상 45이하의 범위를 갖는다.

LottoResult

* 로또와 당첨로또를 인자로 받아 결과를 저장해 놓을 수 있다.
* Prize 를 입력받아 몇장의 로또가 해당 Prize 에 당첨되었는지 반환한다.
* 로또 하나하나가 당첨된 금액을 모두 더한 금액에 총 로또 수를 나눈값

Prize

* 각 등수에 대한 정보를 static 하게 사용할 수 있다.
* 각 등수는 순서를 갖는다.

Money

 * 돈은 자신을 생성할 수 있다.
 * 돈은 다른 돈에서 자신의 돈을 뺄 수 있다.
 * 돈은 가중치와 다른 돈의 곱의 값에서 자신의 돈을 뺄 수 있다.





## 1단계 문자열 덧셈 계산기

### 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항

- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

### 기능 분석

* Null 또는 공백의 입력이 들어왔을 때 결과로 0을 리턴해야한다.
* 하나의 숫자만 들어왔을 때 결과로 그 숫자를 리턴해야한다.
* 다수의 숫자가 들어왔을 때 정상적인 덧셈 결과를 리턴하는지
* 음수 또는 숫자이외의 문자가 들어왔을 때 결과로 ERROR 를 발생시켜야한다.
* 정상적인 커스텀 구분자를 사용하는 경우 덧셈 결과를 리턴해야한다.
* 비정상적인 커스텀 구분자를 사용하는 경우 ERROR 를 발생시켜야한다.