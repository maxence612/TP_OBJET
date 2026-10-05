/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

import java.util.ArrayList;
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
    private List<ElementDeJeu> elements = new ArrayList<>();
    
    
    public World(){
        largeur=8;
        longueur=12;
        carte = new ElementDeJeu[largeur][longueur];
        
        robin = new Archer();
        elements.add(robin);
        guillaumeT = new Archer();
        elements.add(guillaumeT);
        peon = new Paysan();
        elements.add(peon);
        bugs1 = new Lapin(); 
        elements.add(bugs1);
        bugs2 = new Lapin();
        elements.add(bugs2);
        grosBill = new Guerrier();
        elements.add(grosBill);
        wolfie = new Loup();
        elements.add(wolfie);
        
       }
    
    private boolean occupe(Point2D p){
        return carte[p.getX()][p.getY()] != null;
    }
    
    public void creerMondeAlea(){
        Random genRand= new Random();
        int x=genRand.nextInt(this.largeur);
        int y=genRand.nextInt(this.longueur);
        Point2D pt = new Point2D(x,y);
        
        for(int i=0; i<elements.size();i++){
            while(occupe(pt)){
                x=genRand.nextInt(this.largeur);
                y=genRand.nextInt(this.longueur);
                pt = new Point2D(x,y);
            }
            elements.get(i).setPos(pt);
            carte[x][y]=elements.get(i);
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
                   System.out.print(" + "); 
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
    
    public void creerPersoAlea(){
        Random rd = new Random();
        int nombre_race;
        int nombre_perso = rd.nextInt(100);
        for (int i=0;i<nombre_perso;i++){
          nombre_race = rd.nextInt(4);
        if (nombre_race==0){
            elements.add(new Guerrier());   
        }
        if (nombre_race==1){
            elements.add(new Paysan());  
            
        }
       if (nombre_race==2){
            elements.add(new Archer());   
        }
        if (nombre_race==3){
            elements.add(new Loup());   
        }
        if (nombre_race==4){
            elements.add(new Lapin());   
        }
        }
        
        
    }
}


