package Exercise2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by rpanait on 7/28/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> words = new LinkedList<>();
        // Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        //String[] words=new String[2000];
        FileReader fr = new FileReader("C:\\Users\\rpanait\\Desktop\\info.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            words.addAll(Arrays.asList(s.split(" ")));
        }
       // System.out.println(words);

        AppearancePercentage ap1 = new AppearancePercentage(words);
        Thread t1 = new Thread(ap1);
        t1.start();

    }

}

