public class Fil extends Thread {
    private String nom;
    private int maxIteracions;

    public Fil(String nom, int maxIteracions) {
        this.nom = nom;
        this.maxIteracions = maxIteracions;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxIteracions; i++) {
            System.out.println(nom + " " + i);
            try {
                // Espera aleatòria per simular comportaments diferents
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el fil " + nom);
    }
}
