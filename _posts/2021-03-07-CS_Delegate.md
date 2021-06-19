---
title: "C# - Delegate"
layout: single
classes: wide
tags : [C#]
---

# 대리자
지금까지는 코드를 작성할 때, 직관적이고 순차적으로 만들었다.

## 상황
버튼 눌렸다는 함수
함수 내에 PlayerAttack함수 호출.
상황에 따라 이렇게 하기 힘들다.

## 문제

### 설계적인 문제

버튼이 눌렸을 때 일어날 코드를 한 줄씩 떄려박으면,
UI와 게임 로직 코드가 얽힘.
따라서 최대한 UI, 게임 로직 코드는 분리하는게 좋다.

### 현실적인 문제

console 라이브러리는 ms에서 만들어서 준거라서 거 안에 추가할 수 없었다.
buttonpressed가 수정할 수 없는 형태로 제공될 경우가 많다.

### 해결방법
buttonPressed 안에 우리가 원하는 요구사항을 인자로 넘겨주는 방법
함수 자체를 인자로 넘겨주고 어떤 조건이 발생하면 함수를 호출해주는 방법!

**call back**
이런 식으로 함수 자체를 인자로 넘겨주고, 나중에 필요로 할 때, 함수를 역으로 호출하는 경우를 callback 방식이라 한다.
**함수 자체를 인자로 넘겨주는 방식**
함수 자체를 인자로 넘겨주고 어떤 조건이 만족하면 해당 함수를 호출하도록하는 함수를 선언하면,
유니티에서도 우리가 넘겨준 코드가 무엇인지 모른다고하더라도 우리가 필요로하는 함수를 잘 호출하여주면 됨. 


## delegate 예제
```C#
delegate int OnClicked();
// int OnClicked() 자체가 int, void 처럼 하나의 형식이다.
// {반환 : int 입력 : void }인 형식
// OnClicked 가 delegate 형식의 이름이다.

// 예시로 만든 {반환 : int, 입력 : void }인 함수
int TestDelegate() {
    Console.WriteLine("Hello Delegate");
    return 0;
} // 우리가 정의하고 호출하고싶어하는 함수

// 콜백 메서드
static void ButtonPressed(OnClicked clickedFunction)
{
    clickedFunction();
} // ex. 유니티에서 제공하는 함수. 이미 delegate 함수가 인자로 들어올 것을 가정하고 작성됨.
```

```C#
static void Main(string[] args) {
    Console.WriteLine();
    
    ButtonPressed(TestDelegate);
}
```

객체를 만들어서 호출
```C#
static void Main(string[] args) {
    Console.WriteLine();
    
    OnClicked clicked = new OnClicked(TestDelegate);
    clicked();
}
```

객체를 만들어서 인자로 넘겨줌
```C#
static void Main(string[] args) {
    Console.WriteLine();
    
    OnClicked clicked = new OnClicked(TestDelegate);
    ButtonPressed(clicked);
}
```

우리가 고칠 수 없는 함수에서 delegate의 성능이 상당히 발휘되는 것은 맞지만,
접근할 수 있더라도 delegate를 사용함으로써 얻을 수 있는 효과는 존재한다.

예를 들어, sorting 문제를 살펴보자.
[10, 20, 40, 30, 50]
우리가 어떤 함수를 인자로 넣어주느냐에 따라 작은 순서대로 나열될 수도 있고, 큰 순서대로
나열이 되는 다양한 방식으로 동작할 수 있는 함수를 만든다고 가정했을때, 두 숫자의 크기를
비교하는 부분만 공통적으로 묶어내는 등으로 다양하게 응용할 수 있다.

## 델리게이트 체인

델리게이트 객체를 만들어서 사용하게 되면 델리게이트 체인을 구현할 수 있다.
```C#
OnClicked clicked = new OnClicked(TestDelegate);
            clicked += TestDelegate2;
            // 객체를 만들어서 사용하면 할 수 있는 기능 : delegate를 체이닝할 수 있다.
            
            ButtonPressed(clicked);
```

