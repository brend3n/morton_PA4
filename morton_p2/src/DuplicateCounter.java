import java.util.*;
import java.io.*;

public class DuplicateCounter {
    HashMap<String,Integer> countMap;

    public DuplicateCounter(){
        this.countMap = new HashMap<String, Integer>();
    }


    public void count(String dataFile){

        String buffer;
        try{
            // Opening input file
            FileReader inFile = new FileReader(dataFile);
            Scanner scan = new Scanner(inFile);


            // Adding all keys into Map, incrementing counter if key already there
            while(scan.hasNext()){
                buffer = scan.next();
                if (!countMap.containsKey(buffer)){
                    countMap.put(buffer, 1);
                }else{
                    countMap.put(buffer, countMap.get(buffer) + 1);
                }
            }

            // Closing file
            inFile.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void write (String outputFile) {

        try {

            // Opening output file
            FileWriter writer = new FileWriter(outputFile);
            PrintWriter print = new PrintWriter(writer);

            // Printing key and value pairs into output file with some formatting
            for(Map.Entry element : countMap.entrySet()){
                print.printf((String)element.getKey());
                print.printf(": " + (Integer)element.getValue());
                print.printf("\n");
            }

            // Closing output file
            print.close();

        }catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
