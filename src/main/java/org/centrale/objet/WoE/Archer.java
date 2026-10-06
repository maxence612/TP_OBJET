/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public class Archer extends Personnage{
   /**
     * Nombre de flèches restantes à l'archer
     */    
    private int nbFleches;

    
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
     * @param nbFleches nombre initial de flèches 
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p,int nbFleches) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFleches;
    }
    /**
     *
     * @param a archer à dupliquer
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = 4;
    }

    public Archer() {
        super();
        this.nbFleches = 8;
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
          
   public void combattre(Creature C){
       // Combat Rapproché
       if (this.getPos().distance(C.getPos())==1){
           System.out.println("Combat entre "+ this.getNom()+" et la créature");
           Random genRand= new Random();
            int x=genRand.nextInt(100);
            if (x > this.getPageAtt()){
                System.out.println("La créature n'a pas perdu des points de vie");
                return;
            }
            else {
             int y =genRand.nextInt(100);
             if (y<=C.getPagePar()){
                C.setPtVie(C.getPtVie()-this.getDegAtt()+C.getPtPar());
                System.out.println("La créature a perdu des points de vie");
            
            }
            else {
                    System.out.println("La créature a paré l'attaque");
                }
            }
       }
       else{
        System.out.println("Combat à rapproché impossible, la distance entre les deux personnages est de : "+this.getPos().distance(C.getPos()));
       }
   }
   /**
    * Affiche la lettre représentant l'archer sur la carte.
    *
     */
    public void aff_lettre(){
        System.out.print(" A ");
    }
}
