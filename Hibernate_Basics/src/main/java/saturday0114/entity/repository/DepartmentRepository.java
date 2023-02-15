package saturday0114.entity.repository;


import saturday0114.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import saturday0114.entity.utils.HibernateUtil;

import java.util.List;

public class DepartmentRepository {
    public void save(Department department) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(department);
        transaction.commit();
        session.close();


    }

    public void delete(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(department);
        transaction.commit();
        session.close();
    }

    public List<Department> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("FROM Department", Department.class).list();
    }
}
