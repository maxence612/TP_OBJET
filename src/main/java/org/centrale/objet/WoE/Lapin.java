/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Créature de type lapin.
 *
 * @author Maxence Schwerer et Corentin Godard
 */
public class Lapin extends Monstre{
    /**
     * Crée un lapin avec les caractéristiques indiquées.
     *
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param pos position initiale
     * @param nom nom du lapin
     */
    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, String nom) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos, nom);
    }
    /**
     * Crée une copie du lapin indiqué.
     *
     * @param l lapin à copier
     */
    public Lapin(Lapin l) {
        super(l);
    }

    /**
     * Crée un lapin avec les caractéristiques par défaut.
     */
    public Lapin() {
        super();
    }
    /**
     * Affiche le symbole du lapin sur la carte.
     */   
    public void aff_lettre(){
        System.out.print(" R ");
    }
    /**
     * Affiche les informations principales du lapin.
     */
     public void afficheDetails(){
        System.out.println("Lapin : " + this.getNom()+", Points de vie : " + this.getPtVie() + ", Position : (" + this.getPos().getX() + ", " + this.getPos().getY() + ")");
    }
    /**
     * Retourne les données du lapin au format de sauvegarde du jeu.
     *
     * @return chaîne contenant le type et l'état du lapin
     */
    public String info_svg() {
        return("Lapin " + this.getNom() + " " + this.getPtVie() + " " + this.getDegAtt() + " " + this.getPtPar() + " " + this.getPageAtt() + " " + this.getPagePar() + " " + this.getPos().getX() + " " + this.getPos().getY());
    }
    
}
