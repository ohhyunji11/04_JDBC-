package edu.kh.emp.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.emp.model.vo.Employee;

public class EmployeeDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public EmployeeDAO() {
		try {
			prop = new Properties();
		    prop.loadFromXML(new FileInputStream("query.xml"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	/** 전체 사원 정보 조회 DAO
	 * @param conn
	 * @return list
	 */
	public List<Employee> selectAll(Connection conn) throws Exception{
		
		//  결과 저장용 변수 선언
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL을 수행 후 결과(ResultSet) 반환 받음
			rs = stmt.executeQuery(sql);
		  
			
			// 조회 결과를 얻어와 한 행씩 접근항
			// Employee 객체 생성 후 컬럼값 담기
			// -> List 담기
			while(rs.next()) {
			
				
			int empId = rs.getInt("EMP_ID");	
				// EMP_ID 컬럼은 문자열 컬럼이지만
			    // 저장된 값들은 모두 숫자형태
			    // -> DB에서 자동으로 형변환 진행해서 얻어옴
			
		      String empName = rs.getString("EMP_NAME");
			  String empNo = rs.getString("EMP_NO");
			  String email = rs.getString("EMAIL");
			  String phone = rs.getString("PHONE");
			  String departmentTitle = rs.getString("DEPT_TITLE");
			  String jobName = rs.getString("JOB_NAME");
			  int salary = rs.getInt("SALARY");
			  
			  Employee emp = new Employee(empId, empName, empNo, email, phone,
					  departmentTitle, jobName, salary);
			  		
				
				
			list.add(emp); // List 담기	
				
				
				
			} // while 문종료
			
			
			
			
		} finally {
			// 사용한 JDBC 객체 자원 반환
			close(rs);
			
		}
		
		return list;
	}



	/** 사원 정보 추가 DAO
	 * @param conn
	 * @param emp
	 * @return result (1/0)
	 */
	public int insertEmployee(Connection conn, Employee emp) throws Exception {
		
		int result = 0;
		
		try {
			
			// SQL 작성
			String sql = prop.getProperty("insertEmployee");
			// INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?,?, SYSDATE, NULL, DEFAULT)
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// ? (위치홀더)에 알맞은 값 대입
			pstmt.setInt(1,  emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getempNo);
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp);
			
			
			
		} finally {
			
			
		}
		
		return result;
		
		
		
	}



	/** 사번이 일치하는 사원 정보 삭제 DAO
	 * @param conn
	 * @param empId
	 * @return
	 */
	public int deleteEmployee(Connection conn, int empId) throws Exception{
		
		int result = 0;

		try {
			String sql = prop.getProperty("deleteEmployee");
			// DELETE FROM EMPLOYEE WHERE EMP_ID = ?
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empId);
			
			result = pstmt.executeUpdate();
			
			
			
			
		} finally {
			close(conn);
		}
		
		return result;
	}
	
	
}