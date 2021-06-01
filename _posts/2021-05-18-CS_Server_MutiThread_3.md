---
title: "C#  서버 프로그래밍 - 멀티쓰레드 | 컴파일러 최적화"
layout: single
classes: wide
tags : [C# 서버 프로그래밍]
---
  
Task t 객체  
t.Wait(); // Thread 종료까지 기다리겠다는 의미 Thread 객체였다면 t.join()하는 것과 같음.  
  
## 디버깅 모드와 릴리즈 모드  
평소에는 디버깅 모드로 실행해왔지만,  
실제로 라이브로 배포할 때는 릴리즈모드로 실행한다.  
  
이 때 버그가 터질 수 있다.  
  
```c#
using System;
using System.Threading;
using System.Threading.Tasks;

namespace ServerCore
{
    class Program
    {
        static bool _stop = false; // 힙 메모리에 담김.

        static void ThreadMain()
        {
            Console.WriteLine("쓰레드 시작");

            while (_stop == false)
            {
                // 누군가가 stop 신호를 해주기를 기다린다.
            }

            Console.WriteLine("쓰레드 종료!");
        }

        static void Main(string[] args)
        {
            Task t = new Task(ThreadMain);
            t.Start();
            Thread.Sleep(1000);

            _stop = true;

            Console.WriteLine("Stop 호출");
            Console.WriteLine("종료 대기중");

            t.Wait(); // Thread 종료까지 기다리겠다는 의미 Thread 객체였다면 t.join()하는 것과 같음.
            Console.WriteLine("종료 성공");
        }
    }
}


```

**debug 모드 결과**  
```
쓰레드 시작
Stop 호출
쓰레드 종료!
종료 대기중
종료 성공
```

**release 모드 결과**  
```
쓰레드 시작
Stop 호출
종료 대기중
```
**종료 되지 않고 있다.**  

