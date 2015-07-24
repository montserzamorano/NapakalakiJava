package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
import java.util.ArrayList;

public abstract class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death=false;
    private ArrayList<TreasureKind> specificHiddenTreasures=new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures=new ArrayList();

    /***********
     * MÉTODOS *
     ***********/

    //CONSTRUCTOR
    
    /**
     * @brief Constructor por parámetros
     * @param t texto
     * @param l nivel
     * @param nVisible número de tesoros visibles
     * @param nHidden número de tesoros ocultos
     * @param v array de tesoros visibles
     * @param h array de tesoros ocultos
     * @param death indica la consecuencia es la muerte
     */

    public BadConsequence(String t, int l, int nVisible, int nHidden, 
            ArrayList <TreasureKind> v, ArrayList <TreasureKind> h, 
            boolean death){
        this.text = t;
        this.levels = l;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        
        for(TreasureKind treasureV :v){
            this.specificVisibleTreasures.add(treasureV);
        }
        for(TreasureKind treasureH :h){
            this.specificHiddenTreasures.add(treasureH);
        }
        
        this.death = death;
    }

    //Consultores y modificadores

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }
    
    public void setnVisibleTreasures(int nVisible){
        nVisibleTreasures = nVisible;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public void setnHiddenTreasures(int nHidden){
        nHiddenTreasures = nHidden;
    }
    
    /**
     * @brief Devuelve true si el jugador está muerto, false en caso contrario.
     * @return
     */
    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public String getText() {
        return text;
    }

    public String getStringTreasures(ArrayList <TreasureKind> someTreasures){
        String s = "";
        for(TreasureKind t :someTreasures){
            if(t == TreasureKind.ARMOR)
                s += "\t-Armor.\n";
            else if(t == TreasureKind.BOTHHANDS)
                s += "\t-Both hands.\n";
            else if(t == TreasureKind.HELMET)
                s += "\t-Helmet.\n";
            else if(t == TreasureKind.NECKLACE)
                s += "\t-Necklace.\n";
            else if(t == TreasureKind.ONEHAND)
                s += "\t-One hand.\n";
            else if(t == TreasureKind.SHOE)
                s += "\t-Shoe\n";
           }
        return s;
    }

    /**
     *
     * @return cadena con el contenido del objeto
     */
    @Override
    public abstract String toString();

    //OTROS MÉTODOS

    public boolean isEmpty(){
        boolean empty = false;

        if(specificVisibleTreasures.isEmpty() && 
                specificHiddenTreasures.isEmpty() 
                && (nVisibleTreasures == 0) && (nHiddenTreasures == 0))
            empty = true;

        return empty;
    }
    /**
     * @brief Devuelve si el mal rollo es de tipo muerte 
     */

    public boolean kills(){
        return death;
    }
    /**
     * @brief Elimina un tesoro visible del mal rollo
     * @param t Tesoro a eliminar
     */
    public abstract void substractVisibleTreasure(Treasure t);
    
    /**
     * @brief Elimina un tesoro escondido del mal rollo
     * @param t Tesoro a eliminar
     */
    public abstract void substractHiddenTreasure(Treasure t);
    
    /**
     * @param v tesoros visibles de los que dispone el jugador
     * @param h tesoros ocultos de los que dispone el jugador
     * @return  mal rollo creado a partir del objeto mal rollo que ejecuta este método
     */
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList <Treasure>
            v, ArrayList <Treasure> h);
}
