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

//        testDetailEntity.setTestId();
        testDetailEntity.setTestRawDataFromLoi(dataString);

        testDetailEntity.setTestDate(readLoiData.getTestOverview()[0]);
        testDetailEntity.setTestMaterialId(readLoiData.getTestOverview()[1]);
        testDetailEntity.setTestMaterialType(readLoiData.getTestOverview()[2]);
        testDetailEntity.setTestIgniteType(readLoiData.getTestOverview()[3]);
        testDetailEntity.setTestFinalLoi(readLoiData.getTestOverview()[4]);
        testDetailEntity.setTestStepLength(readLoiData.getTestOverview()[5]);
        testDetailEntity.setTestSigma(readLoiData.getTestOverview()[6]);
//        testDetailEntity.setTestK(readLoiData.getTestOverview()[7]);
//        testDetailEntity.set(readLoiData.getTestOverview()[8]);
        testDetailEntity.setTestSignOfKKs(readLoiData.getTestOverview()[9]);
        testDetailEntity.setTestK(readLoiData.getTestOverview()[10]);
        testDetailEntity.setTestKs(readLoiData.getTestOverview()[11]);

        testDetailEntity.setTestId("me" + readLoiData.getTestOverview()[0]);


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
