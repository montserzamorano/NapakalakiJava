package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
public class Treasure implements Card{
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    /***********
     * MÉTODOS *
     ***********/
    
    //CONSTRUCTORES
    
    /**
     * @brief Constructor por defecto
     */
    public Treasure(){
        this.name = null;
        this.goldCoins = 0;
        this.minBonus = 0;
        this.maxBonus = 0;
        this.type = null;
    }
    /**
     * @brief Constructor por parámetros
     * @param n nombre
     * @param g número de monedas de oro
     * @param min puntos sin collar
     * @param max puntos si se usa el collar
     * @param t tipo de tesoro
     */
    public Treasure(String n, int g, int min, int max, TreasureKind t) {
        this.name = n;
        this.goldCoins = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
    }
    
    /**
     * @brief Constructor de copia
     * @param t objeto a copiar
     */
    public Treasure(Treasure t){
//        this.name = t.name;
//        this.goldCoins = t.goldCoins;
//        this.minBonus = t.minBonus;
//        this.maxBonus = t.maxBonus;
//        this.type = t.type;
        this(t.name, t.goldCoins, t.minBonus, t.maxBonus, t.type);
    }
    
    //Consultores
    
    public String getName() {
        return name;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getMinBonus() {
        return minBonus;
    }

    public int getMaxBonus() {
        return maxBonus;
    }

    public TreasureKind getType() {
        return type;
    }
    
    public String getStringType(TreasureKind type){
        if(type == TreasureKind.ARMOR)
            return "Armor";
        else if(type == TreasureKind.BOTHHANDS)
            return "Both hands";
        else if(type == TreasureKind.HELMET)
            return "Helmet";
        else if(type == TreasureKind.NECKLACE)
            return "Necklace";
        else if(type == TreasureKind.ONEHAND)
            return "One hand";
        else if(type == TreasureKind.SHOE)
            return "Shoe";
        else
            return "";
    }
    /**
     * @return cadena con el contenido del objeto
     */
    @Override
    public String toString(){
        String ts;
        ts = "\n Name: " + name + "\n";
        ts += "  Gold coins: " + Integer.toString(goldCoins) + "\n";
        ts += "  Minimum bonus: " + Integer.toString(minBonus)+ "\n";
        ts += "  Maximum bonus: " + Integer.toString(maxBonus) + "\n";
        ts += "  Type: " + getStringType(type)+ "\n";
        return ts;
    }
    
    @Override
    public int getBasicValue(){
        return getMinBonus();
    }
    @Override
    public int getSpecialValue(){
        return getMaxBonus();
    }
}
