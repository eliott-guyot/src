import java.util.List;
public class CaseIntelligente extends Case {
    private List<Case> lesVoisines;

    public CaseIntelligente(){
        super();
        
    }

    public void ajouteVoisine(Case uneCase){
        lesVoisines.add(uneCase);
    }
    
    

    public int nombreBombesVoisines(){
        int nb=0;
        for (Case elt : lesVoisines){
            if (elt.contientUneBombe==true){
                nb+=1;
            }
        }
        return nb;
    }

    public String toString(){
        if (this.estMarque()==false && this.contientUneBombe()==false){return (" ");}
        else if (this.estMarque()){return "?";}
        else if (this.reveler() && this.contientUneBombe()==false){return   "@";}
        else if (this.reveler() && this.nombreBombesVoisines()==0){return "0";}
        else{return "3";}
    }
}
