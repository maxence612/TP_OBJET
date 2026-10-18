package org.centrale.objet.WoE;

/**
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class PotionSoin extends Inventorable{
     /**
     * Quantité de point de vie soigné
     */
    private Integer pvSoigne;

    public PotionSoin(Integer pVsoigne) {
        super();
        this.pvSoigne = pVsoigne;
    }

    public PotionSoin(Integer pVsoigne, Integer durabilite, boolean estDansInventaire) {
        super(durabilite, estDansInventaire);
        this.pvSoigne = pVsoigne;
    }

    public PotionSoin(Integer pVsoigne, Integer durabilite, Point2D pos) {
        super(durabilite, false);
        this.pvSoigne = pVsoigne;
        this.setPos(pos);
    }

    public PotionSoin() {
        this(40);
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
        System.out.println("La potion a été utilisée, la créature a maintenant " + c.getPtVie() + " points de vie");
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("La potion est vide");
        }
    }

    public String info_svg() {
        if(this.getEstDansInventaire()){
            return("Inventaire PotionSoin " + this.getPvSoigne() + " " + this.getDurabilite() );
        }
        else{
            return("PotionSoin " + this.getPvSoigne() + " " + this.getDurabilite() + " " + this.getPos().getX() + " " + this.getPos().getY());
        }
    }
}

