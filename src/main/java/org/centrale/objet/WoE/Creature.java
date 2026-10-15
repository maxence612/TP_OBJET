package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author Corentin GODARD et Maxence SCHWERER
 */

public abstract class Creature extends ElementDeJeu implements Deplacable{
    /**
     * Nombre de points de vie restant au personnage
     */
    private int ptVie;
    /**
     * Nombre de dégats infligé par attaque
     */
    private int degAtt;
    /**
     * Nombre de points de parade
     */
    private int ptPar;
    /**
     * Pourcentage de chance que l'attaque aboutisse
     */
    private int pageAtt;
    /**
     * Pourcentage de chance que la parade aboutisse
     */
    private int pagePar;

    /**
     *
     * @param ptVie points de vie initiaux
     * @param degAtt nombre de dégat initiaux infligé par attaque
     * @param ptPar nombre points parade initiaux
     * @param pageAtt pourcentage initial de chance que l'attaque aboutisse 
     * @param pagePar pourcentage initial de chance que la parade aboutisse 
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar,Point2D pos) {
        super(pos);
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
    }
    
    /**
     *
     * @param cr personnage à dupliquer
     */
    public Creature(Creature cr){
        this(cr.getPtVie(),
        cr.getDegAtt(),
        cr.getPtPar(),
        cr.getPageAtt(),
        cr.getPagePar(),cr.getPos());   
    }
    

    public Creature(){
        this(100,
        10,
        5,
        20,
        2,
        new Point2D(5,5)); 
    }
    


    public int getPtVie() {
        return ptVie;
    }

 
    public int getDegAtt() {
        return degAtt;
    }

    
    public int getPtPar() {
        return ptPar;
    }


    public int getPageAtt() {
        return pageAtt;
    }


    public int getPagePar() {
        return pagePar;
    }
   

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }


    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    
    /**
    * Déplace aléatoirement le personnage d'au plus une case
    * horizontalement et verticalement.
     */
    public void deplace(){
        Random rd = new Random();
        int delta_x = rd.nextInt(3) - 1;
        int delta_y = rd.nextInt(3) - 1;
        this.getPos().setX(this.getPos().getX() + delta_x);
        this.getPos().setY(this.getPos().getY() + delta_y);
    }
    
    
}