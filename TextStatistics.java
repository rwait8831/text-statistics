import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class TextStatistics implements TextStatisticsInterface {
    static final String DELIMITERS = "[\\W\\d_]+";
    private File file;
    private int lines;
    private int chars;
    private int words;
    private int[] wordLengthCount;
    private int[] letterFreq;
    private double avgWordLength;

    
    public TextStatistics(File file){
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        this.file = file;
        this.lines = 0;
        this.chars = 0;
        this.words = 0;
        this.avgWordLength = 0;
        this.wordLengthCount = new int[23];
        this.letterFreq = new int[25];
        int letters = 0;
        try{
            Scanner fileScan = new Scanner(file);
            fileScan.useDelimiter(DELIMITERS);
            while(fileScan.hasNextLine())
            {
                //System.out.println(fileScan.nextLine());
                this.lines += 1;
                String theLine = fileScan.nextLine();
                this.chars = chars + theLine.length() + 1;
                Scanner lineScan = new Scanner(theLine);
                lineScan.useDelimiter(DELIMITERS);
                while(lineScan.hasNext()){
                    String token = lineScan.next();
                    int wordLength = token.length();
                    if(wordLength >= 23){
                        wordLengthCount[23] += 1;
                    }
                    else{
                        wordLengthCount[wordLength] += 1;
                    }
                    this.words += 1;
                    letters = letters + token.length();
                }
                this.avgWordLength = (letters/words);
                lineScan.close();
        
            }
            fileScan.close();
        } catch(FileNotFoundException e){
            System.out.println("No File");
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
        return "Words: " + getWordCount() + "\nLines: " + getLineCount() + "\nCharacters: " + getCharCount() + "\nAverage Word Length: " + getAverageWordLength(); 
    }


}


/*
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
} */