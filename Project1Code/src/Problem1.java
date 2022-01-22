import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.*;

public class Problem1 {
    public static void main(String [] args){
        ArrayList<Long> Snippet1_list = new ArrayList<>();
        ArrayList<Long> Snippet2_list = new ArrayList<>();

        long startTime;
        long endTime;
        int fileSize;

        //test snippet one run time
        fileSize = 1000;
        for (int j = 0; j < 10; ++j){
            startTime = System.nanoTime();
            int sum = 0;
            for (int i = 0; i < fileSize; i++){
                sum = sum + i;
            }
            endTime = System.nanoTime();
            Snippet1_list.add(endTime - startTime);
            fileSize += 1000;
        }

        //test snippet two run time
        fileSize = 1000;
        for (int q = 0; q < 10; ++q){
            startTime = System.nanoTime();
            int sum = 0;
            for (int i = 0; i < fileSize; i++) {
                for (int j = 0; j < i*i; j++) {
                    sum = sum + i;
                }
            }
            endTime = System.nanoTime();
            Snippet2_list.add(endTime - startTime);
            fileSize += 1000;
        }

        //print run time in format
        FileOutputStream myChart = null;
        try{
            myChart = new FileOutputStream("Project1Code/src/SnippetTimeChart.csv");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found, end program.");
            System.exit(-1);
        }
        PrintWriter writeFile = new PrintWriter(myChart);

        writeFile.println(",1k,2k,3k,4k,5k,6k,7k,8k,9k,10k");

        //print snippet 1 run time
        writeFile.print("Snippet1,");
        for (int i = 0; i < Snippet1_list.size(); ++i){
            writeFile.print(Snippet1_list.get(i) + ",");
        }
        writeFile.println();

        //print big O of snippet 1
        writeFile.print("Big O of Snippet1,");
        fileSize = 1000;
        for (int i = 0; i < Snippet1_list.size(); ++i){
            writeFile.print(fileSize + ",");
            fileSize += 1000;
        }
        writeFile.println();

        //print snippet 2 run time
        writeFile.print("Snippet2,");
        for (int i = 0; i < Snippet2_list.size(); ++i){
            writeFile.print(Snippet2_list.get(i) + ",");
        }
        writeFile.println();

        //print big O of snippet 2
        writeFile.print("Big O of Snippet2,");
        fileSize = 1000;
        for (int i = 0; i < Snippet2_list.size(); ++i){
            writeFile.print(Math.pow(fileSize, 3) + ",");
            fileSize += 1000;
        }

        writeFile.close();
    }
}
