/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Guerrier combattant au corps à corps.
 *
 * @author Maxence Schwerer et Corentin Godard
 */
public class Guerrier extends Personnage implements Combattant {
    /**
     * Crée un guerrier avec les caractéristiques indiquées.
     *
     * @param nom nom initial
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param distAttMax portée maximale d'attaque
     * @param pos position initiale
     */
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax,
            Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
    }

    /**
     * Crée une copie du guerrier indiqué.
     *
     * @param g guerrier à copier
     */
    public Guerrier(Guerrier g) {
        super(g);
    }

    /**
     * Crée un guerrier avec les caractéristiques par défaut.
     */
    public Guerrier() {
        super();
    }

    /**
     * Attaque une créature adjacente en tenant compte de ses chances de parade.
     *
     * @param C créature visée
     */
    public void combattre(Creature C) {
        // Combat Rapproché
        if (this.getPos().distance(C.getPos()) == 1) {
            System.out.println("Combat entre " + this.getNom() + " et " + C.getNom());
            Random genRand = new Random();
            int x = genRand.nextInt(100);
            if (x > this.getPageAtt()) {
                System.out.println("Attaque ratée, " + C.getNom() + " n'a pas perdu de points de vie");
                return;
            } else {
                int y = genRand.nextInt(100);
                if (y <= C.getPagePar()) {
                    System.out.println("La créature a paré l'attaque");
                } else {
                    int degats = this.getDegAtt() - C.getPtPar();
                    if (degats < 0)
                        degats = 0;
                    C.setPtVie(C.getPtVie() - degats);
                    System.out.println("La créature a perdu " + degats + " points de vie");
                }
            }
        } else {
            System.out.println("Combat à rapproché impossible, la distance entre les deux personnages est de : "
                    + this.getPos().distance(C.getPos()));
        }
    }

    /**
     * Affiche le symbole du guerrier sur la carte.
     */
    public void aff_lettre() {
        System.out.print(" G ");
    }

    /**
     * Affiche les informations principales du guerrier.
     */
    public void afficheDetails() {
        System.out.println("Guerrier : " + this.getNom() + ", Points de vie : " + this.getPtVie() + ", Position : ("
                + this.getPos().getX() + ", " + this.getPos().getY() + ")");
    }

    /**
     * Retourne les données du guerrier au format de sauvegarde du jeu.
     *
     * @return chaîne contenant le type et l'état du guerrier
     */
    public String info_svg() {
        return ("Guerrier " + this.getNom() + " " + this.getPtVie() + " " + this.getDegAtt() + " " + this.getPtPar()
                + " " + this.getPageAtt() + " " + this.getPagePar() + " " + this.getDistAttMax() + " "
                + this.getPos().getX() + " " + this.getPos().getY());

    }
}
