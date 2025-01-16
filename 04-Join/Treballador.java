import java.util.Random;

public class Treballador extends Thread{
    private int nou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual = 0;
    private double cobrat;
    private Random rnd;

    public int getCobrat(){return cobrat;}
    public int getEdat(){return edat_actual;}

    public Treballador(float nou_anual_brut, int edat_inici_treball, int edat_fi_treball, String nom) {
        super(nom); 
        this.nou_anual_brut = nou_anual_brut; 
        this.edat_inici_treball = edat_inici_treball; 
        this.edat_fi_treball = edat_fi_treball; 
        this.edat_actual = 0; 
        this.cobrat = 0.0f; 
        this.rnd = new Random(); 
    }

    public void cobra(){
        nou_anual_brut += nou_anual_brut/12;
    }

    public void pagaImpostos(){
        cobrat = cobrat*0.76;
    }

    @Override
    public void run(){
        while (edat_actual < edat_fi_treball) {
            if (edat_actual >= edat_inici_treball) {
                cobra(); pagaImpostos(); 
            } 
            edat_actual++; 
        }
    }






}