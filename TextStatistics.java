import java.io.*;
import java.util.Scanner;
public class TextStatistics implements TextStatisticsInterface {
    static final String DELIMITERS = "[\\W\\d_]+";
    private File file;
    private int lines;
    private int chars;
    private int words;
    private int[] wordLengthCount;
    private int[] letterFreq;
    private String[] longWords;
    private double avgWordLength;
    private char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private String consoleBreak = "\n=========================================";
    private String fileStat;

    
    public TextStatistics(File file){
        this.file = file;
        this.fileStat =  "\n+++Statistsics+++" + consoleBreak;
        this.lines = 0;
        this.chars = 0;
        this.words = 0;
        this.avgWordLength = 0;
        this.wordLengthCount = new int[23];
        this.letterFreq = new int[26];
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
                    String token = lineScan.next().toLowerCase();
                    int wordLength = token.length();
                    if(wordLength >= 23){
                        wordLengthCount[23] += 1;
                    }
                    else{
                        wordLengthCount[wordLength] += 1;
                    }
                    this.words += 1;
                    letters = letters + wordLength;
                    for(int i = 0; i < wordLength; i++){
                        char theLetter = token.charAt(i);
                            for(int j = 0; j < alpha.length; j++){
                                if(theLetter == alpha[j]){
                                    letterFreq[j] += 1;
                                }
                            }
                        }
                    }
                    lineScan.close();
                }
                this.avgWordLength = ((double)letters/words);
                fileScan.close();
        
            } catch(FileNotFoundException e){
                System.out.println("+++Not a valid file+++");
        }
    }
    // none of these methods have @param values
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

    public String printWordLengths(){
        String lengths = "";
        for(int i = 0; i < wordLengthCount.length; i++){
            if(wordLengthCount[i] > 0){
                lengths += "\n" + i + "\t\t\t" + wordLengthCount[i];
            }
        }
        return lengths;
    }

    public String printLetterFreq(){
        String lengths = "";
        for(int i = 0; i < 13; i++){
            if(letterFreq[i] > 0){
                lengths += "\n" + alpha[i] + " = " + letterFreq[i] + "\t\t\t" + alpha[i+13] + " = " + letterFreq[i+13];
            }
            else{
                lengths += "\n" + alpha[i] + " = 0" + "\t\t\t" + alpha[i+13] + " = " + letterFreq[i+13];
            }
        }
        return lengths;
    }

	/**
	 * @return the average word length in the text file
	 */
	public double getAverageWordLength(){
        return avgWordLength;
    }

    public String toString(){
        return fileStat + "\nWords: " + getWordCount() + "\nLines: " + getLineCount() + "\nCharacters: " + getCharCount() 
        + "\nAverage Word Length: " + getAverageWordLength() + "\n" + consoleBreak + "\n" + printLetterFreq() 
        + "\n" + consoleBreak + "\n\nLength\t\t\tFrequency\n------\t\t\t---------" + printWordLengths() + consoleBreak + "\n"; 
    }


}
