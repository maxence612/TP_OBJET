package org.centrale.objet.WoE;

public abstract class Inventorable extends Objet  {

    private boolean estDansInventaire = false;



    public abstract void utiliser(Creature c);

    public boolean getEstDansInventaire() {
        return estDansInventaire;
    }

    public void setEstDansInventaire(boolean estDansInventaire) {
        this.estDansInventaire = estDansInventaire;
    }


    
}
