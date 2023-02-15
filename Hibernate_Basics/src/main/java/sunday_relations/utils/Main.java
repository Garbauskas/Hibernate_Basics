package sunday_relations.utils;

import org.hibernate.Session;
import sunday_relations.example1.entity.Company;
import sunday_relations.example1.entity.Employee;

import javax.persistence.Embeddable;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Company tesla = new Company();
        tesla.setName("Tesla Corp");

        Employee elon = new Employee();
        elon.setName("Elon Musk");
        elon.setCompany(tesla);

        Employee vitalijus = new Employee();
        vitalijus.setName("Vitalijus");
        vitalijus.setCompany(tesla);

        tesla.setEmployees(Arrays.asList(elon, vitalijus));

        session.save(tesla);
        session.getTransaction().commit();

        Company company = session.find(Company.class, 1L);
        System.out.println(company);

        session.beginTransaction();
        session.delete(company);
        session.getTransaction().commit();


    }
}
