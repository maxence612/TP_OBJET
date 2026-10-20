package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Entité vivante du jeu, dotée de caractéristiques de combat et d'une position.
 *
 * @author Corentin GODARD et Maxence SCHWERER
 */
public abstract class Creature extends ElementDeJeu implements Deplacable{
    /** Nombre de points de vie restants. */
    private int ptVie;
    /** Dégâts infligés lors d'une attaque. */
    private int degAtt;
    /** Valeur de réduction des dégâts par parade. */
    private int ptPar;
    /** Pourcentage de réussite d'une attaque. */
    private int pageAtt;
    /** Pourcentage de réussite d'une parade. */
    private int pagePar;
    /** Nom de la créature. */
    private String nom;

    /**
     * Crée une créature avec ses caractéristiques et sa position initiales.
     *
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param pos position initiale
     * @param nom nom de la créature
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar,Point2D pos, String nom) {
        super(pos);
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.nom = nom;
    }
    
    /**
     * Crée une copie des caractéristiques de la créature indiquée.
     *
     * @param cr créature à copier
     */
    public Creature(Creature cr){
        this(cr.getPtVie(),
        cr.getDegAtt(),
        cr.getPtPar(),
        cr.getPageAtt(),
        cr.getPagePar(),cr.getPos(), cr.getNom());   
    }
    /**
     * Crée une créature avec les caractéristiques et la position par défaut.
     */
    public Creature(){
        this(100,
        100,
        10,
        80,
        10,
        new Point2D(5,5), "Creature"); 
    }
    

    /**
     * Retourne les points de vie restants.
     *
     * @return points de vie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Retourne les dégâts infligés par attaque.
     *
     * @return dégâts d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Retourne la valeur de parade.
     *
     * @return valeur de parade
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Retourne le pourcentage de réussite d'une attaque.
     *
     * @return probabilité d'attaque, exprimée en pourcentage
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Retourne le pourcentage de réussite d'une parade.
     *
     * @return probabilité de parade, exprimée en pourcentage
     */
    public int getPagePar() {
        return pagePar;
    }
    /**
     * Retourne le nom de la créature.
     *
     * @return nom de la créature
     */
    public String getNom() {
        return nom;
    }
    /**
     * Définit le nom de la créature.
     *
     * @param nom nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Définit les points de vie restants.
     *
     * @param ptVie nouveau nombre de points de vie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    /**
     * Définit les dégâts infligés par attaque.
     *
     * @param degAtt nouvelle valeur de dégâts
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    /**
     * Définit la valeur de parade.
     *
     * @param ptPar nouvelle valeur de parade
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Définit le pourcentage de réussite d'une attaque.
     *
     * @param pageAtt nouveau pourcentage
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }
    /**
     * Définit le pourcentage de réussite d'une parade.
     *
     * @param pagePar nouveau pourcentage
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    

    /**
     * Déplace aléatoirement la créature d'au plus une case sur chaque axe.
     */
    public void deplacerAlea(){
        Random rd = new Random();
        int delta_x = rd.nextInt(3) - 1;
        int delta_y = rd.nextInt(3) - 1;
        this.getPos().setX(this.getPos().getX() + delta_x);
        this.getPos().setY(this.getPos().getY() + delta_y);
    }
    
    /**
     * Affiche les informations détaillées de la créature.
     */
    public abstract void afficheDetails();
}