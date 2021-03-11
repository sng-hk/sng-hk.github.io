---
title: "Java - 클래스"
layout: single
classes: wide
subtitle : false
---
## 클래스
* 기본적인 클래스 구조

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
객체 생성 시 객체를 선언하는 필드를 강제적으로 지정해주고 싶을 때 사용.
```java
public class Knight {
    public Knight() { // 생성자

    }
}
```


### this 객체


## 객체 배열


## 클래스 멤버, 인스턴스 멤버

### 인스턴스 멤버

### 클래스 멤버

**응용 : 싱글톤 패턴**
