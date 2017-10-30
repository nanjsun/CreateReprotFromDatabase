package readFile;

import readFile.ReadLoiData;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;




import java.io.IOException;

public class TestDetailToDB extends testData {
//    private Configuration config = new Configuration();
//    private SessionFactory sessionFactory;
//    private Session session;
//    Transaction tx;

//    public Session getConnect(){
//        config.configure();
//        sessionFactory = config.buildSessionFactory();
//        sessionFactory.openSession();
////        session = sessionFactory.getSessionFactory().openSession();
//        session = sessionFactory.getCurrentSession();
//        tx = session.beginTransaction();
//
//        return session;
//        OrganizationEntity testSQL = new OrganizationEntity();


//    }
    public void selectTestDetail() throws IOException{
        Configuration config = new Configuration().configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getSessionFactory().openSession();
//        Session session = sessionFactory.getCurrentSession();


        ReadLoiData readLoiData = new ReadLoiData();

        readLoiData.splitData();
        String dataString = readLoiData.getDataString();
        System.out.println("-----> \n" + dataString);

        TestDetailEntity testDetailEntity = new TestDetailEntity();

        testDetailEntity.setTestId("seu001");
        testDetailEntity.setTestRawDataFromLoi(dataString);

        System.out.println("---->testid:" + testDetailEntity.getTestId());
//        testDetailEntity.set
        Transaction tx = session.beginTransaction();

        session.save(testDetailEntity);
        tx.commit();

        System.out.println("------> commit ok");
        session.close();
        sessionFactory.close();




//        TestDetailEntity selectTestDetail = (TestDetailEntity) session.get(TestDetailEntity.class, new Integer(1));






    }

//    public static void main(String[] args) throws IOException{
//        ReadLoiData r = new ReadLoiData();
//        r.readFile();
//        r.splitData();



//        OrganizationEntity testGet = (OrganizationEntity) session.get(OrganizationEntity.class, new Integer(6));

//        testSQL.setOrganizationName("southeast25");
//        testSQL.setOrganizationLoiTester("No");
//        testSQL.setOrganizationValidate((byte)1);
//        testSQL.setOrganizationComment("test comment");



//        session.save(testSQL);
//        tx.commit();

//    }
//    public void closeConnect(){
//        session.close();
//        sessionFactory.close();
//
//    }
}
