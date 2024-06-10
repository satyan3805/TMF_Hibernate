import java.util.List;

import com.sat.entity.Employee;

public class EmployeeCRUD {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		
		List<Employee> empList = dao.getEmployees();
		for(Employee e: empList) {
			System.out.println(e.toString());
		}
//		List<Object[]> empList = dao.getEmployees();
//		for(Object[] e: empList) {
//			
//			System.out.println(e[0]);
//			System.out.println(e[1]);
//			System.out.println(e[2]);
//			
//			Employee emp = new Employee();
//			emp.setId((int)e[0]);
//			emp.setFirstName((String)e[1]);
//			emp.setLastName((String)e[2]);
//			
//			System.out.println(emp.toString());
//			
//		}
//		
//		Employee e = dao.getEmployeeById(4);
//		System.out.println(e.toString());
		
//		List<Object[]> empList = dao.getEmployeesByName("NAVARA");
//		for(Object[] e: empList) {
//			
//			System.out.println(e[0]);
//			System.out.println(e[1]);
//			System.out.println(e[2]);
//			
//			Employee emp = new Employee();
//			emp.setId((int)e[0]);
//			emp.setFirstName((String)e[1]);
//			emp.setLastName((String)e[2]);
//			
//			System.out.println(emp.toString());
//			
//		}
	}

}
