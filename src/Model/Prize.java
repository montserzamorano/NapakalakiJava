package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
public class Prize {
    private int treasures;
    private int levels;
    
    /***********
     * MÉTODOS *
     ***********/
    
    //CONSTRUCTORES
    /**
     * @brief Constructor por parámetros
     * @param t número de tesoros
     * @param l número de niveles
     */
    public Prize(int t, int l){
        treasures = t;
        levels = l;
    }
    
    /**
     * @brief Constructor por parámetros, el número de niveles por defecto es 1.
     * @param t número de tesoros
     */
    
    public Prize(int t){
        this(t, 1);
    }
    
    /**
     * @brief Constructor de copia
     * @param p objeto a copiar
     */
    public Prize(Prize p){
//        this.treasures = p.treasures;
//        this.levels = p.levels;
        this(p.treasures, p.levels);
    }
    
    //Consultores

    public int getTreasures() {
        return treasures;
    }

    public int getLevels() {
        return levels;
    }
    
    //Otros métodos
    /**
     * 
     * @return cadena con el contenido del objeto
     */
    @Override
    public String toString(){
        String ts;
        ts = "\nPRIZE:\n";
        ts += "  *Treasures: " + Integer.toString(treasures) + "\n";
        ts += "  *Levels: " + Integer.toString(levels) + "\n";
        return ts;
    }
}
