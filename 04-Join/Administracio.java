public class Administracio{
    private int[] num_poblacio_activa = new int[50];
    private int[] poblacio_activa = new int[50];

    public Administracio() { 
        poblacio_activa = new Treballador[num_poblacio_activa]; 
        for (int i = 0; i < num_poblacio_activa; i++) { 
            poblacio_activa[i] = new Treballador(25000.0f, 20, 65, "Ciutadà-" + i); 
        } 
    }

    public static void main(String[] args){
        Administracio admin = new Administracio();
        admin.iniciar();

    }

    public void iniciar() {
        for (Treballador treballador : poblacio_activa) { 
            treballador.start(); 
        } 
        for (Treballador treballador : poblacio_activa) { 
            try { 
                treballador.join(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } mostrarEstadistiques(); 
    } 
    
    public void mostrarEstadistiques() {
        for (Treballador treballador : poblacio_activa) { 
            System.out.printf("%s -> edat: %d / total: %.2f\n", treballador.getName(), treballador.getEdat(), treballador.getCobrat()); 
        } 
    }


}