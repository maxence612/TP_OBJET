/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.List;


/**
 * Représente un élément positionnable sur la carte du jeu.
 *
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public abstract class ElementDeJeu {
    /** Position de l'élément sur la carte. */
    private Point2D pos;

    /**
     * Retourne la position de l'élément.
     *
     * @return position actuelle
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Définit la position de l'élément.
     *
     * @param pos nouvelle position
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Crée un élément à la position indiquée.
     *
     * @param pos position initiale
     */
    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Crée un élément à l'origine.
     */
    public ElementDeJeu() {
        this.pos = new Point2D();
    }

    /**
     * Affiche le symbole de l'élément sur la carte.
     */
    public abstract void aff_lettre();

    /**
     * Produit la représentation textuelle de l'élément utilisée pour la sauvegarde.
     *
     * @return informations sérialisées de l'élément
     */
    public abstract String info_svg();
}

