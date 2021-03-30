---
title: "C# - Porperty 프로퍼티"
layout: single
classes: wide
tags : [C#]
---

객체지향에서 은닉성을 보장하기 위해서 C#에서는 protected, private 등과 같은 키워드로 변수의 값을 외부에서 지정하는 것을 막도록한다. 그리고 변수에 대한 getters 와 setters를 작성하여 외부에서 함수를 이용해야만 변수 값을 지정해줄 수 있도록한다. 하지만, 클래스 내에서 갖는 변수의 개수가 많아지면 많아질수록 getters 와 setters의 양도 많아질 것이다. 이를 쉽게 해결하기 위해 C#에선느 프로퍼티라는 기능을 제공한다.
// 프로퍼티
            public int Hp
            {
                get;set;
            }
. . . . . . . . . . . . . .
            private int _hp;
            public int GetHp() { return _hp; }
            public void SetHp(int value) { _hp = value; }

클래스 안의 변수를 멋대로 외부에서 접근하지 않도록 하고싶을 때 기본적으로 변수는 private으로 선언한 다음에, 그 변수에 접근할 수 있는 public 함수를 만들어서 사용하는 것이 당연했는데, C#에서는 편리하게 프로퍼티를 만들어서 사용할 수 있다. 프로퍼티는 사실상 함수긴 하지만,  그냥 public 변수에 접근하고 고치는 것처럼 굉장히 간편하게 사용할 수 있다. 

다른 사람의 코드에서 프로퍼티로 구현해놓은 것을 봐도 읽을 수 있어야한다.\


변수와 은닉성
private int a;
private int SetA();
public int GetA();

프로퍼티와 은닉성
public int a { get; private set; }

같은 기능을 한다.
a가 어떤 값인지는 가져올 수 있으나, 외부에서 직접적으로 a의 값을 조작할 수 없다.