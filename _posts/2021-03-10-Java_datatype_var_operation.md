---
title : "Java - 데이터"
layout : single
classes: wide
---

## 식별자  
클래스, 변수, 상수, 메소드 등에 붙이는 이름  
- 식별자 작성 원칙  
    - ‘@’, ‘#’, ‘!’와 같은 특수 문자, 공백 또는 탭은 사용불가, ‘_’, ‘$’는 사용 가능  
    - 유니코드 문자 사용 가능. 한글 사용 가능  
    - 자바 언어의 키워드는 식별자로 사용불가  
    - 식별자의 첫 번째 문자로 숫자는 사용불가  
    - ‘_’ 또는 ‘$’를 식별자 첫 번째 문자로 사용할 수 있음(일반적이지는 않음)  
    - 부울 리터럴 (true, false)과 널 리터럴(null)은 식별자로 사용불가  
    - 길이 제한 없음  
    - 대소문자 구별- int abc; 와 int Abc; 는 다른 식별자의 선언  

## 자바의 데이터 형(Type : data type)  
논리형 : Boolean (1비트)  
문자형 : Char (2바이트=16비트)  
정수형 : byte (1바이트) / short (2바이트) / int (4바이트) / Long (8바이트)  
실수형 : float (4바이트) / double (8바이트)  

## 스트링(String, 문자열)  
문자열 : 문자가 열을 짓고 있는 형태, 단어, 문장 등  
기본 타입이 아니다. 문자열은 String 클래스를 이용  
문자열 상수(리터럴) => “Java”, “대한민국”, “안녕하세요”  

## 변수와 변수 선언
- 변수  
    값을 기억 또는 저장하기 위한 공간 또는 공간의 이름  
    변수 값은 프로그램 수행 중 변경될 수 있음  
- 변수 선언  
    데이터형에서 정한 크기의 메모리 할당  

```
int value; // 변수 선언
double weight = 76.66; // 변수 선언 및 생성
char c1 , c2, c3 = 'c'; // c1, c2 는 선언만, c3 는 char타입 선언 동시에 'c' 라는 값 할당
price = 7;
System.out.println(price); // 7
price = -25;
System.out.println(price); // -25

```

## 리터럴  
프로그램에서 숫자나 문자 등의 값을 직접 표현 한 것  
정수, 실수, 문자, 논리, 문자열 상수(리터럴)가 있음  

## 데이터형 변환
한 데이터형의 값을 다른 데이터형(type)의 값으로 변환  

```
long m = 25; // 25는 int 타입 25가 long 타입으로 자동 변환
double d = 3.14 * 10; // 실수 연산 위해 10이 10.0으로 자동 변환
```

**자동 데이터형 변환**  
원래의 데이터형보다 큰 데이터형으로 컴파일러에 의해 자동 변환  
치환문(=)이나 수식 내에서 데이터형이 일치하지 않을 때  

## 강제 데이터형 변환  
개발자에 의한 의도적인 타입 변환  
값 손실 우려 있음.  

```
double d = 1.9;
int n = (int)d; // n = 1
```

## Scanner 클래스  
읽은 바이트를 문자, 정수, 실수, 불린, 문자열 등 다양한 타입으로 변환하여 리턴  
인스턴스 생성하여 사용  

```
import java.util.Scanner; // 임포트 문 필요

class Main
{
    public static void main(String[] args) 
    {
        Scanner a = new Scanner(System.in); // Scanner 객체 생성
        
        String name = scanner.next(); // "Kim"
        String city = scanner.next(); // "Seoul"
        int age = scanner.nextInt(); // 20
        double weight = scanner.nextDouble(); // 65.1
        boolean single = scanner.nextBoolean(); // true   
    }
}
```

## 식, 연산자  
  
* 산술 연산자  
    더하기 : +  
    빼기 : -  
    곱하기 : *      
    나누기 : / (정수/정수: 부동소수점 제외한 정수 부분만 출력, 그외 나머지 경우는 소수 출력)  
    나머지 : % (ex. 홀수 짝수 판단)  
    
제곱 연산자는 자바 내 Math 클래스 이용.  

* 증감 연산자  
    count++; // count를 사용한 후 명령이 끝나면 count 값을 1 증가  
    ++count; // count 값을 1 증가한 후에 count를 사용.  
* 대입 연산자  
    연산의 오른쪽 결과를 왼쪽 변수에 대입.  
    연산 우선순위가 가장 낮음. 제일 늦게 함!  
* 논리 연산자  
    두 개의 논리값에 논리 연산.  
```
!a // a 가 true 이면 false를 나타냄.
a^b // a,b 의 exclusive-OR 연산. 같은 논리값이면 1, 다른 논리값이면 false.
a||b // a,b 의 OR 연산. 모두 false인 경우에만 false.
a&&b // a,b 의 and 연산. 모두 true인 경우에만 true.
```
  
* 비교 연산자  
    두 개의 값을 비교하여 true/false 결과  