package Model;

import java.util.ArrayList;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
public class BCNumberOfTreasures extends BadConsequence{
    public BCNumberOfTreasures(String t, int l, int nVisible, int nHidden){
        //super(t, l,nVisible, nHidden, v, h, death);
        super(t, l, nVisible, nHidden, new ArrayList(), new ArrayList(), false);
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList <Treasure>
            v, ArrayList <Treasure> h){
        BadConsequence bc;
        
        int minV = 0;
        int minH = 0;
        
        //TESOROS VISIBLES NO ESPECÍFICOS
        if(v.size() < this.getnVisibleTreasures()){
            minV = v.size();
        }
        else{
            minV = this.getnVisibleTreasures();
        }
        
        //TESOROS OCULTOS NO ESPECÍFICOS
        if(h.size() < this.getnHiddenTreasures()){
            minH = h.size();
        }
        else{
            minH = this.getnHiddenTreasures();
        }
           
        bc = new BCNumberOfTreasures(this.getText(), this.getLevels(), minV, minH);
        
        return bc;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(getnVisibleTreasures() > 0){
            setnVisibleTreasures(getnVisibleTreasures()-1);
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(getnHiddenTreasures() > 0){
            setnHiddenTreasures(getnHiddenTreasures()-1);
        }
    }
    
    @Override
    public String toString(){
        String ts;
        ts = "\n Esto es un mal rollo con el siguiente contenido: \n";
        ts += "  " + getText() + "\n"; //añadimos el texto
        ts += "  *Levels: " + getLevels() + "\n"; //añadimos los niveles  
        ts += "  *Number of visible treasures: " + getnVisibleTreasures() + "\n";   
        ts += "  *Number of hidden treasures: " + getnHiddenTreasures()  + "\n";

        return ts;
    }
}
