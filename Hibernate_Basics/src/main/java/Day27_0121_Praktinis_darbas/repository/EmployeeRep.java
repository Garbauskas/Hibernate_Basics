package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Employee;
import Day27_0121_Praktinis_darbas.entity.Project;
import org.hibernate.Session;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilPW.getSessionFactory;

public class EmployeeRep extends BaseRep <Employee> {


    @Override
    public List<Employee> findAll() {
        Session session = getSessionFactory().openSession();
        return session.createQuery("FROM Employee", Employee.class).list();
    }

    @Override
    public void saveList(List<Employee> givenList) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(employee -> session.save(employee));
        transaction.commit();
        session.close();

    }
}


