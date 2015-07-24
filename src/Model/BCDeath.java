package Model;

import java.util.ArrayList;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
public class BCDeath extends BadConsequence{
    public BCDeath(String t, boolean death){
        //super(t, l,nVisible, nHidden, v, h, death);
        super(t, 0, 0, 0, new ArrayList(), new ArrayList(), true);
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList <Treasure>
            v, ArrayList <Treasure> h){
        
        return this;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){}
    
    @Override
    public void substractHiddenTreasure(Treasure t){}
    
    @Override
    public String toString(){
        String ts;
        ts = "\n Esto es un mal rollo con el siguiente contenido: \n";
        ts += "  " + getText() + "\n"; //añadimos el texto
        ts += "  *Levels: " + getLevels() + "\n"; //añadimos los niveles
        
        //imprimir muerte
        ts += "  *Death: You are dead.\n";

        return ts;
    }
}
