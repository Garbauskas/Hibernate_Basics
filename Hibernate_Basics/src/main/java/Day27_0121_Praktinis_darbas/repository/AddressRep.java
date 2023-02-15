package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Address;
import Day27_0121_Praktinis_darbas.entity.Employee;
import org.hibernate.Session;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilPW.getSessionFactory;

public class AddressRep extends BaseRep<Address> {

    @Override
    public List<Address> findAll() {
        Session session = getSessionFactory().openSession();
        return session.createQuery("FROM Address", Address.class).list();
    }

    @Override
    public void saveList(List<Address> givenList) {

        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(address -> session.save(address));
        transaction.commit();
        session.close();

    }
}

