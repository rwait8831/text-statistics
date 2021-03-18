import java.io.File;
public class ProcessText {
    public static void main(String[] args){  
        for(String filename: args){
            //File file = new File("/home/user03/Java/TextStatistics/text-statistics/etext/" + filename); //linux
            File file = new File("C:\\Users\\arbyw\\Documents\\Coding\\text-statistics\\etext" + filename); //windows
            //System.out.println(file);

            if(file.exists() && file.isFile()){
                System.out.println(file.getName());
                TextStatistics stats = new TextStatistics(file);
                System.out.println(stats);
            }
        }
    }
}
