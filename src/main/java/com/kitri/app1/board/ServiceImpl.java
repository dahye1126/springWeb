package com.kitri.app1.board;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;



@Component("boardService")
public class ServiceImpl implements Service {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private Dao dao;
	
/*	public ServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		dao = sqlSession.getMapper(Dao.class);
	}*/
	@Override
	public void addArticle(Article a) {
		dao = sqlSession.getMapper(Dao.class);
		dao.insert(a);
	}

	@Override
	public ArrayList<Article> getAll() {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectAll();
	}

	@Override
	public Article getByNum(int num) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByNum(num);
	}

	@Override
	public ArrayList<Article> getByWriter(String writer) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByWriter(writer);
	}

	@Override
	public ArrayList<Article> getByTitle(String title) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByTitle(title);
	}

	@Override
	public void editArticle(Article a) {
		dao = sqlSession.getMapper(Dao.class);
		dao.update(a);
	}

	@Override
	public void delArticle(int num) {
		dao = sqlSession.getMapper(Dao.class);
		dao.delete(num);
	}

}
