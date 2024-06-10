import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sat.entity.Employee;

public class EmployeeDAO {
	
	public EmployeeDAO(){
		
	}
	
	public Employee getEmployeeById(int empId) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    
	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		Employee e = s.get(Employee.class,empId);
		
		Employee e1 = s.load(Employee.class,empId);
		if(e!=null) {
			
		}
		
//		If an object doesn’t exist in database, get() returns null whereas load() throws ObjectNotFoundexception.
//		Expense e = s.load(Expense.class,130);
		s.close();
		sf.close();
		return e;
	}
	
	public List<Employee> getEmployees(){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    
	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		String sqlQuery = "select * from emp1";
		
		List<Employee> resList = s.createNativeQuery(sqlQuery, Employee.class).getResultList();
//		query
//		List<Employee> expensesList = query.getResultList();
		//query.setParameter("catId", catId);
		//List<Employee> expensesList = query.getResultList();
		
		
		//sqlQuery = "select name,empId from emp1 where empId=10"; 
		
		//List<Object> namesList = s.createNativeQuery(sqlQuery, Object.class).getResultList();
//		query
		
		s.close();
		sf.close();
		return resList;
	}
	
	public List<Object[]> getEmployeesByName(String name){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    
	    SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		String sqlQuery = "select * from emp1 where lastName= ? OR firstName= ?"; 
		SQLQuery query = s.createSQLQuery(sqlQuery);
		query.setParameter(1, name);
		query.setParameter(2, name);
		List<Object[]> expensesList = query.list();
		
//		List<Employee> expensesList = query.getResultList();
		s.close();
		sf.close();
		return expensesList;
	}
	

}
