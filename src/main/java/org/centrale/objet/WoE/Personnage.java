package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author Corentin GODARD et Maxence SCHWERER
 */

public class Personnage extends Creature{
    /**
     * Nom du personnage
     */
    private String nom;
    /**
     * Distance maximale d'attaque
     */
    private int distAttMax;
    /**
     *
     * @param nom nom du personnage
     * @param ptVie points de vie initiaux
     * @param degAtt nombre de dégat initiaux infligé par attaque
     * @param ptPar nombre points parade initiaux
     * @param pageAtt pourcentage initial de chance que l'attaque aboutisse 
     * @param pagePar pourcentage initial de chance que la parade aboutisse 
     * @param distAttMax distance initiale maximale de l'attaque
     * @param pos position initiale du personnage
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar,pos);
        this.nom = nom;
        this.distAttMax = distAttMax;
    }
    
    /**
     *
     * @param perso personnage à dupliquer
     */
    public Personnage(Personnage perso){
        super(perso);
        this.nom = perso.getNom();
        this.distAttMax = perso.getDistAttMax();
    }
    

    public Personnage(){
        this("Ethan",
        100,
        10,
        5,
        20,
        20,
        2,
        new Point2D(-1,-1) ); 
    }
    

    public String getNom(){
        return this.nom;
    }
    

    public void setNom(String nom){
        this.nom=nom;
    }


    public int getDistAttMax() {
        return distAttMax;
    }


    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Affiche le nom du personnage, sa position et so nombre de point de vie.
     */
    public void affiche(){
        System.out.println(this.nom+" est en "+this.getPos().getX()+";"+this.getPos().getY()+" avec "+this.getPtVie()+" points de vie" );
    }
    
}