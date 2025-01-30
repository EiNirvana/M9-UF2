import java.util.List;

public class Esdeveniment {
    private List<Assistent> assistents;
    private int numPlacesMax;
    private int numPlacesDisponibles;

    public Esdeveniment(int numPlacesMax){
        this.numPlacesMax = numPlacesMax;
    }

    public void ferReserva(Assistent assistent) throws InterruptedException{
        while (numPlacesDisponibles == 0) {
            wait();
        }
        assistents.add(assistent);
        numPlacesDisponibles--;
    }

    public void cancelarReserva(Assistent assistent){
        if(assistents.contains(assistent)){
            assistents.remove(assistent);
        }

        numPlacesDisponibles++;
    }

}
