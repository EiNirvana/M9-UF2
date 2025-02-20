import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int num = 0;
    private ReentrantLock bloqueig = new ReentrantLock();

    public Forquilla(int num){
        this.num = num;
    }
    public int getnum(){return num;}
    public ReentrantLock getbloqueig(){return bloqueig;}

    public void agafar(){
        bloqueig.lock();
    }
    public void deixar(){
        bloqueig.unlock();
    }
}
