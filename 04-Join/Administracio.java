public class Administracio{
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() { 
        for (int i = 0; i < num_poblacio_activa; i++) { 
            poblacio_activa[i] = new Treballador(25000.0f, 20, 65, "Ciutadà-" + i); 
        } 
    }

    public static void main(String[] args){
        Administracio admin = new Administracio();
        admin.iniciar();
        mostrarEstadistiques(); 

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
        } 
    } 
    
    public void mostrarEstadistiques() {
        for (Treballador treballador : poblacio_activa) { 
            System.out.printf("%s -> edat: %d / total: %.2f\n", treballador.getName(), treballador.getEdat(), treballador.getCobrat()); 
        } 
    }


}