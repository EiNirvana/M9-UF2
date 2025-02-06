public class Taula{
    private static Forquilla[] forquilles;
    private static Filosof[] comensals;
    public static void main(String[] args){
        for (int f = 0; f < 5; f++){
            forquilles[f]= new Forquilla(f, false);
        }
        for(int i = 0; i < 4; i++){
            if (i != 4){
                comensals[i] = new Filosof(forquilles[i], forquilles[i + 1], 0, "fil" + i);
            } else {
                comensals[i] = new Filosof(forquilles[i], forquilles[0], 0, "fil" + i);
            }
            new Thread(comensals[i]).start();
        }
        showTaula();
    }

    public void cridarATaula(){

    }

    public static void showTaula(){
        for(int i = 0; i < comensals.length; i++){
            if (i != comensals.length){
                System.out.print("Comensal:" + comensals[i] + " esq:" + i + " dret:" + (i+1));
            } else {
                System.out.print("Comensal:" + comensals[i] + " esq:" + i + " dret:" + 0);
            }
        }
    }
}