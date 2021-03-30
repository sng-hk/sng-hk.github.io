---
title: "Java - 메서드"
layout: single
classes: wide
tags: [java]
---

## 메서드  
반복되는 명령들을 한 번에 묶어서 처리하고 싶을 때 사용한다.  

**캡슐화 원칙**  
자바의 모든 메서드는 클래스 안에 선언되어야 함.  

* 메서드의 구조  

```java
public /* 1. 접근 지정자 */ void /* 2. 리턴 타입 */testMethod() {
    
}

public int addOne(int x  /* 3. 매개변수*/ ) {
    return x + 1;
}

```

### 1. 접근 지정자  
* private :   
외부 클래스에서는 접근할 수 없다.  
클래스 내부에서만 사용가능.  

* public :  
외부 클래스에서도 접근할 수 있다.  
  
* prodected :  
접근할 메서드가 선언된 클래스를 상속받는 자식 클래스일 경우,  
외부에 있던 내부에 있던 클래스 상속이 가능하다.  

**추후에 자세하게 알아보자.**

### 2. 리턴 타입  
* void
아무것도 반환하지 않는다.  
메서드 내의 명령을 처리하고 메서드를 종료한다.  

* 기본 데이터형, 배열, 객체, 객체 배열 등 반환  
리턴 타입에 맞게 메서드 안의 명령을 처리한 뒤에  
메서드 이름 앞에 선언한 데이터형에 맞는 데이터타입을 반환해야한다.  

### 3. 매개 변수  
* 기본 데이터형이 전달되는 경우  
값이 복사되어 전달.  

* 객체, 배열이 전달되는 경우  
해당 객체의 레퍼런스를 전달.  
    
추후 **참조와 복사**에서 자세하게 알아보자

## 메서드 오버 로딩
한 클래스 내에서 두 개 이상의 이름이 같은 메소드가 작성된 경우.  
1. 메소드 이름이 동일하되, 매개 변수의 개수가 다르거나, 매개변수 타입이 서로 달라야 한다.  
3. 리턴 타입은 오버로딩과 관련 없다.  

```java
class Cal{
    
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public int float sum(float a, float b) {
        return a + b;
    }
}

class Main {
    public static void main(String[] args) {
        Cal c = new Cal();
        int r1 = c.sum(1,2);
        int r2 = c.sum(3,4,5);
        float r3 = c.sum(2.3, 3.3);
    }
}
```

## 메서드 오버 라이딩
추후 **클래스 상속**에서 자세하게 알아보자.  