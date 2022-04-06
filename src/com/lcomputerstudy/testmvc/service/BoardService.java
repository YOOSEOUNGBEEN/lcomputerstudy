// ﻿com.lcomputerstudy.testmvc.service > UserService.java
package com.lcomputerstudy.testmvc.service;

import java.util.ArrayList;

import com.lcomputerstudy.testmvc.dao.BoardDAO;
import com.lcomputerstudy.testmvc.vo.Board;

public class BoardService {
	
	private static BoardService service = null;
	private static BoardDAO dao = null;
    
	private BoardService() {
		
	}

	public static BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
			dao = BoardDAO.getInstance();
		}
		return service;
	}

	public ArrayList<Board> getBoards() {
		return dao.getBoards();
	}
	
	public void insertBoard(Board board) {
		dao.insertBoard(board);
	}

	public Board getDetail(Board board) {
		return dao.getDetail(board);
	}

	public void editBoard(Board board) {
		// TODO Auto-generated method stub
		dao.getEdit(board);
	}

	public Board getDelete(Board board) {
		dao.getDelete(board);
		return null;
	}
	
}