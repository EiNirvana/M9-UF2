
import jdk.jfr.Timespan;

public class Filosof extends Thread{
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private String nom;

    public Filosof(Forquilla forquillaEsquerra, Forquilla forquillaDreta, 
        int gana, String nom){
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = gana;
        this.nom = nom;
    }
    public Filosof(){}

    public int getGana() {return gana;}
    public String getNom() {return nom;}

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setGana(int gana) {
        this.gana = gana;
    }

    public String pensa(){

    }
    public String menjar(){
        this.gana = 0;
        

    }

    public void run(){

    }
}
