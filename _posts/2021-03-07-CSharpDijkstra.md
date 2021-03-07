---
title: C# 자료구조 - 다익스트라 알고리즘 Dijkstra
layout: single
classes: wide
---

MMORPG 에서는 길찾기를 구현하는 것이 매우 중요하다. 특히 몬스터들이 플레이어를 향해서 길찾기를 하여 다가가야하기때문이다.
BFS의 단점. 직관적으로도 알 수 있는 최단경로라고하더라도, BFS를 이용하면 결국 그래프 전체를 탐색해야한다. 필수적이지 않은 정보들까지  검색을 해봐야 경로를 알 수 있다. 

    1) 임의의 시작 노드를 잡는다 (ex  : start -> 0)
    2) 현재 노드와 간선으로 연결 되어있는 노드들 중에서 가장 가중치가 작은 노드를 후보로 선택한다. 
    3) 후보가 된 노드를 방문한다. 방문한 노드와 연결된 노드들을 조사해서 상황에 따라 발견한 최단거리를 갱신한다.
    4) 연결되지 않았거나 이미 방문한 정점이라면 3)을 생략한다.
    5) 조사한 정점의 최단거리를 갱신한다.
    

-----

    1.
    start = 0
    후보군 : 0
    distance = { 0, max, max, max, max, max}
.

    2.
    closest = distance[0]
    now = 0
    next = 1 or 3
    distance = { 0, 15, max, 35, max, max}
    visited = { t,  t,  f,  f,  f, f }
.

    3.
    closest = distance[1]
    now = 1
    next = 2 or 3
    distance = { 0, 15, 20, 25, max, max}
    visited = { t,  t,  f,  f,  f, f }
.

    4.
    closest = distance[1]
    now = 2
    next = x
    distance = { 0, 15, 20, 25, max, max}
    visited = { t,  t,  t,  f,  f, f }
.    

    5.
    closest = distance[3]
    now = 3
    next = 4
    distance = { 0, 15, 20, 25, 30, max}
    visited = {t, t, t, t, f, f }
.

    6.
    closest = distance[4]
    now = 4
    next = 5
    distance = { 0,15, 20, 25, 30, 35}
    visited = { t, t, t, t, t, f }
.

    7.
    closest = distance[5]
    now = 5

    distance = { 0,15, 20, 25, 30, 35}
    visited = { t, t, t, t, t, t }
.
