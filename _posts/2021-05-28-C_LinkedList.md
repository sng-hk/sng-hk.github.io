---
title: "C - 연결리스트, STL"
layout: single
classes: wide
tags: [C언어]
---

# 연결리스트

## 연결리스트의 모습을 구조체로 표현

## 구조체와 연결리스트

```cpp
#include <stdio.h>

struct tv {
	int dat;
	struct tv *nextdata;
} tv_size;

main() {
	struct tv *start, *channel;
	start = malloc(sizeof(tv_size)); // start가 tv_size크기만큼의 메모리 할당.첫번째 주소번지 되돌려줌. 
	channel = start;
	channel -> data = 2;
	channel -> nextdata = malloc(sizeof(tv_size));
	channel = channel -> nextdata;
	channel -> data = 7;
	channel -> nextdata = malloc(sizeof(tv_size));
	
}
```
  
# STL  
  
Standard Template Library 라이브러리  
  
연결리스트 등을 이미 구현한 라이브러리  