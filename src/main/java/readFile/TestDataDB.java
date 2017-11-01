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

public class TestDataDB {
    private TestData testData = new TestData();


    public void writeData2DB(String fileName) throws IOException{
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getSessionFactory().openSession();
        testData.readFile(fileName);
        testData.splitData();
        String dataString = testData.getDataString();
        out.println("-----> \n" + dataString);
        TestDetailEntity testDetailEntity = new TestDetailEntity();
        testDetailEntity.setTestRawDataFromLoi(dataString);
        testDetailEntity.setTestDate(testData.getTestOverview()[0]);
        testDetailEntity.setTestMaterialId(testData.getTestOverview()[1]);
        testDetailEntity.setTestMaterialType(testData.getTestOverview()[2]);
        testDetailEntity.setTestIgniteType(testData.getTestOverview()[3]);
        testDetailEntity.setTestFinalLoi(testData.getTestOverview()[4]);
        testDetailEntity.setTestStepLength(testData.getTestOverview()[5]);
        testDetailEntity.setTestSigma(testData.getTestOverview()[6]);
        testDetailEntity.setTestColumnOfK(testData.getTestOverview()[7]);
        testDetailEntity.setTestRowOfK(testData.getTestOverview()[8]);
        testDetailEntity.setTestSignOfKKs(testData.getTestOverview()[9]);
        testDetailEntity.setTestK(testData.getTestOverview()[10]);
        testDetailEntity.setTestKs(testData.getTestOverview()[11]);

//        add a random int to TestID(Primary key, unique)
        Random random = new Random();
        int a = random.nextInt(100) ;

        testDetailEntity.setTestId("SEU-" + a + testData.getTestOverview()[0]);
        testDetailEntity.setTestDetailOfSteps(testData.getDetailOfStepsString());
        out.println("---->testid:" + testDetailEntity.getTestId());
        Transaction tx = session.beginTransaction();
        session.save(testDetailEntity);
        tx.commit();
        out.println("------> commit ok");
        session.close();
        sessionFactory.close();
    }

    public void createReport(String testID){
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        TestDetailEntity testDetailEntity = (TestDetailEntity) session.get(TestDetailEntity.class, new String(testID));
        tx.commit();
        session.close();
        sessionFactory.close();

//        System.out.println(testDetailEntity.getTestMaterialId());
        String signedKWithKs, signedKWithoutKs;
        if(testDetailEntity.getTestSignOfKKs().equals('1')){
            signedKWithKs = '-' + testDetailEntity.getTestK();
            if(testDetailEntity.getTestKs().equals('1')){
                signedKWithoutKs = testDetailEntity.getTestK();
            }else {
                signedKWithoutKs = '-' + testDetailEntity.getTestK();
            }
        }else {
            signedKWithKs = testDetailEntity.getTestK();
            if(testDetailEntity.getTestKs().equals('1')){
                signedKWithoutKs = '-' + testDetailEntity.getTestK();
            }else {
                signedKWithoutKs = testDetailEntity.getTestK();
            }
        }


        String allIgniteDetail = testDetailEntity.getTestDetailOfSteps();

        System.out.println("---------------->" + allIgniteDetail.length() + "=====" + allIgniteDetail);

        IgniteData[] igniteData = new IgniteData[20];
//        igniteData[0] = new IgniteData();
//        igniteData[0].setAction("aaaa");
//        System.out.println("----->" + igniteData[0].getAction());
        for(int i = 0; i < 20; i ++){
            igniteData[i] = new IgniteData();

            igniteData[i].setConcentration(allIgniteDetail.substring(12 * i, 12 * i + 4));
            igniteData[i].setTime(allIgniteDetail.substring(12 * i + 4, 12 * i + 8));
            igniteData[i].setLength(allIgniteDetail.substring(12 * i + 8, 12 * i + 11));
            igniteData[i].setAction(allIgniteDetail.substring(12 * i + 11, 12 * i + 12));
//            System.out.println(i + "----->" + igniteData[i].getConcentration());
        }

        float cf = Float.parseFloat(igniteData[19].getConcentration());
        float k = Float.parseFloat(signedKWithKs);
        float d = Float.parseFloat(testDetailEntity.getTestStepLength());
        String testFinalLoiLong = String.format("%.2f",cf + (k * d));

        float sigma = Float.parseFloat(testDetailEntity.getTestSigma());
        float sigma23 = sigma * 2 / 3;
        float sigma32 = sigma * 3 / 2;


        Map<String, Object> datas = new HashMap<String, Object>(){{
            put("TestMaterialId", testDetailEntity.getTestMaterialId());
            put("TestMaterialType", testDetailEntity.getTestMaterialId());
            put("TestIgniteType", testDetailEntity.getTestIgniteType());
            put("TestStepLength", testDetailEntity.getTestStepLength());
            put("TestFinalLoi", testDetailEntity.getTestFinalLoi());
            put("TestDate", testDetailEntity.getTestDate());
            put("TestColumnOfK", testDetailEntity.getTestColumnOfK());
            put("TestRowOfK", testDetailEntity.getTestRowOfK());
            put("TestSignedKWithKs", signedKWithKs);
            put("TestSignedKWithoutKs", signedKWithoutKs);
            put("TestSigma", testDetailEntity.getTestSigma());
            put("TestOperator", testDetailEntity.getTestOperator());
            put("TestSigma23", String.format("%.2f", sigma23));
            put("TestSigma32", String.format("%.2f", sigma32));


            put("TestFinalLoi2", testFinalLoiLong);

        }};



        if((d > sigma23 && d < sigma32) || (d == 0.2 && d > sigma32)){
            final String lengthOk = "步长合理";
            datas.put("TestChceckStepLength", lengthOk);
        }
        if(d < sigma23){
            final String tooLong = "请加大步长，重复第2部分";
            datas.put("TestChceckStepLength", tooLong);
        }
        if(d > sigma32){
            final String tooShort = "请减小步长，重复第2部分";
            datas.put("TestChceckStepLength", tooShort);
        }

        for(int i = 0; i < 20; i ++){
            String concentration = "step" + i + "concentration";
            String time = "step" + i + "time";
            String length = "step" + i + "length";
            String action = "step" + i + "action";
            datas.put(concentration, igniteData[i].getConcentration());
            datas.put(time, igniteData[i].getTime());
            datas.put(length, igniteData[i].getLength());
            datas.put(action, igniteData[i].getAction());
            System.out.println("--->" + concentration + "：" + igniteData[i].getConcentration().trim() + "endsign");
//            System.out.println("--->" + time);
//            System.out.println("--->" + length);
//            System.out.println("--->" + action);
        }

        float[] ci = new float[6];
        float[] ci_oi = new float[6];
        int indexOfci = 0;

        for(int i = 0; i < 20 && indexOfci < 6 ; i ++){

            if(!igniteData[19-i].getConcentration().trim().isEmpty()){
                System.out.println("--->test---:"+ (19 - i) + ":" + igniteData[19-i].getConcentration());
                System.out.println("result:" + !igniteData[i].getConcentration().trim().isEmpty());
                System.out.println("indexOfci:" + indexOfci);
                System.out.println("i:" + i);

                ci[indexOfci] = Float.parseFloat(igniteData[19-i].getConcentration());
                ci_oi[indexOfci] = ci[indexOfci] - Float.parseFloat(testFinalLoiLong);
                datas.put("ci" + indexOfci, ci[indexOfci]);
                datas.put("ci_oi" + indexOfci, String.format("%.2f", ci_oi[indexOfci]));
                indexOfci ++;
            }
        }

        System.out.println("--->index of ci" + indexOfci);

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
