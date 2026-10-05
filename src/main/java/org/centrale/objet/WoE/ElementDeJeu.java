/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public class ElementDeJeu {
        /**
     * Position de l'objet 
     */
    private Point2D pos;
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;    
   
    }  

    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }

    public ElementDeJeu() {
        this.pos = new Point2D();
    }
    
    
}


