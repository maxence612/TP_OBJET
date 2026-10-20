/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Personnage de type paysan.
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class Paysan extends Personnage{
    /**
     * Crée un paysan avec les caractéristiques indiquées.
     *
     * @param nom nom initial
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param distAttMax portée maximale d'attaque
     * @param pos position initiale
     */
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
    }
    /**
     * Crée une copie du paysan indiqué.
     *
     * @param p paysan à copier
     */
    public Paysan(Paysan p) {
        super(p);
    }

    /**
     * Crée un paysan avec les caractéristiques par défaut.
     */
    public Paysan() {
       super();
    }
    /**
     * Affiche le symbole du paysan sur la carte.
     */    
    public void aff_lettre(){
        System.out.print(" P ");
        
    }
    /**
     * Affiche les informations principales du paysan.
     */
     public void afficheDetails(){
        System.out.println("Paysan : " + this.getNom()+", Points de vie : " + this.getPtVie() + ", Position : (" + this.getPos().getX() + ", " + this.getPos().getY() + ")");
    }
    /**
     * Retourne les données du paysan au format de sauvegarde du jeu.
     *
     * @return chaîne contenant le type et l'état du paysan
     */
    public String info_svg() {
        return("Paysan " + this.getNom() + " " + this.getPtVie() + " " + this.getDegAtt() + " " + this.getPtPar() + " " + this.getPageAtt() + " " + this.getPagePar() + " " + this.getDistAttMax() + " " + this.getPos().getX() + " " + this.getPos().getY());
    }
}
