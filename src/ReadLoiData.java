import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadLoiData {
    private String dataString;
    private String[] testOverview = new String[11];
    private testData[] partOne = new testData[20];

//    private testData[] partTwo = new testData[10];

//    public static void main(String[] args) throws Exception{
//
//
//    }
    public void readFile() throws IOException{

        Scanner loiData = new Scanner(Paths.get("15091201.TXT"), "UTF-8");

        this.dataString = loiData.nextLine();

//        System.out.println(dataString.length());
//        System.out.println(this.dataString);

    }
    public void splitData()throws IOException{
        try{
            readFile();
        }
        catch (IOException e)
        {
            System.out.println("wrong!");
        }
//        get test data
        this.testOverview[0] = dataString.substring(0,8);
//        get test materialId
        this.testOverview[1] = dataString.substring(16, 30);
//        get material type
        this.testOverview[2] = dataString.substring(30, 31);
//        get ignite type
        this.testOverview[3] = dataString.substring(31, 32);
//        get final LOI xx.x
        this.testOverview[4] = dataString.substring(32, 36);
//        get step length 0.2
        this.testOverview[5] = dataString.substring(36, 39);
//        get sigma 0.110
        this.testOverview[6] = dataString.substring(39, 44);
//        get cloum number of k table
        this.testOverview[7] = dataString.substring(44, 45);
//        get row number of k table
        this.testOverview[8] = dataString.substring(45, 47);
//        get k*ks, if k*ks < 0, this byte set to 1,
        this.testOverview[8] = dataString.substring(47, 48);
//        get k value, like x.xx
        this.testOverview[9] = dataString.substring(48, 52);
//        get ks , if ks<0  this value is set to 1
        this.testOverview[10] = dataString.substring(52,53);

        for(int i = 0; i < 20; i++ ){

            partOne[i] = new testData();

//            System.out.println(dataString.substring(53 + 12 * i, 58 + 12 * i));
//            partOne[1].setNongdu("1111");

            partOne[i].setNongdu(dataString.substring(53 + 12 * i, 57 + 12 * i));
            this.partOne[i].setTime(dataString.substring(57 + 12 * i, 61 + 12 * i));
            this.partOne[i].setLength(dataString.substring(61 + 12 * i, 64 + 12 * i));
            this.partOne[i].setAction(dataString.substring(64 + 12 * i, 65 + 12 * i));
        }




        for(int i = 0; i < 11; i++){
            System.out.println(i + "-->" + testOverview[i] );

        }
        for(int i = 0; i < 20; i++){
            System.out.println(i + "Nongdu++>" + this.partOne[i].getNongdu() );
            System.out.println(i + "Time++>" + this.partOne[i].getTime() );
            System.out.println(i + "Length++>" + this.partOne[i].getLength() );
            System.out.println(i + "Action++>" + this.partOne[i].getAction() );

        }

        System.out.println(dataString.length() + "-----" + dataString.substring(292, 293) + "+++" + this.partOne[19].getAction());


    }

}
