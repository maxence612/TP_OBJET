package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class PotionSoin extends Objet{
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
        this.pvSoigne=0;
    }

    public Integer getPvSoigne() {
        return pvSoigne;
    }

    public void setPvSoigne(Integer pVsoigne) {
        this.pvSoigne = pVsoigne;
    }
    
    
}

