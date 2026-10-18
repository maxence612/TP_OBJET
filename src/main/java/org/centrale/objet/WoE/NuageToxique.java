package org.centrale.objet.WoE;

import java.util.Random;

public class NuageToxique extends Objet implements Combattant,Deplacable{
    public NuageToxique() {
        super();
    }

    public void combattre(Creature c) {
        c.setPtVie(c.getPtVie()-10);
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("Le nuage toxique s'est dissipé");
        }
    }

    public void aff_lettre(){
    
    }
    
    public void afficheDetails(){
        System.out.println("Nuage toxique : ");
        System.out.println("Durabilité : " + this.getDurabilite());
    }

     
    public void deplacerAlea(){
        Random rd = new Random();
        int delta_x = rd.nextInt(3) - 1;
        int delta_y = rd.nextInt(3) - 1;
        this.getPos().setX(this.getPos().getX() + delta_x);
        this.getPos().setY(this.getPos().getY() + delta_y);
    }

    public void utiliser(Creature c) {
        System.out.println("Vous ne pouvez pas utiliser le nuage toxique !");
    }
    public String info_svg() {
        return("");
    }
}
