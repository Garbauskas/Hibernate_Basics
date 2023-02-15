package saturday0114.entity.teamwork;

import org.hibernate.Session;
import saturday0114.entity.teamwork.entity.Patient;
import saturday0114.entity.teamwork.repository.PatientRepository;
import saturday0114.entity.teamwork.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Patient jonas = new Patient();
        jonas.setId(1);
        jonas.setName("Jonas");
        jonas.setAge(25);
        jonas.setEmail("jonas@gmail.com");

        Patient petras = new Patient();
        petras.setId(2);
        petras.setName("Petras");
        petras.setAge(26);
        petras.setEmail("petras@gmail.com");

        Patient zenius = new Patient();
        zenius.setId(3);
        zenius.setName("zenius");
        zenius.setAge(36);
        zenius.setEmail("zenius@gmail.com");

        PatientRepository patientRepository = new PatientRepository();
        patientRepository.save(jonas);
        patientRepository.save(petras);
        patientRepository.save(zenius);

    }
}
