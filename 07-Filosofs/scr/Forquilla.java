import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private final int numero;
    private final Lock lock = new ReentrantLock();

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public boolean agafar() {
        return lock.tryLock();
    }

    public void deixar() {
        lock.unlock();
    }

    public int getNum() {
        return numero;
    }
}
