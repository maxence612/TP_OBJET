/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe de base des objets représentés sur la carte et possédant une durabilité.
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public abstract class Objet extends ElementDeJeu{

    /** Durabilité restante de l'objet. */
    private Integer durabilite;

    /**
     * Définit la durabilité de l'objet.
     *
     * @param durabilite nouvelle durabilité
     */
    public void setDurabilite(Integer durabilite) {
        this.durabilite = durabilite;
    }

    /**
     * Retourne la durabilité restante de l'objet.
     *
     * @return durabilité restante
     */
    public Integer getDurabilite() {
        return durabilite;
    }

    /**
     * Crée un objet avec la durabilité indiquée.
     *
     * @param durabilite durabilité initiale
     */
    public Objet(Integer durabilite) {
        super();
        this.durabilite = durabilite;
    }

    /**
     * Crée un objet avec une durabilité initiale égale à un.
     */
    public Objet() {
        super();
        this.durabilite=1;
    }

    /**
     * Affiche le symbole représentant l'objet sur la carte.
     */
    public abstract void aff_lettre();

    /**
     * Affiche les détails de l'objet.
     */
    public abstract void afficheDetails();
}

