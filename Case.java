public class Case {
    protected boolean contientUneBombe ;
    protected boolean estDecouverte;
    protected boolean estMarque;


    public Case(){
        this.contientUneBombe=false;
        this.estDecouverte=false;
        this.estMarque=false;
    }

    public void reset (){
        this.contientUneBombe=false;
        this.estDecouverte=false;
        this.estMarque=false;
    }

    public void poseBombe(){
        this.contientUneBombe=true;
    }

    public boolean contientUneBombe(){
        return this.contientUneBombe;
    }

    public boolean estDecouverte(){
        return this.estDecouverte;
    }

    public boolean estMarque(){
        return this.estMarque;
    }

    public boolean reveler(){
        if (this.estDecouverte && this.contientUneBombe==false){
            return true;
        }
        return false;
    }

    public void marquer(){
        this.estMarque=true;
    }
    
}
