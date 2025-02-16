public class Forquilla {
    private final int num;
    private int propietari;
    public static final int LLIURE = -1;

    public Forquilla(int num) {
        this.num = num;
        this.propietari = LLIURE;
    }

    public synchronized void agafar(int filosof) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = filosof;
    }

    public synchronized void deixar() {
        propietari = LLIURE;
        notifyAll();
    }

    public int getNum() {
        return num;
    }

    public int getPropietari() {
        return propietari;
    }
}