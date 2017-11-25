package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance_690 {

	static class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	
	private HashMap<Integer, Employee> map = new HashMap<>();
	
    public int getImportance(List<Employee> employees, int id) {
    	if(employees.size() == 0) return 0;
    	
        int result = 0;
               
        
        for(Employee e: employees) {
        	map.put(e.id, e);
        }
        
        //calc total value
        Employee targetEmployees = map.get(id);
        
        if(targetEmployees == null) return 0;
        
        return calc(targetEmployees);
    }
    
    public int calc(Employee employee){
    	if(employee == null) return 0;
    	int result = 0;
    	result += employee.importance;
    	for(Integer e: employee.subordinates) {
    		Employee tEmployee = map.get(e);
    		if(tEmployee!=null)
    			result += calc(tEmployee);
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.id = 1;
		e1.importance = 5;
		e1.subordinates = new ArrayList<>();
		e1.subordinates.add(2);
		e1.subordinates.add(3);
		
		Employee e2 = new Employee();
		e2.id = 2;
		e2.importance = 3;
		e2.subordinates = new ArrayList<>();
		
		Employee e3 = new Employee();
		e3.id = 3;
		e3.importance = 3;
		e3.subordinates = new ArrayList<>();
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		EmployeeImportance_690 s = new EmployeeImportance_690();
		
		System.out.println(s.getImportance(employees,1));
	}

}
