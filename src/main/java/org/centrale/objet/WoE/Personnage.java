package org.centrale.objet.WoE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Personnage du jeu, caractérisé notamment par une portée d'attaque.
 *
 * @author Corentin GODARD et Maxence SCHWERER
 */
public abstract class Personnage extends Creature{
    /** Distance maximale à laquelle le personnage peut attaquer. */
    private int distAttMax;

    /** Prénoms utilisés par le constructeur sans argument. */
    private static final ArrayList<String> listePrenom =
            new ArrayList<>(Arrays.asList("Ethan", "Mobutu", "Bastian", "Benay","LouisBDA","Maxence"));

    /** Générateur utilisé pour choisir un prénom aléatoire. */
    private static final Random random = new Random();

    /**
     * Sélectionne un prénom dans la liste des prénoms disponibles.
     *
     * @return prénom choisi aléatoirement
     */
    private static String prenomAuHasard() {
        return listePrenom.get(random.nextInt(listePrenom.size()));
    }

    /**
     * Crée un personnage avec un prénom et des caractéristiques par défaut.
     */
    public Personnage() {
        this(prenomAuHasard(),
             100,
             50,
             5,
             70,
             30,
             1,
             new Point2D(-1, -1));
    }
    
    /**
     * Crée un personnage avec les caractéristiques indiquées.
     *
     * @param nom nom du personnage
     * @param ptVie points de vie initiaux
     * @param degAtt dégâts infligés par attaque
     * @param ptPar valeur de parade
     * @param pageAtt pourcentage de réussite d'une attaque
     * @param pagePar pourcentage de réussite d'une parade
     * @param distAttMax portée maximale d'attaque
     * @param pos position initiale
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar,pos, nom);
        this.distAttMax = distAttMax;
    }
    
    /**
     * Crée une copie du personnage indiqué.
     *
     * @param perso personnage à copier
     */
    public Personnage(Personnage perso){
        super(perso);
        this.distAttMax = perso.getDistAttMax();
    }
    /**
     * Retourne la portée maximale d'attaque.
     *
     * @return distance maximale d'attaque
     */
    public int getDistAttMax() {
        return distAttMax;
    }
    /**
     * Définit la portée maximale d'attaque.
     *
     * @param distAttMax nouvelle distance maximale
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Affiche le nom, la position et les points de vie du personnage.
     */
    public void affiche(){
        System.out.println(this.getNom()+" est en "+this.getPos().getX()+";"+this.getPos().getY()+" avec "+this.getPtVie()+" points de vie" );
    }
    
}