import java.io.*;
import java.io.File;
import java.util.Scanner;
public class TextStatistics implements TextStatisticsInterface {
    private File file;
    private int lines;
    private int chars;
    private int words;
    private int[] wordLengthCount;
    private int[] letterFreq;
    private double avgWordLength;

    
    public TextStatistics(File file){
        this.file = file;
        try{
            Scanner fileScan = new Scanner(file);
            while(fileScan.hasNextLine())
            {
                //System.out.println(fileScan.nextLine());
                this.lines += 1;
                String theLine = fileScan.nextLine();
                Scanner lineScan = new Scanner(theLine);
                lineScan.useDelimiter(DELIMITERS);
                while(lineScan.hasNext()){
                    String token = lineScan.next();
                    
                    this.words += 1;
                    this.chars = words + token.length();
                }
                
        
            }
        }
    }

    /**
	 * @return the number of characters in the text file
	 */
	public int getCharCount(){
        return chars;
    }

	/**
	 * @return the number of words in the text file
	 */
	public int getWordCount(){
        return words;
    }

	/**
	 * @return the number of lines in the text file
	 */
	public int getLineCount(){
        return lines;
    }

    /**
	 * @return the letterCount array with locations [0]..[25] for 'a' through 'z'
	 */
	public int[] getLetterCount(){
        return letterFreq;
    }

	/**
	 * @return the wordLengthCount array with locations [0]..[23] with location [i]
	 * storing the number of words of length i in the text file. Location [0] is not used.
	 * Location [23] holds the count of words of length 23 and higher.
	 */
	public int[] getWordLengthCount(){
        return wordLengthCount;
    }

	/**
	 * @return the average word length in the text file
	 */
	public double getAverageWordLength(){
        return avgWordLength;
    }

    public String toString(){
        return "Words: " + getWordCount() + "\nLines: " + getLineCount(); 
    }


}

try{
    // Instantiate a new Scanner to read from the specified File
    Scanner fileScan = new Scanner(file);

    // Iterate through every line of the file
    while(fileScan.hasNextLine())
    {
        //System.out.println(fileScan.nextLine());
        lines += 1;
        String theLine = fileScan.nextLine();
        Scanner lineScan = new Scanner(theLine);
        lineScan.useDelimiter(DELIMITERS);
        while(lineScan.hasNext()){
            String token = lineScan.next();
            
            words += 1;
            chars += token.length();
        }
        

    }
    fileScan.close();
    System.out.println(lines);
} catch(FileNotFoundException e){
    System.out.println("File not found");
}