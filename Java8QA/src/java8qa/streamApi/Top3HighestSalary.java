package java8qa.streamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Top3HighestSalary {

	public static void main(String[] args) {
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee(101, "Dheeraj", 20000,"Dhanvad"));
		empList.add(new Employee(102, "Govind", 49000,"Bangalore"));
		empList.add(new Employee(103, "Dheeraj", 44000,"Faridabad"));
		empList.add(new Employee(104, "Pathan", 250000,"Bangalore"));
		empList.add(new Employee(105, "Rahul", 49000,"Mumbai"));
		empList.add(new Employee(106, "Ranjeet", 20000,"Bangalore"));
		empList.add(new Employee(107, "Rishu", 46000,"Mumbai"));
		empList.add(new Employee(108, "Dheeraj", 200000,"Patna"));
		empList.add(new Employee(109, "Kuldeep", 28000,"Patna"));
		empList.add(new Employee(110, "Satish", 90000,"Bangalore"));
		empList.add(new Employee(111, "Ranjeet", 67000,"Mumbai"));
		empList.add(new Employee(112, "Santosh", 70000,"Patna"));
		empList.add(new Employee(113, "Neeraj", 17000,"Patna"));
		empList.add(new Employee(114, "Abhilasha", 85000,"Bangalore"));
		empList.add(new Employee(115, "Ankita",  150000,"Mumbai"));
		
		System.err.println("the id list of the employee is: " +empList);
		
		fetchEmployeeBYId(empList).forEach(e->{
			System.out.println(e);
		});
     System.err.println("\n\nthe list of the employee by name wise");
     fetchEmployeeByTheirNames(empList).forEach(e->{
    	 System.out.println(e);
     });
     
     System.err.println("\n\nthe list of the employee id wise: ");
     for(Map.Entry<Integer, List<Employee>> me:fetchEmployeeIdwise(empList).entrySet()) {
    	 System.out.println(me.getKey() + "=>"+me.getValue());
     }
     
     System.err.println("\n\nthe list of the employee name wise");
     for(Map.Entry<String, List<Employee>> me: fetchAllEmployeeNamewise(empList).entrySet()){
    	 me.getValue().stream().mapToLong(e->e.getId()).filter(e->e>1);
    	 
    		 System.out.println(me.getKey()+"=>" +me.getValue());
   
     }
     
     System.err.println("\n\nthe total employee name wise");
     for(Map.Entry<String, Long> me:countEmployeesNameWise(empList).entrySet()) {
    	 System.out.println(me.getKey()+ " : " +me.getValue());
     }
     
     System.err.println("\n\nthe total employee salary wise");
     for(Map.Entry<Integer,List<Employee>> me: fetchEmployeeSalaryWise(empList).entrySet()) {
    	 System.out.println(me.getKey() + "=>" +me.getValue());
     }
	}
	
	//resource to find employee's id-list
	public static List<Integer> fetchEmployeeBYId(List<Employee> l){
		List<Integer> idList=l.stream().map(e->e.getId()).collect(Collectors.toList());
		
		return idList;
	}
	//resource to find employee's name-list
     public static List<String> fetchEmployeeByTheirNames(List<Employee> l){
    	 List<String> nameList=l.stream().map(e->e.getName()).collect(Collectors.toList());
    	 
    	 return nameList;
     }
     //resource to find All employees by their id by using grouping by
     public static Map<Integer, List<Employee>> fetchEmployeeIdwise(List<Employee> l){
    	 Map<Integer, List<Employee>> empIdMap=l.stream().collect(Collectors.groupingBy(e->e.getId()));
    	 return empIdMap;
     }
     
   //resource to find All employees by their names by using grouping by
     public static Map<String,List<Employee>> fetchAllEmployeeNamewise(List<Employee> l){
    	 Map<String, List<Employee>> empNameMap=l.stream().collect(Collectors.groupingBy(Employee::getName));
    	 return empNameMap;
     }
     
   //resource to find total employees by their names by using grouping by
     public static Map<String,Long> countEmployeesNameWise(List<Employee> l){
    	 Map<String,Long> empCountNameWise=l.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
    	 return empCountNameWise;
     }
     //resource to find all employees salary wise
     public static Map<Integer,List<Employee>> fetchEmployeeSalaryWise(List<Employee> l){
    	 Map<Integer, List<Employee>> empSalWise=l.stream().collect(Collectors.groupingBy(Employee::getSallary));
    	 return empSalWise;
     }
     //resource to find top 3 Employee getting highest salary:approach-1
  // public static Map<Integer, Optional<Employee>> fethTop3HSalEmployee(List<Employee> l){
	   Comparator<Employee> compSal=Comparator.comparing(Employee::getSallary);
	  //l.stream().collect(Employee::getSallary,(BiConsumer<R, ? super Employee>) Collectors.reducing(BinaryOperator.maxBy(compSal)));
   //}
    
}  
