package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Représente le joueur, son personnage et son inventaire.
 */
public class Joueur implements Combattant {

    /** Personnage contrôlé par le joueur. */
    private Personnage perso;
    /** Objets transportés par le joueur. */
    private Inventaire inventaire;

    /**
     * Crée un joueur pour une nouvelle partie et génère ses caractéristiques.
     *
     * @param name nom attribué au personnage
     * @param typePerso classe du personnage (« Guerrier » ou « Archer »)
     */
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
     * Crée un joueur à partir d'un personnage déjà initialisé.
     *
     * @param perso personnage chargé
     * @param tailleInventaire capacité maximale de son inventaire
     */
    public Joueur(Personnage perso, int tailleInventaire){
        this.perso = perso;
        this.inventaire = new Inventaire(tailleInventaire);
    }


    /**
     * Retourne le personnage contrôlé par le joueur.
     *
     * @return personnage du joueur
     */
    public Personnage getPerso(){
        return this.perso;
    }
    /**
     * Remplace le personnage contrôlé par le joueur.
     *
     * @param perso nouveau personnage
     */
    public void setPerso(Personnage perso){
        this.perso = perso;
    }

    /**
     * Retourne l'inventaire du joueur.
     *
     * @return inventaire du joueur
     */
    public Inventaire getInventaire(){
        return this.inventaire;
    }

    /**
     * Transmet l'attaque au personnage du joueur.
     *
     * @param c créature visée
     */
    public void combattre(Creature c) {
        if (this.getPerso() instanceof Guerrier) {
            ((Guerrier) this.getPerso()).combattre(c);
        } else if (this.getPerso() instanceof Archer) {
            ((Archer) this.getPerso()).combattre(c);
        }
    
    }
    /**
     * Retourne les données du joueur et de son personnage au format de sauvegarde.
     *
     * @return chaîne contenant la capacité d'inventaire et l'état du personnage
     */
    public String info_svg() {
        return("Joueur " + this.inventaire.getCapaciteMax()+ " " + perso.info_svg() );
    }

     /**
     * Retourne les données du joueur et de son personnage au format de sauvegarde.
     *
     * @return chaîne contenant la capacité d'inventaire et l'état du personnage
     */
    public void estMort() {
        System.out.println("Vous êtes mort, fin de partie ...");
        System.exit(0);
}
}
