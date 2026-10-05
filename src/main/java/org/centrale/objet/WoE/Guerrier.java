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

    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    public Guerrier(Guerrier g) {
        super(g);
    }

    public Guerrier() {
        super();
    }

 
   public void combattre(Creature C){
       
   }
   
}
