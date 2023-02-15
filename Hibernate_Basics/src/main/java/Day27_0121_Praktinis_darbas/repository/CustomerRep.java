package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Employee;
import org.hibernate.Session;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilPW.getSessionFactory;

public class CustomerRep extends BaseRep<Customer> {


    @Override
    public List<Customer> findAll() {
        Session session = getSessionFactory().openSession();
        return session.createQuery("FROM Customer", Customer.class).list();
    }

    @Override
    public void saveList(List<Customer> givenList) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(customer -> session.save(customer));
        transaction.commit();
        session.close();

    }
}





