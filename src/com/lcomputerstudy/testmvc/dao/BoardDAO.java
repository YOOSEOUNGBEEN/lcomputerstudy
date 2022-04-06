package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Board;


public class BoardDAO {
private static BoardDAO dao = null;
    
	private BoardDAO () {
		
	}

	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<Board> getBoards() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> list = null;
		
		try {
			conn = DBConnection.getConnection();
			String query = "select * from board";
	       	pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();
	        list = new ArrayList<Board>();

	        while(rs.next()){     
	        	Board board = new Board();
       	       	board.setB_idx(rs.getInt("b_idx"));
       	       	board.setB_title(rs.getString("b_title"));
       	       	board.setB_contents(rs.getString("b_contents"));
       	       	board.setB_count(rs.getString("b_count"));
       	       	board.setB_writer(rs.getString("b_writer"));
       	       	board.setB_count(rs.getString("b_count"));
       	       	list.add(board);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public void insertBoard(Board board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
			
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into board(b_order,b_title,b_contents,b_count,b_writer,b_date) values(1,?,?,0,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_contents());
			pstmt.setString(3, board.getB_writer());
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "update board set b_group = last_insert_id() where b_idx = last_insert_id()";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();	
			
		} catch( Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Board getDetail(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
		    String query = "select * from board where b_idx=?";
		   	pstmt = conn.prepareStatement(query);
		   	pstmt.setInt(1, board.getB_idx());
		   	
		    rs = pstmt.executeQuery();
		
		    while(rs.next()){
		    	board = new Board();
		    	board.setB_idx(rs.getInt("b_idx"));
		    	board.setB_title(rs.getString("b_title"));
		    	board.setB_contents(rs.getString("b_contents"));
		    	board.setB_count(rs.getString("b_count"));
		    	board.setB_writer(rs.getString("b_writer"));
		    	board.setB_date(rs.getString("b_date"));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return board;
	}

	public void getEdit(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	    try {
	    	conn = DBConnection.getConnection();
			String sql = "UPDATE board SET b_title = ?, b_contents = ?, b_count = ?, b_writer = ?, b_date = ? where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_contents());
			pstmt.setString(3, board.getB_count());
			pstmt.setString(4, board.getB_writer());
			pstmt.setString(5, board.getB_date());
			pstmt.setInt(6, board.getB_idx());
			pstmt.executeUpdate();

	    } catch(Exception ex) {
	    	System.out.println("SQLException : "+ex.getMessage());
	    } finally {
	    	try {
	    		if(pstmt != null) pstmt.close();
	    		if(conn != null) conn.close();
	    	}catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}
		
	}

	public void getDelete(Board board) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
			String query = "delete from board where b_idx=?";
		   	pstmt = conn.prepareStatement(query);
		   	pstmt.setInt(1, board.getB_idx());
		   	pstmt.executeUpdate();	
		} catch (Exception ex) {
			System.out.println("SQLException : "+ex.getMessage());
		} finally {
	    	try {
	    		if(pstmt != null) pstmt.close();
	    		if(conn != null) conn.close();
	    	}catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	    	}		
	}
}