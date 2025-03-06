import java.util.Random;

public class Fumandor extends Thread {
    private Estanc estanc = new Estanc();
    private String idFumador;
    private boolean tabac;
    private boolean llumi;
    private boolean paper;
    private int fumades;

    public Fumandor(String idFumador, Estanc estanc) {
        this.idFumador = idFumador;
        this.estanc = estanc;
    }

    public Estanc getEstanc() {return estanc;}
    public String getIdFumador() {return idFumador;}

    public void setEstanc(Estanc estanc) {
        this.estanc = estanc;
    }
    public void setIdFumador(String idFumador) {
        this.idFumador = idFumador;
    }

    public void fuma() throws InterruptedException{
        if(tabac & llumi & paper){
            System.out.println("Fumador " + getIdFumador() + " fumant");
            Thread.sleep(new Random().nextInt(1000) + 1000);
            this.tabac = false;
            this.llumi = false;
            this.paper = false;
            fumades += 1;
            System.out.println("Fumador " + getIdFumador() + " ha fumat " + fumades + " vegades");
        }
    }

    public void compraTabac(){
        System.out.println("Fumador " + getIdFumador() + " comprant Tabac");
        estanc.venTabac();
        this.tabac = true;
    }
    public void compraLlumi(){
        System.out.println("Fumador " + getIdFumador() + " comprant Llumi");
        estanc.venLlumi();
        this.llumi = true;
    }
    public void compraPaper(){
        System.out.println("Fumador " + getIdFumador() + " comprant Paper");
        estanc.venPaper();
        this.paper = true;
    }

    public void run(){
        try{
            while(fumades < 3){
                compraTabac();
                compraLlumi();
                compraPaper();
                fuma();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
