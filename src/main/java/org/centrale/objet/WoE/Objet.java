/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public class Objet extends ElementDeJeu{

        /**
     * Durabilité de l'objet
     */
    private Integer durabilite;
 


    public void setDurabilite(Integer durabilite) {
        this.durabilite = durabilite;
    }

    public Integer getDurabilite() {
        return durabilite;
    }

    public Objet(Integer durabilite) {
        super();
        this.durabilite = durabilite;
        
    
    }

    public Objet() {
        super();
        this.durabilite=0;
    }


    public void aff_lettre(){
        System.out.print(" O ");
    }
    
}


