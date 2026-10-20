/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Arme inventorable qui augmente les dégâts d'une créature lors de son
 * utilisation.
 *
 * @author Corentin Godard et Maxence Schwerer
 */
public class Epee extends Inventorable{

    /** Dégâts supplémentaires accordés par l'épée. */
    private Integer degat;

    /**
     * Définit les dégâts supplémentaires de l'épée.
     *
     * @param degat nouvelle valeur de dégâts
     */
    public void setDegat(Integer degat) {
        this.degat = degat;
    }

    /**
     * Retourne les dégâts supplémentaires de l'épée.
     *
     * @return dégâts accordés
     */
    public Integer getDegat() {
        return degat;
    }

    /**
     * Crée une épée avec les dégâts indiqués.
     *
     * @param degat dégâts supplémentaires
     */
    public Epee(Integer degat){
        super();
        this.degat = degat;
    }

    /**
     * Crée une épée sans dégâts supplémentaires.
     */
    public Epee() {
        this(5);
    }

    /**
     * Crée une épée avec son état d'inventaire.
     *
     * @param degat dégâts supplémentaires
     * @param durabilite durabilité initiale
     * @param estDansInventaire {@code true} si l'épée est dans un inventaire
     */
    public Epee(Integer degat, Integer durabilite, boolean estDansInventaire) {
        super(durabilite, estDansInventaire);
        this.degat = degat;
    }

    /**
     * Crée une épée posée à l'emplacement indiqué.
     *
     * @param degat dégâts supplémentaires
     * @param durabilite durabilité initiale
     * @param pos position initiale
     */
    public Epee(Integer degat, Integer durabilite, Point2D pos) {
        super(durabilite, false);
        this.degat = degat;
        this.setPos(pos);
    }

    /**
     * Affiche le symbole de l'épée sur la carte.
     */
    public void aff_lettre(){
        System.out.print(" E ");
    }

    /**
     * Affiche les caractéristiques de l'épée.
     */
    public void afficheDetails(){
        System.out.println("Épée : ");
        System.out.println("Points de dégât : " + this.degat);
        System.out.println("Durabilité : " + this.getDurabilite());
    }

    /**
     * Applique les dégâts de l'épée à une créature et réduit sa durabilité.
     *
     * @param c créature équipée de l'épée
     */
    public void utiliser(Creature c){
        c.setDegAtt(c.getDegAtt()+this.degat);
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("L'épée est cassée");
        }
    }
    /**
     * Retourne les données de l'épée au format de sauvegarde du jeu.
     *
     * @return chaîne contenant l'état de l'épée et, si nécessaire, sa position
     */
    public String info_svg() {
        if(this.getEstDansInventaire()){
            return("Inventaire Epee " + this.getDegat() + " " + this.getDurabilite() );
        }
        else{
            return("Epee " + this.getDegat() + " " + this.getDurabilite() + " " + this.getPos().getX() + " " + this.getPos().getY());
        }
    }
}

