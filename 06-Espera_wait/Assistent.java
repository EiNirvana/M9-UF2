public class Assistent implements Runnable {
    private String nom;
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        try {
            while (true) {
                double random = Math.random();
                if (random < 0.5) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelarReserva(this);
                }
                Thread.sleep((long) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
