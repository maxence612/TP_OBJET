/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 * Coordonnées entières d'un point dans le plan.
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class Point2D {

    /** Coordonnée horizontale du point. */
    private int x ;
    /** Coordonnée verticale du point. */
    private int y ;

    /**
     * Crée le point à l'origine.
     */
    public Point2D() {
    }

    /**
     * Crée une copie du point indiqué.
     *
     * @param p point à copier
     */
    public Point2D(Point2D p) {
        this.x = p.x ;
        this.y=p.y ;
    }

    /**
     * Crée un point avec les coordonnées indiquées.
     *
     * @param x coordonnée horizontale
     * @param y coordonnée verticale
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Crée un décalage d'une case correspondant à une direction numérotée.
     *
     * @param direction direction sur le pavé numérique (0 à 8)
     */
    public Point2D(int direction) {
        this.x = deltaX(direction);
        this.y = deltaY(direction);
    }
    
    /**
     * Calcule le décalage horizontal correspondant à une direction.
     *
     * @param direction direction sur le pavé numérique
     * @return décalage horizontal associé
     */
    private int deltaX(int direction){
        if (direction>=2 && direction<=4){
            return 1;
        }
        if (direction>=6 && direction<=8){
            return -1;
        }
        return 0;
    }
    /**
     * Calcule le décalage vertical correspondant à une direction.
     *
     * @param direction direction sur le pavé numérique
     * @return décalage vertical associé
     */
    private int deltaY(int direction){
        if (direction==8 || direction==1 || direction==2){
            return -1;
        }
        if (direction>=4 && direction<=6){
            return 1;
        }
        return 0;
    }
    /**
     * Affiche les coordonnées du point.
     */
    public void affiche(){
        System.out.println("["+x +";"+y+"]");
    }

    /**
     * Retourne la coordonnée horizontale.
     *
     * @return coordonnée x
     */
    public int getX() {
        return x;
    }

    /**
     * Définit la coordonnée horizontale.
     *
     * @param x nouvelle coordonnée x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retourne la coordonnée verticale.
     *
     * @return coordonnée y
     */
    public int getY() {
        return y;
    }

    /**
     * Définit la coordonnée verticale.
     *
     * @param y nouvelle coordonnée y
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Translate le point selon le décalage fourni.
     *
     * @param dx décalage horizontal
     * @param dy décalage vertical
     */
    public void translate(int dx, int dy){
        x=x+dx;
        y=y+dx;
    }
    /**
     * Remplace les deux coordonnées du point.
     *
     * @param x nouvelle coordonnée horizontale
     * @param y nouvelle coordonnée verticale
     */
    public void setPosition(int x, int y ){
        this.x=x;
        this.y=y;
               
    }
    /**
     * Calcule la distance euclidienne jusqu'au point indiqué.
     *
     * @param p point de destination
     * @return distance entre les deux points
     */
    public float distance(Point2D p){
        return (float) Math.sqrt( Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2) );
    }

    /**
     * Compare les coordonnées de ce point à celles du point indiqué.
     *
     * @param p point à comparer
     * @return {@code true} si les deux points ont les mêmes coordonnées
     */
    public boolean equals(Point2D p){
        return(this.x==p.getX() && this.y==p.getY());       
    }
}
