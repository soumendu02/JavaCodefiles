public class Thread_runnable {
    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        Thread gun1=new Thread(t1);
        Thread2 t2=new Thread2();
        Thread gun2=new Thread(t2);
        gun1.start();
        gun2.start();
    }
}
class Thread1 implements Runnable{
    public void run(){
        int i = 0;
        while (i < 10000) {
            System.out.println("RUNNING IN THREAD 1");
            ++i;
        }
    }
}
class Thread2 implements Runnable{
    public void run(){
        int i = 0;
        while (i < 10000) {
            System.out.println("RUNNING IN THREAD 2");
            ++i;
        }
    }
}