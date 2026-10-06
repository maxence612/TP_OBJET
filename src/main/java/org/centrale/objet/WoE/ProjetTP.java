/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class ProjetTP {

    public static void main(String[] args) {
        System.out.println("Ok");
        World monde = new World();
        
        monde.creerPersoAlea(1000);
        monde.placerObjets();
        monde.afficheWorld();
        monde.mesure_temps();
    }
}
