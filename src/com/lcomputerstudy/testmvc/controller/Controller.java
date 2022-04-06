package com.lcomputerstudy.testmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcomputerstudy.testmvc.service.BoardService;
import com.lcomputerstudy.testmvc.service.UserService;
import com.lcomputerstudy.testmvc.vo.Board;
import com.lcomputerstudy.testmvc.vo.User;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String view = null;
		
		UserService userService = null;
		BoardService boardService = null;
		Board board = null;
		User user = null;
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		switch (command) {
			case "/user-list.do":
				userService = UserService.getInstance();
				ArrayList<User> list = userService.getUsers();
				view = "user/list";
				request.setAttribute("list", list);
				break;
				
			case "/user-insert.do":
				view = "user/insert";
				break;
				
			case "/user-insert-process.do":
				user = new User();
				user.setU_id(request.getParameter("id"));
				user.setU_pw(request.getParameter("password"));
				user.setU_name(request.getParameter("name"));
				user.setU_tel(request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3"));
				user.setU_age(request.getParameter("age"));
				
				userService = UserService.getInstance();
				userService.insertUser(user);
						
				view = "user/insert-result";
				break;
				
			case "/user-detail.do":
				user = new User(); 
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				userService = UserService.getInstance();
				user = userService.getDetail(user);
				request.setAttribute("user", user);
				view = "user/detail";
				break;
			
			case "/user-edit.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				userService = UserService.getInstance();
				user = userService.getDetail(user);
				request.setAttribute("user", user);
				view = "user/edit";
				break;
			
			case "/user-edit-process.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				user.setU_id(request.getParameter("edit_id"));
				user.setU_pw(request.getParameter("edit_password"));
				user.setU_name(request.getParameter("edit_name"));
				user.setU_tel(request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3"));
				user.setU_age(request.getParameter("edit_age"));
				
				userService = UserService.getInstance();
				userService.editUser(user);
						
				view = "user/edit-result";
				break;
				
			case "/user-delete.do":
				user = new User();
				user.setU_idx(Integer.parseInt(request.getParameter("u_idx")));
				userService = UserService.getInstance();
				user = userService.getDelete(user);
				request.setAttribute("user", user);
				view = "user/delete";
				break;
				
				//---------------------------------------------------------
		
			case "/board-list.do": 
				boardService = BoardService.getInstance();
			  	ArrayList<Board> list2 = boardService.getBoards(); 
			  	view = "board/list";
			  	request.setAttribute("list", list2); 
			  	break;
			 
			case "/board-insert.do":
				view = "board/insert";
				break;
				
			case "/board-insert-process.do":
				board = new Board();
				board.setB_title(request.getParameter("title"));
				board.setB_contents(request.getParameter("contents"));
				board.setB_count(request.getParameter("count"));
				board.setB_writer(request.getParameter("writer"));
				board.setB_date(request.getParameter("date"));

				boardService = BoardService.getInstance();
				boardService.insertBoard(board);

				view = "board/insert-result";
				break;
				
			case "/board-detail.do":
				board = new Board(); 
				board.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
				boardService = BoardService.getInstance();
				board = boardService.getDetail(board);
				request.setAttribute("board", board);
				view = "board/detail";
				break;
			
			case "/board-edit.do":
				board = new Board();
				board.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
				boardService = BoardService.getInstance();
				board = boardService.getDetail(board);
				request.setAttribute("board", board);
				view = "board/edit";
				break;
				
			case "/board-edit-process.do":
				board = new Board();
				board.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
				board.setB_title(request.getParameter("edit_title"));
				board.setB_contents(request.getParameter("edit_contents"));
				board.setB_count(request.getParameter("edit_count"));
				board.setB_writer(request.getParameter("edit_writer"));
				board.setB_date(request.getParameter("edit_date"));
				
				boardService = BoardService.getInstance();
				boardService.editBoard(board);
						
				view = "board/edit-result";
				break;
			
			case "/board-delete.do":
				board = new Board();
				board.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
				boardService = BoardService.getInstance();
				board = boardService.getDelete(board);
				request.setAttribute("board", board);
				view = "board/delete";
				break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view+".jsp");
		rd.forward(request, response);
	}

}