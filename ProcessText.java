import java.io.*;
import java.io.File;
import java.util.Scanner;
public class ProcessText {
    final static String DELIMITERS = "[\\W\\d_]+";
    public static void main(String args[]){
        File file = new File("/home/user03/Java/TextStatistics/text-statistics/etext/testfile.txt");

        if(file.exists() && file.isFile())
        {
            TextStatistics stats = new TextStatistics(file);
            System.out.println(stats);
        }
    }
}
