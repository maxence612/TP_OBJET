package org.centrale.objet.WoE;




/**
 * Définit le comportement d'un élément capable d'attaquer une créature.
 */
public interface Combattant {
    /**
     * Attaque la créature indiquée.
     *
     * @param c créature visée
     */
    public void combattre(Creature c);
}
