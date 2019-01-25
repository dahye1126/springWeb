package com.kitri.app1.member;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("memService") //빈 이름 등록
public class ServiceImpl implements Service {
	@Resource(name="sqlSession") //의존성주입위해 setter 추가 //name 빈이름
	private SqlSession sqlSession;
	private Dao dao;
	
/*	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		dao = sqlSession.getMapper(Dao.class);
	}*/

/*	public ServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession; //마이바티스 제공 api클래스
		dao = sqlSession.getMapper(Dao.class);//(dao인터페이스)DaoImpl 객체를 생성하여 할당
	}*/
	
	@Override
	public Member getMyInfo(String id) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.select(id);
	}

	@Override
	public void join(Member m) {
		dao = sqlSession.getMapper(Dao.class);
		dao.insert(m);

	}

	@Override
	public void editMyInfo(Member m) {
		dao = sqlSession.getMapper(Dao.class);
		dao.update(m);

	}

	@Override
	public boolean checkId(String id) {
		dao = sqlSession.getMapper(Dao.class);
		Member m = dao.select(id);
		if(m==null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean login(String id, String pwd) {
		dao = sqlSession.getMapper(Dao.class);
		Member m = dao.select(id);
		if(m != null && m.getPwd().equals(pwd)) {
			return true;
		}
		return false;
	}

	@Override
	public void delMember(String id) {
		dao = sqlSession.getMapper(Dao.class);
		dao.delete(id);

	}

}
