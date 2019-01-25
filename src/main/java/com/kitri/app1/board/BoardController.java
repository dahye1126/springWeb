package com.kitri.app1.board;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
//전체검색->모델앤뷰에 담아 (뷰스-board폴더 list.jsp)
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Resource(name="boardService")
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value="/board/list")
	public String getAll() {
		service.getAll();
		return "board/list";
	}
	
	
}
