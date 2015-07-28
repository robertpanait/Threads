package Exercise2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rpanait on 7/28/2015.
 */
public class AppearancePercentage implements Runnable {
    public static List<String> words = new LinkedList<>();
    Map<String, Integer> wordCounts = new HashMap<String, Integer>();
    int counter;

    public AppearancePercentage(List<String> words) {
        this.words = words;
    }

    @Override
    public void run() {
        int size=words.size();
        for (String word : words) {
            Integer count = wordCounts.get(word);
            if (count == null) {
                count = 0;
            }
            wordCounts.put(word, (count + 1));
        }
        System.out.println(wordCounts);

        try {
            writeToTxtFile(wordCounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToTxtFile(Map<String, Integer> map) throws IOException {

        FileWriter fw = new FileWriter("C:\\Users\\rpanait\\Desktop\\infoutput.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(((entry.getKey() + " " + (double)entry.getValue()/words.size()*100))+System.getProperty("line.separator"));
        }
        bw.close();
    }

}
