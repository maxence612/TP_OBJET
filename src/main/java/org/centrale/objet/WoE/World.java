package org.centrale.objet.WoE;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
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

    public Archer robin ;
    public Archer guillaumeT;
    public Paysan peon;
    public Lapin bugs1;
    public Lapin bugs2;
    public Guerrier grosBill;
    public Loup wolfie;
    public PotionSoin potion1;

    private int largeur;
    private int longueur;
    private ElementDeJeu[][] carte;
    private int[][] carte_nuage; // Tab 1 si nuage toxique, 0 sinon (possible de metre 3,4...)
    private List<Creature> creatures = new ArrayList<>();
    private List<Objet> objets = new ArrayList<>();
    public Joueur joueur;
    public String[] classes = {"Guerrier", "Archer"};
    private Scanner sc = new Scanner(System.in); 
    
    public World(String nomPartie){
        chargementPartie(nomPartie);
               
    }
    public World(int largeur, int longueur){
        this.largeur = largeur;
        this.longueur = longueur;
        this.carte = new ElementDeJeu[largeur][longueur];
        this.carte_nuage = new int[largeur][longueur];
    }
    
    private boolean occupe(Point2D p){
        return carte[p.getX()][p.getY()] != null;
    }
    
    public void creerMondeAlea(){
          
    }
    /**
 *
 * Sert à placer les créatures et les objets générés précédement sur la carte
 */
    public void placerCreaturesEtObjets(){
        Random genRand= new Random();
        int x=genRand.nextInt(this.largeur);
        int y=genRand.nextInt(this.longueur);
        Point2D pt = new Point2D(x,y);
        
        for(int i=0; i<creatures.size();i++){
            while(occupe(pt)){
                x=genRand.nextInt(this.largeur);
                y=genRand.nextInt(this.longueur);
                pt = new Point2D(x,y);
            }
            creatures.get(i).setPos(pt);
            carte[x][y]=creatures.get(i);
        }

        for(int i=0; i<objets.size();i++){
            while(occupe(pt)){
                x=genRand.nextInt(this.largeur);
                y=genRand.nextInt(this.longueur);
                pt = new Point2D(x,y);
            }
            objets.get(i).setPos(pt);
            carte[x][y]=objets.get(i);
        }
        
    }
    
    /**
 *
 * Permet d'afficher le monde dans la console, en affichant les lettres représentant les créatures et les objets sur la carte.
 */
    public void afficheWorld(){
        Point2D pt;
        boolean actuel_nuage=false;
        
        for(int y=0;y<longueur;y++){
           for(int x=0;x<largeur;x++){
               pt = new Point2D(x,y);

               if(carte_nuage[x][y] == 1 && !actuel_nuage){
                    actuel_nuage = true;
                    System.out.print(ANSI_RED);
               }
               else if(carte_nuage[x][y] == 0 && actuel_nuage){
                    actuel_nuage = false;
                    System.out.print(ANSI_RESET);
               }
       
               if(occupe(pt)){
                   carte[x][y].aff_lettre();
               }
               else{
                   System.out.print(" . "); 
               }
               
            } 
           System.out.println();
        }
    }
    /**
 *
 * Permet de déplacer les créatures du monde, en appelant la méthode deplacement() de chaque créature.
 */
    public void deplacement(){
        Point2D pos = new Point2D(1,2);
        Point2D pos2 = new Point2D(2,1);
        robin = new Archer();
        guillaumeT = new Archer();
        guillaumeT.setPos(pos);
        robin.setPos(pos2);
        robin.affiche();
        guillaumeT.affiche();
        System.out.println("Distance entre les deux personnages : " + robin.getPos().distance(guillaumeT.getPos()));
        System.out.println(guillaumeT.getNbFleches());
        guillaumeT.combattre(robin);
        System.out.println(guillaumeT.getNbFleches());
        System.out.println(guillaumeT.getPtVie());
        potion1 = new PotionSoin();
        potion1.utiliser(guillaumeT);
        System.out.println(guillaumeT.getPtVie());
    }
  
    
    
    /**
     *
     * Permet de créer un certain nombre de créatures aléatoires.
     * @param nombre_perso le nombre de créatures à créer
     */
    public void creerCreaturesAlea(int nombre_perso){
        Random rd = new Random();
        int nombre_race;
        for (int i=0;i<nombre_perso;i++){
          nombre_race = rd.nextInt(5);
        if (nombre_race==0){
            creatures.add(new Guerrier());   
        }
        if (nombre_race==1){
            creatures.add(new Paysan());  
        }
       if (nombre_race==2){
            creatures.add(new Archer());   
        }
        if (nombre_race==3){
            creatures.add(new Loup());   
        }
        if (nombre_race==4){
            creatures.add(new Lapin());   
        }
        }
               
        
    }
  
    public void creerObjetsAlea(int nombre_objets){
        Random rd = new Random();
        int nombre_race;
        for (int i=0;i<nombre_objets;i++){
          nombre_race = rd.nextInt(2);
        if (nombre_race==0){
            objets.add(new Epee());   
        }
        if (nombre_race==1){
            objets.add(new PotionSoin());  
        }
        
        }
               
        
    }

    /**
 *
 * Création du joueur au début de la partie
 */
   public void creation_Joueur(){
    System.out.println("Entrez le nom du joueur :");
    String nom = sc.next();
    System.out.println("Voulez vous jouer un Archer ou un Guerrier");
    String classe = sc.next();
    joueur = new Joueur(nom , classe);
    creatures.add(joueur.getPerso());
   }

/**
 *
 * Tour de jeu du joueur
 */

   public void tourDeJeu(){
        System.out.println("Nouveau tour de jeu !");
        
        System.out.println("Voulez vous battre ou vous déplacer ? (b/d)");
        String choix = sc.next();
        if (choix.equals("d")){
        System.out.println("Ou voulez vous déplacer ? ");
        System.out.println("8 | 1 | 2");
        System.out.println("7 | 0 | 3");
        System.out.println("6 | 5 | 4");


        int direction = Integer.parseInt(sc.next());
        if(! deplacerElementDeJeu(joueur.getPerso(), new Point2D(direction))){
            System.out.println("Déplacement impossible, veuillez réessayer.");
        }
        else{
            System.out.println("Le joueur est maintenant en position : ");
            joueur.getPerso().getPos().affiche();
            System.out.println("Fin du tour !");
        }
    }
    else if (choix.equals("b")){
        System.out.println("Gros Gourmand");
        List<Creature> cibles = new ArrayList<>();
        int rayon = (int) Math.sqrt(joueur.getPerso().getDistAttMax());
        int x = joueur.getPerso().getPos().getX();
        int y = joueur.getPerso().getPos().getY();
    for (int i = x - rayon; i <= x + rayon; i++) {
        for (int j = y - rayon; j <= y + rayon; j++) {
            if (i >= 0 && i < largeur && j >= 0 && j < longueur && !(i == x && j == y) ) {
                if (carte[i][j] instanceof Creature) {
                    cibles.add((Creature) carte[i][j]);
                }
        }
    }
}
        if (cibles.isEmpty()) {
            System.out.println("Aucune créature à portée.");
        }
        else {
            System.out.println("Qui voulez-vous attaquer ?");
            for (int i = 0; i < cibles.size(); i++) {
                Creature c = cibles.get(i);
                System.out.println((i + 1) + " - " + c.getClass().getName()
                        + " (PV : " + c.getPtVie() + ")");
                        
            }
            int ennemi = Integer.parseInt(sc.next());
            if (ennemi == 0) {
                System.out.println("Vous avez choisi de ne pas attaquer.");
            } else if (ennemi > 0 && ennemi <= cibles.size()) {
                Creature cible = cibles.get(ennemi - 1);
                joueur.combattre(cible);
                System.out.println("Vous avez attaqué " + cible.getClass().getName()
                        + " (PV restants : " + cible.getPtVie() + ")");
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");

            }
        }
    }

    else{
        System.out.println("Choix invalide, veuillez réessayer.");
    }
   }

    
   


   public boolean deplacerElementDeJeu(ElementDeJeu element, Point2D decalage) {
        int x = decalage.getX() + element.getPos().getX();
        int y = decalage.getY() + element.getPos().getY();
        Point2D newPos = new Point2D(x, y);

        if (x < 0 || x >= largeur || y < 0 || y >= longueur) {
            return false;
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


    public void chargementPartie(String source){
        File f = new File(source);
        if (! f.exists() || ! f.isFile()) {
            throw new IllegalArgumentException("Le fichier spécifié n'existe pas");
        }
        else{
            largeur=50;
            longueur=50;
            carte = new ElementDeJeu[largeur][longueur];
            carte_nuage = new int[largeur][longueur];   
        }
    }

    public void sauvegardePartie(){
        String date = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        sauvegardePartie("sauvegarde_" + date + ".txt");
    }

    public void sauvegardePartie(String destination){
        File f = new File(destination);
        if (f.exists()) {
            throw new IllegalArgumentException("Le fichier spécifié existe déjà");
        }
        else{
            // Code pour sauvegarder la partie
            //=> On parcours la liste de tous les elments de jeu et on appel leur méthode svg
        }
    }


    public Joueur getJoueur() {
        return joueur;
    }

}
