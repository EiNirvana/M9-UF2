import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private List<Assistent> assistents;
    private int numPlacesMax;
    private int numPlacesDisponibles;

    public Esdeveniment(int numPlacesMax) {
        this.numPlacesMax = numPlacesMax;
        this.numPlacesDisponibles = numPlacesMax;
        this.assistents = new ArrayList<>();
    }
    

    public void ferReserva(Assistent assistent) throws InterruptedException{
        while (numPlacesDisponibles == 0) {
            wait();
        }
        assistents.add(assistent);
        numPlacesDisponibles--;
        System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + numPlacesDisponibles);
        notifyAll();
    }

    public void cancelarReserva(Assistent assistent){
        if (assistents.contains(assistent)) {
            assistents.remove(assistent);
            numPlacesDisponibles++;
            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + numPlacesDisponibles);
            notifyAll();
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + numPlacesDisponibles);
        }
    }

}
