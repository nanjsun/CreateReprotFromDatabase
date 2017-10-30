package readFile;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Random;
import java.io.IOException;

public class TestDetailToDB extends testData {

    public void selectTestDetail() throws IOException{
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getSessionFactory().openSession();
        ReadLoiData readLoiData = new ReadLoiData();
        readLoiData.splitData();
        String dataString = readLoiData.getDataString();
        System.out.println("-----> \n" + dataString);
        TestDetailEntity testDetailEntity = new TestDetailEntity();
        testDetailEntity.setTestRawDataFromLoi(dataString);
        testDetailEntity.setTestDate(readLoiData.getTestOverview()[0]);
        testDetailEntity.setTestMaterialId(readLoiData.getTestOverview()[1]);
        testDetailEntity.setTestMaterialType(readLoiData.getTestOverview()[2]);
        testDetailEntity.setTestIgniteType(readLoiData.getTestOverview()[3]);
        testDetailEntity.setTestFinalLoi(readLoiData.getTestOverview()[4]);
        testDetailEntity.setTestStepLength(readLoiData.getTestOverview()[5]);
        testDetailEntity.setTestSigma(readLoiData.getTestOverview()[6]);
        testDetailEntity.setTestSignOfKKs(readLoiData.getTestOverview()[9]);
        testDetailEntity.setTestK(readLoiData.getTestOverview()[10]);
        testDetailEntity.setTestKs(readLoiData.getTestOverview()[11]);

//        add a random int to TestID(Primary key, unique)
        Random random = new Random();
        int a = random.nextInt(100) ;

        testDetailEntity.setTestId("SEU-" + a + readLoiData.getTestOverview()[0]);
        testDetailEntity.setTestDetailOfSteps(readLoiData.getDetailOfStepsString());
        System.out.println("---->testid:" + testDetailEntity.getTestId());
        Transaction tx = session.beginTransaction();
        session.save(testDetailEntity);
        tx.commit();
        System.out.println("------> commit ok");
        session.close();
        sessionFactory.close();
    }
}
