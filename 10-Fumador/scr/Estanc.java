import java.util.ArrayList;
import java.util.Random;

public class Estanc extends Thread{
    private ArrayList<Tabac> tabacs = new ArrayList<>();
    private ArrayList<Llumi> llumis = new ArrayList<>();
    private ArrayList<Paper> papers = new ArrayList<>();
    private boolean obert = true;

    public void setTabacs(ArrayList<Tabac> tabacs) {
        this.tabacs = tabacs;
    }
    public void setLlumis(ArrayList<Llumi> llumis) {
        this.llumis = llumis;
    }
    public void setPapers(ArrayList<Paper> papers) {
        this.papers = papers;
    }
    public ArrayList<Tabac> getTabacs() {return tabacs;}
    public ArrayList<Llumi> getLlumis() {return llumis;}
    public ArrayList<Paper> getPapers() {return papers;}

    //Cridar en nouSubministrament()
    public void addTabac(Tabac tabac){
        tabacs.add(tabac);
    }
    public void addLlumi(Llumi llumi){
        llumis.add(llumi);
    }
    public void addPaper(Paper paper){
        papers.add(paper);
    }

    public void venTabac(){
        Tabac tabac = new Tabac();
        tabacs.remove(tabac);
    }
    public void venLlumi(){
        Llumi llumi = new Llumi();
        llumis.remove(llumi);
    }
    public void venPaper(){
        Paper paper = new Paper();
        papers.remove(paper);
    }


    public void nouSubministrament(){
        //randomly creates a tabac, paper, or llumi
        Random random = new Random();
        int novaCompra = random.nextInt(3);

        switch (novaCompra) {
            case 0:
                Tabac nouTabac = new Tabac();
                addTabac(nouTabac);
                break;
            case 1:
                Llumi nouLlumi = new Llumi();
                addLlumi(nouLlumi);
                break;
            case 2:
                Paper nouPaper = new Paper();
                addPaper(nouPaper);
                break;
        }

    }

    public void tancarEstanc(){
        this.obert = false;
    }

    public void run(){
        try {
            while (this.obert) {
                nouSubministrament();
                Thread.sleep(new Random().nextInt(1000) + 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
