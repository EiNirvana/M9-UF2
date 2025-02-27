import java.util.Random;

public class Filosof extends Thread {
    private int id;
    private Forquilla esquerra, dreta;
    private long iniciGana, fiGana, gana;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                agafarForquilles();
                menjar();
                deixarForquilles();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pensar() throws InterruptedException {
        iniciGana = System.currentTimeMillis();
        System.out.println("Filòsof " + id + " està pensant...");
        Thread.sleep(new Random().nextInt(1000) + 1000);
    }

    private void agafarForquilles() throws InterruptedException {
        while (true) {
            esquerra.agafar();
            if (dreta.getbloqueig().tryLock()) { // Intenta agafar la forquilla dreta
                return;
            } else {
                esquerra.deixar();
                Thread.sleep(new Random().nextInt(500) + 500);
            }
        }
    }

    private void menjar() throws InterruptedException {
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
        System.out.println("Filòsof " + id + " menja amb gana: " + gana);
        Thread.sleep(new Random().nextInt(1000) + 1000);
    }

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
        System.out.println("Filòsof " + id + " ha acabat de menjar i deixa les forquilles.");
    }
}
