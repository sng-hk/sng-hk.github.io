---
title: "CHAPTER 12. 데이터 길들이기"
layout: single
classes: wide
tags : [Python]
---

# CHAPTER 12. 데이터 길들이기  
  
지금까지 파이썬 언어 자체(데이터 타입, 코드 구조, 구문 등)만 다뤘다. 2부부터는 실제 문제 적용을 다룰 것이다.    
    
이 장에서는 데이터 길들이기에 대한 실용적인 기술을 배운다. 이것을 데이터 먼장(data  munging)또는 데이터베이스 세계의 비즈니스와 유사한 ETL(추출 Export, 변형Transform, 로드Load)이라고 부른다. 프로그래밍 서적들은 일반적으로 이러한 주제를 명시적으로 다루지 않지만, 개발자들은 목적에 다라 데이터를 올바른 형태로 만드는 데 많은 시간을 소비한다.  
  
데이터 과학은 지난 몇 년 동안 매우 인기를 끌고 있다. 하버드 비즈니스 리뷰 기사는 데이터 과학자를  
`21세기 가장 섹시한 직업`이라고 표현했다. 데이터 과학자는 수요가 가장 많은 직업이고 연봉도 높지만  
고된 직업이기도 하다. 데이터 과학은 데이터 베이스의 ETL 요구 사항을 넘어서 사람 눈에 보이지 않는  
통찰력을 발견하기 위해서 머신러닝을 사용한다.  
  
기본 데이터 형식부터 데이터 과학을 위한 가장 유용한 도구까지 살펴볼 것이다.  
  
데이터 형식을 크게 텍스트와 2진수로 나눌 수 있다. 텍스트데이터에서 파이썬 문자열을 사용한다.  
이 장에서는 지금까지 살펴보지 않은 문자열 정보를 다룬다.  
  
* 유니코드 문자  
* 정규표현식 패턴 매칭  
  
이진 데이터와 두 가지 파이썬 내장 타입을 살펴본다.  
  
* 불변 8비트 값의 바이트  
* 가변 값의 바이트 배열  
  
## 12. 1 텍스트 문자열 : 유니코드  
5장에서는 파이썬 문자열 기본을 배웠다. 이제 유니코드를 배워볼 차례다.  
파이썬 3의 문자열은 바이트 배열이 아닌 유니코드 문자 시퀀스다. 이것은 파이썬 2에서  
파이썬 3의 가장 큰 변화다.  
지금까지 이 책의 모든 텍스트 예제는 평범하고 오래된 ASCII 코드를 사용했다.  
숭어가 지구를 돌아다니기 전인 1960년 대에 아스키 코드가 제정됐다. 그때 컴퓨터는  
냉장고만한 크기였고, 단순한 계산을 잘 수행했다. 컴퓨터의 기본저장 단위는 바이트로  
8 비트에 256( = 2^8)개의 고유한 값을 저장할 수 있었다. 여러가지 이유로  
아스키 코드는 7비트만 사용한다. 26개의 대소문자, 숫자 10개, 문장 부호,  
공백 문자, 비인쇄 제어 코드로 구성됐다.  
  
슬프게도 세계에는 아스키코드가 제공하는 것보다 더 많은 문자가 존재한다. 예를 들어 프랑스 식당에  
독일 핫도그는 잇지만, 프랑스 카페에 움라우트가 붙은 게뷔르츠트라미너 와인은 없다.  
파이썬은 많은 문자와 기호를 지원하기 위해 많은 노력을 했다. 이 책에서 가끔 독특한 문자와  
기호를 보게 될 것이다. 다음은 그 중 일부 문자 코드다.  
* Latin-1 ghrdms ISO8859-1  
* Windows code page 1252  
이들 각 문자는 모두 8비트를 사용하지만, 그것조차도 충분하지 않다. 심지어 비유럽 국가 언어는  
8비트로 모든 문자를 표현할 수 없다. 국가별로 독자적인 문자열 인코딩을 사용하는 것을 해결하기 위해  
국제 표준화 기구에서 유니코드를 만들었다. 유니코드는 수학 및 기타 분야의 기호들도 포함한다. 심지어 이모티콘까지!  
  
> 유니코드는 플랫폼, 프로그램, 언어에 상관없이 문자마다 고유한 번호를 제공한다. - 유니코드 협회  
  
유니코드 코드 차트 페이지(https://www.unicode.org/charts)는 현재 정의된 모든 문자 집합과  
이미지에 대한 링크를 제공한다. 가장 최신 버전 12.0은 문자 137,000개를 정의한다.  
각 문자는 고유한 이름과 식별 번호가 있다. 문자들은 유니코드 평면이라고 하는 8비트의 세트로 분할된다.  
첫번째 256평면은 기본 다국어 평면이다. 위키백과의 유니코드 평면(http://bit.ly/unicode-plane)에서  
자세한 내용을 확인할 수 있다.  
  
### 12.1.1 파이썬 3 유니코드 문자열  
유니코드 식별자 또는 문자에 대한 이름을 안다면, 이 문자를 파이썬 문자열에 사용할 수 있다.  
여기에 해당하는 몇가지 예가 있다.  
  
* 4자리 16진수와 그 앞에 \\u는 유니코드의 기본 평면에 256개 중 하나의 문자를 지정한다.  
첫번째 두 숫자는 평면 번호다(00에서 FF까지). 다음 두 숫자는 평면에 있는 문자의 인덱스다. 평면 00은 아스키 코드고,  
평면 안의 문자 위치는 아스키 코드의 번호와 같다.  
* 높은 평면의 문자일수록 비트 수가 더 필요하다. 이에 대한 파이썬의 이스케이프 시퀀스는  
\\U이고, 8자리의 16진수를 사요ㅗㅇ한다. 숫자에 남는 공간이 있다면 왼족에 0을 채운다.  
* 모든 문자는 표준 이름 \\N{name}으로 지정할 수 있다.  
유니코드 문자 이름 인덱스 페이지(http://unicode.org/charts/charindex.html)에서 표준 이름 리스트를 참조한다.  
  
파이썬의 uniocodedata 모듈은 유니코드 식별자와 이름으로 검색할 수 있는 함수를 제공한다.  
* lookup() : 인수로 대소 문자를 구분하지 않는 이름을 취하고, 유니코드 문자를 반환한다.  
* name() : 인수로 유니코드 문자를 취하고, 대문자 이름을 반환한다.  
파이썬 유니코드 문자를 취하는 테스트 함수를 작성해보자. 이름으 검색하고, 그 이름으로 유니코드 문자를  
다시 검색한다(원래 문자와 일치해야 한다).  
  
```python  
def unicode_test(value):  
    import unicodedata  
    name = unicodedata.name(value)  
    value2 = unicodedata.lookup(name)  
    print('value = "%s", name = "%s", value2 = "%s"' % (value, name, value2)  
```  
  
먼저 아스키 문자를 넣어보자.  
  
```python  
>>> unicode_test('A')  
```  
  
아스키 문자 부호를 넣어보자.  
  
```python  
unicode_test('$')  
```  
  
유니코드 통화 문자를 넣어보자.  
```python  
unicode_test('\u00a2')  
```  
  
다른 유니코드 통화 문자를 넣어보자.  
  
```python  
unicode_test('\u20ac')  
```  
  
잠재적으로 발생할 수 있는 유일한 문제는 텍스트를 표시하는 데 사용하는 글꼴 제한이다.  
모든 유니코등 ㅔ대한 이미지가 있는 글꼴은 거의 없으면, 누락된 글꼴에 대해 플레이스홀더  
문자가 표시될 수 있다. 예를 들어 딩벳 글꼴의 SNOWMAN에 대한 유니코드 기호는 다음과 같다.  
  
```python  
unicode_test('\u2603')  
```  
  
문자열에서 단어 cafe를 저장한다고 가정하자. 파일 혹은 웹사이트에서 이 단어를 찾아 복사해서 붙여넣기 한 다음,  
무사히 저장되길 기도해야 한다.  
  
```python  
place = 'cafe'  
```  
  
UTF-8인코등(12.1.2절 참조) 형식의 소스를 복사해서 붙여넣었기 때문에 제대로 동작했다.  
마지막 e 문자는 어떻게 지정할 수 있을까? E에 대한 문자 인덱스를 찾으면  
(http://bit.ly/e-index), E WITH ACUTE, LATIN SMALL LETTER 이름은 00E9 값을 가진다.  
name() 과 lookup() 함수로 확인해보자. 먼저 유니코드로 문자 이름을 얻는다.  
  
```python  
unicodedata.name('\u00e9')  
```  
  
다음에는 이름으로 코드를 얻는다.  
  
```python  
unicodedata.lookup('E WITH ACUTE, LATIN SMALL LETTER')  
```  
  
```  
NOTE_   
유니코드 문자 이름 인덱스 페이지에 등록된 문자 이름은 잘 정리되어있다.  
이들을 파이썬이 사용하는 실제 유니코드 이름을 변환하려면 콤마를 지우고, 콤마 이후에 나오는 이름을  
앞으로 옮겨야 한다. 따라서 E WITH ACUTE, LATIN SMALL LTTER 는 LATIN SMALL LTTER E WITH CUTE  
로 바꿔야 한다.  
```  
  
이제 코드와 이름으로 문자열 café를 저장할 수 있다.  
  
```python  
place = 'caf\u00e9'  
print(place)  
place = 'caf\N{LATIN SMALL LETTER E WITH ACUTE}`  
place  
```  
  
이전 코드에서는 é를 직접 삽입했다. 그리고 다음과 같이 문자열에 추가하는 것도 가능하다.  
  
```python  
u_umlaut = '\N{LATIN SMALL LETTER U WITH DIAERESIS}`  
print(u-umlaut)  
drink = 'Gew' + u_umlaut + 'rztraminer'  
print('Now I can finally have my', drink, 'in a', place)  
```  
문자열 len() 함수는 유니코드의 바이트가 아닌 문자수를 센다.  
  
```python  
print(len('$'))  
print(len('\U0001f47b'))  
```  
  
유니코드 숫자 ID를 알고 있다면, ord()와 chr() 함수를 사용하여 정수 ID로  
단일 문자의 유니코드 문자열을 빠르게 변환할 수 있다.
  
```python  
print(chr(232))  
print(chr(0xe9))  
print(chr(0x1fc6))  
```  
  
### 12.1.2 UTF-8  
파이썬에서 일반 문자열을 처리할 때는 각 유니코드 문자를 저장하는 방법에 대해 걱정하지 않아도 된다.  
그러나 외부 데이터를 교환할 때는 다음 과정이 필요하다.  
* 문자열을 바이트로 인코딩  
* 바이트를 문자열로 디코딩  
유니코드에 65,536 미만의 문자가 있다면 2 바이트로 된 각 유니코드 문자열의 식별자를 저장할 수 있다.  
그러나 불행하게도 문자가 더 많다. 3바이트 또는 4바이트의 식별자로 인코딩할 수 있지만,  
텍스트 문자열에 대한 메모리 및 디스크 저장 공간이 3\~4배 증가한다. 그래서 유닉스 개발자 켄 톰프슨과  
롭 파이크는 뉴저지 식당의 식탁에서 하룻밤 만에 UTF-8 동적 인코딩 형식을 설계했다.유니코드 한 문자당 1\~4바이트를 사용한다.  
* 1 바이트 : 아스키 코드  
* 2 바이트 : 키릴 문자를 제외한 대부분 파생된 라티넝  
* 3 바이트 : 기본 다국어 평면의 나머지  
* 4 바이트 : 아시아 언어 및 기호를 포함한 나머지  
UTF-8은 파이썬, 리눅스, HTML 의 표준 텍스트 인코딩이다. UTF-8은 바르고 완전하며 잘 동작한다.  
코드에 UTF-8 인코딩 방식을 사용하면 다양한 인코딩 방식을 시도하는 것보다 인생이 한결 편해질 것이다.  
  
### 12.1.3 인코딩  
문자열을 바이트로 인코딩해보자. 문자열 encode() 함수의 첫 번째 인수는 인코딩 이름이다.  
[표 12-1] 에서 선택할 수 있다.  
  
표 12 - 1 인코딩)  
    
|인코딩 이름|설명|  
|---|---|  
|'ascii'|7비트 아스키 코드|  
|'utf-8'|8비트 가변 길이 인코딩 형식, 거의 대부분의 문자 지원|  
|'latin-1'|ISO 8859-1로도 알려짐  
|'cp-1252'|윈도우 인코딩 형식|  
    
모두 UTF-8로 인코딩할 수 있다. 유니코드 문자 '\\u2603'을 snwoman에 할당해보자.  
  
```python  
snowman = '\u2603'  
```  
snowman은 한 문자열의 파이썬 유니코드 문자열이다. 내부적으로 몇 바이트가 저장되어야 하는지  
신경 쓸 필요가 없다.  
  
```python  
print(len(snowman))  
```  
유니코드 문자를 바이트 시퀀스로 인코딩해보자.  
```python  
ds = snowman.encode('utf-8')  
```  
앞서 언급했듯이, UTF-8은 가변 길이 인코딩이다. 이 경우 snowman 유니코드 문자를 인코딩하기 위해  
3바이트를 사용한다.  
```python  
print(len(ds))  
print(ds)  
```  
ds는 바이트 배열이기 때문에 len()은 숫자 3을 반환한다.  
UTF-8 이외의 다른 인코딩도 사용할 수 있다. 하지만 유니코드 문자열을 인코딩할 수 없다면  
에러를 얻게 된다. 예를 들어 아스키 인코딩을 사용할 때, 유니코드 문자가 유효한 아스키 문자가 아닌 경우  
실패한다.  
```python  
ds = snowman.encode('ascii')  
```  
인코딩 에외를 피하기 위해 encode() 함수에 두 번째 인수를 취한다. 이전 예제에서는 두 번재 인수를  
지정하지 않아서 기본값인 'strict'가 지정되었다. 이는 아스키 코드가 아닌 문자가 나타났을 때  
UnicodeEncodeError를 발생시킨다. 'ignore'를 사용하여 알 수 없는 문자를 인코딩하지 않도록 해보자.  
  
```python  
snowman.encode('ascii', 'ignore')  
```  
  
  
  
  
