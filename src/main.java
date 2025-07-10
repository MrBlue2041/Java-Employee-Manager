import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("How many employees will be registred?");
		int N = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			System.out.printf("Employee #%d:\n", i + 1);
			System.out.print("Id:");
			int id = sc.nextInt();

			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary:");
			double salary = sc.nextDouble();
			sc.nextLine();
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
			
		}
		
		System.out.print("Enter the employee id that will have salary increase:");
		int funcid = sc.nextInt();
		int index = GetExistsID(list, funcid);
		if(index == -1) {
			System.out.print("This id not exists.");
		} else {
			System.out.print("Enter the percentage of salary increase:");
			double percentage = sc.nextDouble();
			
			list.get(index).increaseSalary(percentage);
		}
		
		System.out.print("Employees:");
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Employee Name: " + list.get(i).getName() + " Salary: " + list.get(i).getSalary());
		}
		
		sc.close();
	}
	
	public static int GetExistsID(List<Employee> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id)
				return i;
		}	
		return -1;
	}
}
