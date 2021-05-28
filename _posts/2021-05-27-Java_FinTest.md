---
title: "Java - 객체모델링 시험 예상문제"
layout: single
classes: wide
tags: [Java]
---
  
# 1. 서버-클라이언트 프로그래밍  
  
## 소켓 간 연결  
서버  
자신의 IP주소, 포트번호를 묶음(bind)  
클라이언트 socket에서 connect 신호가 오기까지 기다림.  
br.readLine() : 읽어들임  
pw.println() : 보냄.  
  
클라이언트  
socket을 만들어서 기다리고 있는 서버 소켓에 connect 요청.  
데이터를 전송. pw.println()  
  
클라이언트 윈도우 작성은 이전 클라이언트 코드에서 br.readLine()을 TextArea  
pw.prinln()은 TextField의 actionLisntener에 작성  
  
### 문제 1. 서버 프로그램 분석 및 클라이언트 프로그램 작성  
  
### 문제 2. 위 문제 1 에서 작성된 클라이언트 윈도우로 제작.  
추가되는 낸용은 답안지에 기입하고, 번호로 명기.  
아래의 추가로 불필요해진 코드는 주석 처리.  
  
# 2. 스레드  
  
## 스레드  
하나의 프로세스 내에서 독립적으로 돌아가는 프로그램  
  
run() 코드 안에 원하는 동작 작성  
while(true) 작성  
안에 try - catch 문 작성  
Thread.sleep(20); 인자는 미리세컨드라 1000미리세컨드는 1초.  
  
c.start() 호출 시 run()메서드 호출  
  
### 문제 1. 다음의 프로그램 내용을 보고, 코드 내에서 \[\] 안에 들어갈 내용을 답안지에 해당 번호내에 채우시오  

### 문제 2. 위 문제에서는 Space 클래스의 main 메서드를 통해 1개의 스레드만을 생성하여 동작시켰다. 2개의 스레드를 생성하여 동작시키고자한다. 즉 아래의 main 메서드와 같이, 하나는 0.5초 간격으로 카운트하고, 다른 하나는 0.7초 간격으로 카운트르 진행하고자 한다. 라인번호를 참조하여 구현 방법을 구체적으로 설명하시오  
  
클래스에 int 타입 time 변수 선언.  
생성자로 time을 몇초로 설정할지 받아옴.  
sleep() 메서드에 리터럴을 인자로 넘겨주는게 아닌 time을 인자로 넘겨준다.  
  
### 문제   
  
# 3. 그래픽 - 스레드  
  
## Java 에서 다중상속  
  
implements 활용  
```java
class Practice extends JFrame implements Runnable {
    
}
```
## paint() 메서드  
  
repaint() 메서드를 호출하면 OS가 paint() 메서드 호출  
  
### 여러 개의 공이 벽에 튕기면 방향을 바꾸기  
  
1\)배열 이용.  
2\)java Colletion 중 Vector 또는 ArrayList. 제네릭 클래스 이용  
  
배열에 담긴 요소들에 대해 각각 명령  
1\)for문  
2\)for each 문  
  
# 4. JDBC (DB 접속)  
  
### 문제 1  
1) 테이블 내에 있는 모든 데이터를 선택하여 보이는 SQL을 작성하라  
SELECT * FROM list;  
2) 테이블에서 필드 code 가 5 이상인 데이터를 선택하되 이름과 나이만을 선택하도록하여라  
SELECT irum, nai FROM list WHERE code>=5;  
3) 테이블에서 필드 nai가 15보다 큰 경우에 대해 나이 평균을 구하여라  
SELECT AVG(nai) FROM list WHERE nai>15;  
4) 테이블에 다으 데이터를 삽입하시오.(code : 7, irum : 월매, nai : 47)  
INSERT INTO list VALUES (7, "월매", 47);  
5) code 5번의 나이를 14로 수정  
UPDATE list SET nai = 14 WHERE code = 5;  
6) 변사또의 자료 삭제  
DELETE FROM list WHERE code=1;  
  
### 문제 2  
데이터베이스에 들어있는 모든 데이터를 읽어 화면에 출력하는 프로그램이다.  

---
  
최종목적 :  
15주차 시험을 볼 때......  
소스코드를 작성함.  
착각할 수 있는 것, 프로그램을 돌려봐서 이해는 했는데  
시험볼 때 모를 수도 있다. 음. 이해하고 외우자~  