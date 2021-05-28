---
title: "C - 콘솔 조작 API"
layout: single
classes: wide
tags: [C언어]
---



```cpp

```


커서 깜빡임도 없앤다.
```cpp
//No Cursor
    CONSOLE_CURSOR_INFO CurInfo;
    CurInfo.dwSize=1;
    CurInfo.bVisible=FALSE;
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE),&CurInfo);
```


전체 코드
```cpp
#include <stdio.h>
#include <windows.h>

main() {
    system("mode con cols=56 lines=20 | title MyGame");	
    printf("Hello");

    // text color change 
    CONSOLE_SCREEN_BUFFER_INFO info;
    GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &info);
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), (info.wAttributes&0xf0) | (10 &0xf));
    // (GREEN=10)
    printf("Hello");
	
    // gotoxy
    HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
    COORD pos;
    pos.X = 12;
    pos.Y = 10;
    SetConsoleCursorPosition(consoleHandle,pos);
    printf("Hello");
		
    //No Cursor
    CONSOLE_CURSOR_INFO CurInfo;
    CurInfo.dwSize=1;
    CurInfo.bVisible=FALSE;
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE),&CurInfo);
}
```


재활용성, 생산성을 위해 함수를 이용해 작성
```cpp
#include <stdio.h>
#include <windows.h>

void init(int ScrWidth,int ScrHeight) {
	char temp[40];
	sprintf(temp,"mode con cols=%d lines=%d | title MyGame",
	              ScrWidth,ScrHeight);
	system(temp);
}

enum ConsolColor{ BLACK, DARKBLUE, DARKGREEN,
    DARKCYAN, DARKRED, DARKMAGENTA, DARKYELLOW,
    GRAY, DARKGRAY, BLUE, GREEN, CYAN,
    RED, MAGENTA, YELLOW, WHITE, LIGHTGRAY = 7,
    ORIGINAL = 7, ORIGINALFONT = 7, ORIGINALBG = 0
}; 

void setColor(int color) {
	// text color change 
    CONSOLE_SCREEN_BUFFER_INFO info;
    GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &info);
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), (info.wAttributes&0xf0) | (color &0xf));
}

void gotoxy(int x,int y) {
	HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
	COORD pos;
	pos.X = x;
	pos.Y = y;
	SetConsoleCursorPosition(consoleHandle,pos);
}

void noCursor() {	// No Cursor
    CONSOLE_CURSOR_INFO CurInfo;
    CurInfo.dwSize=1;
    CurInfo.bVisible=FALSE;
    SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE),&CurInfo);
}

main() {
	init(56,20);

	setColor(RED);
	gotoxy(8,2);
	printf("Hello");
	setColor(GREEN);
	gotoxy(8,3);
	printf("Hello");
	setColor(RED);
	noCursor();
}
```


여러 개의 프로그램을 하나의 프로그램으로 만들기
```cpp

```

## 컴파일러 지시어

`#define, #include` 등
앞에 `#`이 붙는 명령어들을 컴파일러 지시어라고 한다.
