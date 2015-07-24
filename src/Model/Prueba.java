package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mar
 */

public class Prueba {
    public static void imprimirArray(ArrayList<Treasure> treasures){
        for(Treasure t: treasures)
            System.out.print(t);
    }
    
    public static void main(String[] args){
        ArrayList<Monster> monstruos = new ArrayList();
        BadConsequence bc, bc1;
        Prize prize;
        
        bc1 = bc = new BCSpecificTreasures("Pierdes 1 mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList());
        
        prize = new Prize(3);
        
        monstruos.add(new Monster("El mal indicible impronunciable", 10, bc, 
                prize, -2));
        
        int a=4;
        bc = new BCNumberOfTreasures("Pierdes todos tus tesoros visibles",1,8,0);
        
        prize = new Prize(4,2);
        
        monstruos.add(new Monster("Wiiiii", 3, bc, prize));
        
//        for(Monster m :monstruos){
//            System.out.print(m.toString());
//        }
        
        ArrayList <Cultist> cultists = new ArrayList(); 
        
        cultists.add(new Cultist("Sectario 1", 2));
        cultists.add(new Cultist("Sectario 2", 3));
        
        //System.out.print("\n\nSECTARIOS:\n");
//        for(Cultist c:cultists){
//            System.out.print(c);
//        }
        
        Player p = new Player("j1");
        
        ArrayList<Treasure> treasures = new ArrayList();
        Treasure x, w;
        treasures.add(x=new Treasure("Tesoro 1", 0, 1, 2, TreasureKind.HELMET));
        treasures.add(w=new Treasure("Tesoro 2", 2, 3, 4, TreasureKind.ONEHAND));
        
        p.setHiddenTreasures(treasures);
        
        CultistPlayer culp = new CultistPlayer(p, cultists.get(0));
        System.out.print(culp.toString());
        
        System.out.print("\nTesoros ocultos: ");
        imprimirArray(culp.getHiddenTreasures());
        
        System.out.print("\n\nTesoros visibles: ");
        imprimirArray(culp.getVisibleTreasures());
        
        System.out.print("\n");
        
        System.out.print("------------------------------------------");
        culp.makeTreasureVisible(x);
        
        System.out.print("\nTesoros ocultos: ");
        imprimirArray(culp.getHiddenTreasures());
        
        System.out.print("\n\nTesoros visibles: ");
        imprimirArray(culp.getVisibleTreasures());
        
        //System.out.print(bc);
        
        //bc = bc.adjustToFitTreasureLists(culp.getVisibleTreasures(), culp.getHiddenTreasures());
        
        //System.out.print(bc);
        //culp.applyBadConsequence(bc);
        
        //System.out.print("\nVALID STATE: " + culp.validState() + "\n");
        
        //culp.discardVisibleTreasure(x);
        
        //System.out.print("\nVALID STATE: " + culp.validState() + "\n");
        
        System.out.print("------------------------------------------");
        culp.makeTreasureVisible(w);
        
        System.out.print("\nTesoros ocultos: ");
        imprimirArray(culp.getHiddenTreasures());
        
        System.out.print("\n\nTesoros visibles: ");
        imprimirArray(culp.getVisibleTreasures());
        
//        System.out.print(bc1);
//        
//        bc1 = bc1.adjustToFitTreasureLists(culp.getVisibleTreasures(), culp.getHiddenTreasures());
//        
//        System.out.print(bc1);
//        culp.applyBadConsequence(bc1);
//        
//        System.out.print("\nVALID STATE: " + culp.validState() + "\n");
//        
//        culp.discardVisibleTreasure(w);
//        
//        System.out.print("\nVALID STATE: " + culp.validState() + "\n");
    }
}
