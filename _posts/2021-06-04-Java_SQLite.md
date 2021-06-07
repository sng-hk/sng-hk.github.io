---
title: "Java - 활용 : SQLite 기초"
layout: single
classes: wide
tags: [Java]
---
  
<a href="https://github.com/sqlitebrowser/sqlitebrowser">SQLite 설치 링크</a>  
  
  
## DB 기본 명령어  
  
## Java DB 기본 명령어  
  
**SELECT)**  
ResultSet rs = stat.executeQuery("SELECT ID,Name FROM User");  
  
**INSERT)**  
prstat = con.prepareStatement("insert into User(ID,Name,Age) values(?,?,?)");   
...  
int r = prstat.executeUpdate();  
  
SELECT, INSERT 명령어 차이  

---

**DELETE)**

**UPDATE)**


```java

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class IdNameAgeDB extends JFrame {
	Connection con = null;
	Scanner sc = new Scanner(System.in);
	JTextField tf = new JTextField();
	JTextArea ta = new JTextArea();
	JScrollPane js = new JScrollPane();
	String iddata;

	IdNameAgeDB() {
		setTitle("My DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setVisible(true);
		add(tf, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iddata = tf.getText();
				try {
					Class.forName("org.sqlite.JDBC");
					String dbFile = "C:\\work\\dbTest.db";
					con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
					Statement stat = con.createStatement();

					String sqldata = "SELECT ID,Name,Age FROM User where ID=" + iddata;
					ResultSet rs = stat.executeQuery(sqldata);
					while (rs.next()) {
						String id = rs.getString("ID");
						String name = rs.getString("Name");
						String age = rs.getString("Age");
						ta.append(id + " " + name + " " + age + "\n");
					}

				} catch (Exception except) {
					except.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (Exception except) {
						}
					}
				}
				tf.setText("");
			}
		});

		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "C:\\work\\dbTest.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			Statement stat = con.createStatement();

			String sqldata = "SELECT ID,Name,Age FROM User where ID=" + iddata;
			ResultSet rs = stat.executeQuery(sqldata);
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("Name");
				String age = rs.getString("Age");
				System.out.println(id + " " + name + " " + age);
			}

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

	}
}

public class Main {
	public static void main(String[] args) {
		new IdNameAgeDB();
	}
}
```