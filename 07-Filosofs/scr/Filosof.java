
import java.util.Random;



public class Filosof implements Runnable {
    private final String nom;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;
    private final Random rand = new Random();

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }

    private void menjar() throws InterruptedException {
        System.out.println(nom + " agafa la forquilla esquerra " + esquerra.getNum());
        if (esquerra.agafar()) {
            System.out.println(nom + " agafa la forquilla dreta " + dreta.getNum());
            if (dreta.agafar()) {
                System.out.println(nom + " menja");
                this.gana = 0;
                Thread.sleep(rand.nextInt(1000) + 1000); // Menja per un temps entre 1s i 2s
                dreta.deixar();
                esquerra.deixar();
                System.out.println(nom + " ha acabat de menjar");
            } else {
                esquerra.deixar();
                System.out.println(nom + " deixa la forquilla esquerra " + esquerra.getNum());
            }
        } else {
            System.out.println(nom + " no pot agafar la forquilla esquerra " + esquerra.getNum());
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println(nom + " pensant");
        Thread.sleep(rand.nextInt(1000) + 1000); 
        gana++;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
                System.out.println(nom + " gana=" + gana);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}