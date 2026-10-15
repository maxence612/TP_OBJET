/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class Point2D {

    private int x ;
    private int y ;

    public Point2D() {
    }

    public Point2D(Point2D p) {
        this.x = p.x ;
        this.y=p.y ;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(int direction) {
        this.x = deltaX(direction);
        this.y = deltaY(direction);
    }
    
    private int deltaX(int direction){
        if (direction>=2 && direction<=4){
            return 1;
        }
        if (direction>=6 && direction<=8){
            return -1;
        }
        return 0;
    }

    private int deltaY(int direction){
        if (direction==8 || direction==1 || direction==2){
            return -1;
        }
        if (direction>=4 && direction<=6){
            return 1;
        }
        return 0;
    }


    public void affiche(){
        System.out.println("["+x +";"+y+"]");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    
    public void setY(int y) {
        this.y = y;
    }
        /**
    * Translate un Point2D.
    *
     */
    public void translate(int dx, int dy){
        x=x+dx;
        y=y+dx;
    }
    
    public void setPosition(int x, int y ){
        this.x=x;
        this.y=y;
               
    }
         /**
    * Calcule la distance entre deux points 2D.
    *
     */   
 public float distance(Point2D p){
        return (float) Math.sqrt( Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2) );
    }

         /**
    * Indique si deux Point2D sont égaux.
    *
     */   
    public boolean equals(Point2D p){
        return(this.x==p.getX() && this.y==p.getY());       
    }
}
