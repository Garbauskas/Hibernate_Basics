package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Employee;
import Day27_0121_Praktinis_darbas.interfaces.Persistable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilPW.getSessionFactory;

public abstract class BaseRep <T>{
    public Session session;
    public Transaction transaction;

    public void save(Persistable persistable) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(persistable);
        transaction.commit();
        session.close();
    }

    public void update(Persistable persistable) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(persistable);
        transaction.commit();
        session.close();

    }

    public void delete(Persistable persistable) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(persistable);
        transaction.commit();
        session.close();

    }

    public abstract List<T> findAll();

    public abstract void saveList(List<T> givenList);

   // public void saveList(List<Persistable> givenList) {
      //  session = getSessionFactory().openSession();
       // transaction = session.beginTransaction();
       // givenList.forEach(persistable -> session.save(persistable));
       // transaction.commit();
        //session.close();
    }




