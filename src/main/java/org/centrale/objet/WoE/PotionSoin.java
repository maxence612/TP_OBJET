package org.centrale.objet.WoE;

/**
 * Objet inventoriable qui restaure des points de vie lorsqu'il est utilisé.
 *
 * @author Maxence SCHWERER et Corentin GODARD
 */
public class PotionSoin extends Inventorable{
    /** Nombre de points de vie restaurés par utilisation. */
    private Integer pvSoigne;

    /**
     * Crée une potion avec la quantité de soin indiquée.
     *
     * @param pVsoigne points de vie restaurés
     */
    public PotionSoin(Integer pVsoigne) {
        super();
        this.pvSoigne = pVsoigne;
    }

    /**
     * Crée une potion avec son état d'inventaire.
     *
     * @param pVsoigne points de vie restaurés
     * @param durabilite durabilité initiale
     * @param estDansInventaire {@code true} si la potion est dans un inventaire
     */
    public PotionSoin(Integer pVsoigne, Integer durabilite, boolean estDansInventaire) {
        super(durabilite, estDansInventaire);
        this.pvSoigne = pVsoigne;
    }

    /**
     * Crée une potion posée à l'emplacement indiqué.
     *
     * @param pVsoigne points de vie restaurés
     * @param durabilite durabilité initiale
     * @param pos position initiale
     */
    public PotionSoin(Integer pVsoigne, Integer durabilite, Point2D pos) {
        super(durabilite, false);
        this.pvSoigne = pVsoigne;
        this.setPos(pos);
    }

    /**
     * Crée une potion restaurant 40 points de vie.
     */
    public PotionSoin() {
        this(40);
    }

    /**
     * Retourne le nombre de points de vie restaurés par la potion.
     *
     * @return quantité de soin
     */
    public Integer getPvSoigne() {
        return pvSoigne;
    }

    /**
     * Définit la quantité de soin de la potion.
     *
     * @param pVsoigne nouveau nombre de points de vie restaurés
     */
    public void setPvSoigne(Integer pVsoigne) {
        this.pvSoigne = pVsoigne;
    }
    
    /**
     * Affiche le symbole de la potion sur la carte.
     */
    public void aff_lettre(){
        System.out.print(" H ");
    }

    /**
     * Affiche les caractéristiques de la potion.
     */
    public void afficheDetails(){
        System.out.println("Potion de soin : ");
        System.out.println("Points de vie soignés : " + this.pvSoigne);
        System.out.println("Durabilité : " + this.getDurabilite());
    }

    /**
     * Restaure les points de vie de la créature et réduit la durabilité.
     *
     * @param c créature soignée
     */
    public void utiliser(Creature c){
        c.setPtVie(c.getPtVie()+this.pvSoigne);
        System.out.println("La potion a été utilisée, la créature a maintenant " + c.getPtVie() + " points de vie");
        setDurabilite(getDurabilite()-1);
        if (getDurabilite()==0){
            System.out.println("La potion est vide");
        }
    }

    /**
     * Retourne les données de la potion au format de sauvegarde du jeu.
     *
     * @return chaîne contenant l'état de la potion et, si nécessaire, sa position
     */
    public String info_svg() {
        if(this.getEstDansInventaire()){
            return("Inventaire PotionSoin " + this.getPvSoigne() + " " + this.getDurabilite() );
        }
        else{
            return("PotionSoin " + this.getPvSoigne() + " " + this.getDurabilite() + " " + this.getPos().getX() + " " + this.getPos().getY());
        }
    }
}
