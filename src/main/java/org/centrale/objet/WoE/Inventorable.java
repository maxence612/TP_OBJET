package org.centrale.objet.WoE;

public abstract class Inventorable extends Objet  {

    private boolean estDansInventaire = false;



    public abstract void utiliser(Creature c);

    public Inventorable(Integer durabilite, boolean estDansInventaire) {
        super(durabilite);
        this.estDansInventaire = estDansInventaire;
    }

    public Inventorable() {
        super();
    }

    public boolean getEstDansInventaire() {
        return estDansInventaire;
    }

    public void setEstDansInventaire(boolean estDansInventaire) {
        this.estDansInventaire = estDansInventaire;
    }


    
}
