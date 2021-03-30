---
title: "C - 연산자"
layout: single
classes: wide
tags: [cLanguage]
---

### 산술 연산

```
#include <stdio.h>

main() {
  int a = 10, b = 3;
  int result1 = a + b; // 더하기
  int result2 = a - b; // 빼기 
  int result3 = a * b; // 곱하기
  int result4 = a / b; // 몫 (정수 / 정수)
  int result5 = a % b; // 나머지 구하는 연산

  printf("%d + %d : %d \n", a, b, result1);
  printf("%d - %d : %d \n", a, b, result2);
  printf("%d * %d : %d \n", a, b, result3);
  printf("%d / %d : %d \n", a, b, result4);
  printf("%d %% %d : %d \n", a, b, result5); // 출력함수로 % 나타내기
}
```
**참고 : %를 출력함수로 나타내기 -> %%**  
  
### 연산 우선 순위
1. 괄호로 묶인 것  
2. *, /  
3. +, -  
4. = (대입 연산자)  

**연산 우선순위를 잘 모르겠으면 괄호를 이용해 강제로 지정하기.**  