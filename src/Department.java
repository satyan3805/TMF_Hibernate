import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sat.entity.Employee;


@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findEmployeeByName",  
	        query = "from Employee e where e.name = :name"  
	        ) ,
	        
	        @NamedQuery(  
	    	        name = "findEmployeeById",  
	    	        query = "from Employee e where e.id = :eId"  
	    	        )
	    }  
	)  

@Entity
public class Department {
	

	@OneToMany( mappedBy = "category" ,fetch =FetchType.EAGER)
	private List<Employee> empList;

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	} 
	
	
}
