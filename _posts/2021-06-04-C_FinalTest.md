---
title: "C - 기말 시험 정리"
layout: single
classes: wide
tags: [C언어]
---

## 반복문:

for 문 <-> while 문, do -while 문

## switch case defualt 문:

c언어에서는 비교할 수 있는 데이터는 문자(문자열 아님), 숫자 외에 안됨

## 포인터:

포인터 정의 및 활용, 포인터와 배열이 어떻게 똑같은가?

### 포인터 선언

```cpp
int *ptr; // ptr은 정수 데이터를 참조하는 주소를 담는 기억공간.int *ptr;
```

### 변수의 메모리 주소를 포인터에 저장

```cpp
int *ptr; // ptr은 정수 데이터를 참조하는 주소를 담는 기억공간.int *ptr;
int x = 10;
ptr = &x; // x의 메모리 주소를 ptr에 저장.
```

### 역참조 연산자로 값을 불러오기

```cpp
int *ptr; // ptr은 정수 데이터를 참조하는 주소를 담는 기억공간.int *ptr;
int x = 10;
ptr = &x;

printf("%d", *ptr); // 10

```

### 포인터에서 에스터리스크(*)는..!

포인터를 선언할 때도 사용하고, 
포인터가 가리키는 주소에 담긴 값을 가져올 때(역참조)도 사용한다.
즉 선언, 사용(역참조)를 구분해서 사용하면 이해하기 쉽다.

```cpp
int *ptr; // 포인터 선언.
*ptr = 10; // ptr이 가리키는 주소에 담긴 값을 10으로 할당.
```

### 역참조 연산자를 이용하여 값을 저장하기

```cpp
int *ptr; // ptr은 정수 데이터를 참조하는 주소를 담는 기억공간.int *ptr;
int x = 10;
ptr = &x;

*ptr = 25;

printf("%d", *ptr); // 25
printf("%d", x); // 25
```

### malloc 메서드로 메모리 할당하기

malloc() 메서드는 인자로 들어온 값의 바이트크기만큼 메모리를 확보하고,
메모리의 첫번째 주소를 반환한다. malloc 함수는 stdlib.h 헤더 파일에 선언되어있다.

```cpp
#include <stdio.h>
#include <stdlib.h>
```

## 함수:

함수를 정의하는 방법 과 호출하는 방법
call by value, call by reference 처럼 사용하는 방법.
매개변수를 활용할 때.
포인터를 활용하면, return 을 한 개의 데이터밖에 할 수 없다는 한계를 극복할 수 있다.
이와 같은 방법이 call by reference. 주소 번지
함수를 넘겨줄 때, 배열을 넘겨주는 방법.
배열을 함수 호출 시 인자로 넘겨줄 때, int[] x이면 swap(x) 로 넘겨준다.

### 자동 변수, 정적 변수, 지역 변수, 전역 변수

**자동 변수)**
```cpp
#include <stdio.h>

ppp() {               
	int i=0; // 호출될 때 전역변수로 i 생성.
	i+=1;
	printf("%d\n",i);
}                    
 
    main() {              
	int k;
	for(k=0;k<3;k++) {
		ppp();
	}
}
```

**정적 변수)**
```cpp
#include <stdio.h>

ppp() {               
	static int i=0; // 호출될 때 전역변수로 i 생성.
	i+=1;
	printf("%d\n",i);
}                    
 
    main() {              
	int k;
	for(k=0;k<3;k++) {
		ppp();
	}
}
```

**지역 변수)**
```cpp
#include <stdio.h>

ppp() {               
	static int i=0; 호출될 때 전역변수로 i 생성.
	i+=1;
	printf("%d\n",i);
}                    
 
    main() {              
	int k;
	for(k=0;k<3;k++) {
		ppp();
	}
    printf("%d", i);
}
```

**전역 변수)**
```cpp
#include <stdio.h>
int i = 7;
ppp() {               
	static int i=0; 호출될 때 전역변수로 i 생성.
	i+=1;
	printf("%d\n",i);
}                    
 
    main() {              
	int k;
	for(k=0;k<3;k++) {
		ppp();
	}
    printf("%d", i);
}

```

## 구조체:

구조체가 30% 시험범위 나옴
연결리스트는 시험에 출제 x.
나이가 30이상인 사람 모두 출력. 성이 백씨인 사람은 누구인가, 나이 평균...
구조체 만드는 방법,
초기화 시키는 방법,
데이터를 불러오는 방법,
구조체를 함수에 넘겨줄 때 어떻게 넘겨줄까...근데 위 문제에서는 구조체를 넘겨준다기보다 구조체 배열을 넘겨줌.
파일 처리?는 시험에 안나옴.

### strcmp, strncmp 메서드를 이용해 문자열 비교하기

문자열을 비교할 때

### 