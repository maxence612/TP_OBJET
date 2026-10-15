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
public class Archer extends Personnage implements Combattant{
   /**
     * Nombre de flèches restantes à l'archer
     */    
    private int nbFleches;

    
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
     * @param nbFleches nombre initial de flèches 
     */
    public Archer(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, int nbFleches) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
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
       /**
     *
     * @param C créature à attaquer
     * @throws Exception si l'archer n'a plus de flèches
     * Permet à l'archer d'attaquer une créature, que ce soit à distance ou au corps à corps, en fonction de la distance entre l'archer et la créature.
     */       
   public void combattre(Creature C){
       // Combat Rapproché
       if (this.getPos().distance(C.getPos())==1){
           System.out.println("Combat au corps à corps entre "+ this.getNom()+" et la créature");
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
           // Combat à distance
           if (this.getPos().distance(C.getPos())<=this.getDistAttMax()){
               if (this.nbFleches>0){
                   System.out.println("Combat à distance entre "+ this.getNom()+" et la créature");
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
                   this.nbFleches--;
               }
               else{
                   System.out.println("L'archer n'a plus de flèches pour attaquer la créature");
               }
           }
           else{
               System.out.println("Combat à distance impossible, la distance entre les deux personnages est de : "+this.getPos().distance(C.getPos()));
           }


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
