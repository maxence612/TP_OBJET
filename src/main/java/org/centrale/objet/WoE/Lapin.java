/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author maxen
 */
public class Lapin extends Monstre{
       /**
     *
     * @param ptVie points de vie initiaux
     * @param degAtt nombre de dégat initiaux infligé par attaque
     * @param ptPar nombre points parade initiaux
     * @param pageAtt pourcentage initial de chance que l'attaque aboutisse 
     * @param pagePar pourcentage initial de chance que la parade aboutisse 
     * @param pos position initale  
     * @param nom nom du monstre
     */
    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, String nom) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos, nom);
    }
     /**
     *
     * @param l lapin à dupliquer
     */
    public Lapin(Lapin l) {
        super(l);
    }

    public Lapin() {
        super();
    }
     /**
    * Affiche la lettre représentant le lapin sur la carte.
    *
     */   
    public void aff_lettre(){
        System.out.print(" R ");
    }
     public void afficheDetails(){
        System.out.println("Lapin : " + this.getNom()+", Points de vie : " + this.getPtVie() + ", Dégâts d'attaque : " + this.getDegAtt() + ", Points de parade : " + this.getPtPar() + ", Pourcentage d'attaque : " + this.getPageAtt() + ", Pourcentage de parade : " + this.getPagePar() + ", Position : (" + this.getPos().getX() + ", " + this.getPos().getY() + ")");
    }
    public String info_svg() {
        return("");
    }
    
}
