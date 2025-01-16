public class Coet{
    private final Motor[] motors = new Motor[4];

    public Coet(){
        for (int i = 0; i < motors.length; i++){
            motors[i] = new Motor();
            motors[i].setName("Motor " + i);
        }
    }

    public void passaAPotencia(int p){
        if (p < 0 || p > 10){
            System.err.println("Error: Potència fora de rang (0-10)");
            return;
        }

        System.out.println("Passant a potència " + p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca(){
        for(Motor motor: motors){
            
        }
    }
}