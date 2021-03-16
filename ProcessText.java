import java.io.*;
import java.io.File;
public class ProcessText {
    static final String DELIMITERS = "[\\W\\d_]+";
    public static void main(String args[]){
        for(String arg: args){
            //File file = new File("/home/user03/Java/TextStatistics/text-statistics/etext/" + arg); //linux
            File file = new File("C:\\Users\\arbyw\\Documents\\Coding\\text-statistics\\etext" + arg); //windows
            //System.out.println(file);

           if(file.exists() && file.isFile())
            {
                TextStatistics stats = new TextStatistics(file);
                System.out.println(stats);
            }
        }
    }
}
