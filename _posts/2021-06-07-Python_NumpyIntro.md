---
title: "Python - Numpy 기초 예제"
layout: single
classes: wide
tags : [Python]
---

# 4. NumPy Basics: Arrays and Vectorized Computation

```python
import numpy as np
np.random.seed(12345)
import matplotlib.pyplot as plt
plt.rc('figure', figsize=(10, 6))
np.set_printoptions(precision=4, suppress=True)
```


```python
import numpy as np
my_arr = np.arange(1000000)
my_list = list(range(1000000))
```


```python
%time for _ in range(10): my_arr2 = my_arr * 2
%time for _ in range(10): my_list2 = [x * 2 for x in my_list]
```

    Wall time: 25.9 ms
    Wall time: 1.36 s
    

## 4.1 The NumPy ndarray: A Multidimensional Array Object


```python
import numpy as np
# Generate some random data
data = np.random.randn(2, 3)
data
```




    array([[-0.2047,  0.4789, -0.5194],
           [-0.5557,  1.9658,  1.3934]])




```python
data * 10
```




    array([[-2.0471,  4.7894, -5.1944],
           [-5.5573, 19.6578, 13.9341]])




```python
data + data
```




    array([[-0.4094,  0.9579, -1.0389],
           [-1.1115,  3.9316,  2.7868]])




```python
print(data.shape); print(data.dtype)
```

    (2, 3)
    float64
    

### 4.4.1 Creating ndarrays


```python
data1 = [6, 7.5, 8, 0, 1]
arr1 = np.array(data1)
arr1
```




    array([6. , 7.5, 8. , 0. , 1. ])




```python
data2 = [[1, 2, 3, 4], [5, 6, 7, 8]]
arr2 = np.array(data2)
arr2
```




    array([[1, 2, 3, 4],
           [5, 6, 7, 8]])




```python
print(arr2.ndim); print(arr2.shape)
```

    2
    (2, 4)
    


```python
print(arr1.dtype); print(arr2.dtype)
```

    float64
    int32
    


```python
# 초기값을 가진 배열 생성하기 :
np.zeros(10)
```




    array([0., 0., 0., 0., 0., 0., 0., 0., 0., 0.])




```python
np.ones((3, 6))
```




    array([[1., 1., 1., 1., 1., 1.],
           [1., 1., 1., 1., 1., 1.],
           [1., 1., 1., 1., 1., 1.]])




```python
np.empty((2, 3, 2))
```




    array([[[1.1250e-311, 2.8162e-322],
            [0.0000e+000, 0.0000e+000],
            [0.0000e+000, 2.4234e-057]],
    
           [[5.9523e-091, 8.6952e-071],
            [4.3187e-038, 2.9564e-032],
            [6.4822e+170, 4.9343e+257]]])




```python
np.arange(15)
```




    array([ 0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14])



### 4.1.2 Data Types for ndarrays


```python
# dtype 옵션 :
arr1 = np.array([1, 2, 3], dtype=np.float64)
arr2 = np.array([1, 2, 3], dtype=np.int32)
print(arr1); print(arr2)
```

    [1. 2. 3.]
    [1 2 3]
    


```python
# astype() 메소드 :
arr = np.array([1, 2, 3, 4, 5])
float_arr = arr.astype(np.float64)
print(arr.dtype); print(float_arr.dtype)
```

    int32
    float64
    


```python
# astype() 메소드 :
#     소수점 아래 자리는 버린다.
arr = np.array([3.7, -1.2, -2.6, 0.5, 12.9, 10.1])
print(arr)
print(arr.astype(np.int32))
```

    [ 3.7 -1.2 -2.6  0.5 12.9 10.1]
    [ 3 -1 -2  0 12 10]
    


```python
numeric_strings = np.array(['1.25', '-9.6', '42'], dtype=np.string_)
numeric_strings.astype(float)
```




    array([ 1.25, -9.6 , 42.  ])




```python
# astype() 메소드 :
#     다른 배열의 type을 사용하여 데이터 형 변환.
int_array = np.arange(10)
calibers = np.array([.22, .270, .357, .380, .44, .50], dtype=np.float64)
int_array.astype(calibers.dtype)
```




    array([0., 1., 2., 3., 4., 5., 6., 7., 8., 9.])




```python
#     u4 : unit32와 동일하다.
empty_uint32 = np.empty(8, dtype='u4')
empty_uint32
```




    array([ 595210624,        530,          1, 1044258848,  595210056,
                  530,  595210048,        530], dtype=uint32)



### 4.1.3 Arithmetic with NumPy Arrays


```python
# 벡터화 :
#     같은 크기의 배열은 배열의 원소 단위로 수행된다.
arr = np.array([[1., 2., 3.], [4., 5., 6.]])
print(arr)
print(arr * arr)
print(arr - arr)
```

    [[1. 2. 3.]
     [4. 5. 6.]]
    [[ 1.  4.  9.]
     [16. 25. 36.]]
    [[0. 0. 0.]
     [0. 0. 0.]]
    


```python
# 벡터와 스칼라
print(1 / arr)
print(arr ** 0.5)
```

    [[1.     0.5    0.3333]
     [0.25   0.2    0.1667]]
    [[1.     1.4142 1.7321]
     [2.     2.2361 2.4495]]
    


```python
arr2 = np.array([[0., 4., 1.], [7., 2., 12.]])
arr2
arr2 > arr
```




    array([[False,  True, False],
           [ True, False,  True]])



### 4.1.4 Basic Indexing and Slicing


```python
# 인덱싱 :
#     브로드캐스팅
#         배열 = 스칼라 ?
arr = np.arange(10)
print(arr)
print(arr[5])
print(arr[5:8])
arr[5:8] = 12
print(arr)
```

    [0 1 2 3 4 5 6 7 8 9]
    5
    [5 6 7]
    [ 0  1  2  3  4 12 12 12  8  9]
    


```python
# 배열 조삭(slicing) : memory model
#     원본 배열의 views이다. : 
#         데이터는 복사되지 않고, 뷰에 대한 변경은
#         그대로 원본배열에 반영된다는 것이다.
#     리스트와 중요한 차이점이다.
arr_slice = arr[5:8]
arr_slice
```




    array([12, 12, 12])




```python
arr_slice[1] = 12345
arr
```




    array([    0,     1,     2,     3,     4,    12, 12345,    12,     8,
               9])




```python
arr_slice[:] = 64
arr
```




    array([ 0,  1,  2,  3,  4, 64, 64, 64,  8,  9])




```python
# 다차원 배열 : 2차원 배열
arr2d = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
arr2d[2]
```




    array([7, 8, 9])




```python
print(arr2d[0][2])   # 재귀적 표현
print(arr2d[0, 2])   # 간단한 표현
```

    3
    3
    


```python
# 다차원 배열 : 3차원 배열
arr3d = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])
arr3d
```




    array([[[ 1,  2,  3],
            [ 4,  5,  6]],
    
           [[ 7,  8,  9],
            [10, 11, 12]]])




```python
arr3d[0]
```




    array([[1, 2, 3],
           [4, 5, 6]])




```python
# 3차원 배열에 대입문
#     1) scalar, 2) 배열
old_values = arr3d[0].copy()
arr3d[0] = 42
print(arr3d)
arr3d[0] = old_values
print(arr3d)
```

    [[[42 42 42]
      [42 42 42]]
    
     [[ 7  8  9]
      [10 11 12]]]
    [[[ 1  2  3]
      [ 4  5  6]]
    
     [[ 7  8  9]
      [10 11 12]]]
    


```python
arr3d[1, 0]
```




    array([7, 8, 9])




```python
# 변수
x = arr3d[1]
print(x)
print(x[0])
print(x.shape)
```

    [[ 7  8  9]
     [10 11 12]]
    [7 8 9]
    (2, 3)
    

#### Indexing with slices


```python
#     list와 같은 1차원 객체처럼 slice할 수 있다.
print(arr)
print(arr[1:6])
```

    [ 0  1  2  3  4 64 64 64  8  9]
    [ 1  2  3  4 64]
    


```python
# 축을 기준으로 slicing할 수 있다.
#     첫번째 축인 0번 축을 기준으로 
print(arr2d)
print(arr2d[:2])
```

    [[1 2 3]
     [4 5 6]
     [7 8 9]]
    [[1 2 3]
     [4 5 6]]
    


```python
# 다차원 slicing :
#     축을 따라 선택 영역내의 원소가 선택된다.
arr2d[:2, 1:]
```




    array([[2, 3],
           [5, 6]])




```python
# 정수 색인과 슬라이스틀 함께 사용하면,
#     한 차원 낮은 슬라이스를 얻을 수 있다.
arr2d[1, :2]
```




    array([4, 5])




```python
x=arr2d[:2, 2]
print(x.shape)
print(x)
```

    (2,)
    [3 6]
    


```python
#     이렇게 하면 원래 차원의 슬라이스를 얻을 수 있다.
arr2d[:, :1]
```




    array([[1],
           [4],
           [7]])




```python
# 슬라이싱 구문에 값을 대입하면
#     선택 영역 전체에 값이 할당된다.
arr2d[:2, 1:] = 0
arr2d
```




    array([[1, 0, 0],
           [4, 0, 0],
           [7, 8, 9]])



### 4.1.5 Boolean Indexing


```python
# 실험 데이터 준비
names = np.array(['Bob', 'Joe', 'Will', 'Bob', 'Will', 'Joe', 'Joe'])
data = np.random.randn(7, 4)
print(names)
print(data)
```

    ['Bob' 'Joe' 'Will' 'Bob' 'Will' 'Joe' 'Joe']
    [[ 0.0929  0.2817  0.769   1.2464]
     [ 1.0072 -1.2962  0.275   0.2289]
     [ 1.3529  0.8864 -2.0016 -0.3718]
     [ 1.669  -0.4386 -0.5397  0.477 ]
     [ 3.2489 -1.0212 -0.5771  0.1241]
     [ 0.3026  0.5238  0.0009  1.3438]
     [-0.7135 -0.8312 -2.3702 -1.8608]]
    


```python
# 배열에 대한 연산자 : 
#     이것도 벡터화된다.
names == 'Bob'
```




    array([ True, False, False,  True, False, False, False])




```python
# 불리언 배열을 색인으로 사용 :
#     불리언 배열은 반드시 색인하려는 축의 길이와 동일한
#     길이이어야 한다.
data[names == 'Bob']
```




    array([[ 0.0929,  0.2817,  0.769 ,  1.2464],
           [ 1.669 , -0.4386, -0.5397,  0.477 ]])




```python
print(data[names == 'Bob', 2:])
print(data[names == 'Bob', 3])
```

    [[ 0.769   1.2464]
     [-0.5397  0.477 ]]
    [1.2464 0.477 ]
    


```python
print(names != 'Bob')
print(data[~(names == 'Bob')])
```

    [False  True  True False  True  True  True]
    [[ 1.0072 -1.2962  0.275   0.2289]
     [ 1.3529  0.8864 -2.0016 -0.3718]
     [ 3.2489 -1.0212 -0.5771  0.1241]
     [ 0.3026  0.5238  0.0009  1.3438]
     [-0.7135 -0.8312 -2.3702 -1.8608]]
    


```python
cond = names == 'Bob'
print(data[~cond])
```

    [[ 1.0072 -1.2962  0.275   0.2289]
     [ 1.3529  0.8864 -2.0016 -0.3718]
     [ 3.2489 -1.0212 -0.5771  0.1241]
     [ 0.3026  0.5238  0.0009  1.3438]
     [-0.7135 -0.8312 -2.3702 -1.8608]]
    


```python
# 3가지 이름 중에서 2 가지 이름을 선택하려면,
#     &(and 와 |(or같은 논리 연산자를 사용하면 된다.
#     keyword 'and', 'or'는 불리언 배열에 사용 못한다..
mask = (names == 'Bob') | (names == 'Will')
print(mask)
print(data[mask])
```

    [ True False  True  True  True False False]
    [[ 0.0929  0.2817  0.769   1.2464]
     [ 1.3529  0.8864 -2.0016 -0.3718]
     [ 1.669  -0.4386 -0.5397  0.477 ]
     [ 3.2489 -1.0212 -0.5771  0.1241]]
    


```python
# 불리언 색인을 사용해서 배열을 선택하면,
#     항상 데이터 복사가 일어난다.
#         배열의 내용이 바뀌지 않더라도
```


```python
# 불리언 배열로 값을 설정할 때는 상식적으로 동작한다.
data[data < 0] = 0
data
```




    array([[0.0929, 0.2817, 0.769 , 1.2464],
           [1.0072, 0.    , 0.275 , 0.2289],
           [1.3529, 0.8864, 0.    , 0.    ],
           [1.669 , 0.    , 0.    , 0.477 ],
           [3.2489, 0.    , 0.    , 0.1241],
           [0.3026, 0.5238, 0.0009, 1.3438],
           [0.    , 0.    , 0.    , 0.    ]])




```python
# 1차원 불리언 배열로 전행 행이나 열을 선택하는 것도 쉽다.
data[names != 'Joe'] = 7
data
```




    array([[7.    , 7.    , 7.    , 7.    ],
           [1.0072, 0.    , 0.275 , 0.2289],
           [7.    , 7.    , 7.    , 7.    ],
           [7.    , 7.    , 7.    , 7.    ],
           [7.    , 7.    , 7.    , 7.    ],
           [0.3026, 0.5238, 0.0009, 1.3438],
           [0.    , 0.    , 0.    , 0.    ]])



### 4.1.6 Fancy Indexing


```python
# 정수 배열을 사용한 색인
```


```python
arr = np.empty((8, 4))
for i in range(8):
    arr[i] = i
arr
```




    array([[0., 0., 0., 0.],
           [1., 1., 1., 1.],
           [2., 2., 2., 2.],
           [3., 3., 3., 3.],
           [4., 4., 4., 4.],
           [5., 5., 5., 5.],
           [6., 6., 6., 6.],
           [7., 7., 7., 7.]])




```python
# 특정한 순서로 행을 선택하고자 할 경우,
#     정수 값을 가진 ndarray나 list로 지정.
arr[[4, 3, 0, 6]]
```




    array([[4., 4., 4., 4.],
           [3., 3., 3., 3.],
           [0., 0., 0., 0.],
           [6., 6., 6., 6.]])




```python
arr[[-3, -5, -7]]
```




    array([[5., 5., 5., 5.],
           [3., 3., 3., 3.],
           [1., 1., 1., 1.]])




```python
#     다차원 색인 배열인 경우에,
#         각각의 색인 튜플에 대응하는 1차원 배열이 생성
arr = np.arange(32).reshape((8, 4))
print(arr)
print(arr[[1, 5, 7, 2], [0, 3, 1, 2]])
```

    [[ 0  1  2  3]
     [ 4  5  6  7]
     [ 8  9 10 11]
     [12 13 14 15]
     [16 17 18 19]
     [20 21 22 23]
     [24 25 26 27]
     [28 29 30 31]]
    [ 4 23 29 10]
    


```python
# 행렬의 행과 열에 대응하는 사각형 모양의 값을 
#     출력하기 위해서
arr[[1, 5, 7, 2]][:, [0, 3, 1, 2]]
```




    array([[ 4,  7,  5,  6],
           [20, 23, 21, 22],
           [28, 31, 29, 30],
           [ 8, 11,  9, 10]])




```python
# 팬시 색인은 슬라이싱과 달리 선택된 데이터를 새로운
#     배열로 복사한다.
```

### 4.1.7 Transposing Arrays and Swapping Axes


```python
# 배열 전치는 데이터를 복사하지 않고
#     데이터 모양이 바뀐 뷰를 반환하는 특별한 기능이다.
```


```python
# transpose() 메서드와 T 속성
arr = np.arange(15).reshape((3, 5))
print(arr)
print(arr.T)
```

    [[ 0  1  2  3  4]
     [ 5  6  7  8  9]
     [10 11 12 13 14]]
    [[ 0  5 10]
     [ 1  6 11]
     [ 2  7 12]
     [ 3  8 13]
     [ 4  9 14]]
    


```python
# 행렬의 내적 : np.dot() 메서드
arr = np.random.randn(6, 3)
print(arr)
print(np.dot(arr.T, arr))
```

    [[ 0.585   0.1527 -1.5657]
     [-0.5625 -0.0327 -0.929 ]
     [-0.4826 -0.0363  1.0954]
     [ 0.9809 -0.5895  1.5817]
     [-0.5287  0.457   0.93  ]
     [-1.5693 -1.0225 -0.4028]]
    [[ 4.5959  0.9099  0.7701]
     [ 0.9099  1.6275 -0.3439]
     [ 0.7701 -0.3439  8.0431]]
    


```python
arr = np.arange(16).reshape((2, 2, 4))
print(arr)
print(arr.transpose((1, 0, 2)))
```

    [[[ 0  1  2  3]
      [ 4  5  6  7]]
    
     [[ 8  9 10 11]
      [12 13 14 15]]]
    [[[ 0  1  2  3]
      [ 8  9 10 11]]
    
     [[ 4  5  6  7]
      [12 13 14 15]]]
    


```python
arr
arr.swapaxes(1, 2)
```




    array([[[ 0,  4],
            [ 1,  5],
            [ 2,  6],
            [ 3,  7]],
    
           [[ 8, 12],
            [ 9, 13],
            [10, 14],
            [11, 15]]])



## 4.2 Universal Functions: Fast Element-Wise Array Functions


```python
# ndarray 안에 있는데이터 원소별로 연산을
#     수행하는 함수이다.
```


```python
arr = np.arange(10)
arr
```




    array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])




```python
# 단항 유니버설 함수
print(np.sqrt(arr))
print(np.exp(arr))
```

    [0.     1.     1.4142 1.7321 2.     2.2361 2.4495 2.6458 2.8284 3.    ]
    [   1.        2.7183    7.3891   20.0855   54.5982  148.4132  403.4288
     1096.6332 2980.958  8103.0839]
    


```python
# 다항 유니버설 함수
x = np.random.randn(8)
y = np.random.randn(8)
print(x)
print(y)
print(np.maximum(x, y))
```

    [ 0.2205 -0.1934  0.6692 -1.649  -2.2528 -1.1668  0.3536  0.7021]
    [-0.2746 -0.1391  0.1077 -0.6065 -0.4171 -0.017  -1.2241 -1.8008]
    [ 0.2205 -0.1391  0.6692 -0.6065 -0.4171 -0.017   0.3536  0.7021]
    


```python
# 배열 여러개를 반환하는 함수
#     흔하지 않은 경우.
arr = np.random.randn(7) * 5
arr
```




    array([ 2.494 , -4.12  ,  6.6028,  2.5398, -3.2672,  0.9349, -1.9586])




```python
remainder, whole_part = np.modf(arr)
print(remainder)
print(whole_part)
```

    [ 0.494  -0.12    0.6028  0.5398 -0.2672  0.9349 -0.9586]
    [ 2. -4.  6.  2. -3.  0. -1.]
    


```python
print(arr)
np.sqrt(arr)
np.sqrt(arr, arr)
print(arr)
```

    [ 2.494  -4.12    6.6028  2.5398 -3.2672  0.9349 -1.9586]
    [1.5792    nan 2.5696 1.5937    nan 0.9669    nan]
    

    C:\DTools\Anaconda3\envs\tf\lib\site-packages\ipykernel_launcher.py:2: RuntimeWarning: invalid value encountered in sqrt
      
    C:\DTools\Anaconda3\envs\tf\lib\site-packages\ipykernel_launcher.py:3: RuntimeWarning: invalid value encountered in sqrt
      This is separate from the ipykernel package so we can avoid doing imports until
    

## 4.3 Array-Oriented Programming with Arrays


```python
# 벡터화 :
#     배열 연산을 사용해서 반복문을 명시적으로 제거하는 기법
```


```python
points = np.arange(-5, 5, 0.01) # 1000 equally spaced points
xs, ys = np.meshgrid(points, points)
ys
```




    array([[-5.  , -5.  , -5.  , ..., -5.  , -5.  , -5.  ],
           [-4.99, -4.99, -4.99, ..., -4.99, -4.99, -4.99],
           [-4.98, -4.98, -4.98, ..., -4.98, -4.98, -4.98],
           ...,
           [ 4.97,  4.97,  4.97, ...,  4.97,  4.97,  4.97],
           [ 4.98,  4.98,  4.98, ...,  4.98,  4.98,  4.98],
           [ 4.99,  4.99,  4.99, ...,  4.99,  4.99,  4.99]])




```python
z = np.sqrt(xs ** 2 + ys ** 2)
z
```




    array([[7.0711, 7.064 , 7.0569, ..., 7.0499, 7.0569, 7.064 ],
           [7.064 , 7.0569, 7.0499, ..., 7.0428, 7.0499, 7.0569],
           [7.0569, 7.0499, 7.0428, ..., 7.0357, 7.0428, 7.0499],
           ...,
           [7.0499, 7.0428, 7.0357, ..., 7.0286, 7.0357, 7.0428],
           [7.0569, 7.0499, 7.0428, ..., 7.0357, 7.0428, 7.0499],
           [7.064 , 7.0569, 7.0499, ..., 7.0428, 7.0499, 7.0569]])




```python
import matplotlib.pyplot as plt
plt.imshow(z, cmap=plt.cm.gray); plt.colorbar()
plt.title("Image plot of $\sqrt{x^2 + y^2}$ for a grid of values")
```




    Text(0.5, 1.0, 'Image plot of $\\sqrt{x^2 + y^2}$ for a grid of values')




![png](output_86_1.png)



```python
plt.draw()
```


    <Figure size 720x432 with 0 Axes>



```python
plt.close('all')
```

### 4.3.1 Expressing Conditional Logic as Array Operations


```python
# np.where 함수 : 벡터화
#     'x if 조건 else y'와 같은 3항식 벡터와 버전
```


```python
xarr = np.array([1.1, 1.2, 1.3, 1.4, 1.5])
yarr = np.array([2.1, 2.2, 2.3, 2.4, 2.5])
cond = np.array([True, False, True, True, False])
```


```python
result = [(x if c else y)
          for x, y, c in zip(xarr, yarr, cond)]
result
```




    [1.1, 2.2, 1.3, 1.4, 2.5]




```python
result = np.where(cond, xarr, yarr)
result
```




    array([1.1, 2.2, 1.3, 1.4, 2.5])




```python
arr = np.random.randn(4, 4)
print(arr)
print(arr > 0)
```

    [[-0.2723 -0.0171  0.6803  0.6355]
     [-0.7572  0.7181 -0.3043 -1.6778]
     [ 0.427  -1.5637 -0.3675  1.0459]
     [ 1.22   -0.2477 -0.4162 -0.1167]]
    [[False False  True  True]
     [False  True False False]
     [ True False False  True]
     [ True False False False]]
    


```python
np.where(arr > 0, 2, -2)
```




    array([[-2, -2,  2,  2],
           [-2,  2, -2, -2],
           [ 2, -2, -2,  2],
           [ 2, -2, -2, -2]])




```python
np.where(arr > 0, 2, arr) # set only positive values to 2
```




    array([[-0.2723, -0.0171,  2.    ,  2.    ],
           [-0.7572,  2.    , -0.3043, -1.6778],
           [ 2.    , -1.5637, -0.3675,  2.    ],
           [ 2.    , -0.2477, -0.4162, -0.1167]])



### 4.3.2 Mathematical and Statistical Methods


```python
arr = np.random.randn(5, 4)
arr
```




    array([[-1.8448,  2.0687, -0.777 ,  1.4402],
           [-0.1106,  1.2274,  1.9208,  0.7464],
           [ 2.2247, -0.6794,  0.7274, -0.8687],
           [-1.2139, -0.4706, -0.9192, -0.8388],
           [ 0.4352, -0.5578, -0.5675, -0.3726]])




```python
# 전체
print(arr.mean())
print(np.mean(arr))
print(arr.sum())
```

    0.0784883866913893
    0.0784883866913893
    1.569767733827786
    


```python
# mean()이나 sum() 같은 함수는 옵션으로 해당 axis 인수를
#     받아 축에 대한 통계를 계산하고 한 차원 낮은 배열을
#     반환한다.
print(arr.mean(axis=1))
print(arr.sum(axis=0))
```

    [ 0.2218  0.946   0.351  -0.8606 -0.2657]
    [-0.5094  1.5883  0.3845  0.1064]
    


```python
arr = np.array([0, 1, 2, 3, 4, 5, 6, 7])
arr.cumsum()
```




    array([ 0,  1,  3,  6, 10, 15, 21, 28], dtype=int32)




```python
arr = np.array([[0, 1, 2], [3, 4, 5], [6, 7, 8]])
arr
```




    array([[0, 1, 2],
           [3, 4, 5],
           [6, 7, 8]])




```python
print(arr.cumsum(axis=0))
print(arr.cumprod(axis=1))
```

    [[ 0  1  2]
     [ 3  5  7]
     [ 9 12 15]]
    [[  0   0   0]
     [  3  12  60]
     [  6  42 336]]
    

### 4.3.3 Methods for Boolean Arrays


```python
arr = np.random.randn(100)
arr
```




    array([-0.9266,  1.7551,  1.2098,  1.27  , -0.9744, -0.6347, -0.3957,
           -0.2894, -0.7343, -0.7285,  0.8388,  0.2669,  0.7212,  0.911 ,
           -1.0209, -1.4134,  1.2966,  0.2523,  1.1275, -0.5684,  0.3094,
           -0.5774, -1.1686, -0.825 , -2.6444, -0.153 , -0.7519, -0.1326,
            1.4573,  0.6095, -0.4938,  1.24  , -0.1357,  1.43  , -0.8469,
            0.6033,  1.2636, -0.2555, -0.4457,  0.4684, -0.9616, -1.8245,
            0.6254,  1.0229,  1.1074,  0.0909, -0.3501,  0.218 , -0.8948,
           -1.7415, -1.0523,  1.4366, -0.5762, -2.4203, -1.0623,  0.2374,
            0.001 ,  0.0653, -1.3675, -0.0303,  0.9405, -0.6424,  1.0402,
           -1.0829,  0.4292, -0.2362,  0.6418, -0.3317,  1.3941, -1.0767,
           -0.1925, -0.8712,  0.4209, -1.2114, -0.2589, -0.5816, -1.2604,
            0.4646, -1.0702,  0.8042, -0.1567,  2.0104, -0.8871, -0.9779,
           -0.2672,  0.4833, -0.4003,  0.4499,  0.3996, -0.1516, -2.5579,
            0.1608,  0.0765, -0.2972, -1.2943, -0.8852, -0.1875, -0.4936,
           -0.1154, -0.3507])




```python
(arr > 0).sum() # Number of positive values
```




    41




```python
# any() 메서드 :
#     하나 이상의 True 값이 있는 지를 검사하고,
# all() 메서드 :
#     모든 원소가 True인지 검사한다.
bools = np.array([False, False, True, False])
print(bools.any())
print(bools.all())
```

    True
    False
    

### 4.3.4 Sorting


```python
# sort() 메서드 :
#     in-place 정렬을 한다.
```


```python
arr = np.random.randn(6)
arr
```




    array([ 0.0447, -0.8978,  0.8909, -1.1512, -2.6123,  1.1413])




```python
arr.sort()
arr
```




    array([-2.6123, -1.1512, -0.8978,  0.0447,  0.8909,  1.1413])




```python
# 다차원 배열의 경우 :
#     지정된 축의 값의 따라 1차원 부분을 정렬한다.
arr = np.random.randn(5, 3)
arr
```




    array([[-0.8671,  0.3836, -0.437 ],
           [ 0.3475, -1.2302,  0.5711],
           [ 0.0601, -0.2255,  1.3497],
           [ 1.3503, -0.3867,  0.866 ],
           [ 1.7472, -1.4102, -0.3782]])




```python
arr.sort(1)
arr
```




    array([[-0.8671, -0.437 ,  0.3836],
           [-1.2302,  0.3475,  0.5711],
           [-0.2255,  0.0601,  1.3497],
           [-0.3867,  0.866 ,  1.3503],
           [-1.4102, -0.3782,  1.7472]])




```python

```


```python
large_arr = np.random.randn(1000)
large_arr.sort()
large_arr[int(0.05 * len(large_arr))] # 5% quantile
```

### 4.3.5 Unique and Other Set Logic


```python
# 집합 연산 :
```


```python
names = np.array(['Bob', 'Joe', 'Will', 'Bob', 'Will', 'Joe', 'Joe'])
np.unique(names)
ints = np.array([3, 3, 3, 2, 2, 1, 1, 4, 4])
np.unique(ints)
```




    array([1, 2, 3, 4])




```python
sorted(set(names))
```




    ['Bob', 'Joe', 'Will']




```python
# in1d() 메서드 :
#     2개의 배열을 인수로 받아서 첫번째 배열의 각 원소가
#     두번째 배열의 원소를 포함하는 지를 나타내는
#     불리언 배열을 반환한다.
values = np.array([6, 0, 0, 3, 2, 5, 6])
np.in1d(values, [2, 3, 6])
```




    array([ True, False, False,  True,  True, False,  True])



## 4.4 File Input and Output with Arrays


```python
# np.save()
# np.load() :
#     배열 데이터를 효과적으로 디스크에 저장하고
#     불러오는 함수이다. (___.npy)
arr = np.arange(10)
np.save('some_array', arr)
```


```python
arr
del arr
```


```python
np.load('some_array.npy')
```




    array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])




```python
arr
```


    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    <ipython-input-140-24a6d41c5b66> in <module>
    ----> 1 arr
    

    NameError: name 'arr' is not defined



```python
arr = np.load('some_array.npy')
arr
```




    array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])




```python
np.savez('array_archive.npz', a=arr, b=arr)
```


```python
arch = np.load('array_archive.npz')
arch['b']
```




    array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])




```python
np.savez_compressed('arrays_compressed.npz', a=arr, b=arr)
```


```python
!rm some_array.npy
!rm array_archive.npz
!rm arrays_compressed.npz
```

## 4.5 Linear Algebra


```python
# np.dot() 함수
x = np.array([[1., 2., 3.], [4., 5., 6.]])
y = np.array([[6., 23.], [-1, 7], [8, 9]])
x
y
x.dot(y)
```




    array([[ 28.,  64.],
           [ 67., 181.]])




```python
np.dot(x, y)
```




    array([[ 28.,  64.],
           [ 67., 181.]])




```python
np.dot(x, np.ones(3))
```


```python
x @ np.ones(3)
```




    array([ 6., 15.])




```python
from numpy.linalg import inv, qr
X = np.random.randn(5, 5)
mat = X.T.dot(X)
mat
```




    array([[ 9.5217, -0.8643,  0.232 ,  2.4084, -4.2914],
           [-0.8643,  3.331 ,  1.4328,  1.1822, -0.5939],
           [ 0.232 ,  1.4328,  2.4548, -0.2221, -0.6857],
           [ 2.4084,  1.1822, -0.2221,  5.0444,  0.1331],
           [-4.2914, -0.5939, -0.6857,  0.1331,  5.0562]])




```python
# 역행렬
print(inv(mat))
mat.dot(inv(mat))
# 행렬 분할
q, r = qr(mat)
print(q)
print(r)
```

    [[ 0.3283  0.2788 -0.1314 -0.2358  0.2997]
     [ 0.2788  0.7034 -0.3893 -0.3224  0.2749]
     [-0.1314 -0.3893  0.6427  0.1842 -0.0749]
     [-0.2358 -0.3224  0.1842  0.4004 -0.2235]
     [ 0.2997  0.2749 -0.0749 -0.2235  0.4802]]
    [[-0.8853  0.1074 -0.0695 -0.0308  0.446 ]
     [ 0.0804 -0.8387  0.1703  0.3062  0.4091]
     [-0.0216 -0.3679 -0.8377 -0.3872 -0.1115]
     [-0.2239 -0.3298  0.5114 -0.6848 -0.3326]
     [ 0.399   0.2022  0.0533 -0.5352  0.7146]]
    [[-10.7554   0.5003  -0.367   -3.1088   5.7537]
     [  0.      -3.9237  -2.1454  -2.288    1.2681]
     [  0.       0.      -1.9787   2.8069   1.1088]
     [  0.       0.       0.      -3.1516  -2.5815]
     [  0.       0.       0.       0.       1.488 ]]
    

## 4.6 Pseudorandom Number Generation


```python
# numpy.random module :
#     random 내장 함수를 보강하여 다양한 종류의 확률분포
#     함수로부터 효과적으로 표본 값을 생성할 수 있다.
```


```python
samples = np.random.normal(size=(4, 4))
samples
```




    array([[ 0.6342,  1.2597,  0.9649, -0.4344],
           [-0.8796, -0.6948,  1.2264,  0.4573],
           [ 0.1157,  1.014 , -1.135 , -0.2634],
           [ 1.3064, -1.6108, -1.0266,  1.2416]])




```python
from random import normalvariate
N = 1000000
%timeit samples = [normalvariate(0, 1) for _ in range(N)]
%timeit np.random.normal(size=N)
```

    1.62 s ± 35.4 ms per loop (mean ± std. dev. of 7 runs, 1 loop each)
    58 ms ± 3.26 ms per loop (mean ± std. dev. of 7 runs, 10 loops each)
    


```python
np.random.seed(1234)
```


```python
rng = np.random.RandomState(1234)
rng.randn(10)
```




    array([ 0.4714, -1.191 ,  1.4327, -0.3127, -0.7206,  0.8872,  0.8596,
           -0.6365,  0.0157, -2.2427])



## 4.7 Example: Random Walks


```python
import random
position = 0
walk = [position]
steps = 1000
for i in range(steps):
    step = 1 if random.randint(0, 1) else -1
    position += step
    walk.append(position)
```


```python
plt.figure()
```


```python
plt.plot(walk[:100])
```


```python
np.random.seed(12345)
```


```python
nsteps = 1000
draws = np.random.randint(0, 2, size=nsteps)
steps = np.where(draws > 0, 1, -1)
walk = steps.cumsum()
```


```python
walk.min()
walk.max()
```


```python
(np.abs(walk) >= 10).argmax()
```

### 4.7.1 Simulating Many Random Walks at Once


```python
nwalks = 5000
nsteps = 1000
draws = np.random.randint(0, 2, size=(nwalks, nsteps)) # 0 or 1
steps = np.where(draws > 0, 1, -1)
walks = steps.cumsum(1)
walks
```


```python
walks.max()
walks.min()
```


```python
hits30 = (np.abs(walks) >= 30).any(1)
hits30
hits30.sum() # Number that hit 30 or -30
```


```python
crossing_times = (np.abs(walks[hits30]) >= 30).argmax(1)
crossing_times.mean()
```


```python
steps = np.random.normal(loc=0, scale=0.25,
                         size=(nwalks, nsteps))
```

## Conclusion
