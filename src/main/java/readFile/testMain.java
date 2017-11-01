package main.java.readFile;

//import readFile.ReadLoiData;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;




import java.io.IOException;

public class testMain {

    public static void main(String[] args) throws IOException{

        TestDataDB testDataDB = new TestDataDB();
        testDataDB.writeData2DB("15091701.TXT");
        testDataDB.createReport("SEU-6320150917");
    }
}
