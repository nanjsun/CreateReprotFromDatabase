package readFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadLoiData {
    private String dataString;
    private String[] testOverview = new String[12];
    private testData[] testSteps = new testData[20];
    private String detailOfStepsString;

//    private testData[] partTwo = new testData[10];
    public String getDataString(){
        return this.dataString;
    }
    public String[] getTestOverview(){
        return this.testOverview;
    }

    public testData[] getTestSteps(){
        return this.testSteps;
    }

    public String getDetailOfStepsString() {
        return detailOfStepsString;
    }

    public void readFile() throws IOException{

        Scanner loiData = new Scanner(Paths.get("15091201.TXT"), "UTF-8");
        String firstLine = loiData.nextLine();
        StringBuffer sb = new StringBuffer();
        char[] buf = firstLine.toCharArray();
//        int iterateCounter = 0;
        for(char x : buf){
//            iterateCounter ++;
            if((int)x == 0 || (int)x > 255 )
                x = ' ';
            sb.append(x);
        }
        this.dataString = sb.toString();

//        char x = this.dataString.charAt(21);

//        System.out.printf("---->%c:%d\n", x, (int)(x));
//        System.out.print("---->%d", (int)(x));

//        System.out.println(this.dataString.length() + "xx---->\n" + this.dataString);

    }
    public void splitData()throws IOException{

        if(this.dataString == null || this.dataString.length() == 0)
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
        this.testOverview[9] = dataString.substring(47, 48);
//        get k value, like x.xx
        this.testOverview[10] = dataString.substring(48, 52);
//        get ks , if ks<0  this value is set to 1
        this.testOverview[11] = dataString.substring(52,53);

        for(int i = 0; i < 20; i++ ){

            testSteps[i] = new testData();

//            System.out.println(dataString.substring(53 + 12 * i, 58 + 12 * i));
//            testSteps[1].setNongdu("1111");

            testSteps[i].setNongdu(dataString.substring(53 + 12 * i, 57 + 12 * i));
            this.testSteps[i].setTime(dataString.substring(57 + 12 * i, 61 + 12 * i));
            this.testSteps[i].setLength(dataString.substring(61 + 12 * i, 64 + 12 * i));
            this.testSteps[i].setAction(dataString.substring(64 + 12 * i, 65 + 12 * i));
        }

        this.detailOfStepsString = dataString.substring(53, 293);




        for(int i = 0; i < 11; i++){
            System.out.println(i + "-->" + testOverview[i] );

        }
        for(int i = 0; i < 20; i++){
            System.out.println(i + "Nongdu++>" + this.testSteps[i].getNongdu() );
            System.out.println(i + "Time++>" + this.testSteps[i].getTime() );
            System.out.println(i + "Length++>" + this.testSteps[i].getLength() );
            System.out.println(i + "Action++>" + this.testSteps[i].getAction() );

        }

//        System.out.println(dataString.length() + "-----" + dataString.substring(292, 293) + "+++" + this.testSteps[19].getAction());
//        System.out.printf(dataString.charAt(28) + "   int is  : %d ", (int)dataString.charAt(28));
//        if(dataString.charAt(28) == (char)0){
//            System.out.println("yes!");
//
//        }


    }

}
