/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Scanner;

/**
 *
 * @author maxence schwerer et corentin godard 
 */
public class TestPoint2D {
        public static void main(String[] args) {
    
        
         Scanner sc;
        System.out.println("Entrez un entier");        
        sc = new Scanner(System.in);
        int x = sc.nextInt();
          
        System.out.println("Entrez un entier");        
        sc = new Scanner(System.in);
        int y = sc.nextInt();
            
        Point2D monPoint2D;
        monPoint2D = new Point2D();    
        monPoint2D.setPosition(x,y);
        monPoint2D.affiche();
         
             

            }
}
