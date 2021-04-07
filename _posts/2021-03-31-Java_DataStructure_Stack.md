---
title:  "Java 자료구조 - 스택과 큐"
layout: single
classes: wide
tags : [자료구조]
---
## 스택


## 큐
한 줄에 일렬로 서있는 모습에 비유
먼저 온 사람이 먼저 나감

**FIFO,First-In, First-Out**

구현 하는 방법
두가지 방법 - ArrList, LinkedList
다만 ArrList(배열, 배열리스트)로 구현하는게 훨씬 더 쉽고, 일반적이다.

큐에서 삽입, 삭제가 거듭되면 큐의 item들이 배열의 뒤쪽 부분으로 편증되는
문제가 발생.
새 item들은 뒤에 삽입되고 삭제는 앞에서 일어나기 때문

방법 1)
큐의 item들을 배열의 앞부분으로 이동한다.
수행시간이 큐에 들어있는 item의 수에 비례하는 단점.
효율적이지 않은 방법이다.

**방법 2)**
배열을 원형으로, 즉, 배열의마지막 원소가 첫 원소와 맞닿아 있다고 여김

새 itm 삽입 후

배열의 앞뒤가 맞닿아 있다고 생각하기 위해
배열의 rear 다음의 비어있는 원소의 인덱스(rear)는
다음과 같이 표현할 수 있다.

mod()를 이용.

rear = (rear + 1) % N

여기서 N은 배열의 크기이다.

Ex) if rear == 5, (5+1) / 6 = 0 번지로 전환

**큐가 empty일 때 문제 해결 방안**

방법 1)
item을 삭제할 때마다 큐가 empty가 되는지 검사하고,
만일 empty가 되면, front = rear = 0 을 만든다.
삭제할 때마다 empty 조건을 검사하는 것은 프로그램 수행의 효율성이 저하됨
시간이 많이 걸림.


방법 2)
front를 실제의 가장 앞에 이는 item의 바로 앞의 비어있는 원소를
가리키게 한다.
배열이 n 개 라면 n-1개만 item 을 저장하는 값으로 두고,
1개는 항상 비워둔다.
Empty 가 되면, front 와 rear 가 같게 둠.

## 큐를 배열로 구현한 ArrayQueue 클래스

변수는 어떤 것들을 설정해야할지.
front : 
rear : 
size : 큐에 담긴 항목의 수. 배열의 수와 비교하기 위함.

Arrayqueue() // 생성자
front, rear, size 모두 0으로 초기화.
큐의 처음 크기는 2로 초기화.

size() 메서드 // 큐에 있는 항목의 수를 리턴
isEmpty() 메서드 // 큐가 empty이면 true 리턴

위 세가지는 기본적으로 갖고 있다.

add(), remove(), resize()

add() 메서드 : 삽입.
삽입할 공간 확인.
배열의 rear번째 인덱스에 neItem을

```java
public void add(E newItem) {
    if ((rear+1)%q.length == front) // 비어있는 원소가 1개뿐인 경우(즉, 큐가 full인 경우)
    // rear + 1 이 front 와 같은 위치이면 더 넣을 곳이 없다는 의미이므로.
        resize(2*q.length); // 큐의 크기를 2배로 확장
    rear = (rear + 1) % q.length;
    q[rear] = newItem;
    size++;
}
```

remove() 메서드 : 삭제
삭제하기 전, 삭제할 item이 남아있는지 확인.
front 값을 증가시킨 후, front 번째에 있는
item을 제거.

큐의 항목수가 배열 크기의 1/4인지 확인.
만약 그렇다면, 큐의 size를 절반으로 감소.

```java
public E remove() {
    if (isEmpt()) throw new NoSuchElementException(); // underflow
    front = (front+1) % q.length;
    E item = q[front];
    size--;
    if( size > 0 %% size == q.length/4) // 큐의 항목수 == 배열크기/4 이면
        resize(q.length/2)  
}

```

resize() 메서드 : 배열 크기 조절.


## 큐를 연결리스트로 구현한 ListQueue 클래스


add() 메서드 :  
```java
public void add(E newItem) {
    Node newNode = new Node(newItem, null);
    if( isEmpty()) front = newNode;
    else rear.setNext(newNode);
    rear = newNode;
    size++;
}
```

remove() 메서드 :
표현 방식은 달라도, 비슷비슷하다아..

```java

```


sort까지 4가지

### 큐 자료구조의 응용
순서대로 작업을 처리해야할 때 사용.

CPU 태스크 스케줄링 :
사용자가 먼저 해달라고 한 것부터 처리.

네트워크 프린터 :
단말이 여러대 연결된 프린터에서 먼저 요청받은 것부터 출력, 순서대로 기억해둠.

이진트리의 레벨순서 순회

그래프에서의 너비우선탐색


### 수행 시간
- 배열로 구현한 큐의 add메서드나 remove 메서드는 수행시간이 O(1)이다.
- 배열의 크기를 확대 또는 축소시키는 경우 모든 item들을 새 배열로 복사해야하므로
O(N) 시간이 소요.

- 단순연결리스트로 구현한 큐의 add와 remove 연산은 각 O(1) 시간.
삽입 또는 삭제 연산이 rear 와 front로 인해 연결리스트의 다른 노드들이 일일이 방문할
필요가 없기 때문이다.

## 데큐
데크(Double- ended Queue, Deque) : 양쪽 끝에서 삽입, 삭제를 허용하는 자료구조.
스택과 큐 자료구조를 혼합
데큐는 이중 연결리스트로 구현하는게 일반적.

데큐는 기억만 하고있자. 스택 큐 위주로.

## 요약
스택은 한 쪽 끝에서만 item을 삭제하거나 새로운 item을 저장하는
후입선출(LIFO) 자료구조
스택은 컴파일러의 괄호 짝 맞추기, 회문 검사하기, 후위표기법 수식 계산,
중위 표기법 수식을 후위표기법으로 변환, 미로찾기, 트리의 노드 방문, 그래프의 깊이우선탐색.
또한 재귀호출도 스택 자료의 주요한 처리방식.

큐는 삽입과 삭제가 각각 다르다. 선입선출(FIFO)
큐를 구현하는데에 있어서 발생한 문제들을 해결하기 위한 방법 이해하고 암기.


