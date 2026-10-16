package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class PotionSoin extends Objet implements Inventorable{
     /**
     * Quantité de point de vie soigné
     */
    private Integer pvSoigne;

    public PotionSoin(Integer pVsoigne) {
        super();
        this.pvSoigne = pVsoigne;
    }

    public PotionSoin() {
        super();
        this.pvSoigne=40;
    }

    public Integer getPvSoigne() {
        return pvSoigne;
    }

    public void setPvSoigne(Integer pVsoigne) {
        this.pvSoigne = pVsoigne;
    }
    
    public void aff_lettre(){
        System.out.print(" H ");
    }

    public void afficheDetails(){
        System.out.println("Potion de soin : ");
        System.out.println("Points de vie soignés : " + this.pvSoigne);
        System.out.println("Durabilité : " + this.getDurabilite());
    }

    public void utiliser(Creature c){
        c.setPtVie(c.getPtVie()+this.pvSoigne);
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("La potion est vide");
        }
    }
}

