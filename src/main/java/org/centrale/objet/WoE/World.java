package org.centrale.objet.WoE;

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Gère la carte, les entités, les actions de jeu et les sauvegardes d'une partie.
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class World {
    /** Séquence ANSI de réinitialisation des couleurs du terminal. */
    private static final String ANSI_RESET = "\u001B[0m";
    /** Séquence ANSI pour le rouge. */
    private static final String ANSI_RED = "\u001B[31m";
    /** Séquence ANSI pour le vert. */
    private static final String ANSI_GREEN = "\u001B[32m";
    /** Séquence ANSI pour le jaune. */
    private static final String ANSI_YELLOW = "\u001B[33m";
    /** Séquence ANSI pour le bleu. */
    private static final String ANSI_BLUE = "\u001B[34m";

    /** Nombre de cases sur l'axe horizontal. */
    private int largeur;
    /** Nombre de cases sur l'axe vertical. */
    private int longueur;
    /** Cases de la carte occupées par les personnages et objets. */
    private ElementDeJeu[][] carte;
    /** Nuages toxiques présents sur chaque case. */
    private NuageToxique[][] carte_nuage;
    /** Créatures non-joueurs de la partie. */
    private List<Creature> creatures = new ArrayList<>();
    /** Objets présents sur la carte. */
    private List<Objet> objets = new ArrayList<>();
    /** Joueur de la partie. */
    public Joueur joueur;
    /** Classes de personnage proposées lors de la création du joueur. */
    public String[] classes = { "Guerrier", "Archer" };
    /** Lecteur des entrées de jeu dans la console. */
    private Scanner sc = new Scanner(System.in);

    /**
     * Charge une partie à partir du fichier indiqué.
     *
     * @param nomPartie chemin du fichier de sauvegarde
     */
    public World(String nomPartie) {
        chargementPartie(nomPartie);

    }
    /**
     * Crée un nouveau monde de dimensions indiquées et initialise son contenu.
     *
     * @param largeur largeur de la carte en cases
     * @param longueur longueur de la carte en cases
     */
    public World(int largeur, int longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
        this.carte = new ElementDeJeu[this.largeur][this.longueur];
        this.carte_nuage = new NuageToxique[this.largeur][this.longueur];
        creerCreaturesAlea(10);
        creerObjetsAlea(10);
        creationJoueur();
        creerNuagesAlea(5);
        placerElementsAleatoirement();
    }
    /**
     * Indique si une case de la carte est occupée.
     *
     * @param p position à examiner
     * @return {@code true} si la case contient un élément de jeu
     */
    private boolean occupe(Point2D p) {
        return carte[p.getX()][p.getY()] != null;
    }

    /**
     * Ajoute des créatures choisies aléatoirement à la partie.
     *
     * @param nombre_perso nombre de créatures à créer
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
    /**
     * Ajoute des objets choisis aléatoirement à la partie.
     *
     * @param nombre_objets nombre d'objets à créer
     */
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
    /**
     * Crée des nuages toxiques aléatoires et les place sur la carte.
     *
     * @param nombre_nuages nombre de nuages à créer
     */
    public void creerNuagesAlea(int nombre_nuages) {
        Random rd = new Random();
        int x, y, lg;
        for (int i = 0; i < nombre_nuages; i++) {
            x = rd.nextInt(this.largeur);
            y = rd.nextInt(this.longueur);
            lg = rd.nextInt(5) + 1;
            while (lg > 0 && x < largeur) {
                NuageToxique nuage = new NuageToxique();
                nuage.setPos(new Point2D(x, y));
                carte_nuage[x][y] = nuage;
                x++;
                lg--;
            }

        }
    }

    /**
     * Demande en console le nom et la classe du joueur, puis le crée.
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
    }

    /**
     * Place aléatoirement les créatures, objets et personnage sur des cases libres.
     */
    public void placerElementsAleatoirement() {

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

        while (occupe(pt)) {
            x = genRand.nextInt(this.largeur);
            y = genRand.nextInt(this.longueur);
            pt = new Point2D(x, y);
        }
        joueur.getPerso().setPos(pt);
        carte[x][y] = joueur.getPerso();

    }
    /**
     * Place sur la carte les entités dont les positions proviennent d'une sauvegarde.
     */
    public void placerElementsCharges() {
        for (Creature c : creatures) {
            Point2D p = c.getPos();
            carte[p.getX()][p.getY()] = c;
        }

        for (Objet o : objets) {
            Point2D p = o.getPos();
            carte[p.getX()][p.getY()] = o;
        }

        Point2D p = joueur.getPerso().getPos();
        carte[p.getX()][p.getY()] = joueur.getPerso();
    }



    /**
     * Affiche la carte dans la console avec les symboles des entités et les nuages.
     */
    public void afficheWorld() {
        Point2D pt;
        boolean actuel_nuage = false;
        Point2D joueurPos = joueur.getPerso().getPos();
        System.out.print(ANSI_BLUE);
        System.out.print("Le joueur est en ");
        joueurPos.affiche();

        for (int y = 0; y < longueur; y++) {
            for (int x = 0; x < largeur; x++) {
                pt = new Point2D(x, y);

                if (carte_nuage[x][y] != null && !actuel_nuage) {
                    actuel_nuage = true;
                    System.out.print(ANSI_RESET + ANSI_RED);
                } else if (carte_nuage[x][y] == null && actuel_nuage) {
                    actuel_nuage = false;
                    System.out.print(ANSI_RESET + ANSI_BLUE);
                }

                if (pt.equals(joueurPos)) {
                    System.out.print(ANSI_RESET + ANSI_GREEN + " @ " + ANSI_RESET + ANSI_BLUE);
                } else if (occupe(pt)) {
                    carte[x][y].aff_lettre();
                } else {
                    System.out.print(" . ");
                }

            }
            System.out.println();
        }
        System.out.print(ANSI_RESET);
    }
    /**
     * Demande une direction au joueur et tente de déplacer son personnage.
     */
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
    /**
     * Propose les créatures à portée et traite le choix de la cible du joueur.
     */
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
            System.out.println(
                    "Mettez comme chiffre la créature que vous souhaitez attaquer, ou 0 pour ne pas attaquer.");
            int ennemi = Integer.parseInt(sc.next());
            if (ennemi == 0) {
                System.out.println("Vous avez choisi de ne pas attaquer.");
            } else if (ennemi > 0 && ennemi <= cibles.size()) {
                Creature cible = cibles.get(ennemi - 1);
                joueur.combattre(cible);
                System.out.print("Vous avez attaqué ");
                System.out.println(cible.getNom());
            if (cible.getPtVie() <= 0) {
            System.out.println(cible.getNom() + " est mort");
            creatures.remove(cible);
            carte[cible.getPos().getX()][cible.getPos().getY()] = null;
            }
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");

            }
        }

    }
    /**
     * Affiche la signification des symboles utilisés sur la carte.
     */
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
     * Affiche l'inventaire et permet au joueur d'utiliser un de ses objets.
     */
    public void action_inventaire() {
        int choix = -1;
        joueur.getInventaire().affiche();
        System.out.println(
                "Quel objet voulez vous utiliser ? (mettez le numéro de l'objet, ou 0 pour ne pas utiliser d'objet)");
        while (true) {
            try {
                choix = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre.");
            }
            if (choix == 0) {
                System.out.println("Vous avez choisi de ne pas utiliser d'objet.");
                break;
            } else if (choix > 0 && choix <= joueur.getInventaire().getObjets().size()) {
                Inventorable objet = joueur.getInventaire().getObjets().get(choix - 1);
                objet.utiliser(joueur.getPerso());
                if (objet.getDurabilite() == 0) {
                    joueur.getInventaire().getObjets().remove(objet);
                }
                break;
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
    /**
     * Demande un nom de fichier puis sauvegarde la partie.
     */
    public void action_sauvegarder() {
        System.out.print("Entrez le nom du fichier de sauvegarde ou '.' pour utiliser l'horodatage: ");
        String nomFichier = sc.next();
        if(nomFichier.equals(".")){
            sauvegardePartie();
            System.out.println(ANSI_GREEN + "Partie correctement sauvegardée !! " + ANSI_RESET);
        }
        else{
            if (nomFichier.matches(".*[\\\\/:*?\"<>|].*")) {
                System.out.println(ANSI_RED + "Le nom contient des caractères interdits, échec de la sauvegarde." + ANSI_RESET);

            }
            else if (!nomFichier.endsWith(".txt")) {
                nomFichier += ".txt";
                sauvegardePartie(nomFichier);
                System.out.println(ANSI_GREEN + "Partie sauvegardée dans le fichier " + nomFichier + ANSI_RESET);
            }
        }
        
    }

    /**
     * Affiche les choix disponibles et exécute une action pour le tour courant.
     */

    public void tourDeJeu() {
        System.out.println(ANSI_GREEN + "Nouveau tour de jeu !");
        afficheWorld();
        System.out.println("Que voulez-vous faire ?");
        System.out.println(" - Se battre (b)");
        System.out.println(" - Se déplacer (d)");
        System.out.println(" - Afficher l'inventaire (i)");
        System.out.println(" - Utiliser un objet de l'inventaire (u)");
        System.out.println(" - Afficher la légende de la carte (l)");
        System.out.println(" - Sauvegarder (s)");
        System.out.println(" - Quitter (q)" + ANSI_RESET);

        String choix = sc.next();
        screenReset();
        // System.out.println("Fin du tour !");
        if (choix.equals("d")) {
            action_deplacement();
        } else if (choix.equals("i")) {
            joueur.getInventaire().affiche();
        } else if (choix.equals("s")) {
            action_sauvegarder();
        } else if (choix.equals("b")) {
            action_attaquer();
        } else if (choix.equals("l")) {
            afficheLegende();
        } else if (choix.equals("q")) {
            System.out.println("A bientôt !");
            System.exit(0);
        } else if (choix.equals("u")) {
            action_inventaire();
        } else {
            System.out.println("Choix invalide, veuillez réessayer.");
        }
        tourdeJeu_random();
    }
    /**
     * Effectue le déplacement aléatoire de chaque créature non-joueur.
     */
    public void tourdeJeu_random() {
        Random rd = new Random();
        for (Creature c : creatures) {
            int x = rd.nextInt(9);
            Point2D decalage = new Point2D(x);
            deplacerElementDeJeu(c, decalage, false);
        }

    }
    /**
     * Tente de déplacer un élément et, pour le joueur, ramasse un objet rencontré.
     *
     * @param element élément à déplacer
     * @param decalage décalage à appliquer à sa position
     * @param joueurPrincipal {@code true} si le déplacement est celui du joueur
     * @return {@code true} si le déplacement a été effectué, {@code false} si la
     *         destination est hors carte ou occupée
     */
    public boolean deplacerElementDeJeu(ElementDeJeu element, Point2D decalage, boolean joueurPrincipal) {
        int x = decalage.getX() + element.getPos().getX();
        int y = decalage.getY() + element.getPos().getY();
        Point2D newPos = new Point2D(x, y);

        if (x < 0 || x >= largeur || y < 0 || y >= longueur) {
            return false;
        }

        // ramasser un objet si le joueur se déplace sur une case contenant un objet
        if (joueurPrincipal && carte[x][y] instanceof Inventorable) {
            ((Inventorable) carte[x][y]).setEstDansInventaire(true);
            joueur.getInventaire().ajouterObjet((Inventorable) carte[x][y]);
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
     * Lit le fichier de sauvegarde et place les éléments chargés sur la carte.
     *
     * @param source chemin du fichier à lire
     */
    public void chargementPartie(String source) {
        System.out.println("Chargement de la partie...");
        System.out.println("Fichier source : " + source);

        try {
            String ligne;
            BufferedReader reader = new BufferedReader(new FileReader(source));
            ligne = reader.readLine();
            while (ligne != null) {
                System.out.println("Ligne lue : " + ligne);
                analyseLigneLue(ligne);
                ligne = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        System.out.println("Placement des créatures, objets et du personnage...");
        placerElementsCharges();
        System.out.println("Placement des créatures, objets et du personnage terminé.");

    }
    /**
     * Interprète une ligne de sauvegarde et met à jour l'état du monde.
     *
     * @param ligne ligne à analyser
     * @return {@code true} si la ligne correspond à un type reconnu
     */
    private boolean analyseLigneLue(String ligne) {

        // découpage de la ligne
        StringTokenizer st = new StringTokenizer(ligne, " ");
        List<String> elements = new ArrayList<>();
        while (st.hasMoreTokens()) {
            elements.add(st.nextToken());
        }

        // analyse de la ligne
        if (elements.get(0).equals("Largeur")) {
            largeur = Integer.parseInt(elements.get(1));
            return true;
        }
        if (elements.get(0).equals("Longueur")) {
            longueur = Integer.parseInt(elements.get(1));
            this.carte = new ElementDeJeu[this.largeur][this.longueur];
            this.carte_nuage = new NuageToxique[this.largeur][this.longueur];
            return true;
        }
        if (elements.get(0).equals("Joueur")) {
            Personnage perso;
            Point2D pos = new Point2D(Integer.parseInt(elements.get(10)), Integer.parseInt(elements.get(11)));
            String typePerso = elements.get(2);
            if (typePerso.equalsIgnoreCase("Guerrier")) {
                perso = new Guerrier(elements.get(3), Integer.parseInt(elements.get(4)),
                        Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                        Integer.parseInt(elements.get(7)), Integer.parseInt(elements.get(8)),
                        Integer.parseInt(elements.get(9)), pos);
            } else { // typePerso.equalsIgnoreCase("Archer")
                perso = new Archer(elements.get(3), Integer.parseInt(elements.get(4)),
                        Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                        Integer.parseInt(elements.get(7)), Integer.parseInt(elements.get(8)),
                        Integer.parseInt(elements.get(9)), pos, Integer.parseInt(elements.get(12)));
            }
            ;

            joueur = new Joueur(perso, Integer.parseInt(elements.get(1)));
            return true;
        }

        if (elements.get(0).equals("Inventaire")) {
            if (joueur == null) {
                System.out.println("Erreur : le joueur n'a pas été créé avant l'inventaire.");
                return false;
            } else if (elements.get(1).equals("PotionSoin")) {
                PotionSoin potion = new PotionSoin(Integer.parseInt(elements.get(2)), Integer.parseInt(elements.get(3)),
                        true);
                joueur.getInventaire().ajouterObjet(potion);
            } else if (elements.get(1).equals("Epee")) {
                Epee epee = new Epee(Integer.parseInt(elements.get(2)), Integer.parseInt(elements.get(3)), true);
                joueur.getInventaire().ajouterObjet(epee);
            } else {
                System.out.println("Erreur : type d'objet inconnu dans l'inventaire.");
                return false;
            }
            return true;
        }

        if(elements.get(0).equals("NuageToxique")) {
            int x = Integer.parseInt(elements.get(2));
            int y = Integer.parseInt(elements.get(3));
            NuageToxique nuage = new NuageToxique(Integer.parseInt(elements.get(1)));
            nuage.setPos(new Point2D(x, y));
            carte_nuage[x][y] = nuage;
            return true;
        }

        if (elements.get(0).equals("Epee")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(3)), Integer.parseInt(elements.get(4)));
            Epee epee = new Epee(Integer.parseInt(elements.get(1)), Integer.parseInt(elements.get(2)), pos);
            objets.add(epee);
            return true;
        }
        if (elements.get(0).equals("PotionSoin")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(3)), Integer.parseInt(elements.get(4)));
            PotionSoin potion = new PotionSoin(Integer.parseInt(elements.get(1)), Integer.parseInt(elements.get(2)),
                    pos);
            objets.add(potion);
            return true;
        }

        if (elements.get(0).equals("Guerrier")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(8)), Integer.parseInt(elements.get(9)));
            Guerrier guerrier = new Guerrier(elements.get(1), Integer.parseInt(elements.get(2)),
                    Integer.parseInt(elements.get(3)), Integer.parseInt(elements.get(4)),
                    Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                    Integer.parseInt(elements.get(7)), pos);
            creatures.add(guerrier);
            return true;
        }

        if (elements.get(0).equals("Archer")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(8)), Integer.parseInt(elements.get(9)));
            Archer archer = new Archer(elements.get(1), Integer.parseInt(elements.get(2)),
                    Integer.parseInt(elements.get(3)), Integer.parseInt(elements.get(4)),
                    Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                    Integer.parseInt(elements.get(7)), pos, Integer.parseInt(elements.get(10)));
            creatures.add(archer);
            return true;
        }
        if (elements.get(0).equals("Paysan")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(8)), Integer.parseInt(elements.get(9)));
            Paysan paysan = new Paysan(elements.get(1), Integer.parseInt(elements.get(2)),
                    Integer.parseInt(elements.get(3)), Integer.parseInt(elements.get(4)),
                    Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                    Integer.parseInt(elements.get(7)), pos);
            creatures.add(paysan);
            return true;
        }
        if (elements.get(0).equals("Loup")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(7)), Integer.parseInt(elements.get(8)));
            Loup loup = new Loup(Integer.parseInt(elements.get(2)), Integer.parseInt(elements.get(3)),
                    Integer.parseInt(elements.get(4)),
                    Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                    pos, elements.get(1));
            creatures.add(loup);
            return true;
        }
        if (elements.get(0).equals("Lapin")) {
            Point2D pos = new Point2D(Integer.parseInt(elements.get(7)), Integer.parseInt(elements.get(8)));
            Lapin lapin = new Lapin(Integer.parseInt(elements.get(2)), Integer.parseInt(elements.get(3)),
                    Integer.parseInt(elements.get(4)),
                    Integer.parseInt(elements.get(5)), Integer.parseInt(elements.get(6)),
                    pos, elements.get(1));
            creatures.add(lapin);
            return true;
        }

        return false;
    }
    /**
     * Enregistre la partie dans un fichier dont le nom est horodaté.
     */
    public void sauvegardePartie() {
        String date = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        sauvegardePartie("sauvegarde_" + date+".txt");
    }
    /**
     * Enregistre les dimensions, les entités et l'inventaire dans le fichier indiqué.
     *
     * @param destination chemin du fichier de destination
     */
    public void sauvegardePartie(String destination) {
        // File f = new File(destination);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(destination));

            writer.write("Largeur " + largeur);
            writer.newLine();
            writer.write("Longueur " + longueur);
            writer.newLine();

            for (Creature c : creatures) {
                writer.write(c.info_svg());
                writer.newLine();
            }
            for (Objet o : objets) {
                writer.write(o.info_svg());
                writer.newLine();
            }

            for (int i = 0; i < largeur; i++) {
                for (int j = 0; j < longueur; j++) {
                    if (carte_nuage[i][j] != null) {
                        writer.write(carte_nuage[i][j].info_svg());
                        writer.newLine();
                    }
                }
            }

            writer.write(joueur.info_svg());
            writer.newLine();
            for (Objet o : joueur.getInventaire().getObjets()) {
                writer.write(o.info_svg());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de la partie : " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture du fichier : " + e.getMessage());
            }
        }

        System.out.println("Sauvegarde bien effecutée sous le nom " + destination);

    }
    /**
     * Retourne le joueur de la partie.
     *
     * @return joueur courant
     */
    public Joueur getJoueur() {
        return joueur;
    }
    /**
     * Efface le contenu du terminal à l'aide des séquences de contrôle ANSI.
     */
    public void screenReset() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
