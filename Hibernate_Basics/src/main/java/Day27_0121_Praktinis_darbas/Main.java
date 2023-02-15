package Day27_0121_Praktinis_darbas;

import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Project;
import Day27_0121_Praktinis_darbas.repository.*;
import Day27_0121_Praktinis_darbas.service.CustomerInfoService;
import Day27_0121_Praktinis_darbas.service.DataMapperService;
import Day27_0121_Praktinis_darbas.service.JSONService;
import Day27_0121_Praktinis_darbas.service.ProjectInfoService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        CustomerRep customerRep = new CustomerRep();
        ProjectRep projectRep = new ProjectRep();
        EmployeeRep employeeRep = new EmployeeRep();
        AddressRep addressRep = new AddressRep();

        JSONService jsonService = new JSONService();
        List<Customer> customerList = jsonService.loadDataToList();

        DataMapperService dataMapperService = new DataMapperService();
        List<Customer> mappedList = dataMapperService.mapsJsonList(customerList);

        customerRep.saveList(mappedList);

        Customer newCustomer = jsonService.importNewCustomer();
        List<Customer> singleCustomer = dataMapperService.mapsJsonList(Collections.singletonList(newCustomer));
        customerRep.save(singleCustomer.get(0));

        List<Customer> customersFromDB = customerRep.findAll();

        CustomerInfoService customerInfoService = new CustomerInfoService();
        System.out.println("------Customer with most projects-----");
        customerInfoService.findWithMostProjects(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most employees-----");
        customerInfoService.findWithMostEmployees(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most income-----");
        customerInfoService.findWithMostIncome(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most expenses-----");
        customerInfoService.findWithMostCosts(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most profit-----");
        customerInfoService.findMostProfitable(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with least profit-----");
        customerInfoService.findLeastProfitable(customersFromDB).forEach(System.out::println);

        List<Project> projectList = projectRep.findAll();

        ProjectInfoService projectInfoService = new ProjectInfoService();
        System.out.println("------Project with most employees-----");
        projectInfoService.findWithMostEmployees(projectList).forEach(System.out::println);
        System.out.println("------Project with most income-----");
        projectInfoService.findWithMostIncome(projectList).forEach(System.out::println);
        System.out.println("------Project with most cost-----");
        projectInfoService.findWithMostCosts(projectList).forEach(System.out::println);
        System.out.println("------Project with the biggest avarage income-----");
        projectInfoService.findWithBiggestGeneratedEmployeeValue(projectList).forEach(System.out::println);
        System.out.println("------Project with the biggest profit-----");
        projectInfoService.findWithMostProfit(projectList).forEach(System.out::println);
        System.out.println("------Project with the longest term-----");
        projectInfoService.findLongest(projectList).forEach(System.out::println);
        System.out.println("------Project with the shortest term-----");
        projectInfoService.findShortest(projectList).forEach(System.out::println);



    }


}






