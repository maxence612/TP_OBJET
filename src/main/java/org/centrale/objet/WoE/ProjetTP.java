package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class ProjetTP {

    public static void main(String[] args) {
        System.out.println("Ok");
        World monde = new World(15,8);

        
        monde.creerPersoAlea(10);
        monde.creation_Joueur();
        monde.placerObjets();
        while(true){
            monde.afficheWorld();

            monde.tourDeJeu();
        }

    
    }
}
