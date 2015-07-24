package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
import java.util.ArrayList;

public class Monster implements Card{
    private String name;
    private int level;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;
    
     /***********
     * MÉTODOS *
     ***********/
    
    //CONSTRUCTORES
    
    /**
     * @brief Constructor por defecto
     */
    public Monster(){
        name = null;
        level = 0;
        prize = null;
        badConsequence = null;
    }
   
    /**
     * @brief Constructor por parámetros
     * @param n nombre del monstruo
     * @param l nivel
     * @param b maldad
     * @param p premio
     */
    public Monster(String n, int l, BadConsequence b, Prize p){
        this(n, l, b, p, 0);
    }
    /**
     * @brief Constructor para sectarios
     * @param n nombre del monstruo
     * @param l nivel
     * @param b maldad
     * @param p premio
     * @param levelChange incremento/decremento cuando combate con un sectario 
     */
    public Monster(String n, int l, BadConsequence b, Prize p, int levelChange){
        this.name =n;
        this.level = l;
        this.badConsequence = b;
        this.prize = new Prize(p);
        this.levelChangeAgainstCultistPlayer = levelChange;
    }
    /**
     * @brief Constructor de copias
     * @param m objeto a copiar
     */
    public Monster(Monster m){
        this(m.name, m.level, m.badConsequence, m.prize, m.levelChangeAgainstCultistPlayer);
    }
    
    //Consultores
    public String getName() {
        return name;
    }
    
    public int getLevel() {
        return level;
    }
    
    public BadConsequence getBadConsequence() {
        return badConsequence;
    }

    public Prize getPrize() {
        return prize;
    }
    
    /**
     * 
     * @return cadena con el contenido del objeto
     */
    @Override
    public String toString(){
        String ts;
        ts = "NAME: " + name +"\n";
        ts += "LEVEL: " + Integer.toString(level) + "\n";
        ts += "LEVEL CULTIST PLAYER: ";
        ts += Integer.toString(levelChangeAgainstCultistPlayer) + "\n";
        ts += badConsequence.toString() + prize.toString();
        return ts;
    }
    
    @Override
    public int getBasicValue(){
        return getLevel();
    }
    @Override
    public int getSpecialValue(){
        return getLevel() + levelChangeAgainstCultistPlayer;
    }
}
