package org.centrale.objet.WoE;

import java.io.File;
import java.util.Scanner;

/**
 * Point d'entrée de l'application et boucle de sélection de partie.
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class ProjetTP {

    /** Lecteur des choix saisis dans la console. */
    private static Scanner sc = new Scanner(System.in); 
    /** Monde associé à la partie courante. */
    private static World monde;
    /** Indique si la boucle de jeu est active. */
    private static boolean partieLancee = false;

    /**
     * Crée l'objet associé au point d'entrée de l'application.
     */
    public ProjetTP() {
    }

    /**
     * Démarre une nouvelle partie ou charge une sauvegarde, puis lance le jeu.
     *
     * @param args arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        System.out.println("Et c'est parti !");
        System.out.println("---Démarrage---");

        while(true){
            System.out.println(" 1 - Nouveau monde");
            System.out.println(" 2 - Charger une partie");

            String choix = sc.next();

            if(choix.equals("1")){
                monde = new World(15,8);

                System.out.println("Le joueur démarre en ");
                monde.getJoueur().getPerso().getPos().affiche();
                monde.afficheWorld();
                partieLancee = true;

                break;
            }
            
            else if(choix.equals("2")){
                
                while(true){
                    System.out.println("Veuillez entrer le numéro de la partie à charger :");

                    File dossier = new File(".");
                    File[] fichiers = dossier.listFiles(
                        (dir, nom) -> nom.endsWith(".txt")
                    );

                    for (int i = 0; i < fichiers.length; i++) {
                        System.out.println((i + 1) + " - " + fichiers[i].getName());
                    }
                    
                    try{
                        int choixFichier = Integer.parseInt(sc.next());
                        if(choixFichier < 1 || choixFichier > fichiers.length){
                            System.out.println("Choix invalide");
                            continue;
                        }
                        String nomPartie = fichiers[choixFichier - 1].getName();
                        try{
                            monde = new World(nomPartie);
                            partieLancee=true;
                            break;
                        }
                        catch(Exception e){
                            System.out.println("Erreur lors du chargement de la partie : " + e.getMessage());
                            continue;
                        }
                    }
                    catch(NumberFormatException e){
                        System.out.println("Choix invalide");
                        continue;
                    }
                }
                
                break;
            }else{
                System.out.println("Choix invalide");
            }
        }

        
        while(partieLancee){
            monde.tourDeJeu();
        }

    
    }
}
