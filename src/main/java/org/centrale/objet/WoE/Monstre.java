/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe de base des créatures non-joueurs de type monstre.
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public abstract class Monstre extends Creature{
    /**
     * Crée un monstre avec ses caractéristiques initiales.
     *
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param pos position initiale
     * @param nom nom du monstre
     */
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, String nom) {
      super(ptVie,degAtt,ptPar,pageAtt,pagePar,pos,nom);
    }
    /**
     * Crée une copie du monstre indiqué.
     *
     * @param m monstre à copier
     */
    public Monstre(Monstre m){
        super(m);
    }
    /**
     * Crée un monstre avec les caractéristiques par défaut.
     */
    public Monstre(){
        super();
    }
    /**
     * Affiche la position du monstre.
     */
    public void affiche(){
        System.out.println("["+this.getPos().getX() +";"+this.getPos().getY()+"]");
    }
}

