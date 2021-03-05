---
title : "C# / 배열, 동적배열, 연결 리스트 생성"
layout : single
classes: wide
---

자료구조는 크게 선형 구조, 비선형 구조로 분류할 수 있다.

(파일구조와 단순구조는 추후에 알아본다. 단순구조는 정수, 실수, 문자, 문자열이 포함된다.)



- **선형 구조**

  자료를 순차적으로 나열한 형태
  **ex) 배열, 연결 리스트, 스택, 큐**

- **비선형 구조**

  하나의 자료 뒤에 다수의 자료가 올 수 있는 형태
  **ex ) 트리, 그래프**
  
  

**이번에 알아볼 것은 선형 구조이다.**


-----



* ### 배열 :

  \- 사용할 방 개수를 고정해서 계약하고 (절대 변경 불가)
  \- 연속된 방으로 배정받아 사용
  장점 : 연속된 방
  단점 : 방을 추가/취소 불가

* ### 동적 배열 :

  \- 사용할 방 개수를 유동적으로 계약
  \- 연속된 방으로 배정 받아 사용
  배열의 단점을 개선. 방을 추가/축소 가능.
  문제점 : 이사 비용은 어떻게 할 것인가? 몸만 들고 온게 아니라, 살림차리려고 엄청 많이 짐을 들고왔다면 문제가됨.
  **동적 배열 할당 정책 :**
  	실제로 사용할 방보다 많이, 여유분을 두고 (대략 1.5~2배) 예약
  **이사 횟수를 최소화 : **
  **장점 :** 

  ​	유동적인 계약 ( 방 추가 예약으로 이사 횟수 최소화 )
  **단점 :** 

  ​	중간 삽입/삭제 힘들다. 중갑 삽입/삭제시 그 뒤에 연속적으로 	오는 자료들은 한칸씩 앞으로 당겨야한다.

* ### 연결 리스트 :

  \- 연속되지 않은 방을 사용
  장점 : 중간 추가 / 삭제 이점
  단점 : N번째 방을 바로  찾을 수가 없음 ( 임의 접근 Random Access 불가 )
  순서가 없음.

-----



강의에서 C# 에서 동적 배열을 구현하는 연습을 해보았다. 

int, string 등 여러가지 자료형을 다뤄볼 것이기때문에 **제네릭 클래스**를 이용하여 구현했다.

```
using System;
using System.Collections.Generic;
using System.Text;

namespace CSharp_DataStructure
{
    class MyList<T>
    {
// 처음으로 List를 생성하면 크기는 1로 지정한다.
        const int DEFAULT_SIZE = 1; 
// 동적배열로 만들고싶은 자료형을 우선 배열의 형태로 선언하고 생성한다.
        T[] _data = new T[DEFAULT_SIZE]; 
		
// 실제로 사용중인 데이터 개수를 관리한다.
        public int Count = 0; 
// 예약된 데이터 개수를 프로퍼티로 관리한다. 초기값은 1
        public int Capacity { get { return _data.Length; } }


// O(N) (for문에서 Count개수가 N이라면 N번 실행되어야하므로) 
// 하지만 Count는 두배씩 늘어나기때문에 
// 시간복잡도는 상수 시간복잡도로 흔히들 말한다. 한마디로 뒤에다가
// 무엇을 추가하는 것에 대한 비용은 무시한다.
// 특이 케이스로 생각한다. 
        public void Add(T item) 
// 해당 자료형의 데이터가 들어왔을 때
// 그 데이터를 우리가 만든 동적배열에 넣어주는 함수.
        {
// 1. 우선 배열 안에 여분 공간이 충분히 남아있는지 확인한다.
            if (Count >= Capacity)
            {
// 공간을 다시 늘려서 확보한다
// 기존의 _data 배열의 크기보다 두배 더 큰 새로운 배열을 만든다.
                T[] newArray = new T[Count * 2]; 
                
                for (int i = 0; i < Count; i++)
                {
// 기존의 _data 배열에 담겨있던 데이터들을 새로운 배열에 하나씩 모두 담아준다.             
                    newArray[i] = _data[i];
                }
 // 이제부터 data가 가르키는 배열은 기존의 배열이 아니라 newArray가 가르키는 배열이다. 
                _data = newArray;
            }
// 2. 공간이 충분히 남아있으므로 인자로 받아온 item 이라는 데이터를 _data 배열안에 넣어준다.
// 가장 최근에 넣었던 데이터의 Index는 Count - 1 
// item은 Count 번째에 들어가야한다. 
// 이제부터 data가 가르키는 배열은 기존의 배열이 아니라 newArray가 가르키는 배열이다.
// 다음에 Add를 해줬을 때 현재 넣어준 item 뒤에 들어와야하므로 Count를 1 증가시킨다.
            _data[Count++] = item;

        }

// O(1)
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
            // 101 102 103 104 105 
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
	    // 배열
        public int[] _data = new int[25];
        // 동적 배열
        public MyList<int> _data2 = new MyList<int>();
        // 연결 리스트
        public LinkedList<int> _data3 = new LinkedList<int>(); 

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



헷갈렸던 부분 : Add함수에서 마지막에 Count++; 이부분이 헷갈렸다.



Add 하는 과정을 예시로 들어보며 이해해보자. ( _data 배열의 크기가 여유로워서 Count가 Capacity보다 작다고 가정하면, 즉 Count>Capacity 인 상황이라면 )

​	_data은 int형 배열이고 크기는 4이고, _data = {1,5,} 인 상황이라고 가정하면,

​	Capacity = 4, Count = 2 이다.

​	인자로 넣고싶은 값은 9 라고 하면, item = 9 이다.

```
_data[Count++] = item;
```

_data[Count] = item; 만 보면 _data의 Count번째 공간에 item이라는 값을 넣겠다는 것이다.

즉, _data의 2번째 공간에 9 라는 값을 넣을 것이다.

Index는 0번째부터 시작이므로, 0번에는 '1' 이 들어가있고, 1번째에는 '5' 가 들어가있다. 그러므로 item은 현재 들어가있는 배열중 가장 마지막인 2번째에 들어온다.

```
_data[Count] = item;
Count++;
// 위와 같은 표현이다.
```



