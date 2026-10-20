package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Obstacle mobile qui inflige des dégâts aux créatures et se dissipe après
 * plusieurs interactions.
 */
public class NuageToxique extends Objet implements Combattant,Deplacable{
    /**
     * Crée un nuage toxique avec la durabilité par défaut.
     */
    public NuageToxique() {
        super();
    }
    /**
     * Crée un nuage toxique avec la durabilité indiquée.
     *
     * @param durabilite durabilité initiale
     */
    public NuageToxique(int durabilite) {
        super(durabilite);
    }

    /**
     * Inflige dix points de dégâts à une créature et diminue la durabilité.
     *
     * @param c créature affectée
     */
    public void combattre(Creature c) {
        c.setPtVie(c.getPtVie()-10);
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("Le nuage toxique s'est dissipé");
        }
    }

    /**
     * Ne dessine aucun symbole pour le nuage toxique.
     */
    public void aff_lettre(){
    
    }
    
    /**
     * Affiche les détails du nuage toxique.
     */
    public void afficheDetails(){
        System.out.println("Nuage toxique : ");
        System.out.println("Durabilité : " + this.getDurabilite());
    }
    /**
     * Déplace le nuage aléatoirement d'au plus une case sur chaque axe.
     */
    public void deplacerAlea(){
        Random rd = new Random();
        int delta_x = rd.nextInt(3) - 1;
        int delta_y = rd.nextInt(3) - 1;
        this.getPos().setX(this.getPos().getX() + delta_x);
        this.getPos().setY(this.getPos().getY() + delta_y);
    }

    /**
     * Signale que le nuage ne peut pas être utilisé comme un objet d'inventaire.
     *
     * @param c créature concernée (non utilisée)
     */
    public void utiliser(Creature c) {
        System.out.println("Vous ne pouvez pas utiliser le nuage toxique !");
    }
    /**
     * Retourne les données du nuage au format de sauvegarde du jeu.
     *
     * @return chaîne contenant la durabilité et la position du nuage
     */
    public String info_svg() {
        return("NuageToxique " + this.getDurabilite() + " " + this.getPos().getX() + " " + this.getPos().getY());
    }
}
