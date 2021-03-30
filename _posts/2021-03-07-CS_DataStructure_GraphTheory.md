---
title: "C# 자료구조 - 그래프"
layout: single
classes: wide
tags : [C#, 자료구조]
---

자료구조에서의 그래프
현실 세계의 사물 - 추상적인 개념 간 연결 관계를 표현한 것.

## 그래프 용어 정리
- 정점
    데이터(사물, 개념 등)
- 간선
    정점 간 연결여부를 나타냄.

- 가중치 그래프
    간선에 가중치를 부여하여 서로 다른 간선에 가중치를 갖는 그래프
    가중치는 어떤 목적인지에 따라서 다양하게 의미 부여를 할 수 있다.
    각 노드 간의 거리, 시간, 확률 등이 가중치의 예시로 들 수 있다.

- 방향 그래프
    간선이 방향을 나타내는 그래프.
    예시 : 일방 통행이 포함된 도로망, SNS에서 사용자 간 팔로우 혹은 팔로잉 관계도

## C#에서 그래프를 표현하는 방법
1. 노드를 인스턴스화한다.
    단점: 노드를 생성할 때마다 new 연산자를 이용해야 한다.
    노드의 수가 많을 때 적합하지 않다.
```C#
class Vertex
    {
        public List<Vertex> edges = new List<Vertex>();        
    }

class Program 
    {
        static void Main(string[] args)
        {
            List<Vertex> graph = new List<Vertex>()
            {
                new Vertex(),
                new Vertex(),
                new Vertex(),
                new Vertex(),
                
                new Vertex(),
                new Vertex(),
            };
            graph[0].edges.Add(graph[1]);
            graph[0].edges.Add(graph[3]);
            graph[1].edges.Add(graph[0]);
            graph[1].edges.Add(graph[2]);
            graph[1].edges.Add(graph[3]);
            graph[3].edges.Add(graph[4]);
            graph[5].edges.Add(graph[4]);
        }
    }
```


2. 리스트 List<> 를 이용한다.
    각 노드가 가리키는 노드를 List로 갖는 배열을 만든다.
    
1\) 배열로 구현
```C#
List<int>[] adjacent = new List<int>[6];
new List<int> {1,3}; // 0번 노드
new List<int> {0,2,3}; // 1번 노드
new List<int> { }; // 2번 노드
new List<int> {4}; // 3번 노드
new List<int> { }; // 4번 노드
new List<int> {4}; // 5번 노드
```


2\) 동적배열로 구현
```C#
List<List<int>> adjacent = new List<List<int>>(6);
adjacent.Add(new List<int> {1,3});
adjacent.Add(new List<int> {0,2,3);
adjacent.Add(new List<int> { });
adjacent.Add(new List<int> {4});
adjacent.Add(new List<int> { });
adjacent.Add(new List<int> {4});
```

