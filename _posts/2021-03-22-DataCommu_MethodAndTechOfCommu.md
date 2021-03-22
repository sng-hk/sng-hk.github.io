---
title: "데이터 통신 - 정보전송 방식과 기술"
layout: single
classes: wide
---
  
**지난수업 :**  
정보 통신 시스템의 정보처리파트에 대해서 자세하게 살펴봤다.  
컴퓨터 하드웨어 관점에서 컴퓨터 구조, 컴퓨터 설계에 대한 내용.  
CPU, 메모리 등 하드웨어에 대한 부분을 봤고, 정보처리 시스템에서  
데이터의 역할, 데이터 베이스, 운영체제 및 소프트웨어에 대해서 간단하게 살펴봤다.  
  
**이번 내용:**  
정보 전송 중에서도 데이터 전송 방식, 원리, 기술  
컴퓨터 용어들은 다소 생소하기 때문에 반복해서 익힐 것.  
  
---  
  
정보 전송 시스템에 대한 내용을 기반으로 이번 수업 진행  
  
  
다양한 형태의 데이터들을 실제로 보낼 때는 전기 신호로 변환하여 송신한다.  
반대로 받을 때에는 복조 과정을 거쳐 디지털 신호로 입력한다.  
  
교과서에 나온 그림은 일반적으로 PC에서가 아닌 초기에 메인프레임 컴퓨터의 형태이다.  
  
## 1. 정보 전송 개요  
  
### 정보 전송 방식과 기술  
전송 매체(동축 케이블, 주파수 등)를 사용해 데이터를 전송할 때 한 번에 많은 사용자  
제한적인 전송 선로를 사용하기때문에 전송 매체를 공유해야함.  
데이터를 전송할 때 신호가 감쇄되고, 잡음이 생긴다. 이것을 최소화해야한다.  
-> 정보 통신의 기본 : 신속하고 정확하게 정보를 주고받아야한다.   
  
\- **정보 전송 방식**  
- 통신 회선 구성 방식  
- 통신 회선 교환 방식  
- 통신 회선 이용 방식   
- 통신회선망(통신 회선을 여러개 엮은 것)의 구성 방식  
- 데이터의 전송 방식  
- 데이터 전송 방식  
- 캐스팅 모드(방송)의 전송 방식  
  
\- **정보 전송 기술**  
- 정보 전송의 부호화 (Encoding)  
- 정보 전송의 변조 (Modulation, deModulation)  
- 정보 전송의 다중화 (Multiplexing)  
  
## 2. 정보 전송의 기본 요소  
  
### 신호  
  
\- **아날로그 신호**  
- 전압값이 여러개이면서 연속적으로 변하는 신호  
- 주기 신호(우리가 배울 것) 와 비주기 신호로 분류.  
**진폭** : 신호의 크기나 세기. 단위는 `V(볼트)`이다.  
Sin파가 x축으로부터 가장 멀리 떨어진 값. ASin(X)파에서 진폭값은 A이다.  
  
**주파수** : 단위 시간당 사이클을 반복하는 횟수. 단위는 `Hz(헤르츠)`이다.  
1초당 Sin파가 몇 번 진동했는지  
  
**위상** : 임의의 시간에 반송파 사이클의 상대적인 위치. 단위는 `'(도)`를 사용  
Sin(X) 과 Sin(X-2𝝅)는 진폭과 주파수가 같더라도 위상이 다르다고 말한다.  
  
\- **디지털 신호**  
- 이산 신호, 불연속적으로 변하는 신호. 물리량을 유한한 숫자로 표현  
- 아날로그 신호를 디지털화 할 경우 시간 또한 디지털화 필요  
- Hz 단위는 디지털 주파수에서 사용할 때와 아날로그 주파수에서 사용할 때 다른 의미이다.  
  
### 통신 속도  
신호 속도, 전송 속도, 변조 속도로 분류  
신호 속도, 전송 속도는 거의 같은 개념을 쓰인다.  
  
  
\- **데이터 신호 속도**  
1초 동안 전달되는 비트의 수로, 전송속도를 나타냄.  
단위는 bps(bit per sec) 사용.  
  
\- **데이터 전송 속도**  
단위 시간(초, 분, 시간)에 전송되는 데이터 양(바이트, 문자, 블록, 패킷)  
단위는 자/분 (분당 몇 자를 전송했는지) 를 자주 사용.  
  
\- **변조 속도**  
보통 전송 신호는 한 신호당 한 비트를 표현하고 있다.  
어떤 경우에는 신호 하나당 두비트, 세비트를 포함할 수 있다.  
신호의 진폭을 달리하면 두비트 이상을 포함할 수 있다.  
**신호 레벨을 4개로 하면 신호 하나를 두비트로 표현하므로 7개의 신호를 보냈지만 14비트를 보냈다 !**  
  
단위는 보(Baud) 를 사용. (baud = bps(초당 전달되는 비트수)/단위 신호당 비트수)  
  
\- **전송 효율**  
통신선의 사용 효율  
전송 효율 = 순수 정보 비트수/전송된 총 비트수 * 100  
ex. 수업 시간 1시간 중 출석 5분, 수업진행 55분 -> 전송효율 = 55/60  
  
동기 전송은 비동기 전송보다 전송 효율이 높음. 아래에서 자세하게 다룰 예정
  
  
\- **통신 용량(전송 용량)**  
전송 채널을 이용해 `오류 없이 전송할 수 있는 최대 속도`  
단위는 bps. 대역폭, 신호 전력, 채널 잡음과 관련이 있다.  
통신 효율성을 얘기할 때 자주 사용.  
  
\- **오류율**  
전화 중 가끔 잡음이 생길 때 그것을 오류라고 부름.  
장애의 주요 형태  
**1. 신호 감쇄** : 먼 곳까지 전송할 때 거리가 멀어질수록 전자적 신호의 세기가 점차 약해지는 현상.   
전송로선에 신호가 약해지는 시점에 증폭기를 설치해 다시 원래 신호로 복원해주는 역할을 함.  
**2. 지연 왜곡** : 전송매체를 이용해 전달하는 신호의 속도가 주파수에 따라 차이가 나는 현상  
속도에 따라서 지연이 되고, 신호가 왜곡된다. 광 케이블로 가다가 동축 케이블을 이용할 때  
신호가 일부 지연될 수 있다.  
**3. 잡음** : 본래 신호가 자기장의 영향을 받아 신호가 바뀜.  
  
적절한 오류율은 10^-5 ~ 10^-6
  
|종류|식|  
|---|---|  
|비트 오류율|오류가 발생한 비트 수 / 전송된 총 비트 수|  
|블록 오류율|오류가 발생한 블록 수 / 전송된 총 블록 수|  
|문자 오류율|오류가 발생한 문자 수 / 전송된 총 문자 수|  
  
## 3. 정보전송 방식  
  
### 통신 회선의 구성 방식  
통신회선은 물리 매체(전송회선)와 전송 장치(모뎀)에 연결하는 통신회선의 개수에 따라 분류  
  
\- **2선식, 4선식**  
- **2서식(2W, 2Wire)**  
신호선과 공통 접지선이 선 2개로 구성  
양방향 통신에서 위아래로 전송할 때 동일한 전송로 사용  
양방향 통신은 가능하지만, 동시에는 불가능  
ex. 방송망 (방송국->가정 o, 가정 -> 방송국 x)  
  
  
\- **4서식(4W, 4Wire)**  
신호선과 공통 접지선이 선 4개로 구성  
양방향 통신에서 위아래로 전송할 때 별도의 전송로 사용  
동시에 양방향 통신 가능  
  
### 통신회선의 접속 방식  
DTE 사이 회선을 실제로 어떻게 연결할 것인가?  
  
\- **점-대-점 회선 방식 (Point to Point)**  
- 컴퓨터 시스템과 단말기의 **전용회선으로 직접 연결**  
- 응답 속도가 빨라 주로 고속 처리에 이용  
- 전화회선을 구성하는 데도 이용  
  
\- **다지점 회선 방식 (multipoint line)**  
- 컴퓨터 시스템에 연결된 전송회선 1개에 단말기 여러개 연결  
  
단말기에서 동시에 컴퓨터로 데이터를 전송할 때 신호가 섞이는 문제를 해결하기 위한 약속  
  
**풀링 (Pulling)**  
단말기에서 컴퓨터로 데이터를 전송할 때 사용  
풀링의 주체 : 컴퓨터. 컴퓨터가 제어함.  
  
**선택 (Seletion)**  
컴퓨터에서 특정 단말기를 지정하여 데이터를 전송할 때 사용  
선택의 주체 : 컴퓨터. 컴퓨터가 제어함.  
  
**경쟁 (Contention)**
단말 장치가 서로 경쟁하면서 회선에 접근하는 방법  
에러가 많이 생김.  
풀링과 선택의 차이에 중점. 두 행위 모두 제어의 주체가 컴퓨터이다.  
  
\- **집선 회선 방식 (line concentration line)**  
**단말기의 회선이 저속으로 전송되고 회선 사용률(효율성)이 낮을 때 적합하다.**  
가끔 학교로 전화하는데 안받는 이유..? 입구 회선에 전송되는 데이터보다 집선 장치에서 출구 회선의  
개수가 더 적기 때문  
  
  
\- **회선 다중 방식 (Line Multiplexing)**  
일정한 지역에 있는 단말기 여러 대를 그 지역의 중심 부분에 있는 다중화 장치에 연결하고,  
**다중화 장치와 컴퓨터 사이는 대용량 회선(속도도 빠르고, 대역폭도 넓은 걸로 사용)으로 연결**한다.  
**회선 사용률이 비교적 높은 단말기에서 데이터를 송수신 할 때**도 적용 가능하다.  
  
  
### 통신 회선의 교환 방식  
점대점 회선 방식으로 전용회선으로 직접 연결하는 경우,  
먼 거리의 사용자들 간에 통신을 하려면 비용이 많이 드는 회선을 여러 개 깔아야한다.  
모든 사람에게 회선을 까는 것은 비효율적이기 때문에 회선을 공유해서 사용해야한다. -> **교환 방식**  
  
**교환 회선과 비교환 회선 방식으로 분류한다.**  
  
  
* **교환회선 방식**  
단말 장치끼리 교환기 등을 이용하여 접속  
`회선 교환 방식`과 `축적 교환 방식`으로 나뉨  
  
\- **회선 교환 방식 (Circuit-Switched)**  
사용자가 직접 전화기 번호판을 눌러 Dial 전화망으로 상대방을 호출하고 연결  
(회선 교환기 사용)  
  
\- **축적 교환 방식 (Store and Forward Switching)**  
교환기를 이용하여, 정보를 메시지나 패킷 단위로 저장 및 전송  
(패킷 교환기 사용)  
  
  
* **비교환회선 방식**  
단말 장치끼리 직통회선을 연결하여 사용.  
직통형, 배급형, 분기형, 집중형, 분할 다중형, 루프형

\- 직통형 : 단말과 단말을 1:1로 연결  
\- 집중형 : LAN 에서 자주 사용 (local Area Network)  
\- 루프형 : LAN 에서 자주 사용  
  
### 통신 회선의 이용 방식  
  
|구분|방향|선로|사용 예시|  
|---|---|---|---|  
|단일(단방향) 방식|한쪽은 송신만, 한쪽은 수신만 가능|2선식|라디오,TV (방송)|  
|반이중 방식|양방향 통신은 가능하나, 동시에 송수신은 불가능|팩스,휴대용 무전기|  
|전이중 방식|동시에 양방향 송수신 가능|4선식|전화, 컴퓨터 통신에서 주로 사용|  
  
### 통신 회선망(네트워크)의 구성 방식  
  
*  **트리형**  
데이터 분산처리 시스템에 사용하면 효율적  
  
*  **버스형**  
통신회선 하나(버스)에 각 노드가 분기 접속된  
  
* **성형**  
하나의 중앙 노드를 중심으로 단말 노드가 일대일  
중앙 노드에 오류 등 장애가 발생하면, 시스템 전체에 영향을 미침  
  
* **링형**  
이웃하는 단말끼리 연결  
  
* **망형**  
통신 회선에서 오류가 발생하면 다른 경로를 이용하기 때문에  
분산된 자원을 공유하기 쉽다.  
  
  
  
### 데이터 전송 방식  
(`직렬 전송과 병렬 전송` 용어 이해하기!)  
  
- **직렬 전송**  
데이터 최소 요소인 문자 하나를 구성하는 각 비트를 전송선로 1개를 이용하여 차례로 전송하는 방식  
컴퓨터 하드웨어끼리는 워드단위로 병렬전송을 한다. (CPU - 메모리 병렬 전송)  
하지만, 통신에서는 먼 거리에서 하는 경우에서는 병렬 전송이 어렵다.  
전송회선 1개로도 송수신 측이 서로 통신할 수 잇어 대부분의 데이터 통신 시스템에서 사용한다.  
비용이 적게 들고, 설치 방법이 간단해서 장거리 통신에 많이 사용한다.  
  
- **병렬 전송**  
문자를 구성하는 각 비트를 전송선로 7-8개를 이용해 동시에 전송한다.  
전송속도가 빠르고 단말기와도 쉽게 연결할 수 있어서 편리하다.  
컴퓨터와 하드디스크를 연결하거나 컴퓨터와 측정 장치를 연결할 때 주로 사용한다.  
프린터 연결 시에도 병렬핀을 연결하여 사용할 수 있다.  
  
- **비동기식 전송과 동기식 전송**  
모두 동기화하는 방식이다.  
  
데이터를 전송할 때, Sender는 보낼 준비를 하고, Reciever는 받을 준비를 한 상태를  
동기화라고 얘기한다.  
  
**비동기식 전송**  
동기화하는 방식이 블록 단위가 아닌 `문자 단위`이다.  
**시작 비트(동기화 비트)** : 1비트로 구성, 논리는 0. 수신자가 받을 준비를 하도록 주목함.  
**데이터 비트** : 5-8 비트 크기의 전송할 데이터 비트  
**패리티 비트** : 짝수 패리티, 홀수 패리티 or 둘 다 사용x  
**정지 비트** : 1비트, 1.5비트 2비트 중 하나를 사용  
  
한 문자를 보내려고하면 8비트의 데이터비트와 3비트의 시작,패리티,정지 비트를 더한 11비트를 사용함.  
30%정도의 비효율이 나옴. ->**효울성이 떨어진다**  
  
  
**동기식 전송**  
  
  
---  
  
요약:  
  
정보전송 시스템의 기본 원리 이해 :   
단말, 신호변환 장치, 회선, 통신 제어장치, 컴퓨터 시스템(메인프레임)  
  
정보전송 방식의 이해:  
통신회선의 구성 방식, 교환 방식, 이용 방식  
통신회선망의 구성 방식, 데이터 전송 방식  



