package fruitstore.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fruitstore.db.DBConn;
import fruitstore.model.Kinds;

// DAO
public class FruitRepository {
	
	private static final String TAG = "FruitRepository : ";
	private static FruitRepository instance = new FruitRepository();
	private FruitRepository() {}
	public static FruitRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	
	public List<Kinds> firstPage() {
		final String SQL = "SELECT * FROM fruit";
		Kinds kinds = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기			
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			List<Kinds> kindslist = new ArrayList<Kinds>();
								
			while(rs.next()) {
				kinds = new Kinds();
				kinds.setId(rs.getInt("id"));
				kinds.setName(rs.getString("name"));
				kinds.setType(rs.getString("type"));
				kinds.setPrice(rs.getInt("price"));
				kinds.setCountprice(rs.getInt("countprice"));
				
				kindslist.add(kinds);
			}
			System.out.println("FruitRepository : kindslist : " + kindslist);
			return kindslist;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"firstPage() : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Kinds> priceDesc() {
		final String SQL = "SELECT * FROM fruit ORDER BY price DESC";
		Kinds kinds = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기			
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
		List<Kinds> kindslist = new ArrayList<>();
			while(rs.next()) {
				kinds = new Kinds();
				kinds.setId(rs.getInt("id"));
				kinds.setName(rs.getString("name"));
				kinds.setType(rs.getString("type"));
				kinds.setPrice(rs.getInt("price"));
				kinds.setCountprice(rs.getInt("countprice"));
				
				kindslist.add(kinds);
			}
			return kindslist;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"priceDesc() : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Kinds> countpriceDesc() {
		final String SQL = "SELECT * FROM fruit ORDER BY countprice DESC";
		Kinds kinds = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기			
			// if 돌려서 rs -> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
		List<Kinds> kindslist = new ArrayList<>();
			while(rs.next()) {
				kinds = new Kinds();
				kinds.setId(rs.getInt("id"));
				kinds.setName(rs.getString("name"));
				kinds.setType(rs.getString("type"));
				kinds.setPrice(rs.getInt("price"));
				kinds.setCountprice(rs.getInt("countprice"));
				
				kindslist.add(kinds);
			}
			return kindslist;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"orderpriceDesc() : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int deleteById(int id) {
		final String SQL = "DELETE FROM fruit WHERE id = ?";
		//Kinds kinds = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기			
			pstmt.setInt(1, id);
		
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"deleteById(id) : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}