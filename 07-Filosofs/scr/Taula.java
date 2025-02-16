public class Taula {
    private final Filosof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0; i < numFilosofs; i++) {
            Forquilla forquillaEsquerra = forquilles[i];
            Forquilla forquillaDreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof("Filòsof " + i, forquillaEsquerra, forquillaDreta);
        }
    }

    public void iniciarSopar() {
        for (Filosof filosof : filosofs) {
            new Thread(filosof).start();
        }
    }

    public static void main(String[] args) {
        int numFilosofs = 5; // Set the number of philosophers
        Taula taula = new Taula(numFilosofs);
        taula.iniciarSopar();
    }
}
