package main.java.readFile;

import main.java.readFile.mappingEntity.TestDetailEntity;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.io.IOException;
import com.deepoove.poi.XWPFTemplate;

import static java.lang.System.out;

public class TestDetailToDB extends ReadLoiData {
    private ReadLoiData readLoiData = new ReadLoiData();


    public void selectTestDetail() throws IOException{
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getSessionFactory().openSession();
        readLoiData.splitData();
        String dataString = readLoiData.getDataString();
        out.println("-----> \n" + dataString);
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
        out.println("---->testid:" + testDetailEntity.getTestId());
        Transaction tx = session.beginTransaction();
        session.save(testDetailEntity);
        tx.commit();
        out.println("------> commit ok");
        session.close();
        sessionFactory.close();
    }

    public void createReport(){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        TestDetailEntity testDetailEntity = (TestDetailEntity) session.get(TestDetailEntity.class, new String("SEU-1120150912"));
        tx.commit();
        session.close();
        sessionFactory.close();

//        System.out.println(testDetailEntity.getTestMaterialId());

        Map<String, Object> datas = new HashMap<String, Object>(){{
            put("TestMaterialId", testDetailEntity.getTestMaterialId());
            put("TestMaterialType", testDetailEntity.getTestMaterialId());
            put("TestIgniteType", testDetailEntity.getTestIgniteType());
            put("TestStepLength", testDetailEntity.getTestStepLength());
            put("TestFinalLoi", testDetailEntity.getTestFinalLoi());
            put("TestDate", testDetailEntity.getTestDate());
        }};

        XWPFTemplate template = XWPFTemplate.compile("src/main/resources/report_template.docx").render(datas);

        try{
            FileOutputStream out = new FileOutputStream("report.docx");
            template.write(out);
            template.close();
            out.close();
        } catch (Exception e){
            out.println("exception-->:" + e);
        }
    }



}
