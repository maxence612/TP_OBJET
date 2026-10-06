 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Maxence Schwerer et Corentin Godard
 */
public class Guerrier extends Personnage{
       /**
     *
     * @param n nom initial
     * @param pV points de vie initiaux
     * @param dA nombre de dégat initiaux infligé par attaque
     * @param pPar nombre points parade initiaux
     * @param paAtt pourcentage initial de chance que l'attaque aboutisse 
     * @param paPar pourcentage initial de chance que la parade aboutisse 
     * @param dMax distance initale à laquelle il peut se battre 
     * @param p position initale  
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }
    /**
     *
     * @param g guerrier à dupliquer
     */
    public Guerrier(Guerrier g) {
        super(g);
    }

    public Guerrier() {
        super();
    }

 
   public void combattre(Creature C){
       
   }
    /**
    * Affiche la lettre représentant le guerrier sur la carte.
    *
     */
    public void aff_lettre(){
        System.out.print(" G ");
    }
   
}
