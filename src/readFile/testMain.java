package readFile;

import readFile.ReadLoiData;

import java.io.IOException;

public class testMain {

    public static void main(String[] args) throws IOException{
        ReadLoiData r = new ReadLoiData();
        r.readFile();
        r.splitData();
    }
}
