public class Barri {
    private Estanc estanc;
    private Fumandor[] fumandors;

    public Barri() {
        this.estanc = new Estanc();
        this.fumandors = new Fumandor[3];
        for(int i = 0; i < 3; i++){
            fumandors[i] = new Fumandor("Fumador " + (i + 1), estanc);
        }
    }

    public static void main(String[] args){
        Barri barri = new Barri();
        barri.inici();
    }

    public void inici(){
        estanc.start();
        for(Fumandor fumador : fumandors){
            fumador.start();
        }

        for (Fumandor fumador : fumandors) {
            try {
                fumador.join(); // Espera que el fumador acabi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        estanc.tancarEstanc();
        System.out.println("L'estanc ha tancat.");

    }

    

}
