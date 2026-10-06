/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public abstract class Monstre extends Creature{
       /**
     *
     * @param ptVie points de vie initiaux
     * @param degAtt nombre de dégat initiaux infligé par attaque
     * @param ptPar nombre points parade initiaux
     * @param pageAtt pourcentage initial de chance que l'attaque aboutisse 
     * @param pagePar pourcentage initial de chance que la parade aboutisse 
     * @param pos position initale  
     */
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
      super(ptVie,degAtt,ptPar,pageAtt,pagePar,pos);
    }
        /**
     *
     * @param m monstre à dupliquer
     */ 
    public Monstre(Monstre m){
        super(m);
    }
    
    public Monstre(){
        super();
    }

   
    public void affiche(){
        System.out.println("["+this.getPos().getX() +";"+this.getPos().getY()+"]");
    }
}


