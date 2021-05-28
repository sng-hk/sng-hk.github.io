---
title: "C - 포인터_함수"
layout: single
classes: wide
tags: [C언어]
---

# 포인터



# 함수

### 함수 기본적인 구조
```cpp
(반환 형태:void/int/...) func/*함수명*/ (int a, int b /*매개변수*/) { // 함수의 시작
    a = a + b;
} // 함수의 끝

```
  
### 함수의 특징과 장점  
  
  
### 사용 예제  
  
1\) 매개변수 값을 넘겨주고, 모든 것을 처리하는 함수 정의 및 호출  
호출하면 끝이기때문에 함수를 활용하기가 어렵다.  
```cpp
#include <stdio.h>

void hap(int a, int b) {
    int c;
    c = a+b;
    printf("%d+%d=%d",a,b,c);
}

void main() {
    hap (10,40);
    hap(20,50);
    hap(10,20);
}

```

```cpp
#include <stdio.h>

oneToNsum(int n1, int n2) {
	int i;
	int sum=0;
	for(i=n1;i<=n2;i++) {
		sum +=i;
	}
	printf("%d",sum);
}
void main() {
	oneToNsum(10);
}
```  
2\) 함수를 호출할 때 되돌려주는(return) 값만 활용하는 것  
활용은 할 수 있지만 되돌려주는 값이 단 하나다.  
```cpp
#include <stdio.h>

int hap(int a, int b) {
    int c;
    c = a+b;
    return c;
}

void main() {
    printf("%d+%d=%d",10,40,hap (10,40));
    printf("%d+%d=%d",20,50,hap (20,50));
    printf("%d+%d=%d",10,20,hap (10,20));
}

```
  
3\) 포인터를 사용하여, 결과값을 받기위해 주소번지를 넘겨주는 경우  
원하는 만큼 결과값을 되돌려받을 수 있다.  
사용하기엔 조금 까다롭다.  
```cpp
#include <stdio.h>

void hap(int a, int b, int *x) {
	*x = a + b;	
}

void main() {
	int a,b;
	int x;
	a = 10,b = 20; hap(a,b,&x);
	printf("%d+%d=%d\n",a,b,x);
	a = 45,b = 55; hap(a,b,&x);
	printf("%d+%d=%d\n",a,b,x);
	a = 30,b = 40; hap(a,b,&x);
	printf("%d+%d=%d\n",a,b,x);
}
```

```cpp
#include <stdio.h>

void hapcha(int a, int b, int *c,int *d) {
	*c = a + b;
	*d = a - b;
}

void main() {
	int a,b,c,d;
	a=10;b=20;
	hapcha(a,b,&c,&d);
	printf("hap = %d cha = %d",c,d); // hap = 30  cha = -10
}
```
## 스택 
  
int x; => auto int x . auto 생략  
자동 변수들은 stack 에 만들어짐.  
  
  
### call by value  
변수를 함수에 넘겨줄 떄, 값을 너겨준다.  
  
  
### call by reference 처럼 동작할 수 있다  
c언어에서 포인터를 이용하면, call by reference 처럼 작동할 수 있다.  
함수 정의시 매개변수를 받아올 때 인자는 변수의 주소를 받아오고,  
```cpp
swap(int *a, int *b) {
    int t;
    t = *a; // a가 가리키는 메모리공간에 담긴 값을 t에 할당.
    *a = *b; // b가 가리키는 메모리 공간에 담긴 값을 a가 가리키는 메모리 공간에 할당.
    *b = t; // t에 담긴 값을 b가 가리키는 메모리 공간에 담는다.
}
```
함수 호출시 매개변수를 넘겨줄 때 인자로 변수의 주소를 넘겨준다.  
```cpp
swap(&x, &y);
```

### 배열을 인자로 넘겨줄 때

배열과 포인터  
정수 배열 a에 대해서  
배열 a는   
*(a+3) 은 a\[3]을 담고 있다.  
  
## 지역 변수와 전역변수  
  
### 지역 변수  
지역 변수는 스택 메모리에 저장됨.  
main() 함수에 선언되는 변수들도 모두 지역 변수에 해당한다.  
auto가 생략되어있다. 자동변수.  
  
  
### 전역 변수  
  
정적 변수  
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
}
```
  
### const  
const 는 constant의 줄임말로 우리말로 상수라고 한다.  
상수의 반대되는 개념은 우리가 자주 사용하는 변수이다.  
```cpp
#include <stdio.h>
main() {
    const float pi = 3.141592;
    float k;
    int i;
    for(i=0;i<100;i++) {
    	k = sin(pi/2*i*0.01);
		printf("%f\n",k);	
	}
}
```
  
## 동적 메모리  
malloc() 함수:   
힙 메모리 영역이 있는데,  
힙 영역에서 주어진 인자값만큼의 바이트 크기 공간을 확보하고,  
확보된 공간의 첫번째 주소번지를 되돌려준다.  
아주 큰 메모리도 확보할 수 있다.(이미지, 동영상 등)  
free() 함수 : 힙 영역에서 메모리를 모두 사용 후에는 다시 자유메모리로 반환.  

```cpp
#include <stdio.h>
#include <stdlib.h>

main() {
    char *x; // x라는 이름의 주소번지를 담을 수 있는 기억공간 생성 
    x=malloc(1); // 힙 메모리 영역에 1바이트 할당. malloc은 주소번지를 return 함. 반환한 값을 x에 저장.
    *x=43; 
    printf("%d\n",*x);
    free(x);
}
```

```cpp
#include <stdio.h>

main() {
    int x[] = {10,20,30};
    show(&x);
}

void show(int *x) {
	int i;
	for(i=0;i<3;i++) {
    	printf("%d ", x[i]);
	}
}
```

---

### 기말시험 예상 문제
```cpp
main() {
    int x[]={42,54,12,33,19};
    int i;
    for(i=0;i<5;i++)
        if(Large20(x[i])==1)
            printf("%d is larger than 20\n",x[i]);
        else
            printf("%d is not larger than 20\n",x[i]);
 }

 출력결과
42 is larger than 20
54 is larger than 20
12 is not larger than 20
33 is larger than 20
19 is not larger than 20
```

```cpp
#include <stdio.h>

oneToNsum(int n1, int n2) {
	int i;
	int sum=0;
	for(i=n1;i<=n2;i++) {
		sum +=i;
	}
	printf("%d",sum);
}
void main() {
	oneToNsum(10);
}
```
