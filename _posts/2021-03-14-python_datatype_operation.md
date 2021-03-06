---
title: "Python - 숫자 데이터 타입, 연산"
layout: single
classes: wide
tags : [Python]
---

## 숫자 데이터 타입

* 정수 int  
* 실수 float  
* 복소수 complex  

```python
print(1+2) # 정수 출력
print(1.3+1.2) # 실수 출력
```

## 리터럴
리터럴(liternal)은 `글자 그대로의` 라는 뜻으로  
어떤 데이터 타입의 값을 그대로 나타낼 때 리터럴이라 한다.  


### 정수 리터럴
**0~9로 시작하는 정수 : 10진수** ex) 314  
0b로 시작하는 정수 : 2진수 ex) 0b1010111001  
0o로 시작하는 정수 : 8진수 ex) 0o24 (10진수 2*8 + 4*1 = 20)  
0x로 시작하는 정수 : 16진수 ex) 0x2b1 (10진수 2*16^2 + 11\*16 + 1\*1)  

**코드 작성 시 큰 수는 언더바로 나눠서 편하게 볼 수 있다**  

```
>>> x = 1_000_000  # 10만
>>> x
1000000
```

### 실수 리터럴

소수점 포함하는 숫자 
ex) 3.1415

### 복소수 리터럴

j 로 끝나는 수 : 복소수의 허수부분 리터럴  
ex) 1 + 3j

## 연산  
\- 더하기 : `+` 기호를 이용해 두 수를 덧셈 연산한다.  
\- 빼기 : `-` 기호를 이용해 두 수를 뺄셈 연산한다.  
\- 곱하기 : `*` 기호를 이용해 두수를 곱셈 연산한다.  
\- 제곱 : `**` 기호를 이용해 제곱 연산을 수행한다.  

ex)

```
>>> 2**10
1024
```

\- 나눗셈 :  
/ : 부동소수점을 포함한 결과가 출력.  
// : 부동소수점 이하는 버리고 정수 출력  
```
5/2
>>> 2.5
```
**참고 : 정수 반환 함수**
파이썬 내장 함수  
int(n) : 인자로 전달된 값을 정수값으로 반환한다.  
```
>>> x = int(4.5)
>>> x
4.0
```
**파이썬 내장 함수는 "예약어" 파트에서 자세하게 다뤄본다!**

\- 나머지 :

```
>>> 10 % 3 # 10을 3으로 나눈 나머지
1
```



### 연산 우선 순위 
결론 : 괄호를 씌워서 내가 원하는대로 조절하자..!  


