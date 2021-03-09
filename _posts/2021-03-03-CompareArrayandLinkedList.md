---
title : "C# - 선형 자료구조"
layout : single
classes: wide
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

**이번에 알아볼 것은 선형 구조이다.**


-----

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

### 연결 리스트

  연속되지 않은 방을 사용  
  장점 : 중간 추가 / 삭제 이점  
  단점 : N번째 방을 바로  찾을 수가 없음 ( 임의 접근 불가 )  
  순서가 없음.  

---

강의에서 C# 에서 동적 배열을 구현하는 연습을 해보았다. 

int, string 등 여러가지 자료형을 다뤄볼 것이기때문에 `제네릭 클래스` 를 이용하여 구현했다.

```C#
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

    }

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
    }
}

```




