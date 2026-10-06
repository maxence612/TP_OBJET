/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author conco
 */
public class World {
    public Archer robin ;
    public Archer guillaumeT;
    public Paysan peon;
    public Lapin bugs1;
    public Lapin bugs2;
    public Guerrier grosBill;
    public Loup wolfie;
    
    private int largeur;
    private int longueur;
    private ElementDeJeu[][] carte;
    private List<Creature> creatures;
    
    
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
    
    public void tourDeJeu(){
        System.out.println("Nouveau tour de jeu !");
        
        System.out.println("Fin du tour !");
    }
    
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
    
    public void deplacement(){
        robin.affiche();
        guillaumeT.affiche();
        robin.deplace();
        robin.affiche();
        guillaumeT.affiche();
        guillaumeT.deplace();
        robin.affiche();
        guillaumeT.affiche();
    }
    
    public int peuplage(){
        Random genRand= new Random();
        int cmb =genRand.nextInt(10);
        return cmb;
    }
    
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
}