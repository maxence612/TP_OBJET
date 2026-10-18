package org.centrale.objet.WoE;

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class World {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";

    private int largeur;
    private int longueur;
    private ElementDeJeu[][] carte;
    private int[][] carte_nuage; // Tab 1 si nuage toxique, 0 sinon (possible de metre 3,4...)
    private List<Creature> creatures = new ArrayList<>();
    private List<Objet> objets = new ArrayList<>();
    public Joueur joueur;
    public String[] classes = { "Guerrier", "Archer" };
    private Scanner sc = new Scanner(System.in);

    public World(String nomPartie) {
        chargementPartie(nomPartie);

    }

    public World(int largeur, int longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
        this.carte = new ElementDeJeu[largeur][longueur];
        this.carte_nuage = new int[largeur][longueur];
    }

    private boolean occupe(Point2D p) {
        return carte[p.getX()][p.getY()] != null;
    }

        /**
     * Permet de créer un certain nombre de créatures aléatoires.
     * @param nombre_perso le nombre de créatures à créer
     */
    public void creerCreaturesAlea(int nombre_perso) {
        Random rd = new Random();
        int nombre_race;
        for (int i = 0; i < nombre_perso; i++) {
            nombre_race = rd.nextInt(5);
            if (nombre_race == 0) {
                creatures.add(new Guerrier());
            }
            if (nombre_race == 1) {
                creatures.add(new Paysan());
            }
            if (nombre_race == 2) {
                creatures.add(new Archer());
            }
            if (nombre_race == 3) {
                creatures.add(new Loup());
            }
            if (nombre_race == 4) {
                creatures.add(new Lapin());
            }
        }

    }

    public void creerObjetsAlea(int nombre_objets) {
        Random rd = new Random();
        int nombre_race;
        for (int i = 0; i < nombre_objets; i++) {
            nombre_race = rd.nextInt(2);
            if (nombre_race == 0) {
                objets.add(new Epee());
            }
            if (nombre_race == 1) {
                objets.add(new PotionSoin());
            }

        }

    }

    public void creerNuagesAlea(int nombre_nuages) {
        Random rd = new Random();
        int x, y, lg;
        for (int i = 0; i < nombre_nuages; i++) {
            x = rd.nextInt(this.largeur);
            y = rd.nextInt(this.longueur);
            lg= rd.nextInt(5) + 1;
            while(lg>0 && x<largeur){
                carte_nuage[x][y] = 1;
                x++;
                lg--;
            }
          
        }
    }
    
    /**
     *
     * Création du joueur au début de la partie
     */
    public void creationJoueur() {
        System.out.println("Entrez le nom du joueur :");
        String nom = sc.next();
        boolean classeValide = false;
        String classe = "";
        while (!classeValide) {
            System.out.println("Voulez vous jouer un Archer ou un Guerrier");
            classe = sc.next();
            for (String c : classes) {
                if (c.equalsIgnoreCase(classe)) {
                    classeValide = true;
                    break;
                }
            }
            if (!classeValide) {
                System.out.println("Classe invalide, veuillez réessayer.");
            }
        }

        joueur = new Joueur(nom, classe);
        creatures.add(joueur.getPerso());
    }

    /**
     *
     * Sert à placer les créatures et les objets générés précédement sur la carte
     */
    public void placerCreaturesEtObjetsEtPerso() {
        Random genRand = new Random();
        int x = genRand.nextInt(this.largeur);
        int y = genRand.nextInt(this.longueur);
        Point2D pt = new Point2D(x, y);

        for (int i = 0; i < creatures.size(); i++) {
            while (occupe(pt)) {
                x = genRand.nextInt(this.largeur);
                y = genRand.nextInt(this.longueur);
                pt = new Point2D(x, y);
            }
            creatures.get(i).setPos(pt);
            carte[x][y] = creatures.get(i);
        }

        for (int i = 0; i < objets.size(); i++) {
            while (occupe(pt)) {
                x = genRand.nextInt(this.largeur);
                y = genRand.nextInt(this.longueur);
                pt = new Point2D(x, y);
            }
            objets.get(i).setPos(pt);
            carte[x][y] = objets.get(i);
        }

    }

    /**
     *
     * Permet d'afficher le monde dans la console, en affichant les lettres
     * représentant les créatures et les objets sur la carte.
     */
    public void afficheWorld() {
        Point2D pt;
        boolean actuel_nuage = false;
        System.out.print(ANSI_BLUE);
        System.out.println("Le joueur est en ");
        joueur.getPerso().getPos().affiche();
        for (int y = 0; y < longueur; y++) {
            for (int x = 0; x < largeur; x++) {
                pt = new Point2D(x, y);

                if (carte_nuage[x][y] == 1 && !actuel_nuage) {
                    actuel_nuage = true;
                    System.out.print(ANSI_RESET+ANSI_RED);
                } else if (carte_nuage[x][y] == 0 && actuel_nuage) {
                    actuel_nuage = false;
                    System.out.print(ANSI_RESET+ANSI_BLUE);
                }

                if (occupe(pt)) {
                    if (carte[x][y] == joueur.getPerso()) {
                        System.out.print(ANSI_GREEN + " @ " + ANSI_RESET);
                    } 
                    else {
                        carte[x][y].aff_lettre();
                        }
                } 
                else {
    System.out.print(" . ");
}

            }
            System.out.println();
        }
        System.out.print(ANSI_RESET);
    }



    public void action_deplacement() {
        // appelé à lorsque le joueur choisit de se déplacer.
        System.out.println("Ou voulez vous déplacer ? ");
        System.out.println("8 | 1 | 2");
        System.out.println("7 | 0 | 3");
        System.out.println("6 | 5 | 4");

        int direction = Integer.parseInt(sc.next());
        if (!deplacerElementDeJeu(joueur.getPerso(), new Point2D(direction), true)) {
            System.out.println("Déplacement impossible, veuillez réessayer.");
        } else {
            System.out.println("Le joueur est maintenant en position : ");
            joueur.getPerso().getPos().affiche();
        }
    }

    public void action_attaquer() {
        // appelé à lorsque le joueur choisit de combattre.
        List<Creature> cibles = new ArrayList<>();
        int rayon = (int) Math.sqrt(joueur.getPerso().getDistAttMax());
        int x = joueur.getPerso().getPos().getX();
        int y = joueur.getPerso().getPos().getY();
        for (int i = x - rayon; i <= x + rayon; i++) {
            for (int j = y - rayon; j <= y + rayon; j++) {
                if (i >= 0 && i < largeur && j >= 0 && j < longueur && !(i == x && j == y)) {
                    if (carte[i][j] instanceof Creature) {
                        cibles.add((Creature) carte[i][j]);
                    }
                }
            }
        }
        if (cibles.isEmpty()) {
            System.out.println("Aucune créature à portée.");
        } else {
            System.out.println("Qui voulez-vous attaquer ?");
            for (int i = 0; i < cibles.size(); i++) {
                Creature c = cibles.get(i);
                System.out.print((i + 1) + ". ");
                c.afficheDetails();
                        
            }
            System.out.println("Mettez comme chiffre la créature que vous souhaitez attaquer, ou 0 pour ne pas attaquer.");
            int ennemi = Integer.parseInt(sc.next());
            if (ennemi == 0) {
                System.out.println("Vous avez choisi de ne pas attaquer.");
            } else if (ennemi > 0 && ennemi <= cibles.size()) {
                Creature cible = cibles.get(ennemi - 1);
                joueur.combattre(cible);
                System.out.print("Vous avez attaqué ");
                System.out.println(cible.getNom());
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");

            }
        }
    }

    public void afficheLegende() {
        System.out.println(ANSI_YELLOW + "# # # # # # # # # # # # #");
        System.out.println("Légende :");
        System.out.println(" . : Case vide");
        System.out.println("[rouge] : Nuage toxique");
        System.out.println("P : Paysan");
        System.out.println("G : Guerrier");
        System.out.println("A : Archer");
        System.out.println("L : Loup");
        System.out.println("R : Lapin");
        System.out.println("E : Epee");
        System.out.println("H : Potion de soin");
        System.out.println("# # # # # # # # # # # # #" + ANSI_RESET);
    }



    /**
     *
     * Tour de jeu du joueur
     */

    public void tourDeJeu() {
        System.out.println(ANSI_GREEN+"Nouveau tour de jeu !");

        System.out.println("Que voulez-vous faire ?");
        System.out.println(" - Se battre (b)");
        System.out.println(" - Se déplacer (d)");
        System.out.println(" - Afficher la carte (a)");
        System.out.println(" - Afficher l'inventaire (i)");
        System.out.println(" - Afficher la légende de la carte (l)");
        System.out.println(" - Sauvegarder (s)");
        System.out.println(" - Quitter (q)"+ANSI_RESET);

        String choix = sc.next();
        screenReset();
        // System.out.println("Fin du tour !");
        if (choix.equals("d")) {
            action_deplacement();
        } else if (choix.equals("a")) {
            afficheWorld();
        } else if (choix.equals("i")) {
            joueur.getInventaire().affiche();
        } else if (choix.equals("s")) {
            sauvegardePartie();
        } else if (choix.equals("b")) {
            action_attaquer();
        } else if (choix.equals("l")) {
            afficheLegende();   
        } else if (choix.equals("q")) {
            System.out.println("A bientôt !");
            System.exit(0);
        } else {
            System.out.println("Choix invalide, veuillez réessayer.");
        }

    }

    public boolean deplacerElementDeJeu(ElementDeJeu element, Point2D decalage,  boolean joueurPrincipal) {
        int x = decalage.getX() + element.getPos().getX();
        int y = decalage.getY() + element.getPos().getY();
        Point2D newPos = new Point2D(x, y);

        if (x < 0 || x >= largeur || y < 0 || y >= longueur) {
            return false;
        }

        //ramasser un objet si le joueur se déplace sur une case contenant un objet
        if(joueurPrincipal && carte[x][y] instanceof Inventorable){ 
            joueur.getInventaire().ajouterObjet( (Objet) carte[x][y]);
            carte[x][y] = null;
            System.out.println(ANSI_GREEN + "Vous avez ramassé un objet !" + ANSI_RESET);
        }

        if (carte[x][y] != null) {
            return false;
        }

        // Libérer l'ancienne case.
        Point2D anciennePos = element.getPos();
        carte[anciennePos.getX()][anciennePos.getY()] = null;

        // Actualiser la position de l'élément.
        element.setPos(newPos);
        carte[x][y] = element;

        return true;
    }

    /**
     * Retourne la liste des créatures situées à une distance < 1 du joueur.
     * (le joueur lui-même est exclu)
     */

    public void chargementPartie(String source) {
        System.out.println("Chargement de la partie...");
        while (true) {
            System.out.println("...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        File f = new File(source);
        if (!f.exists() || !f.isFile()) {
            throw new IllegalArgumentException("Le fichier spécifié n'existe pas");
        } else {
            largeur = 50;
            longueur = 50;
            carte = new ElementDeJeu[largeur][longueur];
            carte_nuage = new int[largeur][longueur];
        }
        */
    }

    public void sauvegardePartie() {  
        String date = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        sauvegardePartie("sauvegarde_" + date);
    }

    public void sauvegardePartie(String destination) {
        destination = destination + ".txt";
        //File f = new File(destination);

        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(destination));
            
            writer.write("Largeur: " + largeur);
            writer.newLine();
            writer.write("Longueur: " + longueur);
            writer.newLine();
            writer.write("Joueur");
            for(Creature c : creatures){
                writer.write(c.info_svg());
                writer.newLine();
            }
            for(Objet o : objets){
                writer.write(o.info_svg());
                writer.newLine();
            }
            for(Objet o : joueur.getInventaire().getObjets()){
                writer.write("Inventaire " + o.info_svg());
                writer.newLine();
            }

        }
        catch(IOException e){
            System.out.println("Erreur lors de la sauvegarde de la partie : " + e.getMessage());
        }
        finally{
            try{
                if(writer != null){
                    writer.close();
                }
            }
            catch(IOException e){
                System.out.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
            }
        }

        System.out.println("Sauvegarde bien effecutée sous le nom " + destination   );
            
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void screenReset(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
