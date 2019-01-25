package member;

//import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;

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
	public void insert(Member m) {
		Connection conn = db.getConnection();
		String sql = "insert into and_mem values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		

	}

	@Override
	public Member select(String id) {
		Member m = null;
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from and_mem where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return null;
	}

	@Override
	public void update(Member m) {
		Connection conn = db.getConnection();
		String sql = "update and_mem set pwd=?, email=? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getId());
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

	}

	@Override
	public void delete(String id) {
		Connection conn = db.getConnection();
		String sql = "delete and_mem where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

	}

}
