---
title: "C - 데이터형(정수형, 실수형, 문자형)"
layout: single
classes: wide
---

## 정수형

### 정수 자료형 크기 및 범위
| 자료형 | 크기 | 범위 |
| --- | --- | ---|
|char | 1바이트 | -128~127|
|short| 2바이트 |-32,768~32,767|
|int| 4바이트 | 	-2,147,483,648 ~ 2,147,483,647 |
|long| 4바이트 | -2,147,483,648 ~2.147.483.647 |



### 화면에 정수를 출력하는 방법

```cpp
#include <stdio.h>

main() {
  int a =5, b=2,c;
  c = a  + b;
  printf("%d \n",c);
}
```

출력 함수에서 c을 출력하기 위해 서식 지정자 `%d`를 사용한다. c을  
십진수 정수로 출력한다.  
  
\- 정수 출력 서식지정자  
**%d : char, short, int 를 정수로 출력**  
%ld : long 을 정수로 출력  
%lld : long long 을 정수로 출력  


## 실수형

### 실수 자료형 크기 및 범위
| 자료형 | 크기 | 범위 |
| --- | --- | ---|
flaot| 4바이트 | -3.4 x 10^38 ~ 3.4 x 10^38 |
double| 8바이트 | -1.8 x 10^308 ~ 1.8 x 10^308 |

### 화면에 실수를 출력하는 방법

```cpp
#include <stdio.h>

main() {
  float f = 3.14f; // float 리터럴
  double d = 1.4; // double 리터럴
  printf("%d \n",c);
}
```

\- 실수 출력 서식지정자  
**%f : double, float 을 실수로 출력**  


## 문자형

| 자료형 | 크기 | 범위 |
| --- | --- | ---|
|char | 1바이트 | -128~127|

```cpp
#include <stdio.h>

main() {
  float f = 3.14f; // float 리터럴
  double d = 1.4; // double 리터럴
  printf("%c \n",c);
}

```