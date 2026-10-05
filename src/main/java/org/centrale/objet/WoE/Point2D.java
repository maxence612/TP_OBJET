/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author maxen
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

    public void translate(int dx, int dy){
        x=x+dx;
        y=y+dx;
    }
    
    public void setPosition(int x, int y ){
        this.x=x;
        this.y=y;
               
    }
    
 public float distance(Point2D p){
        return (float) Math.sqrt( Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2) );
    }

    
    public boolean equals(Point2D p){
        return(this.x==p.getX() && this.y==p.getY());       
    }
}
