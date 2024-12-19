public class Futbolista extends Thread {
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;
    private static final String[] NOM_JUGADORS = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli",
                                                 "Arnau", "Aspas", "Messi", "MBapé"};

    private int ngols = 0;
    private int ntirades = 0;

    public Futbolista(int ngols, int ntirades){
        this.ngols = ngols;
        this.ntirades = ntirades;
    }

    @Override
    public void run(){
        for(int i = 0; i < NUM_TIRADES; i++){
            ntirades++;
            if (Math.random() < PROBABILITAT){
                ngols++;
            }
        }
    }
}
