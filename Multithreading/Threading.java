// package Multithreading;
class Mythread1 extends Thread{
    @Override
    public void run()
    {
        int i = 0;
        while (i < 10000) {
            System.out.println("RUNNING IN THREAD 1");
            ++i;
        }
    }
    
}

class Mythread2 extends Thread {
    @Override
    public void run(){
        int i = 0;
        while (i < 10000) {
            System.out.println("RUNNING IN THREAD 2");
            ++i;
        }
    }
    
}
public class Threading {
    public static void main(String[] args) {
        Mythread1 t1=new Mythread1();
        Mythread2 t2=new Mythread2();
        t1.start();
        t2.start();
    }
}
