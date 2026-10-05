/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author maxen
 */
public class ProjetTP {

    public static void main(String[] args) {
        System.out.println("Ok");
        World monde = new World();
        monde.creerPersoAlea();
        monde.placerObjets();

        monde.afficheWorld();
        monde.total_pdv();
 
    }
}
