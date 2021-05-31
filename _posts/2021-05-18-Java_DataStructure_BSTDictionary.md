---
title:  "Java 자료구조 - BST로 간단한 영어사전 만들기"
layout: single
classes: wide
tags : [자료구조]
---

## 구현

(설명은 아래에!)

**Main.java**
```java
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DictionaryDB dict = new DictionaryDB();
		Scanner sc = new Scanner(System.in);
		int input;
		while (true) {
			System.out.println("어떤 작업을 수행할까요?");
			System.out.println("1. 검색, 2. 단어 모두 조회 3. 삽입, 4. 삭제, 5. DB 불러오기, 6. 사전 저장하기 7. 그만하기");
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("검색할 영어 단어를 입력하세요.");
				String engSearched = sc.next();
				if (dict.getKoWord(engSearched) != null) {
					String koSearched = dict.getKoWord(engSearched);
					System.out.println("우리말" + koSearched);
				}
				break;
			case 2:
				dict.show();
				break;
			case 3:
				System.out.println("삽입할 영어 단어를 먼저 입력하세요.");
				String engInserted = sc.next();
				System.out.println("영어 단어의 우리말 뜻을 입력하세요.");
				String koInserted = sc.next();
				dict.put(engInserted, koInserted);
				break;
			case 4:
				System.out.println("삭제할 단어를 영어로 적으세요.");
				String engDeleted = sc.next();
				dict.delete(engDeleted);
				break;
			case 5:
				dict.load();
				break;
			case 6:
				dict.save();
				break;
			case 7:
				break;
			}
			if (input == 7) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}

```

**DictionaryDB.java**
```java
package DictionaryEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class DictionaryDB {
	Connection con = null;
	String dbFile = "C:\\work\\dictEx.db";;
	PreparedStatement prstat = null;
	static Integer cnt = 1;
	Integer id = cnt;
	String engExp, koMean;

	Word root;

	DictionaryDB() {
		System.out.println("JFrame생성...");
		setTitle("My DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setVisible(true);
		System.out.println("JFrame생성");
	}

// 탐색
	public String getKoWord(String enWord) {
		return getKoWord(root, enWord);
	}

	public String getKoWord(Word w, String enWord) {
		if (w == null)
			return null;
		int t = w.getEnWord().compareTo(enWord);
		if (t > 0)
			return getKoWord(w.getLeft(), enWord); // 왼쪽 서브트리 탐색
		else if (t < 0)
			return getKoWord(w.getRight(), enWord); // 오른쪽 서브트리 탐색
		else
			return w.getKoWord(); // enWord와 같은 노드 발견.
	}

// 삽입
	public void put(String enWord, String koWord) {
		root = put(root, enWord, koWord);
	}

	public void put(Word word) {
		put(word.getEnWord(), word.getKoWord());
	}

	private Word put(Word w, String enWord, String koWord) {
		if (w == null)
			return new Word(enWord, koWord);
		int t = w.getEnWord().compareTo(enWord);
		if (t > 0)
			w.setLeft(put(w.getLeft(), enWord, koWord)); // 삽입할 영단어가 현재노드보다 앞순서이고 null이면, left에 삽입.
		else if (t < 0)
			w.setRight(put(w.getRight(), enWord, koWord));
		else
			w.setKoWord(koWord); // 영단어가 같으면, 영단의 뜻을 갱신
		return w;
	}

	public String min() {
		if (root == null)
			return null;
		return (String) min(root).getEnWord();
	}

	private Word min(Word w) {
		if (w.getLeft() == null)
			return w;
		return min(w.getLeft());
	}

	public void deleteMin() {
		if (root == null)
			System.out.println("empty tree");
		root = deleteMin(root);
	}

	public Word deleteMin(Word w) {
		if (w.getLeft() == null)
			return w.getRight();
		w.setLeft(deleteMin(w.getLeft()));
		return w;
	}

	public void delete(String enWord) {
		root = delete(root, enWord);
	}

	private Word delete(Word w, String enWord) {
		if (w == null)
			return null;
		int t = w.getEnWord().compareTo(enWord);
		if (t > 0)
			w.setLeft(delete(w.getLeft(), enWord));
		else if (t < 0)
			w.setRight(delete(w.getRight(), enWord));
		else { // 삭제할 노드 발견 t = 0 인 경우
			if (w.getRight() == null)
				return w.getLeft();
			if (w.getLeft() == null)
				return w.getRight();
			Word target = w;
			w = min(target.getRight());
			w.setRight(deleteMin(target.getRight()));
			w.setLeft(target.getLeft());
		}
		return w;
	}

// 중위 순회로 순서대로 모든 노드 출력
	public void show() {
		if (root != null)
			show(root);
	}

	private void show(Word w) {
		if (w != null) {
			show(w.getLeft());
			System.out.println(w.getEnWord() + ":" + w.getKoWord());
			show(w.getRight());
		}
	}

// 불러오기
	public void load() {
		// DB에 담긴 단어들을 ArrayList로 저장하여 반환
		ArrayList<Word> WordList = DBsearch();
		Word word;
		for (int i = 0; i < (WordList.size()); i++) {
			word = WordList.get(i);
			System.out.println(word.getEnWord() + ":" + word.getKoWord());
			put(word);
		}
		System.out.println("불러오기 완료");
	}

	public void save() {
		DBdeleteAll();
		if (root != null) {
			this.save(root);
		}
	}

	public void save(Word w) {
		Queue<Word> q = new LinkedList<Word>();
		Word t;
		q.add(w);

		while (!q.isEmpty()) {
			t = q.remove();
			// DB에 Insert
			this.DBinsert(cnt++, t);
			System.out.println("save " + t.getEnWord() + ":" + t.getKoWord());
			if (t.getLeft() != null)
				q.add(t.getLeft());
			if (t.getRight() != null)
				q.add(t.getRight());
		}
		System.out.println("저장 완료, cnt = " + cnt);
		cnt = 0;
	}

	public ArrayList<Word> DBsearch() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT EnWord,KoWord FROM WordTable");
			ArrayList<Word> WordList = new ArrayList<Word>();
			while (rs.next()) {
				engExp = rs.getString("EnWord");
				koMean = rs.getString("KoWord");
				WordList.add(new Word(engExp, koMean));
			}
			return WordList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		return null;
	}

	private void DBinsert(Integer id, Word w) {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			prstat = con.prepareStatement("insert into WordTable(ID,EnWord,KoWord) values(?,?,?)");
			prstat.setString(1, id.toString());
			prstat.setString(2, w.getEnWord());
			prstat.setString(3, w.getKoWord());
			prstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (prstat != null) {
				try {
					prstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}

	private void DBdeleteAll() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			prstat = con.prepareStatement("delete from WordTable");
			int r = prstat.executeUpdate();
			System.out.println("deleteAll r = " + r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (prstat != null) {
				try {
					prstat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
```

## BST 이용  

연결 리스트를 이용해 구현한 `이진 탐색 트리 Binary Search Tree`  
를 활용하여 구현했다.
  
## 기능 설명
  
DB에 저장할 때 **레벨 순회로 저장한 이유**는
루트를 DB Table에서 가장 처음 인덱스 ID = 1에 넣을 수 있어서
저장하기 전 트리 형태와 저장한 후 다시 불러왔을 때 트리 형태가 같다.
저장할 때, 레벨 순회가 아닌 **중위순회로 저장**하면, 다시 불러올 때
트리가 편향 트리가 될 것이라고 예상할 수 있다. 그렇다면 높이가 N이므로
탐색, 삽입 삭제 시 연산시간이 O(N)이 된다.

### 검색

영어 단어를 입력하면 단어에 대응하는 뜻을 출력한다.
  
### 삽입

영단어와 우리말 뜻을 넘겨주면, 사전에 단어를 저장한다.  
  
### 삭제
min() 메서드
deleteMin() 메서드
delete() 메서드

### 단어 모두 출력하기

알파벳 순서대로 단어들을 `영어 : 우리말` 형식으로 출력한다.
BST로 구현된 DicinaryDB객체가 가지는 노드들을 중위순회한다

show() 메서드
중위 순회, 재귀 호출

### DB로부터 불러오기

load() 메서드
DBsearch() 메서드
put() 메서드

### DB에 저장하기

DBdelteAll() 메서드
save() 메서드
레벨 순회
DBinsert() 메서드

### String 클래스 CompareTo 메서드
