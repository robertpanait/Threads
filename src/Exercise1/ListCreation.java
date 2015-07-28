package Exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rpanait on 7/28/2015.
 */
public class ListCreation implements Runnable{
    public int startidx;
    public int endidx;
    List<Integer> list1,list2 = new ArrayList<>();
    public static final Lock lock= new ReentrantLock();
    public ListCreation(List<Integer> list1,List<Integer> list2,int startidx,int endidx) {
        this.list1=list1;
        this.list2=list2;
        this.startidx=startidx;
        this.endidx=endidx;
    }
    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public synchronized List CreatingTheList(List<Integer> inputList,List<Integer> outputList) {
        for(int i=startidx;i<endidx;i++) {
            if(isPrime(inputList.get(i))) {
/*                synchronized (this.list1) {
                    outputList.add(inputList.get(i));
                }*/
                lock.lock();
                outputList.add(inputList.get(i));
                lock.unlock();
            }
        }
        return outputList;
    }
    @Override
    public void run() {
        CreatingTheList(list1,list2);
    }
}
