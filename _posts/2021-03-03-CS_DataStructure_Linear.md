---
title : "C# - 선형 자료구조"
layout : single
classes: wide
tags : [자료구조]
---

## 자료구조의 분류

- 자료구조
  - 단순 구조
    - 정수, 실수, 문자열, 문자
  - **선형 구조**
    - 리스트, 스택, 큐
  - **비선형 구조**
    - 트리, 그래프
  - 파일 구조
    - 순차 파일, 색인 파일, 직접 파일

(파일구조와 단순구조는 추후에 알아보자!)

- **선형 구조**
  자료를 순차적으로 나열한 형태 
- **비선형 구조**
  하나의 자료 뒤에 다수의 자료가 올 수 있는 형태  

**이번에 알아볼 것은 선형 자료구조이다.**


-----
## 선형 리스트  

### 배열  

  \- 사용할 방 개수를 고정해서 계약하고 (절대 변경 불가)  
  \- 연속된 방으로 배정받아 사용  
  장점 : 연속된 방  
  단점 : 방을 추가/취소 불가  

### 동적 배열  

  \- 사용할 방 개수를 유동적으로 계약  
  \- 연속된 방으로 배정 받아 사용  
  배열의 단점을 개선. 방을 추가/축소 가능.  
  문제점 : 이사 비용은 어떻게 할 것인가? 몸만 들고 온게 아니라, 살림차리려고 엄청 많이 짐을 들고왔다면 문제가됨.  
  **동적 배열 할당 정책 :**
  	실제로 사용할 방보다 많이, 여유분을 두고 (대략 1.5~2배) 예약  
  **이사 횟수를 최소화할 수 있다.**
    
  **장점 :** 
  ​	유동적인 계약 ( 방 추가 예약으로 이사 횟수 최소화 )  
  **단점 :** 
  ​	중간 삽입/삭제 힘들다. 중갑 삽입/삭제시 그 뒤에 연속적으로 	오는 자료들은 한칸씩 앞으로 당겨야한다.

## 연결 리스트

  연속되지 않은 방을 사용  
  장점 : 중간 추가 / 삭제 이점  
  단점 : N번째 방을 바로  찾을 수가 없음 ( 임의 접근 불가 )  
  순서가 없음.  

---

## 배열을 이용한 동적 배열 구현  

List<>에서 자주 사용하는 `Add함수`와 `RemoveAt함수`를 구현해보자.

```cs
using System;
using System.Collections.Generic;
using System.Text;

namespace CSharp_DataStructure
{
    class MyList<T>
    {
        const int DEFAULT_SIZE = 1; 
        T[] _data = new T[DEFAULT_SIZE]; 
        public int Count = 0; 
        public int Capacity { get { return _data.Length; } }

        public void Add(T item)
        {
            if (Count >= Capacity)
            {
                T[] newArray = new T[Count * 2]; 
                
                for (int i = 0; i < Count; i++)
                {         
                    newArray[i] = _data[i];
                }
                _data = newArray;
            }
            _data[Count++] = item;
        }
        public T this[int index]
        {
            get { return _data[index]; }
            set { _data[index] = value; }
        }

// O(N) : Count 에 비례해서 연산횟수가 늘어나므로 N.
// 하지만 지우고자하는 index에 따라서 연산횟수가 달라질 수 있다.
// 최악의 조건을 생각한다면 index=0 인 경우이므로 
// 시간복잡도는 O(N)
        public void RemoveAt(int index)
        {
            for (int i = index; i< Count - 1; i++)
            {
                _data[i] = _data[i + 1];
            }
            _data[Count - 1] = default(T);
            Count--;
        }

    } // class MyList<T>

    class Board
    {	      
        // 동적 배열
        public MyList<int> _data2 = new MyList<int>();      
        public void initialize()
        {
            _data2.Add(101);
            _data2.Add(102);
            _data2.Add(103);
            _data2.Add(104);
            _data2.Add(105);

            int temp = _data2[2];

            _data2.RemoveAt(2);
        }
    } // class Board
}

```


---

## 스택  
마지막에 들어온 데이터가 먼저 나간다.  
Last-In, First-Out  
  
```cs
class Program
    {
        static void Main(string[] args)
        {
            Stack<int> stack = new Stack<int>();
            stack.Push(10);
            stack.Push(11);
            stack.Push(12);
            stack.Push(13);

            int data2 = stack.Pop(); // data2 = 13
            int data1 = stack.Peek(); // data2 = 12
        }
    }
```

* Stack<T> 클래스에서 자주 사용되는 함수  
Push() : 데이터를 스택의 가장 뒤쪽에 추가한다.  
Pop() : 스택에 들어와있는 데이터 중 가장 뒤쪽, 즉 가장 최근에 들어온 데이터를  
스택에서 제거하고 해당 데이터를 반환(return)한다.  
  
Peek() : 가장 뒤쪽에 놓인, 즉 가장 최근에 들어온 데이터 값을 반환한다.  

---


## 큐  
먼저 들어온 데이터가 먼저 나간다.  
First-In, Fist-Out  
  
```cs
class Program
    {
        static void Main(string[] args)
        {
            Queue<string> q = new Queue<string>();
            q.Enqueue("hello");
            q.Enqueue("world");
            q.Enqueue("python");
            q.Enqueue("java");
            q.Enqueue("csharp");

            string data1 = q.Dequeue(); // data1 = "hello"
            string data2 = q.Peek(); // data2 = "world"
        }
    }
```

* Queue<T> 클래스에서 자주 사용되는 함수  
Enqueue() : 데이터를 스택의 가장 뒤쪽에 추가한다.  
Dequeue() : 큐에 들어와있는 데이터 중 가장 앞쪽에 놓인, 즉 가장 나중에 들어온  
데이터를 큐에서 제거하고 해당 데이터를 반환(return)한다.  
  
Peek() : 가장 나중에 들어온 데이터 값을 반환한다.  