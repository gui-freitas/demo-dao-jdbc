package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: seller findById ===" );
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TEST 2: seller findByDepartment ===" );
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: seller findAll ===" );
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 4: seller insert ===" );
		Seller newSeller = new Seller(null, "Guilherme", "Guilherme@email.com", new Date(), 4300.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("=== TEST 5: seller update ===" );
		seller = sellerDao.findById(9);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println();
		System.out.println("=== TEST 6: seller delete ===" );
		System.out.println("Enter a id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		

		System.out.println("============ DEPARTMENT ============" );
		
		System.out.println("=== TEST 1: department findById ===" );
		department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println();
		System.out.println("=== TEST 2: department findAll ===" );
		List<Department> listDeparment = departmentDao.findAll();
		for (Department obj : listDeparment) {
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
		
		System.out.println();
		System.out.println("=== TEST 5: department delete ===" );
		System.out.println("Enter a id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}