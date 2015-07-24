package Model;
import java.util.ArrayList;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */

public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        this.myCultistCard = c; //apunta a lo mismo--->¿peligro?
        totalCultistPlayers++;
    }
    //redefinición del método getCombatLevel
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
    //redefinición del método shouldConvert
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    //redefinición del método getOponenteLevel
    @Override
    protected int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    //redefinición del método computeGoldCoinsValue
    /**
     * @brief Se redefine en CultistPlayer de manera que las piezas de oro dupliquen
     * su valor a la hora de canjearlas por niveles.
     * @param t tesoros a canjear
     * @return número de niveles que se pueden comprar
     */
    @Override
    protected float computeGoldCoinsValue(ArrayList <Treasure> t){
        return super.computeGoldCoinsValue(t)*2;
    }

    /**
     * @return número total de sectarios
     */
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
      
    @Override
    public String toString(){
        return getName() + "(sectario)" + "\n   Level: " + Integer.toString(getLevel()) + 
                "\n   Combat Level: " + Integer.toString(getCombatLevel()) + "\n";
    }
}
