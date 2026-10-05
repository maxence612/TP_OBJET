/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author maxen
 */
public class Monstre extends Creature{

    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
      super(ptVie,degAtt,ptPar,pageAtt,pagePar,pos);
    }
    
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


