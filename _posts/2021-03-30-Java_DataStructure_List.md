---
title:  "Java 자료구조 - 리스트"
layout: single
classes: wide
tags : [자료구조]
---

## 리스트

일련의 동일한 타입의 항목들.
항목(Item) = 필드(Field)
두 용어는 같은 의미로 사용됨.
**리스트 구현 : 배열리스트, 연결리스트**

## 배열
일련의 동일한 타입의 원소들이 **연속적인** 메모리 공간에
할당되어 각 항목이 하나의 원속에 저장되는 기본적인 자료구조

자바에서 배열의 크기는 불변으로, 처음 지정하면 이후에 크기를
변경할 수 없다. 자바에서 제공하는 컬렉션 인터페이스를 구현한
ArrayList는 동적배열로 배열의 크기를 변경할 수 있다.

a : 배열 이름인 동시에 배열의 첫번째원소의 레퍼런스 저장.
a\[i] : 인덱스 i 를 가지는 원소를 가리키는 레퍼런스

Ex) int[] a :
a = new int[10];
int[] a = new int[10]; (Java)
int a[10] (C)

각 원소 a\[i] 는 a 가 가지고 있는 레퍼런스에 원소의
크기(바이트) * i 를 더하여 a[i]의 레퍼런스 계산
a\[i] = a + (원소의 크기 * i)
예 : a = 4455, 원소크기 2바이트, i = 5
-> 4455 + 2*5 = 4465

char 배열의 원소의 크기 = 2바이트
int 배열의 원소의 크기 = 4바이트

### 배열의 단점 (Overflow)
배열은 미리 정해진 크기의 메모리 공간을 할당 받은 뒤 사용해야 함.
**Overflow : 빈자리가 없어 새 항목을 삽입할 수 없는 상황.**
Overflow 가 발생하면 에러 처리를 하여 프로그램을 정지시키는 방법이 주로 사용된다.
하지만 프로그램의 안정성을 향상시키기 위해 동적 배열, 배열리스트(Array List)를 사용.

## 배열리스트

### 동적 배열 할당 정책
배열에 overflow가 발생하면, 배열 크기를 2배로 확장한다.
배열의 3/4 가 비어 있다면, 배열 크기를 1/2로 축소한다.

### 배열 리스트
특정 원소에 **접근**할 때에는 배열의 인덱스를 이용하여
O(1) 시간에 접근
새 항목이 배열 중간에 삽입되거나 중간에 있는 항목을 삭제하면,
뒤 따르는 항목들을 한 칸씩 뒤로 or 앞으로 이동시켜야 하므로
삽입 삭제 연산은 항상 O(1) 시간에 수행할 수 없음.

## 배열 리스트 클래스 구현

### 리스트를 배열로 구현 : ArrList 클래스
```java
import java.utilNoSuchElementException;
public class ArrList<E> {
    private E a[]; // 리스트의 항목들을 저장할 배열
    private int size; // 리스트의 항목의 수. 담겨 있는 요소의 개수.
    public ArrList() { // 생성자
        a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
        size = 0; // 항목 수는 0으로 초기화.
    }
    // 탐색, 삽입, 삭제 연산을 위한 메소드 선언
    // peek() {}
    // insert() {}
    // delete() {}
}
```
제네릭 타입 : 
인스턴스에서 각 메서드에 맞
일반화된 제네릭 클래스를 사용하면 각 메서드마다 타입을 융통성 있게 변경해서 사용할 수 있다.

### 탐색 peek() 메서드
```java
public E peek(int k) { // k번째 항목을 리턴, 단순히 읽기만 한다.
    if (size == 0) { // 저장된 항목이 있는지 없는지 체크.
        throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
        return a[k];
    }
}
```
**peek() 메서드 : k번째 저장된 항목을 탐색.**
a\[k]를 리턴, k < size 라 가정.

### 배열의 크기를 조정하는 resize() 메서드
```java
private void resize(int newSize) { // 배열의 크기를 조정
    Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t 생성
    
    for (int i=0;i<size;i++) { // a에 담긴 항목들을 t로 하나씩 옮긴다.
        t[i] = a[i]; 
        a = (E[]) t; // t의 데이터 타입 변경. 다운캐스팅
    }
}
```
### 삽입 insert 메서드

**insertLast() 메서드**
```java
public void insertLast(E newItem) { // 가장 뒤에 새 항목 삽입
    // Overflow를 막기 위한 동적 배열 할당 정책.
    if (size == a.length) { // 배열에 빈 공간이 있는지
        resize(2*a.length); // 없다면 배열 크기 2배 확장
    }
    a[size++] = newItem; // 배열에 새 항목을 삽입한다
}
```

**insert() 메서드**
```java
public void insert(E newItem, int k) { // k 번째에 새 항목 삽입.
    // Overflow 방지, 동적 배열 할당 정책.
    if(size == a.length) {
        resize(2*length);
    }
    for (int i = size-1;i>=k;i--) { // 뒤에 놓인 항목들부터 k한 칸씩 뒤로 이동.
        a[i+1] = a[i];
    }
    // 이후 k 번째에 새로운 항목 newItem 삽입.
    a[k] = newItem;
    size++;
}
```

### 삭제 delete() 메서드
```java
public E delete(int k) {
    if (isEmpty()) {   
    throw new NoSuchElementException(); // underflow 겨웅 프로그램 정지.
    }
    E item = a[k]; // 최종적으로 지워진 항목의 값이 무엇인지, 즉  k번째에 담긴 항목을 반환.
    for (int i=k;i<size;i++) { // k+1 번째 항목부터 맨 뒤 항목까지 한칸씩 앞으로 이동.
        a[i] = a[i+1]; 
    }
    size--;

    // 동적 배열 할당 정책.
    if (size > 0 && size == a.length/4) {// 배열에 항목들이 1/4만 차지한다면
        resize(a.length/2);
    }
    return item; // 지워진 k 번째 항목 반환.
}
```

### 수행시간
peek() 메서드는 인덱스를 이용하여 배열 원소를 직접 접근.
따라서 O(1) 시간에 수행 가능

삽입이나 삭제는 새 항목을 중간에 삽입하거나 중간에 있는 항목을 삭제한
후에 뒤 따르는 항목들을 한칸씩 앞or뒤로 이동해야하므로 각각 최악의 경우는 O(N) 시간 소요.

새 항목을 가장 뒤에 삽입하는 경우는 O(1) 시간.

배열의 크기를 확대 또는 축소시키는 것도 최악의 경우에는 O(N) 시간.

## 연결 리스트 Linked List
* **단순 연결 리스트**
* **이중 연결 리스트**
* **원형 연결 리스트**

## 단순 연결 리스트 클래스 구현

### 단순 연결리스트의 노드를 위한 Node 클래스

```java
public class Node <E> {
    private E item; // 노드가 갖고 있는 실제 데이터 값.
    private Node<E> next; // 다음 요소를 가리키는 인스턴스를 지닌다.
    public Node(E newItem, Node<E> node) { // 생성자
        item = newItem;
        next = node;
    }

    // get set 메서드
    public E getItem() {
        return item();
    }
    public Node<E> getNext() {
        return next;
    }
    public void setItem(E newItem) {
        item = newItem
    }
    public void setNext(Node<E> newNext) {
        next = newNext;
    }
}

```
### 리스트를 단순연결리스트로 구현한 SList 클래스
```java
import java.util.noSuchElementException;
public class SList <E> {
    protected Node head; // 연결리스트의 첫 노드를 가리킴
    // head는 item을 갖고 있지 않기 때문에 제네릭으로 선언할 필요 없음.
    private int size;
    public SList() { // 연결 리스트 생성자.
        head = null;
        size = 0;
    }
    // 탐색, 십입, 삭제 연산을 위한 메서드 선언
}
```

### 탐색 search() 메서드
탐색은 인자로 주어지는 target 을 찾을 때까지 연결리스트의 노드들을
첫 노드부터 차레로 탐색

```java 
public int search(E target) { // target을 탐색
    Node p = head; 
    for ( int k=0;k<size;k++) {
        if (target == p.getItem()) {
            return k; // head는 null이기 때문에 head가 가리키는 첫번째 레퍼런스부터가 찐(?) 탐색
            p = p.getNext();
        }
    }
    return -1;
}
```

### 맨 앞에 삽입 insertFront() 메서드

```java
public void insertFront(E newItem) { // 연결리스트 맨 앞에 새 노드 삽입
    head = new Node(newItem, head);
    // head (SList 인스턴스가 갖는 head의 원래 노드 필드가 새로운 노드를 가리키도록 하고,
    // head =        
    size++;
}
```

---

매 챕터마다 그 자료구조 타입에 시행을 시키게 되면 시간이 얼마나 걸리는지 체크할 것.


## 2차원 배열 예제

### 달팽이 문제 예제 풀이
```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int i = 0, j = 0, size = 5;
		int a[][] = new int[size][size];

		Scanner sc = new Scanner(System.in);
		int count = 1, tmp_cnt = 1;

		int right = 0, down = 1, left = 2, up = 3;
		int direction = 0; // 초기 방향 오른쪽을 초기화

		while (count <= size * size) {
			a[i][j] = count++;
			if (direction == right) {
				j++;
				if (j == size - tmp_cnt) {
					direction = down;
				}
			} else if (direction == down) {
				i++;
				if (i == size - tmp_cnt) {
					direction = left;
				}
			} else if (direction == left) {
				j--;
				if (j == tmp_cnt - 1) {
					direction = up;
				}
			} else if (direction == up) {
				i--;
				if (i == tmp_cnt) {
					tmp_cnt++;
					direction = right;
				}
			}
		}

		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				System.out.printf("%2d ",a[i][j]);
			}
			System.out.println();
		}
	}
}

```

### 지그재그(?)로 출력하기
```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int a[][] = new int[5][5];
		int i, j = 0, cnt = 1, size = 5;

		for (i = 0; i < size; i++) {
			if (i % 2 == 0) {
				for (j = 0; j < size; j++) {
					a[i][j] = cnt++;
				}
			} else {
				for (j = 0; j < size; j++) {
					a[i][4 - j] = cnt++;
				}
			}
		}

		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				System.out.printf("%2d ", a[i][j]);
			}
			System.out.println();
		}
	}
}

```