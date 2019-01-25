package com.kitri.app1.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	@Resource(name="memService")
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	
	//@RequestMapping 클라이언트 요청보내면 URL과 비교한다 
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public void joinForm() { //회원가입페이지 이동(반환타입 void면 value값 URL 그대로 member/join.jsp로 이동
		
	}
	
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String join(Member m) {
		service.join(m);
		return "member/login"; //member/login.jsp로 이동
	}
	
	
	//public ModelAndView checkId(HttpServletRequest req) { //리스폰스 리퀘스트 세션 인식X -> 파라미터(HttpServletRequest,HttpServletResponse)로 받아오다 //ModelAndView(뷰페이지경로, 뷰페이지데이터를 담는 객체)
	//String id = req.getParameter("id");
	@RequestMapping("/member/checkId")
	public ModelAndView checkId(@RequestParam(value="id") String id) {	//@RequestParam(value="id") = req.getParameter("id")와 같다(value:"id":전달된 폼파라미터이름, String id 저장할변수타입-  담다)
		ModelAndView mav = new ModelAndView("member/checkId"); //생성자에 뷰페이지 경로
		boolean flag = service.checkId(id);
		mav.addObject("flag", flag); //("flag" 데이터이름, flag 값)
		return mav;
	}
	
	//ex) (@RequestParam(value="num") int num)
	
	
	@RequestMapping("/member/loginForm")
	public String loginForm() {
		return "member/login";
	}
	
	
	@RequestMapping("/member/login")
	public String login(HttpServletRequest req, Member m) { //로그인처리 session->HttpSession->HttpServletRequest
		HttpSession session = req.getSession(); //사용하고있는 session 반환
		String result = "";
		boolean flag = service.login(m.getId(), m.getPwd());
		if(flag) {
			session.setAttribute("id", m.getId());
			result = "member/menu";
		}else {
			result = "member/login";
		}
		return result;
	}
	
	
	@RequestMapping("/member/myInfo")
	public ModelAndView myInfo(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMyInfo(id);
		ModelAndView mav = new ModelAndView("member/myInfo");
		mav.addObject("m", m);
		return mav;
	}
	
	
	@RequestMapping(value="/member/edit")
	public String edit(Member m) {
		service.editMyInfo(m);
		return "member/menu"; //member/login.jsp로 이동
	}
	
	
	@RequestMapping(value="/member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("id");
		session.invalidate();
		return "member/login"; //member/login.jsp로 이동
	}
	
	
	@RequestMapping(value="/member/out")
	public String out(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		session.removeAttribute("id");
		session.invalidate();
		return "member/login"; //member/login.jsp로 이동
	}
	
	
	
}
