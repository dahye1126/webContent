package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import member.Member;

public class DaoImpl implements Dao {
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();	
	}
	
	public void close(Connection conn) {
		try {
			conn.close();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(Article a) {
		Connection conn = db.getConnection();
		String sql = "insert into and_board values(seq_and_board.nextval,?,?,?,sysdate)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getWriter());
			pstmt.setString(2, a.getTitle());
			pstmt.setString(3, a.getContent());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

	}

	@Override
	public ArrayList<Article> selectAll() {

		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from and_board";
		ArrayList<Article> list = new ArrayList<Article>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}

	@Override
	public Article selectByNum(int num) {
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from and_board where num=?";
		Article a = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	num);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				a = new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return a;
	}

	@Override
	public ArrayList<Article> selectByWriter(String writer) {
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from and_board where writer=?";
		ArrayList<Article> list = new ArrayList<Article>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}

	@Override
	public ArrayList<Article> selectByTitle(String title) {
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from and_board where title like '%"+title+"%'";
		ArrayList<Article> list = new ArrayList<Article>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return list;
	}

	@Override
	public void update(Article a) {
		Connection conn = db.getConnection();
		String sql = "update and_board set title=?, content=?, w_date=sysdate where num=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getTitle());
			pstmt.setString(2, a.getContent());
			pstmt.setInt(3, a.getNum());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

	}

	@Override
	public void delete(int num) {
		Connection conn = db.getConnection();
		String sql = "delete and_board where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

	}

}
