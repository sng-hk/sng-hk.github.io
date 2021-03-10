---
title : "Java - 조건문, 반복문"
layout : single
classes: wide
---

# 조건문

## if 문
if() 의 괄호 안 논리값이 참이면 {} 안의 명령 실행.  

```
if(n<10) {
    System.out.println("n은 10보다 작습니다!");
}

```

## if - else 문
if() 의 괄호 안 논리값이 참이면 {} 안의 명령 실행.  
거짓이면 else 뒤의 {} 안의 명령 실행.  
```
if(n<10) {
    System.out.println("n은 10보다 작습니다!");
} else {
    System.out.println("n은 10보다 크거나 같습니다!");
}
```

### if - else if - else 문
여러개의 조건으로 분류하여 각각의 조건에 따른 명령을 실행하고 싶을 때 사용.
```
if (score < 60 and score >= 0)
{
    grade = "C";
}
else if (score >= 60 && score < 80)
{
    grade = "B";
}
else if (score >=80 and score <= 100)
{
    grade = "A";
}
else
{
    // 예외 처리
}
```

## switch 문  
switch ~ case ~ default 문  
Case 의 값과 비교하여 같으면 해당 case의 실행문장 수행,  
이후 break를 만나면 switch문을 벗어남  
Case의 값과 일치하는 것이 없으면default 문 실행.  
default문 생략 가능  
```
char grade='A';
switch (grade) {
    case 'A':
    System.out.println("90점 이상입니다.");
    break;
    
    case 'B':
    System.out.println("80점 이상입니다.");
    break;

    case 'C':
    System.out.println("70점 이상입니다.");
    break;

    default:
    System.out.println("70점 미만입니다.");
}
```

## 조건문을 중첩하여 사용하기.

```
if(score >= 60) 
{ // 60점 이상
    if(year != 4)
    {
        System.out.println("합격!"); // 4학년 아니면 합격
    }
    else if(score >= 70) 
    {
        System.out.println("합격!"); // 4학년이 70점 이상이면 합격
    }
    else 
    {
        System.out.println("불합격!"); // 4학년이 70점 미만이면 불합격
    }
}
else 
{
    // 60점 미만 불합격 
    System.out.println("불합격!");
}
```

# 반복문

## for 문
동일한 데이터 타입에 같은 명령을 여러번 실행해야할 때가 종종 생긴다.  

```
sum += 1;
sum += 2;

...

sum += n;
 
```
  
이러한 수고로움을 덜어줄 수 있는 방법으로 for문을 사용하면, 일련의 규칙을 갖고  
반복되는 명령을 쉽게 처리할 수 있다..!  

* for 문 구조  
for(초기값; 실행조건; 증감값) {  
    // 실행할 명령  
}  
  
증감값은 {} 안의 실행할 명령이 끝나고서 가장 나중에 실행된다.  
  
간단한 예제를 통해 살펴보자.  
```
int n = 2;
int sum = 0;
for (int i = 0; i<n; i++) {
    sum = sum + i;
}

```
1.  
`i=0` 이므로 실행조건 `i<n` 을 만족한다.  
따라서 `sum = sum + i` 를 실핸한다.  
{} 안의 명령이 모두 끝났으므로 `i++`를 실행한다.  
  
2.  
`i=1` 이므로 실행조건 `i<n` 을 만족한다.  
따라서 `sum = sum + i` 를 실행한다.  
{} 안의 명령이 모두 끝났으므로 `i++`를 실행한다.  
  
3.  
`i=2` 이므로 실행조건 `i<n` 을 만족하지 않는다.  
따라서 {} 안의 명령을 실행하지 않고 for문을 마친다.  


### continue  
반복문의 현재 부분만 탈출하고 다음 반복문으로 넘어간다.  
  
### break  
현재 돌고 있는 반복문 전체를 빠져나간다.  
  
## for each 문  
배열에 대한 이해가 필요.  

```
int[] array = {1,2,3,4,5};
int sum = 0;
for (int i : array) {
    sum = sum + i
}

```
  
## while 문  
조건식이 ‘참’인 동안 반복 실행  
while 문은 반복문이지만 if 문처럼 조건문의 성격을 지녔다.  
조건만 만족한다면 계속해서 {} 안의 명령을 실행한다.  
  
* while 문의 구조  
while(조건) {  
    // 실행할 명령  
}  
  
## do-while 문  
  
* do - while 문의 구조  
do () {  
  
} while (조건)  
    // 실행할 명령  
## 중첩 반복문  
ex) 간단한 구구단 프로그램  

```

```