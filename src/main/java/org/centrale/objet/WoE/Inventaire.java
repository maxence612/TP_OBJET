package org.centrale.objet.WoE;
import java.util.List;
import java.util.ArrayList;


public class Inventaire {
    private List<Inventorable> inventaire;
    private int capaciteMax;

    public Inventaire(List<Inventorable> inventaire, int capaciteMax) {
        this.inventaire = inventaire;
        this.capaciteMax = capaciteMax;
    }

    public Inventaire(int capaciteMax) {
        this.inventaire = new ArrayList<>();
        this.capaciteMax = capaciteMax;
    }

    public boolean ajouterObjet(Inventorable objet) {
        if (inventaire.size() < capaciteMax) {
            inventaire.add(objet);
            return true;
        } else {
            System.out.println("Inventaire plein !");
            return false;
        }
    }

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

    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public List<Inventorable> getObjets() {
        return inventaire;
    }
}
