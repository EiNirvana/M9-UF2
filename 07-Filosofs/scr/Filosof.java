
import jdk.jfr.Timespan;

public class Filosof implements Runnable {
    private final String nom;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;

    public Filosof(String nom, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.nom = nom;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                if (agafarForquilles()) {
                    menjar();
                    deixarForquilles();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println(nom + " està pensant");
        Thread.sleep((long) (Math.random() * 1000 + 1000));
    }

    private boolean agafarForquilles() throws InterruptedException {
        if (forquillaEsquerra.agafar()) {
            System.out.println(nom + " ha agafat la forquilla esquerra " + forquillaEsquerra.getNumero());
            if (forquillaDreta.agafar()) {
                System.out.println(nom + " ha agafat la forquilla dreta " + forquillaDreta.getNumero());
                return true;
            } else {
                forquillaEsquerra.deixar();
                System.out.println(nom + " ha deixat la forquilla esquerra " + forquillaEsquerra.getNumero());
            }
        }
        Thread.sleep((long) (Math.random() * 500 + 500));
        return false;
    }

    private void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println(nom + " ha deixat les forquilles " + forquillaEsquerra.getNumero() + " i " + forquillaDreta.getNumero());
    }

    private void menjar() throws InterruptedException {
        System.out.println(nom + " està menjant");
        Thread.sleep((long) (Math.random() * 1000 + 1000));
    }
}
