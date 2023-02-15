package hibernate.Sunday_teamwork.utils;

import hibernate.Sunday_teamwork.entity.Person;
import hibernate.Sunday_teamwork.entity.Phone;
import hibernate.Sunday_teamwork.entity.ServiceProvider;
import hibernate.Sunday_teamwork.service.Json;
import org.hibernate.Session;
import sunday_relations.utils.HibernateUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Person antanas = new Person();
        antanas.setName("Antanas");

        Phone iphone = new Phone();
        iphone.setName("iPhone");
        iphone.setPerson(antanas);

        ServiceProvider telia = new ServiceProvider();
        telia.setName("Telia");
        telia.setPhone(iphone);
        iphone.setServiceProvider(telia);

        Phone samsung = new Phone();
        samsung.setName("Samsung");
        samsung.setPerson(antanas);

        ServiceProvider tele2 = new ServiceProvider();
        tele2.setName("Tele2");
        tele2.setPhone(samsung);
        samsung.setServiceProvider(tele2);

        antanas.setPhone(Arrays.asList(iphone, samsung));

        session.save(antanas);
        session.getTransaction().commit();

        Person person = session.find(Person.class, 1L);
        System.out.println(person);

        //session.beginTransaction();
        //session.delete(person);
        //session.getTransaction().commit();

        Phone phone = session.get(Phone.class, 2L);
        phone.setName("Huawey");
        session.beginTransaction();
        session.update(phone);
        session.getTransaction().commit();



    }
}
