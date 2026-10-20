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
public class Archer extends Personnage implements Combattant {
    /** Nombre de flèches restantes. */
    private int nbFleches;

    /**
     * Crée un archer avec les caractéristiques indiquées.
     *
     * @param nom nom initial
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param distAttMax portée maximale d'attaque
     * @param pos position initiale
     * @param nbFleches nombre initial de flèches
     */
    public Archer(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos,
            int nbFleches) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
        this.nbFleches = nbFleches;
    }

    /**
     * Crée une copie de l'archer indiqué.
     *
     * @param a archer à copier
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = 4;
    }

    /**
     * Crée un archer avec les caractéristiques par défaut et huit flèches.
     */
    public Archer() {
        super();
        this.nbFleches = 8;
    }

    /**
     * Retourne le nombre de flèches restantes.
     *
     * @return nombre de flèches
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * Définit le nombre de flèches restantes.
     *
     * @param nbFleches nouveau nombre de flèches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Attaque une créature au corps à corps ou à distance selon leur éloignement.
     * Une attaque à distance consomme une flèche.
     *
     * @param C créature visée
     */
    public void combattre(Creature C) {
        // Combat Rapproché
        if (this.getPos().distance(C.getPos()) == 1) {
            System.out.println("Combat au corps à corps entre " + this.getNom() + " et " + C.getNom());
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
            // Combat à distance
            if (this.getPos().distance(C.getPos()) <= this.getDistAttMax()) {
                if (this.nbFleches > 0) {
                    System.out.println("Combat à distance entre " + this.getNom() + " et la créature");
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
    if (degats < 0) degats = 0;
    C.setPtVie(C.getPtVie() - degats);
    System.out.println("La créature a perdu " + degats + " points de vie");
}
                    }
                    this.nbFleches--;
                } else {
                    System.out.println("L'archer n'a plus de flèches pour attaquer la créature");
                }
            } else {
                System.out.println("Combat à distance impossible, la distance entre les deux personnages est de : "
                        + this.getPos().distance(C.getPos()));
            }

        }
    }

    /**
     * Affiche le symbole de l'archer sur la carte.
     */
    public void aff_lettre() {
        System.out.print(" A ");
    }

    /**
     * Affiche les informations principales de l'archer en vue d'un .
     */
    public void afficheDetails() {
        System.out.println("Archer : " + this.getNom() + ", Points de vie : " + this.getPtVie() + ", Position : ("
                + this.getPos().getX() + ", " + this.getPos().getY() + ")");

    }

    /**
     * Retourne les données de l'archer au format de sauvegarde du jeu.
     *
     * @return chaîne contenant le type et l'état de l'archer
     */
    public String info_svg() {
        return ("Archer " + this.getNom() + " " + this.getPtVie() + " " + this.getDegAtt() + " " + this.getPtPar() + " "
                + this.getPageAtt() + " " + this.getPagePar() + " " + this.getDistAttMax() + " " + this.getPos().getX()
                + " " + this.getPos().getY() + " " + this.nbFleches);
    }
}
