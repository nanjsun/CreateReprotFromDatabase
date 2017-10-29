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
        sessionFactory.openSession();

        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();


        OrganizationEntity testSQL = new OrganizationEntity();

//        OrganizationEntity testGet = (OrganizationEntity) session.get(OrganizationEntity.class, new Integer(6));



        testSQL.setOrganizationName("southeast22");
        testSQL.setOrganizationLoiTester("No");
        testSQL.setOrganizationValidate((byte)1);
        testSQL.setOrganizationComment("test comment");

        session.save(testSQL);
        tx.commit();
//        System.out.println("Organization name:" + testGet.getOrganizationName());

        System.out.println("--->" + "testSQL.getOrganizationId()");
//        System.out.println("--->" + testSQL.getOrganizationId());
//        System.out.println("--->" + testSQL.getOrganizationComment());
//        System.out.println("--->" + testSQL.getOrganizationName());
        session.close();

        sessionFactory.close();
    }
}
