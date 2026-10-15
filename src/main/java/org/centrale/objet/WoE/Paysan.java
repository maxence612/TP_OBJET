/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class Paysan extends Personnage{
       /**
     *
     * @param nom nom initial
     * @param ptVie points de vie initiaux
     * @param degAtt nombre de dégat initiaux infligé par attaque
     * @param ptPar nombre points parade initiaux
     * @param pageAtt pourcentage initial de chance que l'attaque aboutisse 
     * @param pagePar pourcentage initial de chance que la parade aboutisse 
     * @param distAttMax distance initale à laquelle il peut se battre 
     * @param pos position initale  
     */
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
    }
     /**
     *
     * @param p paysan à dupliquer
     */
    public Paysan(Paysan p) {
        super(p);
    }

    public Paysan() {
       super();
    }
        /**
    * Affiche la lettre représentant le paysan sur la carte.
    *
     */    
    public void aff_lettre(){
        System.out.print(" P ");
    }
}
