import java.util.Random;

public class Motor extends Thread{
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private boolean enFuncionament = true;

    public synchronized void setPotencia(int potencia){
        this.potenciaObjectiu = potencia;
    }

    @Override
    public void run(){
        Random random = new Random();

        while(enFuncionament){
            synchronized(this){
                if (potenciaActual < potenciaObjectiu){
                    potenciaActual++;
                    System.out.printf("%s: Incre. Onjectiu: %d Actual: %d%n", 
                                    getName(), potenciaObjectiu, potenciaActual);
                }
                else if (potenciaActual > potenciaObjectiu){
                    potenciaActual--;
                    System.out.printf("%s: Decre. Onjectiu: %d Actual: %d%n", 
                                    getName(), potenciaObjectiu, potenciaActual);
                }

                if (potenciaActual == 0 && potenciaObjectiu == 0){
                    System.out.printf("%s: FerRes Onjectiu: %d Actual: %d%n", 
                                    getName(), potenciaObjectiu, potenciaActual);
                    enFuncionament = false;
                }
            }
            try{
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e){
                System.err.println(getName() + " interromput");            
            }
        }
    }
}