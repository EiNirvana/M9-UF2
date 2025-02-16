
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
        esquerra.agafar(gana);
        System.out.println(nom + " agafa la forquilla esquerra " + esquerra.getNum());

        dreta.agafar(gana);
        System.out.println(nom + " agafa la forquilla dreta " + dreta.getNum());

        System.out.println(nom + " menja");
        Thread.sleep(rand.nextInt(1000) + 1000); // Menja per un temps entre 1s i 2s

        dreta.deixar();
        System.out.println(nom + " deixa la forquilla dreta " + dreta.getNum());

        esquerra.deixar();
        System.out.println(nom + " deixa la forquilla esquerra " + esquerra.getNum());

        System.out.println(nom + " ha acabat de menjar");
        this.gana = 0; // Redueix la gana a zero després de menjar
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
                System.out.println(nom + " gana = " + gana);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    @Override
    public String toString() {
        return nom + " esq: " + esquerra.getNum() + " dret: " + dreta.getNum();
    }
}