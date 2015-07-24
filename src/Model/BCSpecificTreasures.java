package Model;

import java.util.ArrayList;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
public class BCSpecificTreasures extends BadConsequence {
    public BCSpecificTreasures(String t, int l, ArrayList <TreasureKind> v, 
            ArrayList <TreasureKind> h){
        //super(t, l,nVisible, nHidden, v, h, death);
        super(t, l, 0, 0, v, h, false);
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList <Treasure>
            v, ArrayList <Treasure> h){
        BadConsequence bc;
        
        ArrayList <TreasureKind> visible = new ArrayList();
        ArrayList <TreasureKind> hidden = new ArrayList();
        
        //TESOROS VISIBLES ESPECÍFICOS
        int contOneHand = 0;
        boolean both = false;
        //comprobamos si hay oneHand || bothHands en el array de tesoros
        for(int i=0; i<v.size() && !both && contOneHand < 2; i++){
            if(v.get(i).getType() == TreasureKind.ONEHAND)
                contOneHand++;
            if(v.get(i).getType() == TreasureKind.BOTHHANDS)
                both = true;
        }
        for(TreasureKind vis :this.getSpecificVisibleTreasures()){
            //comprobamos si es tesoro de manos

            if(vis == TreasureKind.ONEHAND && contOneHand != 0){
                visible.add(vis);
                contOneHand--;
            }
            else if(vis == TreasureKind.BOTHHANDS){
                if(both)
                visible.add(vis);
            }
           //si contiene el elemento
            else{
                for(Treasure t :v){
                    if(t.getType() == vis){
                        visible.add(vis);
                    }
                }
            }
        }
        
        //TESOROS OCULTOS ESPECÍFICOS
        contOneHand = 0;
        both = false;
        //comprobamos si hay oneHand || bothHands en el array de tesoros
        for(int i=0; i<h.size() && !both && contOneHand < 2; i++){
            if(h.get(i).getType() == TreasureKind.ONEHAND)
                contOneHand++;
            if(h.get(i).getType() == TreasureKind.BOTHHANDS)
                   both = true;
        }
        for(TreasureKind hid :this.getSpecificHiddenTreasures()){
            //comprobamos si es tesoro de manos

            if(hid == TreasureKind.ONEHAND && contOneHand != 0){
                hidden.add(hid);
                contOneHand--;
            }
            else if(hid == TreasureKind.BOTHHANDS){
                if(both)
                    hidden.add(hid);
            }
            //si contiene el elemento
            else{
                for(Treasure t :h){
                    if(t.getType() == hid){
                        hidden.add(hid);
                    }
                }
            }
        }
        bc = new BCSpecificTreasures(this.getText(), this.getLevels(), visible, 
                hidden);
        return bc;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(!getSpecificVisibleTreasures().isEmpty()){
            getSpecificVisibleTreasures().remove(t.getType());
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(!getSpecificHiddenTreasures().isEmpty()){
            getSpecificHiddenTreasures().remove(t.getType());
        }
    }
    
    @Override
    public String toString(){
        String ts;
        ts = "\n Esto es un mal rollo con el siguiente contenido: \n";
        ts += "  " + getText() + "\n"; //añadimos el texto
        ts += "  *Levels: " + Integer.toString(getLevels()) + "\n"; //añadimos los nivele
        
        //imprimir array de tesoros
        ts += "  *Visible treasures: \n";
        if(!getSpecificVisibleTreasures().isEmpty())
            ts += getStringTreasures(getSpecificVisibleTreasures());
        ts += "  *Hidden treasures: \n";
        if(!getSpecificHiddenTreasures().isEmpty())
            ts += getStringTreasures(getSpecificHiddenTreasures());

        return ts;
    }
}
