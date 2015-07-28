package Exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rpanait on 7/28/2015.
 */
public class Main {
    public static void main(String[] args) {
        long startTime,estimatedTime;
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<10;i++) {
            list1.add(r.nextInt(100));
        }
        ListCreation lc1 = new ListCreation(list1,list2,0,4);
        ListCreation lc2 = new ListCreation(list1,list2,5,9);

        Thread t1=new Thread(lc1);
        Thread t2=new Thread(lc2);

        startTime = System.nanoTime();

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        estimatedTime = System.nanoTime()-startTime;
        System.out.println("Estimated time: "+ estimatedTime);

        System.out.println("Lista de input este :" + list1);
        System.out.println("Lista ce rezulta este :"+ list2);
    }
}
