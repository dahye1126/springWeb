package com.kitri.app1.member;

//import java.lang.reflect.Member;

public interface Dao {
	void insert(Member m);
	Member select(String id);
	void update(Member m);
	void delete(String id);
}
