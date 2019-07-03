package week2.monday;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import week2.monday.model.Department;
import week2.monday.model.Employee;

import java.util.*;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = createSmallCompany();
		Employee tempEmployee = empList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(tempEmployee.getName());
		Employee empMa =
		empList.stream()
		.reduce(new Employee(), (e1,e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		System.out.println(empMa.getName());
		
		//pritn people with julie as amanager
		List<Employee> empWithSame = 
		empList.stream()
		.filter(e -> e.getManagerId() != null && e.getManagerId() == 3)
		.collect(Collectors.toList());
		
		String result = 
				empWithSame.stream()
				.map(e -> e.getName())
				.collect(Collectors.joining(" and ", "Same Manager: ", " report to Jullie"));
		System.out.println(result);
		
		List<Employee> empWithNo =
				empList.stream()
				.filter(e -> e.getManagerId() == null)
				.collect(Collectors.toList());
				
	}
	private static List<Employee> createSmallCompany() {

		Department technologyDept = new Department();
		technologyDept.setId(1);
		technologyDept.setDepartmentName("Technology");
		
		Department hrDept = new Department();
		hrDept.setId(2);
		hrDept.setDepartmentName("Human Resource");
		
		Department payrollDept = new Department();
		payrollDept.setId(3);
		payrollDept.setDepartmentName("Payroll");
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(1, "Tom", 200000, null, hrDept));
		employees.add(new Employee(2, "Joe", 95000, 1, hrDept));
		
		employees.add(new Employee(3, "Julie", 180000, null, technologyDept));
		employees.add(new Employee(4, "Adam", 140000, 3, technologyDept));
		employees.add(new Employee(5, "James", 135000, 3, technologyDept));
		
		employees.add(new Employee(6, "Jake", 125000, null, payrollDept));
		
		return employees;
	}
}
