package saturday0114.entity.teamwork.repository;


import org.hibernate.Session;
import org.hibernate.Transaction;
import saturday0114.entity.teamwork.entity.Patient;
import saturday0114.entity.utils.HibernateUtil;

import java.util.List;

public class PatientRepository {

    public void save(Patient patient) {

        Session session = saturday0114.entity.teamwork.utils.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(patient);
        transaction.commit();
        session.close();
    }

    public void delete(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(patient);
        transaction.commit();
        session.close();
    }

    public List<Patient> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Patient", Patient.class).list();
    }

    public List<Patient> findByName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Patient", Patient.class).list();
    }
}
