import entities.Address;
import entities.GenderType;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(new Person("Dries","Joncheere", LocalDate.of(1995,6,7)
                , GenderType.MAN,retrievePicture("C:\\Users\\Dries\\Downloads\\blackhole.jpg"),"Zwanzer",false,"http://dries.be").setAddress(new Address("Kruisstraat","Jeruzalem","Israël","1234","7")));
        tx.commit();
        emf.close();
    }

    private static byte[] retrievePicture(String location){
        Path p = Paths.get(location);

        byte[] b = null;

        try{
            b = Files.readAllBytes(p);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return b;
    }
}
