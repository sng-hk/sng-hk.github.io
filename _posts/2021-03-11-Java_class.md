---
title: "Java - 클래스"
layout: single
classes: wide
tags: [java]
---
## 클래스

클래스에 대해 설명하기 전,  
사각형의 가로, 세로와 면적을 구하는 과정을 살펴보자.  

```java
public class JStudy {
	public static void main(String[] args) {
		int garo[] = new int[2];
		int sero[] = new int[2];
		int Myun[] = new int[2];
		garo[0]=2; sero[0]=3;
		garo[1]=3; sero[1]=8;
		
		Myun[0] = garo[0] * sero[0];
		Myun[1] = garo[1] * sero[1];
		
		System.out.println(Myun[0] + " " + Myun[1]);
	}
}

```

### 클래스를 사용하는 이유

관련 있는 자료들을 묶어서 사용할 수 있도록 하기 위함.  
클래스를 사용하면 데이터의 관리가 쉬워진다..!
클래스를 사용하면 데이터를 정리해서 사용할 수있다.

예)
|이름|가로|세로|면적|색깔|
|---|---|---|---|---|
|노란네모|3|4|12|노랑|
|파란세모|5|2|5|파랑|
  
|이름|나이|키|몸무게|
|---|---|---|---|
|형준|18|178|69|
|지성|29|182|59|

이렇게 관련 있는 자료들끼리 묶어서  
사용하면 데이터를 손쉽게 관리할 수 있을 것이다.  

  
### 기본적인 클래스 구조

```java

public class Knight {
    private int hp; // 필드 : 멤버 변수
    public string name; // 필드 : 멤버 변수

    Knight(name,hp) { // 생성자
        this.name = name;
        this.hp = hp;
    }

    public void Attack() { // 메서드 : 멤버 함수
        // 실행할 명령문
    }

}
```

## 객체 선언 및 생성, 메서드 호출

```java

public class Knight {
    private int hp;
    private String name; 

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }
}

class Main
{
    public static void main(String[] args) 
    {
        Knight player1; // Knight 타입 객체 선언
        player1 = new Knight(); // 객체 생성

        player1.setHp(10);
        int n = player1.getHp(); // n = 10
    }
}
```

## 생성자
```java

class Sakak {
	int garo;
	int sero;
	int Myun;
	
	void surface(int garo, int sero) {
		Myun = garo*sero;
	}
	
	void show() {
		System.out.println("garo = " + garo + "sero = " + sero);
        System.out.println("surface = " + Myun);
	}

}

public class JStudy {
	public static void main(String[] args) {
		Sakak s = new Sakak(); // garo = 3, sero =2, 면적을 구하고 그 값을 출력.
        s.surface(garo,sero);
	}
}

```

위를 같이 실행하면  
```
Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
	garo cannot be resolved to a variable
	sero cannot be resolved to a variable

	at JStudy.main(JStudy.java:20)
```
다음과 같이 s라는 이름의 객체가 갖는 멤버인 garo, sero 의 값을 설정하지 않았기 때문이다.  
s 라는 객체 변수에 garo 와 sero 값을 무조건 설정해야만  
객체가 생성될 수 있도록 강제할 수 있는 방법이 생성자를 이용하는 것이다.  
객체 생성 시 객체가 갖는 멤버 중 필드를 강제적으로 지정해주고 싶을 때 사용한다.  
객체를 선언한 후 생성하는 과정을 초기화라고도 한다.  
    
### 생성자의 규칙
1\) 클래스명과 메소드명이 동일하다.  
2\) 리턴타입을 정의하지 않는다.  

( 참고 : 접근 지정자는 정의할 수 있다..! )  

### 생성자 특징

값을 반환하지 않는다.  
생성자는 인스턴스를 생성해주는 역할을 하는 특수한 메소드라고 할 수 있다.  
그런데 반환 값이 있다면 엉뚱한 객체가 생성될 것이다. 따라서 반환 값을 필요로하는 작업에서는 생성자를 사용하지 않는다.  
반환 값이 없기 때문에 return도 사용하지 않고, 반환 값을 메소드 정의에 포함시키지도 않는다.  
생성자의 이름은 클래스의 이름과 동일하다. 자바에서 클래스의 이름과 동일한 메소드는 생성자로 사용하기로 약속되어 있다.  
(출처 : https://opentutorials.org/module/516/5519 by 생활코딩)  

  
### 기본 생성자

```java
    public Knight() { // 기본 생성자

    }
```
생성자를 선언하지 않으면 다음과 같이 인자와 초기화 시 수행할 명령을 포함하지 않는  
기본 생성자와 선언한 것과 마찬가지이다.  

### 생성자 활용
```java
class Sakak {
	int garo;
	int sero;
	int Myun;
	
	void surface(int garo, int sero) {
		Myun = garo*sero;
	}
	
	void show() {
		System.out.println("garo = " + garo + "sero = " + sero);
        System.out.println("surface = " + Myun);
	}

    Sakak(int garo, int sero) { // 생성자
        this.garo = garo;
        this.sero = sero;
        
        surface(garo,sero);
        show();

    }
}

public class JStudy {
	public static void main(String[] args) {
		Sakak s = new Sakak(3,2); // garo = 3, sero =2, 면적을 구하고 그 값을 출력.
	}
}

```



## this 키워드

this.변수; // 현재 접근한 객체 자기 자신의 변수를 
```java
class Sakak {
	int _garo;
	int _sero;
	int _Myun;

	Sakak(int garo, int sero) {
		_garo = garo;
		_sero = sero;		
	}
}
```
객체가 갖는 필드를 set 하고, get 하는 방법으로 

## 객체 배열
객체 배열을 선언하고 생성하는 방법은 기본적으로는
기본 데이터 타입의 배열을 생성하는 방법과 같다.

```java

public class MyJava {
	public static void main(String[] args) {
		int[] arr = new int[10]; // 크기가 10인 int 타입의 배열 선언 및 생성
		Sakak[] s = new Sakak[5]; // 크기가 5인 Sakak타입 배열 선언 및 생성		
	}
}
```

객체 배열을 생성할 때 주의할 점.
배열 속 객체를 new 연산자로 생성해줘야한다.

```java

public class MyJava {
	public static void main(String[] args) {
		Sakak[] s = new Sakak[5]; // 크기가 5인 Sakak타입 배열 선언 및 생성
		// 아직 배열 속 데이터마다 선언은 했지만 Sakak() 객체를 생성해주지 않았으므로
		// 각각의 데이터들마다 객체를 생성 및 초기화해준다.
		s[0] = new Sakak(1,2);
		s[1] = new Sakak(5,3);		
	}
}
```

## 가비지 컬렉션

객체 소멸
- new에 의해 할당 받은 객체와 배열 메모리를
자바 가상 기계로 되돌려 주는 행위

가비지
가리키는 레퍼런스가 하나도 없는 객체
더 이상 접근할 수 없어 사용할 수 없게 된 메모리

가비지 컬렉션
자바 가상 기계의 가비지 컬렉터가 자동으로 가비지 수집, 반환


## 접근 지정자
(은닉성 : )
### 클래스 접근 지정자

### 멤버 접근 지정자


### 인스턴스 멤버(non-static 멤버), 클래스 멤버(static 멤버)
| |non-static 멤버|static 멤버|
|---|---|---|
|공간 특성|객체마다 멤버가 별도 존재 -> 인스턴스 멤버라 부름.|멤버는 클래스당 하나 생성 -> 객체 내부가 아닌 별도 공간에 생성 -> 클래스 멤버라 부름|
|시간 특성|객체 생성 시에 멤버 생성됨. 객체 사라질 시점에 사라짐|클래스 로딩 시에 멤버 생성. 프로그램 종료시 사라짐|
|공유 특성|공유되지 않음|클래스를 사용하는 모든 객체들에 의해 공유됨.|

### 인스턴스 멤버 (non-Static 멤버)
인스턴스 멤버는 객체가 생성될 때, 객체마다 생긴다.

### 클래스 멤버 (Static 멤버)

static 메소드는 오직 static 멤버만 접근 가능
객체가 생성되지 않은 상황에서도
static 메소드는 실행될 수 있기 때문에, non-static 멤버 활용 불가
non-static 메소드는 static 멤버 사용 가능

static 메소드는 this 사용불가
static 메소드는 객체 없이도 사용 가능하므로, this 레퍼런스 사용할 수 없음


## 클래스 상속, 오버라이딩
(다형성 : )  
기존의 클래스를 수정하는데 있어서 위험성을 가진다.  
현재는 코드가 짧아서 수정하는데 위험 부담이 없지만,
코드의 크기가 커질수록 조그마한 부분이라도 잘못 건드리면 프로그램에 문제가 생길 수도 있다.
따라서, 수정할 클래스를 상속하는 새로운 클래스를 만들어서 수정하여 기존의 원본 클래스는 그대로 두고,
상속 받은 클래스를 수정해서 안전하게 코드를 수정할 수 있다.

```java
class MySakak extends Sakak {
	MySakak(int garo, int sero) {
		super(garo, sero);
	}
	void show() {
		System.out.println("garo => " + garo + " sero => " + sero);
		surface(garo,sero);
        System.out.println("surface => " + Myun);
	}
}

public class MyJava {
	public static void main(String[] args) {
		MySakak s = new MySakak(3,4);		
	}
}
```
**결과**  
```
garo => 3 sero => 4
surface => 12
```
	
### 부모 생성자 불러오기 : super() 메서드
인자를 갖는 부모 클래스 생성자를 지정해서 불러올 때 사용.  
자식 클래스를 생성할 떄, 그 생성자에 해당하는 부모 생성자를 먼저 호출한 후,  
자식 클래스 생성자를 호출한다.  


---
**응용 : 디자인 패턴**  
