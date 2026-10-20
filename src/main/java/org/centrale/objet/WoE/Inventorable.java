package org.centrale.objet.WoE;

/**
 * Objet pouvant être ramassé et placé dans l'inventaire d'un joueur.
 */
public abstract class Inventorable extends Objet  {

    /** Indique si l'objet est actuellement stocké dans un inventaire. */
    private boolean estDansInventaire = false;

    /**
     * Utilise l'objet sur une créature.
     *
     * @param c créature sur laquelle appliquer l'objet
     */
    public abstract void utiliser(Creature c);

    /**
     * Crée un objet inventorable avec son état de stockage.
     *
     * @param durabilite durabilité initiale
     * @param estDansInventaire {@code true} si l'objet appartient déjà à un inventaire
     */
    public Inventorable(Integer durabilite, boolean estDansInventaire) {
        super(durabilite);
        this.estDansInventaire = estDansInventaire;
    }

    /**
     * Crée un objet inventoriable avec les valeurs par défaut de sa classe parente.
     */
    public Inventorable() {
        super();
    }

    /**
     * Indique si l'objet se trouve dans un inventaire.
     *
     * @return {@code true} si l'objet est dans un inventaire
     */
    public boolean getEstDansInventaire() {
        return estDansInventaire;
    }

    /**
     * Définit si l'objet se trouve dans un inventaire.
     *
     * @param estDansInventaire nouvel état de stockage
     */
    public void setEstDansInventaire(boolean estDansInventaire) {
        this.estDansInventaire = estDansInventaire;
    }
}
