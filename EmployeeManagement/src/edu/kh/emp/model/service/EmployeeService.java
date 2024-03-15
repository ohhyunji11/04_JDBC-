package edu.kh.emp.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();

	/** 전체 사원 정보 조회 서비스
	 * @return List
	 */
	public List<Employee> selectAll() throws Exception{
		
		// 1. 커넥션 생성
		Connection conn = JDBCTemploate.getConnection();
		
		List<Employee> list = dao.selectAll(conn);
		
		close(conn);
		
		
		return list;
	}

	/** 사원 정보 추가 서비스
 	 * @param emp
	 * @return result (1/0)
	 */
	public int insertEmployee(Employee emp) {
	
		Connection conn = getConnection();
		
		int result = dao.insertEmployee(conn, emp);
		
		
				
				
		return 0;
	}

	
	
	/** 사번이 일치하는 사원 정보 수정 서비스
	 * @param emp
	 * @return result
	 */
	public int updateEmployee(Employee emp) {
		
		Connection conn = getConnerction();
		
		int result = dao.updateEmployee(conn, emp);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	/** 사번이 일치하는 사원 정보 삭제 서비스
	 * @param empId
	 * @return result
	 */
	public int deleteEmployee(int empId) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmployee(conn, empId);
		
		if(result > 0) commit(conn);
		else           rollback(conn);
	
		
		close(conn);
		
		
		return result;
	}

}
