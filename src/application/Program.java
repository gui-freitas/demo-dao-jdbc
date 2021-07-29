package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===" );
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println();
		System.out.println("=== TEST 2: department findAll ===" );
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: department insert ===" );
		Department newDepartment = new Department(null, "Finance");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println();
		System.out.println("=== TEST 4: department update ===" );
		department = departmentDao.findById(7);
		department.setName("New Deparment");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		sc.close();
	}
}