---
title:  "Java 자료구조 - 스택과 큐"
layout: single
classes: wide
tags : [자료구조]
---
  
## 스택  
**Last-In First-Out**  
  
스택은 데이터를 일시적으로 저장하기 위해 사용하는 자료구조로,  
데이터의 입력과 출력 순서가 후입선출이다.  
스택에 데이터를 넣는 작업을 푸시,  
스택으로부터 데이터를 꺼내오는 작업을 팝이라고 한다.  
  
스택은 실생활에서 접시 그릇을 차곡차곡 쌓아둔 모습에 비유할 수 있다.  
  
![image](https://user-images.githubusercontent.com/61813239/114713814-7632c680-9d6c-11eb-9e26-d36e2192eb6c.png)  
  
### 스택의 활용 예시  
  
폰노이만 아키텍쳐 즉, 프로그램 내장식 컴퓨터를 설계할 때,  
CPU 안에 스택을 두어 이용해서 폰노이만 병목에서  
발생하는 트래픽을 효과적으로 줄이는 방법이 있다.  
  
프로시저 호출을 위해 범용 레지스터를 사용하지 않고  
스택을 활용하여 프로시저를 중첩호출 하는 방법도 스택의 활용 예이다.  
  
스택을 활용한 함수의 중첩 호출과정을 살펴보자.  
  
![image](https://user-images.githubusercontent.com/61813239/114714212-d88bc700-9d6c-11eb-93d9-7fb6aa715d8a.png)  
  

```
class Main {
    static void main(String[] args) {
        A();
        D();
    }

    static void A() {
        B();
        ...
    }

    static void B() {
        C();
        ...
    }

    static void C() {
        ...
    }

    static void D() {
        ...
    }
}
```
  
A() 호출  
스택의 최상위에는 B()를 호출하는 명령어(A() call) 다음으로 실행할 명령어의 위치를 담는다.  
  
B() 호출  
A() 에서는 B()를 호출한다.  
따라서 스택의 최상위에는 B()를 호출하는 명령어 다음으로 오는 명령어의 위치를 담는다.  
  
B() return  
B() 실행을 모두 마치고 복귀할 때에는 스택 최상위에 담겨있던 A()에서 B()를 호출한 부분 다음으로 오는 명령어를 실행한다.  
  
A() return  
A()의 호출이 끝났으므로, 스택 최상위에 담겨있는 A()를 호출하는 명령어 다음에 오는 명령어를 실행한다.  
  
* **후위 표기법**  
  
연산자를 피연산자 뒤에 표기하는 방법 예) AB+  
중위표기법의 수식을 후위표기법으로 변환하는 방법을 알아보자.  
수식 A\*B-C/D를 후위 표기법으로 변환하면,  
1\) 수식의 각 연산자에 대해서 우선순위에 따라 괄호를 사용하여 다시 표현한다.  
((A*B)-(C/D)  
  
2\) 각 연산자를 그에 대응하는 오른쪽 괄호의 뒤로 이동시킨다.  

```
((AB)*(CD)/)-
```
  
3\) 괄호를 제거한다.  
```
AB*CD/-
```
  
우리가 일반적으로 사용하는 표기법은 **중위 표기법**`(A*B-C/D)`이지만,  
컴퓨터 내부에서 수식을 처리하기에 가장 효율적인 방법은 **후위 표기법**이다.  
후위 표기법을 사용하면 괄호나 연산자 우선순위를 따로 처리하지 않고  
왼쪽에서 오른쪽으로 표기된 순서대로 처리할 수 있다.  
  
우리가 컴퓨터에 중위 표기법 형태의 수식을 입력하면 컴퓨터 내부에서는  
효율적인 처리를 위해 스택을 사용하여 입력된 수식을 후위 표기법으로 변환하게 된다.  
  
컴퓨터 내부에서 후위 표기법의 수식을 연산할 때도 스택을 사용할 수 있다.  
스택을 사용하여 수식을 계산하는 방법은,  
  
1\) 피연산자를 만나면 스택에 삽입한다.  
2\) 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 연산하고  
3\) 연산 결과를 다시 스택에 삽입한다.  
4\) 수식이 끝나면, 마지막으로 스택을 pop하여 출력한다.  
    
**실행과정**  

```
// 피연산자를 만나면 스택에 삽입한다.
push A
push B

// 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 연산하고
pop A
pop B
mul A B 

// 연산 결과를 다시 스택에 삽입한다.
push (A*B)

// 피연산자를 만나면 스택에 삽입한다.
push C
push D

// 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 연산하고
pop C
pop D
div C D

// 연산 결과를 다시 스택에 삽입한다.
push (C/D)

// 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 연산하고
pop (A*B)
pop (C/D)
sub (A*B) (C/D)

// 연산 결과를 다시 스택에 삽입한다.
push ((A*B)-(C/D))

// 수식이 끝나면, 마지막으로 스택을 pop하여 출력한다.
pop ((A*B)-(C/D))
```
출처: https://ryumin13.tistory.com/entry/자료구조-스택의-응용 [진정한 프로그래머가 되길 꿈꾸며..]  

<!-- ### 스택을 배열로 구현하기

```java
import java.util.EmptyStackException;
public class ArrayStack<E> {
    private E s[]; //
    private int top;
    public ArrayStack() {
        s = (E[]) new Object[1];
        top = -1;
    }
    public int size() {return top +1;}
    public boolean isEmpty() {return (top == -1);}

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
            return s[top];
        }
    }

    public void push(E newItem) {
        if (size() == s.length) {
            resize(2*s.length);
        }
        s[top++] = newItem;
    }

    public E pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        E item = s[top];
        s[top--] = null;
        if (size() > 0 && size() == s.length/4) {
            resize(s.length/2);
        }
        return item;
    }
}

```

### 스택을 연결리스트로 구현하기

```java
public class Node<E> {
    private E item;
    private Node<E> next;
    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }

    public E getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setItem(E newItem) {
        item = newItem;
    }

    public void setNext(Node<E> newNext) {
        next = newNext;
    }
}

```

```java
import java.util.EmptyStackException;
public class ListStack <E> {
    private Node<E> top;
    private int size;
    public ListStack() {
        top = null;
        size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty() {
        return size == 0;
        }
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getItem();
    }

    public void push(E newItem) {
        Node newNode = newNode(newItem, top);
        top = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E topItem = top.getItem();
        top = top.getNext();
        size--;
        return topItem;
    }
}

``` -->
  
## 큐  
  
**FIFO,First-In, First-Out**  
큐는 스택과 마찬가지로 데이터를 일시적으로 쌓아두기 위한 자료구조이다.  
가장 먼저 넣은 데이터를 가장 먼저 꺼내는 선입 선출 구조로 되어있다.  
  
큐의 실생활에성의 활용 예로는 은행 창구나 마트 계산대에 길게 선 대기 손님들의  
모습을 예로 들 수 있다.  
  
![image](https://user-images.githubusercontent.com/61813239/114720623-23104200-9d73-11eb-850a-7bc000d67d17.png)  
  
큐에서 데이터를 넣는 작업을 인큐, 데이터를 꺼내는 작업을 디큐라고 보통 얘기한다.  
또한, 데이터를 꺼내는 쪽을 보통 front라고 얘기하고, 데이터를 넣는 쪽을 rear라고 얘기한다.  
  
### 큐의 활용 예시  
  
**너비 우선 탐색**  
  
너비 우선 탐색은 맹목적 탐색방법의 하나로 시작 정점을 방문한 후  
시작 정점에 인접한 모든 정점들을 우선 방문하는 방법이다.  
더 이상 방문하지 않은 정점이 없을 때까지 방문하지 않은 모든  
정점들에 대해서도 너비 우선 검색을 적용한다.  
  
**BFS 너비 우선 탐색 구현**  
1) 현재 노드로부터 연결된 노드들 중 방문하지 않은 노드들을 큐에 넣는다.  
2) 큐에서 가장 나중에 들어간 노드를 큐에서 빼내고 해당 노드를 방문한다.  
3) 위의 1),2) 과정을 반복한다.  
  
큐를 이용하여 코드로 구현한다.  
특정한 상황, 간선이 가중치가 없는 그래프일 경우에만 적용될 수 있다.  
즉, 노드에서 다른 노드로 가는 비용이 모든 간선에서 동일하지 않을경우에는 사용할 수 없다.  
  
![image](https://user-images.githubusercontent.com/61813239/114730221-a2a20f00-9d7b-11eb-8939-3906a7c8be3e.png)  
  
위 그림에서 너비 우선 탐색 과정은 다음과 같다.  
* 1을 큐에 넣는다.  
* 1을 큐에서 빼낸 후, 1에 방문한다.  
* 2, 3을 큐에 넣는다.  
* 2를 큐에서 빼낸 후, 2를 방문한다.  
* 4, 5를 큐에 넣는다.  
* 3을 큐에서 빼낸 후, 3을 방문한다.  
* 6,7을 큐에 넣는다.  
* 4를 큐에서 뺀다.  
* 5를 큐에서 뺀다.  
* 6을 큐에서 뺀다.  
* 7을 큐에서 뺀다.  
  
**결과적으로**  
**1-2-3-4-5-6-7 순서로 노드를 방문한다.**  

<!-- ### 큐를 구현하기

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

![image](https://user-images.githubusercontent.com/61813239/114725236-4dfc9500-9d77-11eb-9749-2ccb9556fe2e.png)


새 item 삽입 후

배열의 앞뒤가 맞닿아 있다고 생각하기 위해
배열의 rear 다음의 비어있는 원소의 인덱스(rear)는
다음과 같이 표현할 수 있다.

rear = (rear + 1) % N

N으로 나누었을 때 나오는 나머지 값을 인덱스로 설정한다.
여기서 N은 배열의 크기이다.

Ex) 만약 rear == 5, (5+1) % 6 = 0 번지로 전환

**큐가 empty일 때 문제 해결 방안**

방법 1)
item을 삭제할 때마다 큐가 empty가 되는지 검사하고,
만일 empty가 되면, front = rear = 0 을 만든다.
삭제할 때마다 isEmpty 조건을 검사하는 것은 프로그램 수행의 효율성이 저하됨
시간이 많이 걸림.


방법 2)
front를 실제의 가장 앞에 이는 item의 바로 앞의 비어있는 원소를
가리키게 한다.
배열이 n 개 라면 n-1개만 item 을 저장하는 값으로 두고,
1개는 항상 비워둔다.
Empty 가 되면, front 와 rear 가 같게 둠.

방법 2의 의도:
rear 와 front 의 값이 같다면,
그 큐는 비어있다고 판단할 수 있고,

rear + 1 과 front 의 값이 같다면,
그 큐는 꽉 찼다고 판단할 수 있다.

## 큐를 배열로 구현한 ArrayQueue 클래스

변수는 어떤 것들을 설정해야할지.
front : 큐에 담긴 노드 중 가장 나중에 담긴 요소의 인덱스를 가리킨다.
rear : 큐에 담긴 노드 중 가장 최근에 담긴 요소의 인덱스를 가리킨다.
size : 큐에 담긴 항목의 수. 배열의 수와 비교하기 위함.

Arrayqueue() // 생성자
front, rear, size 모두 0으로 초기화.
큐의 처음 크기는 2로 초기화.
```java

```


size() 메서드 // 큐에 있는 항목의 수를 리턴
isEmpty() 메서드 // 큐가 empty이면 true 리턴
```java

```
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
    if (isEmpty()) throw new NoSuchElementException(); // underflow
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

## 요약
스택은 한 쪽 끝에서만 item을 삭제하거나 새로운 item을 저장하는
후입선출(LIFO) 자료구조
스택은 컴파일러의 괄호 짝 맞추기, 회문 검사하기, 후위표기법 수식 계산,
중위 표기법 수식을 후위표기법으로 변환, 미로찾기, 트리의 노드 방문, 그래프의 깊이우선탐색.
또한 재귀호출도 스택 자료의 주요한 처리방식.

큐는 삽입과 삭제가 각각 다르다. 선입선출(FIFO)
큐를 구현하는데에 있어서 발생한 문제들을 해결하기 위한 방법 이해하고 암기.

 -->
