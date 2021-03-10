---
title: C# 자료구조 - 깊이 우선 탐색 / DFS / Depth First Search
layout: single
classes: wide
---

그래프 탐색이란 하나의 정점으로부터 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것이다. 예를 들어 특정도시에서 다른 도시로 갈 수 있는지, 전자회로에서 특정 단자와 단자가 서로 연결되어 있는지를 탐색하는 알고리즘이다.




재귀 함수를 이용하면 쉽게 코드로 구현할 수 있다.

1) 현재 노드에서부터 연결되어있는 노드 중 임의로 한 곳에 방문한다.
2) 만약 연결되어있는 노드가 없거나, 이미 방문한 노드밖에 없는지 체크한다.
3) 2)의 조건에 부합한다면 현재 노드의 부모 노드로 돌아가서 1)번부터 다시 실행한다.