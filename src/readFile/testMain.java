package readFile;

import readFile.ReadLoiData;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;




import java.io.IOException;

public class testMain {

    public static void main(String[] args) throws IOException{
        ReadLoiData r = new ReadLoiData();
        r.readFile();
        r.splitData();

        Configuration config = new Configuration();
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();



        OrganizationEntity testSQL = new OrganizationEntity();

        testSQL.setOrganizationId(1);
        String res = testSQL.getOrganizationComment();
        testSQL.setOrganizationComment("sfasfa");
        System.out.println("--->" + res);
        System.out.println("--->" + testSQL.getOrganizationId());
        System.out.println("--->" + testSQL.getOrganizationComment());
        System.out.println("--->" + testSQL.getOrganizationName());

        session.save(testSQL);
        tx.commit();
        sessionFactory.close();
    }
}
