/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public class Epee extends Objet{

        /**
     * Durabilité de l'objet
     */
    private Integer degat;
 


    public void setDegat(Integer degat) {
        this.degat = degat;
    }

    public Integer getDegat() {
        return degat;
    }

    public Epee(Integer degat){
        super();
        this.degat = degat;
        
    
    }

    public Epee() {
        super();
        this.degat=0;
    }


    
    
}


