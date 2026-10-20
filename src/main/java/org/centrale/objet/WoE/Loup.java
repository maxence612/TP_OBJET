/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Créature de type loup.
 *
 * @author Maxence Schwerer et Corentin Godard
 */
public class Loup extends Monstre implements Combattant{
    /**
     * Crée un loup avec les caractéristiques indiquées.
     *
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param pos position initiale
     * @param nom nom du loup
     */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, String nom) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos, nom);
    }
    /**
     * Crée une copie du loup indiqué.
     *
     * @param l loup à copier
     */
    public Loup(Loup l) {
        super(l);
    }

    /**
     * Crée un loup avec les caractéristiques par défaut.
     */
    public Loup() {
        super();
    }
    
    /**
     * Attaque la créature indiquée.
     *
     * @param C créature visée
     */
    public void combattre(Creature C){
       
   }
    /**
     * Affiche le symbole du loup sur la carte.
     */
    public void aff_lettre(){
        System.out.print(" L ");
    }
    /**
     * Affiche les informations principales du loup.
     */
    public void afficheDetails(){
        System.out.println("Loup : " + this.getNom()+", Points de vie : " + this.getPtVie() + ", Position : (" + this.getPos().getX() + ", " + this.getPos().getY() + ")");
    }
    /**
     * Retourne les données du loup au format de sauvegarde du jeu.
     *
     * @return chaîne contenant le type et l'état du loup
     */
    public String info_svg() {
        return("Loup " + this.getNom() + " " + this.getPtVie() + " " + this.getDegAtt() + " " + this.getPtPar() + " " + this.getPageAtt() + " " + this.getPagePar() + " " + this.getPos().getX() + " " + this.getPos().getY());
    }
}
