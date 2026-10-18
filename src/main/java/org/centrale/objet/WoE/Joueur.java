package org.centrale.objet.WoE;
import java.util.ArrayList;
import java.util.Random;


public class Joueur implements Combattant {

    private Personnage perso;
    private Inventaire inventaire;


    public Joueur(String name, String typePerso){
         Random rd = new Random();
        if (typePerso.equalsIgnoreCase("Guerrier")){
            this.perso = new Guerrier();
            perso.setNom(name);            
        }
        else if (typePerso.equalsIgnoreCase("Archer")){
            this.perso = new Archer();
            ((Archer) perso).setNbFleches(rd.nextInt(11));
        }
        perso.setNom(name);
        perso.setPtVie(perso.getPtVie()+rd.nextInt(11)-5);
        perso.setDegAtt(perso.getDegAtt()+rd.nextInt(11)-5);
        perso.setPtPar(perso.getPtPar()+rd.nextInt(11)-5); 

        int temp_pourcentagePar= perso.getPagePar()+rd.nextInt(11)-5;
        if (temp_pourcentagePar<0){
            temp_pourcentagePar=0;
        }
        if(temp_pourcentagePar>100){
            temp_pourcentagePar=100;
        }
        perso.setPagePar(temp_pourcentagePar);

        int temp_pourcentageAtt= perso.getPageAtt()+rd.nextInt(11)-5;
        if (temp_pourcentageAtt<0){
            temp_pourcentageAtt=0;
        }
        if(temp_pourcentageAtt>100){
            temp_pourcentageAtt=100;
        }
        perso.setPageAtt(temp_pourcentageAtt);

        this.inventaire = new Inventaire(10);
    }

    /**
     * Permet de faire avancer le joueur dans une direction donnée
     * @param direction la direction dans laquelle le joueur doit avancer
     */


    public Personnage getPerso(){
        return this.perso;
    }
    public void setPerso(Personnage perso){
        this.perso = perso;
    }

    public Inventaire getInventaire(){
        return this.inventaire;
    }

    public void combattre(Creature c) {
        if (this.getPerso() instanceof Guerrier) {
            ((Guerrier) this.getPerso()).combattre(c);
        } else if (this.getPerso() instanceof Archer) {
            ((Archer) this.getPerso()).combattre(c);
        }
    
    }

}
