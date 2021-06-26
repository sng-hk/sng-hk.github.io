---
title: "Unity - Component 패턴"
layout: single
classes: wide
tags : [Unity]
---

# 컴포넌트 패턴

설게를 신경 안쓰고 Update() 문에 모든 코드를 다 때려넣으면
추후 유지 보수가 힘들다.

모든 코드를 다 부품화 해서 관리하는 아이디어.
스킬, 물리, 애니메이션과 관련된 각 코드는 별도의 클래스로 만들어서 객체로 생성해 사용.
게임 오브젝트를 Instpector로 살펴보면 Transform, Cube, Mesh Renderer, Mesh Filter 등
모두 별도의 Component로 분리되어 관리되고 있다.

C# 스크립트를 작성해 Component로 활용할 수 있다.

## C# 스크립트

### Start() 메서드

초기에 한 번만 실행되는 메서드

### Update() 메서드

게임이 실행되는 내내 반복해서 실행되는 메서드

