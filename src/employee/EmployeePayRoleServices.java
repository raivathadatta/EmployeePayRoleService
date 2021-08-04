package employee;

import java.util.*;

public class EmployeePayRoleServices {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Employee> employeelist = new ArrayList<>();

	public EmployeePayRoleServices() {
	}


	public static void main(String[] args) {
		
		EmployeePayRoleServices services = new EmployeePayRoleServices();
		services.readEmployeeData();
		services.writeEmployeeData();
	}

	private void writeEmployeeData() {
		System.out.println("The Employee Data"+" "+employeelist);
	}

	private void readEmployeeData() {
		Employee employee = new Employee();
		System.out.println("Enter the id");
		employee.setId(scanner.nextInt());
		System.out.println("Enter Name of EMPLOYEE");
		employee.setName(scanner.next());
		System.out.println("Enter Salary");
		employee.setSalary(scanner.nextFloat());
		employeelist.add(employee);
		
	}
}
