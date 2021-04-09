---
title: "C - 2차원 배열"
layout: single
classes: wide
tags: [C언어]
---

## 2차원 배열





## 2차원 배열 예제

### 달팽이 문제 예제 풀이 1
```cpp
#include<stdio.h>

main() {
   int a[50][50];
   int i=0, j=0, size;
   
   scanf("%d", &size); // 정사각형 사이즈를 받아옴.
   int count = 1, tmp_cnt = 1;
   
   int right = 0, down = 1, left = 2, up = 3;
   int direction = 0; // 초기 방향 오른쪽을 초기화
    
   while(count <= size*size) {
      a[i][j] = count;
      count++;
      if(direction == right) {
         j++;
         if(j == size - tmp_cnt) {
            direction = down;      
         }
      }
      else if(direction == down) {
         i++;
         if(i == size - tmp_cnt) {
            direction = left;   
         }
      }
      else if(direction == left) {
         j--;
         if(j == tmp_cnt - 1) {
            direction = up;
         }
      }
      else if(direction == up) {
         i--;
         if(i == tmp_cnt) {
            tmp_cnt++;
            direction = right;            
         }
      }
   }
   
   for(i = 0;i<size;i++) {
      for(j = 0;j<size;j++) {
         printf("%d ",a[i][j]);
      }
      printf("\n");
   }
}
```

### 달팽이 문제 예제 풀이 2
```cpp
#include<stdio.h>

main() {
   int a[50][50];
   int i=0, j=0, size;
   
   scanf("%d", &size); // 정사각형 사이즈를 받아옴.
   int count = 1, tmp_cnt = 1;
   
   int right = 0, down = 1, left = 2, up = 3;
   int direction = 0; // 초기 방향 오른쪽을 초기화
    
   while(count <= size*size) {
      a[i][j] = count;
      count++;
      if(direction % 4 == right) {
         j++;
         if(j == size - tmp_cnt) {
            direction++;
         }
      }
      else if(direction % 4 == down) {
         i++;
         if(i == size - tmp_cnt) {
            direction++;   
         }
      }
      else if(direction % 4 == left) {
         j--;
         if(j == tmp_cnt - 1) {
            direction++;
         }
      }
      else if(direction % 4 == up) {
         i--;
         if(i == tmp_cnt) {
            tmp_cnt++;
            direction++;
         }
      }
   }
   
   for(i = 0;i<size;i++) {
      for(j = 0;j<size;j++) {
         printf("%d ",a[i][j]);
      }
      printf("\n");
   }
   
    
}
```