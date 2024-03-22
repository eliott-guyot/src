import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Plateau extends CaseIntelligente{
    protected int nblignes;
    protected int nbColonnes;
    protected int pourcentageDeBombes;
    protected int nbBombes;
    private List<Case> lePlateau;

    public Plateau(int nbLignes, int nbColonnes, int pourcentage){
        this.nblignes=nbLignes;
        this.nbColonnes=nbColonnes;
        this.pourcentageDeBombes=pourcentage;
    }
    private void creerLesCasesVides(){
        for (int cpt=0;cpt< this.nbColonnes*this.nblignes;++cpt){
            this.lePlateau.add(cpt,new Case());
        }
    }

    private void rendLesCasesIntelligentes(){
        for (int cpt=0;cpt <this.nbColonnes*this.nblignes;++cpt){
            this.lePlateau.add(cpt,new CaseIntelligente());
        }
    }

    public int getNbLignes(){return this.nblignes;}
    public int getNbColonnes(){return this.nbColonnes;}
    public int getNbTotalBombes(){return this.nbBombes;}
    
    public Case getCase(int numLigne,int numColonne){
        return this.lePlateau.get(numLigne*numColonne);
    }

    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }

    public int getNbCasesMarquees(){
        int nb=0;
        for (int cpt=0; cpt<this.nbColonnes*this.nblignes;++cpt){
            if (lePlateau.get(cpt).estMarque()){
                nb++;
            }
        }
        return nb;
    }

    public void poseBombe(int x,int y){
        this.getCase(x, y).poseBombe();
    }

    public void reset(){
        creerLesCasesVides();
    }
}

