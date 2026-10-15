package org.centrale.objet.WoE;
import java.util.ArrayList;


public class Joueur {

    private String name;
    private Personnage perso;

    public Joueur(String name){
        this.name = name;
    }

    /**
     * Permet de faire avancer le joueur dans une direction donnée
     * @param direction la direction dans laquelle le joueur doit avancer 1=haut, 2=droite, 3=bas, 4=gauche
     */
    public void avancerJoueur(int direction){
        perso.avancer(deltaX(direction), deltaY(direction));
    }

    private int deltaX(int direction){
        if (direction==2){
            return 1;
        }
        if (direction==4){
            return -1;
        }
        return 0;
    }
    
    private int deltaY(int direction){
        if (direction==1){
            return 1;
        }
        if (direction==3){
            return -1;
        }
        return 0;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Personnage getPerso(){
        return this.perso;
    }
    public void setPerso(Personnage perso){
        this.perso = perso;
    }

}
