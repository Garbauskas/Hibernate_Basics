package saturday0114.entity;

import saturday0114.entity.Department;
import org.hibernate.Session;
import saturday0114.entity.repository.DepartmentRepository;
import saturday0114.entity.utils.HibernateUtil;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Department itDepartment = new Department();
        itDepartment.setName("IT Gurus");
        itDepartment.setBudget(new BigDecimal(15000));

        Department transportDept = new Department();
        transportDept.setName("UAB FastWheels");
        transportDept.setBudget(new BigDecimal(3456000));

        DepartmentRepository departmentRepository = new DepartmentRepository();
        departmentRepository.save(itDepartment);
        departmentRepository.save(transportDept);

        //departmentRepository.delete(itDepartment);
        departmentRepository.findAll().forEach(System.out::println);
    }
}