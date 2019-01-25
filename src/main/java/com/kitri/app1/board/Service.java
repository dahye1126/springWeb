package com.kitri.app1.board;

import java.util.ArrayList;

public interface Service {
	void addArticle(Article a);
	ArrayList<Article> getAll();
	Article getByNum(int num);
	ArrayList<Article> getByWriter(String writer);
	ArrayList<Article> getByTitle(String title);
	void editArticle(Article a);
	void delArticle(int num);
}
