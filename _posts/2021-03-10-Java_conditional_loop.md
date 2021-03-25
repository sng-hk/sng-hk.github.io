---
title : "Java - 조건문, 반복문"
layout : single
classes: wide
---

# 조건문

## if 문
if() 의 괄호 안 논리값이 참이면 {} 안의 명령 실행.

```java
if(n<10) {
    System.out.println("n은 10보다 작습니다!");
}

```

## if - else 문
if() 의 괄호 안 논리값이 참이면 {} 안의 명령 실행.  
거짓이면 else 뒤의 {} 안의 명령 실행.  

```java
if(n<10) {
    System.out.println("n은 10보다 작습니다!");
} else {
    System.out.println("n은 10보다 크거나 같습니다!");
}
```

### if - else if - else 문
여러개의 조건으로 분류하여 각각의 조건에 따른 명령을 실행하고 싶을 때 사용.  

```java
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

```java
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

```java
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

```java
sum += 1;
sum += 2;
// ...
sum += 100;
 
```
  
이러한 수고로움을 덜어줄 수 있는 방법으로 for문을 사용하면, 일련의 규칙을 갖고  
반복되는 명령을 쉽게 처리할 수 있다..!  

* for 문 구조  

```
for(초기값; 실행조건; 증감값) {  
    // 실행할 명령  
}  
```
  
증감값은 {} 안의 실행할 명령이 끝나고서 가장 나중에 실행된다.  
  
간단한 예제를 통해 살펴보자.  

```java
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

예제) 
21, 18, 15, ..., 6,3 을 한 줄단 숫자 하나씩 출력하는 프로그램 만들기.  
  
방법 1)  
```java
public class Main {
	public static void main(String[] args) {
		for(int i=7; i>0;i--) {
			int result = i*3;
			System.out.println(result);
		}
	}
}
```
  
방법 2)  
```java
public class Main {
	public static void main(String[] args) {
		for(int i=21; i>0;i-=3) {
			System.out.println(i);
		}
	}
}
```

### continue  
반복문의 현재 부분만 탈출하고 다음 반복문으로 넘어간다.  
  
### break  
현재 돌고 있는 반복문 전체를 빠져나간다.  
  
## for each 문  
배열에 대한 이해가 필요.  

```java
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


## 예제
  
<문제 1>
다음과 같은 자료가 있다.
int mdata[] = {20,30,65,43,12,54};

위 데이터에 대해 다음과 같은 결과가 나오도록 프로그램을 작성하라
1) 최대값을 출력한다.
2) 합계를 출력한다.
3) 평균을 출력한다.
출력의 모습은 다음과 같이 나오도록 한다.

maximum = 65
sum = 224
average = 37.33

<문제 2>
위 문제를 다 풀어낸 학생은 다음의 내용을 추가로 코딩할 것
1)  최대값이 몇번째에 놓여있는가를 프로그램적으로 찾아내어 출력하는 코딩을 작성한다.
2) 40 이상인 값의 갯수를 구하는 프로그램을 작성한다.
출력의 모습은 다음과 같다.

maximum = 65
sum = 224
average = 37.33
max data = 3
above 40 => 3

```java
class Main
{
	public static void main (String[] args)
	{
		int mdata[] = {20,30,65,43,12,54};
		int max = mdata[0];
        int maxIndex = 0;
		for (int i = 0; i<mdata.length; i++) {
			if(mdata[i]>=max) {
				max = mdata[i];
                maxIndex = i;
			}
		}
		System.out.println("maximum =" + max); // <1> - 1)
		System.out.println("max data = " + maxIndex); // <2> - 1)
		int sum = 0;
		int count = 0;
		float avr;
		for (int i = 0; i<mdata.length; i++) {
			sum += mdata[i];
			count++;
		}
		System.out.println("sum =" + sum); // <1> - 2)
		
		
		avr = (float)sum/count;
		System.out.println(String.format("average = %.2f", avr)); // <1> - 3)
		
		count = 0;
		for (int i = 0; i<mdata.length; i++) {
			if(40 <= mdata[i]) {
				count++;
			}
		}
		System.out.println("above 40 => " + count); // <2> - 2)
		
	}
}
```


<문제 3>
다음의 사이트를 참조. 
https://biz.chosun.com/site/data/html_dir/2020/08/19/2020081903481.html
이 기사 중, 다음의 문장

문재인 정부 출범 후 2017년 8월말 발표된 ‘2017~2021 국가재정운용계획’상 2018년 7.1%까지 올라간 재정지출 증가율은 2019년 5.7%, 2020년 5.2%로 낮아질 계획이었다. 그러나 실제 2019년 재정지출 증가율은 9.5% 수준이었다. 2019년 예산안을 발표하면서 공개한 ‘2018~2022 국가재정운용계획’상 2020년 지출 증가율은 7.3%로 둔화될 계획이었지만, 실제 올해 확정된 지출증가율은 9.1% 수준이었다.

위 문장에서 "20xx년 y.y%" 를 모두 골라 출력하는 프로그램
(출력 결과)
2018년 7.1%
2019년 5.7%
2020년 5.2%

```java		
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentences = "문재인 정부 출범 후 2017년 8월말 발표된 ‘2017~2021 국가재정운용계획’상 2018년 7.1%까지 올라간 재정지출"
				+ " 증가율은 2019년 5.7%, 2020년 5.2%로 낮아질 계획이었다."
				+ " 그러나 실제 2019년 재정지출 증가율은 9.5% 수준이었다."
				+ " 2019년 예산안을 발표하면서 공개한 ‘2018~2022 국가재정운용계획’상 "
				+ "2020년 지출 증가율은 7.3%로 둔화될 계획이었지만,"
				+ " 실제 올해 확정된 지출증가율은 9.1% 수준이었다.";	
		int indexOfPercent;
		String[] resultArr = new String[6];							
		for (int i = 0; i < resultArr.length; i++) {			
			indexOfPercent = sentences.indexOf("%");
			resultArr[i] = sentences.substring(indexOfPercent-9,indexOfPercent+1);
			sentences = sentences.substring(indexOfPercent + 2);
			
			if (!(resultArr[i].contains("20") && resultArr[i].contains("년"))) {
				continue;
			}
			System.out.println(resultArr[i]);
	
		}
	}	
		
}		

```


---
시험 문제 :
`for (int i = 0; i < count; i++;)`  
i가 전역변수로 들어올 떄, 지역변수로 들어올 때 차이.  
