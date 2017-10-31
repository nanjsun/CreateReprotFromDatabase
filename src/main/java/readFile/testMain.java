package main.java.readFile;

//import readFile.ReadLoiData;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;




import java.io.IOException;

public class testMain {

    public static void main(String[] args) throws IOException{

        TestDetailToDB testDetailToDB = new TestDetailToDB();
//        testDetailToDB.selectTestDetail();
        testDetailToDB.createReport();
    }
}
