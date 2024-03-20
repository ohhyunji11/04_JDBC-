package edu.kh.jdbc.member.model.dao;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class CommentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
	
	 } catch(Exception e) {
		 e.printStackTrace();
	 }
		
	 
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception)

   // 결과 저장용 객체 생성
   List<Comment> commentList = new ArrayList<CommentList>;
   
   try {
	   
 
   
   String sql = prop.getProperty("selectCommentList");
   
   pstmt = comm.prepareStatement(sql);
   
   pstmt.setInt(1, input);
   
   rs = pstmt.executeQuery();
   
   while(rs.next()) {
	   Comment c = new Comment();
	   
	   c.setCommentNo(rs.getInt(1));
	   c.setCommentContet(rs.getString(2));
	   C.setMemberNo(rs.getInt(3));
	   c.setMemberName(rs.getString(4));
	   c.setCreateDate(rs.getString(5));
	   
	   commentList.add(c); // 리스트에 추가
	   
    }
   }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}