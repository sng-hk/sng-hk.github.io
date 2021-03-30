---
title: "C - 출력함수, 변수"
layout: single
classes: wide
tags: [C언어]
---

### 출력함수
문자열 "Hello" 출력  
```cpp
# include<stdio.h>

main() {
    printf("Hello");
}

```
  
### 줄바꿈
`\n`를 넣으면 커서를 다음 줄로 이동시킨다.  

```cpp
# include<stdio.h>

main() {
    printf("Hello\n world!");
}

```

### 포맷  
%d	: 십진수 10을 10진수 정수형으로 출력  
%x	: 십진수 10을 16진(hexa)수 정수형으로 출력  
%o	: 십진수 10을 8진(octal)수 정수형으로 출력  

%f  : 데이터를 float 형으로 출력  


```cpp
# include<stdio.h>

main() {    
    printf("Decimal value = %d\n",10); // Decimal value = 10
    printf("Hexadecimal value = %x\n",10); // Hexadecimal value = A
    printf("Octal value = %o\n",10); // Octal value = 12
}

```

### 변수  
`기억공간의 이름 = 값` 형식으로. 변수를 저장하고  
추후에 값을 변수를 이용해서 가져올 수 있다.  

```cpp
#include <stdio.h>

main() {
    int x; // 선언
    x = 30 // 초기화
    printf("value = %d \n",x); // value = 30 
}

```
  
```cpp
#include <stdio.h>

main() {
    int x; // 선언
    x = 030 // 8진수
    printf("value = %d \n",x); // value = 24 
}
```
  
```cpp
#include <stdio.h>

main() {
    int x; // 선언
    y = 0x30 // 16진수
    printf("value = %d \n",y); // value = 48 
}
```

### 변수 이름 붙이기
1. 영문자 (대문자, 소문자)와 숫자, '_' 기호만을 조합하여 만든다.  
2. 변수의 맨 앞에는 숫자는 오지 못한다.  

