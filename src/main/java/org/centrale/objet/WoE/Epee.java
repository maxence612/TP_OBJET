/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public class Epee extends Inventorable{

        /**
     * Durabilité de l'objet
     */
    private Integer degat;
 

  
    public void setDegat(Integer degat) {
        this.degat = degat;
    }

    public Integer getDegat() {
        return degat;
    }

    /**
     *
     * @param degat points de degat de l'arme
     */
    public Epee(Integer degat){
        super();
        this.degat = degat;
        
    
    }

    public Epee() {
        super();
        this.degat=0;
    }

    public void aff_lettre(){
        System.out.print(" E ");
    }

    public void afficheDetails(){
        System.out.println("Épée : ");
        System.out.println("Points de dégât : " + this.degat);
        System.out.println("Durabilité : " + this.getDurabilite());
    }

    public void utiliser(Creature c){
        c.setDegAtt(c.getDegAtt()+this.degat);
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("L'épée est cassée");
        }
    }
    public String info_svg() {
        if(this.getEstDansInventaire()){
            return("Inventaire Epee " + this.getDegat() + " " + this.getDurabilite() );
        }
        else{
            return("Epee " + this.getDegat() + " " + this.getDurabilite() + " " + this.getPos().getX() + " " + this.getPos().getY());
        }
    }
    
    
}


