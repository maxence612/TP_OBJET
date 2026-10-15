/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class World {
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
    private List<Creature> creatures;
    public Joueur joueur;
    public String[] classes = {"Guerrier", "Archer"};
    
    public World(){
        largeur=50;
        longueur=50;
        carte = new ElementDeJeu[largeur][longueur];
        
       }
    
    private boolean occupe(Point2D p){
        return carte[p.getX()][p.getY()] != null;
    }
    
    public void creerMondeAlea(){
        
        
    }
    /**
 *
 * Sert à placer les créatures du monde sur la carte
 */
    public void placerObjets(){
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
        
    }
    
    /**
 *
 * Permet d'afficher le monde dans la console, en affichant les lettres représentant les créatures et les objets sur la carte.
 */
    public void afficheWorld(){
        Point2D pt;
        
        for(int i=0;i<largeur;i++){
           for(int j=0;j<longueur;j++){
               pt = new Point2D(i,j);
       
               if(occupe(pt)){
                   carte[i][j].aff_lettre();
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
  
    
    public int peuplage(){
        Random genRand= new Random();
        int cmb =genRand.nextInt(10);
        return cmb;
    }
    
    /**
 *
 * Permet de créer un certain nombre de créatures aléatoires, en fonction du nombre passé en paramètre.
 * @param nombre_perso le nombre de créatures à créer
 */
    public void creerPersoAlea(int nombre_perso){
        creatures = new ArrayList<>();
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
    /**
 *
 * Permet de mesurer le temps d'exécution de la méthode total_pdv_taille() et total_pdv_iterateur() pour différents nombres de créatures.
 */
    public void total_pdv_taille(){
        int total_pdv=0;
        for(int i = 0; i< creatures.size(); i++){
            total_pdv += creatures.get(i).getPtVie();
        }
        System.out.println("-----");
        System.out.println(total_pdv);
        System.out.println("-----");
    }
    
    public void total_pdv_iterateur(){
        int total_pdv=0;
        for(Creature c : creatures){
            total_pdv += c.getPtVie();
        }
        System.out.println("-----");
        System.out.println(total_pdv);
        System.out.println("-----");
    }
    
    /**
 *
 * Permet de mesurer le temps d'exécution de la méthode total_pdv_taille() et total_pdv_iterateur() pour différents nombres de créatures.
 */
   public void mesure_temps(){
       System.out.println("===== Avec la taille ====");  
       for(int i= 100; i<=100000;i*=10){
            creerPersoAlea(i);
            long debutN = System.nanoTime();
            
            total_pdv_taille();
            long finN = System.nanoTime();
            System.out.println("Avec "+ i +" elements = en micro seconde : " + (finN-debutN)/1000);  
       }
       System.out.println("============================");  
       System.out.println("===== Avec un itérateur ====");
       for(int i= 100; i<=100000;i*=10){
            creerPersoAlea(i);
            long debutN = System.nanoTime();
            total_pdv_iterateur();
            long finN = System.nanoTime();
            System.out.println("Avec "+ i +" elements = en micro seconde : " + (finN-debutN)/1000);  
       }

   }

    /**
 *
 * Création du joueur au début de la partie
 */
   public void creation_Joueur(){
    System.out.println("Entrez le nom du joueur :");
    Scanner sc = new Scanner(System.in);
    String nom = sc.next();
    System.out.println("Voulez vous jouer un Archer ou un Guerrier");
    String classe = sc.next();
    joueur = new Joueur(nom , classe);
   }

    /**
 *
 * Tour de jeu du joueur
 */

   public void tourDeJeu(){
    System.out.println("Nouveau tour de jeu !");
    System.out.println("Ou voulez vous déplacer ? ");
    System.out.println("8 | 1 | 2");
    System.out.println("7 | 0 | 3");
    System.out.println("6 | 5 | 4");
    Scanner sc = new Scanner(System.in);
    int direction = sc.nextInt();
    joueur.avancerJoueur(direction);
    System.out.println("Le joueur est maintenant en position : (" + joueur.getPerso().getPos().getX() + "," + joueur.getPerso().getPos().getY() + ")");
    System.out.println("Fin du tour !");
   }

    
   
   public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

   public void couleur(){
        System.out.println(ANSI_RED + "Ceci est du texte en rouge." + ANSI_RESET);
        
        System.out.println(ANSI_GREEN + "Ceci est du texte en vert." + ANSI_RESET);
 
   }

}
