 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Maxence Schwerer et Corentin Godard
 */
public class Guerrier extends Personnage implements Combattant{
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
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
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
    * Affiche la lettre représentant le guerrier sur la carte.
    *
     */
    public void aff_lettre(){
        System.out.print(" G ");
    }
   
    public void afficheDetails(){
        System.out.println("Guerrier : " + this.getNom()+", Points de vie : " + this.getPtVie() + ", Position : (" + this.getPos().getX() + ", " + this.getPos().getY() + ")");
    }
    public String info_svg() {
        return("Guerrier " + this.getNom() + " " + this.getPtVie() + " " + this.getDegAtt() + " " + this.getPtPar() + " " + this.getPageAtt() + " " + this.getPagePar() + " " + this.getDistAttMax() + " " + this.getPos().getX() + " " + this.getPos().getY() );

    }
}
