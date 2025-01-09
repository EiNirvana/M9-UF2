//Classe DormAleatori
import java.util.Random;

public class DormAleatori extends Thread{
    private long startTime;

    public DormAleatori(String nom){
        super(nom);
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run(){
        Random random = new Random();

        for(int i = 0; i <= 10; i++){
            int interval = random.nextInt(1000);
            long currentTime = System.currentTimeMillis();
            long timeDifference = currentTime - startTime;

            System.out.printf("%s(%d) a dormir %dms total %dms%n", getName(), i, interval, elapsedTime);

            try {
                // Espera aleatòria per simular comportaments diferents
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.err.println(getName() + " interromput");
            }
        }
    }
}