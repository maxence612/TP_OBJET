package org.centrale.objet.WoE;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventaire contenant des objets utilisables et limité par une capacité.
 */
public class Inventaire {
    /** Objets actuellement stockés. */
    private List<Inventorable> inventaire;
    /** Nombre maximal d'objets pouvant être stockés. */
    private int capaciteMax;

    /**
     * Crée un inventaire à partir d'une liste et de sa capacité maximale.
     *
     * @param inventaire objets initiaux
     * @param capaciteMax capacité maximale
     */
    public Inventaire(List<Inventorable> inventaire, int capaciteMax) {
        this.inventaire = inventaire;
        this.capaciteMax = capaciteMax;
    }

    /**
     * Crée un inventaire vide de la capacité indiquée.
     *
     * @param capaciteMax capacité maximale
     */
    public Inventaire(int capaciteMax) {
        this.inventaire = new ArrayList<>();
        this.capaciteMax = capaciteMax;
    }

    /**
     * Ajoute un objet si une place est disponible.
     *
     * @param objet objet à ajouter
     * @return {@code true} si l'objet a été ajouté, {@code false} si l'inventaire est plein
     */
    public boolean ajouterObjet(Inventorable objet) {
        if (inventaire.size() < capaciteMax) {
            inventaire.add(objet);
            return true;
        } else {
            System.out.println("Inventaire plein !");
            return false;
        }
    }

    /**
     * Affiche le contenu de l'inventaire et les détails de chacun de ses objets.
     */
    public void affiche() {
        int i = 1;
        System.out.println("# # # # # # # # # # # # #");
        System.out.println("Inventaire :");
        System.out.println("Remplis : " + inventaire.size() + "/" + capaciteMax);
        for (Inventorable objet : inventaire) {
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("Objet " + i + " :");
            i++;
            objet.afficheDetails();
        
        }
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("# # # # # # # # # # # # #");
    }

    /**
     * Retourne la capacité maximale de l'inventaire.
     *
     * @return capacité maximale
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }
    /**
     * Définit la capacité maximale de l'inventaire.
     *
     * @param capaciteMax nouvelle capacité maximale
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    /**
     * Retourne la liste des objets stockés.
     *
     * @return liste interne des objets de l'inventaire
     */
    public List<Inventorable> getObjets() {
        return inventaire;
    }
}
