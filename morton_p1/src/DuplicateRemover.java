import java.util.*;
import java.io.*;

public class DuplicateRemover {

    HashSet<String> uniqueWords;

    public DuplicateRemover() {
        this.uniqueWords = new HashSet<String>();
    }

    public void remove (String dataFile){
        try{
            // Opening file
            FileReader inFile = new FileReader(dataFile);
            Scanner scan = new Scanner(inFile);

            // Scanning all words in File and adding to HashSet
            while(scan.hasNext()){
                uniqueWords.add(scan.next());
            }

            // Close file
            inFile.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void write (String outputFile) {

        try {

            // Opening file
                // Exception may be thrown for error opening file
            FileWriter writer = new FileWriter(outputFile);
            PrintWriter print = new PrintWriter(writer);

            // Iterator for going through the HashSet
            Iterator<String> value = uniqueWords.iterator();


            // iterate through HashSet and print along the way
            while(value.hasNext()){
                print.printf(value.next());
                print.printf(" ");
            }

            // Close file to prevent leaks
            print.close();

        }catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }

    }
}