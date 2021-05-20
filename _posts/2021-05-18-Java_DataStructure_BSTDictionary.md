---
title:  "Java 자료구조 - BST로 간단한 영어사전 만들기"
layout: single
classes: wide
tags : [자료구조]
---

## 구현

(설명은 아래에!)
```java
package DictionaryEx;

class Word {
   private String enWord; // key로 사용.
   private String koWord; // value로 사용.
   private Word left, right;
   
   public Word(String enWord, String koWord) {
      this.enWord = enWord.toLowerCase();
      this.koWord = koWord.toLowerCase();
      left = right = null;
   }
   public String getEnWord() {
      return enWord;
   }
   public void setEnWord(String enWord) {
      this.enWord = enWord;
   }
   public String getKoWord() {
      return koWord;
   }
   public void setKoWord(String koWord) {
      this.koWord = koWord;
   }
   public Word getLeft() {
      return left;
   }
   public void setLeft(Word left) {
      this.left = left;
   }
   public Word getRight() {
      return right;
   }
   public void setRight(Word right) {
      this.right = right;
   }
}

class Dictionary {
   private Word root;
   
   public void setRoot(Word root) {
      this.root = root;
   }
   
   public Word getRoot() {
      return root;
   }
   
   public Dictionary(String enWord, String koWord) {
      root = new Word(enWord, koWord);
   }
   
   // 탐색
   public String getKoWord(String enWord) {return getKoWord(root, enWord);   }
   public String getKoWord(Word w, String enWord) {
      if (w == null) return null;
      int t = w.getEnWord().compareTo(enWord);
      if (t > 0)       return getKoWord(w.getLeft(), enWord); // 왼쪽 서브트리 탐색
      else if (t < 0) return getKoWord(w.getRight(), enWord); // 오른쪽 서브트리 탐색
      else          return w.getKoWord(); // enWord와 같은 노드 발견.
   }
   
   // 삽입
   public void put(String enWord, String koWord) { root = put(root,enWord,koWord); }
   public Word put(Word w, String enWord, String koWord) {
      if (w == null) return new Word(enWord, koWord);
      int t = w.getEnWord().compareTo(enWord);
      if (t > 0)      w.setLeft(put(w.getLeft(), enWord, koWord)); // 삽입할 영단어가 현재노드보다 앞순서이고 null이면, left에 삽입.
      else if (t < 0)   w.setRight(put(w.getRight(), enWord, koWord));
      else w.setKoWord(koWord); // 영단어가 같으면, 영단의 뜻을 갱신
      return w;
   }

   // 단어들 모두 보여주기
   public void show() { if(root != null) show(root); }
   private void show(Word w) {
      if(w != null) {
         show(w.getLeft());
         System.out.println(w.getEnWord() + ":" + w.getKoWord());
         show(w.getRight());
      }
   }
   
}

public class Main {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Dictionary dict = new Dictionary("Report", "보고서");
      dict.put("Korea", "한국");
      dict.put("Kimchi", "김치");
      dict.put("Horse", "말");
      dict.put("Cup", "잔");
      dict.put("Apple", "사과");

      dict.show();
   }

}
```
  
## BST 이용  
연결 리스트를 이용해 구현한 `이진 탐색 트리 Binary Search Tree`  
를 활용하여  
  
  
## 메서드 설명  
  
**탐색**  
영어 단어를 입력하면 단어에 대응하는 뜻을 출력한다.  
  
**삽입**  
영단어와 우리말 뜻을 넘겨주면, 사전에 단어를 저장한다.  
  
**삭제**  
  
  
**단어들 모두 보여주기**  
알파벳 순서대로 일렬로 단어들을 보여준다.  
BST로 구현된 자료구조를 중위순회한다.   
  
## Comparable 인터페이스  
