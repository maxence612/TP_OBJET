package org.centrale.objet.WoE;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class ProjetTP {

    private static Scanner sc = new Scanner(System.in); 
    private static World monde;
    public static void main(String[] args) {
        System.out.println("Et c'est parti !");
        System.out.println("---Démarrage---");

        while(true){
            System.out.println(" 1 - Nouveau monde");
            System.out.println(" 2 - Charger une partie");

            String choix = sc.next();

            if(choix.equals("1")){
                monde = new World(15,8);
                //monde.creerPersoAlea(10);
                //monde.creation_Joueur();
                //monde.placerObjets();
                monde.getJoueur().getInventaire().affiche();
                break;
            }
            
            else if(choix.equals("2")){
                while(true){
                    System.out.println("Veuillez entrer le nom de la partie à charger :");
                    String nomPartie = sc.next();
                    try{
                        monde = new World(nomPartie);
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Erreur lors du chargement de la partie : " + e.getMessage());
                        continue;
                    }
                }
                
                break;
            }else{
                System.out.println("Choix invalide");
            }
        }

        

        
        while(true){
            monde.afficheWorld();
            monde.tourDeJeu();
        }

    
    }
}
