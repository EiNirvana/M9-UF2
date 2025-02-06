public class Forquilla {
    private int num_fork;
    private boolean enUs;

    public Forquilla(int num_fork, boolean enUs) {
        this.num_fork = num_fork;
        this.enUs = enUs;
    }
    public Forquilla(){}

    public int getNum_fork() {return num_fork;}
    public boolean isEnUs() {return enUs;}

    public void setNum_fork(int num_fork) {
        this.num_fork = num_fork;
    }
    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }
    
    public void agafaForquilla(){this.enUs = true;}
    public void deixaForquilla(){this.enUs = false;}
}
