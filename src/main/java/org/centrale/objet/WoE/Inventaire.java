package org.centrale.objet.WoE;
import java.util.List;
import java.util.ArrayList;


public class Inventaire {
    private List<Objet> objets;
    private int capaciteMax;

    public Inventaire(List<Objet> objets, int capaciteMax) {
        this.objets = objets;
        this.capaciteMax = capaciteMax;
    }

    public Inventaire(int capaciteMax) {
        this.objets = new ArrayList<>();
        this.capaciteMax = capaciteMax;
    }

    public boolean ajouterObjet(Objet objet) {
        if (objets.size() < capaciteMax) {
            objets.add(objet);
            return true;
        } else {
            System.out.println("Inventaire plein !");
            return false;
        }
    }

    public void affiche() {
        System.out.println("# # # # # # # # # # # # #");
        System.out.println("Inventaire :");
        System.out.println("Remplis : " + objets.size() + "/" + capaciteMax);
        for (Objet objet : objets) {
            System.out.println("- - - - - - - - - - - - -");
            objet.afficheDetails();
            
        }
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("# # # # # # # # # # # # #");
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public List<Objet> getObjets() {
        return objets;
    }
}
