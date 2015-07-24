package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
import java.util.ArrayList;
import java.util.Collections;

public class CardDealer {
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    private static CardDealer instance = null;    

    /***********
     * MÉTODOS *
     ***********/

    //CONSTRUCTOR
    /*se privatiza el constructor para que no se pueda hacer
    un new CardDealer desde otro lugar que no sea dentro de la
    misma clase*/
    private CardDealer(){}

    //PRIVADOS
    /**
     * @brief Inicializa en mazo de cartas de Tesoros (unusedTreasures) con todas
     * las cartas de tesoros proporcionadas en el pdf de cartas de tesoros.
     */
    private void initTreasureCardDeck(){
        unusedTreasures = Cards.initializateTreasures();
        shuffleTreasures();
    }

    /**
     * @brief Inicializa en mazo de cartas de Monstruos (unusedMonsters) con todas
     * las cartas de monstruos proporcionadas en el pdf de cartas de tesoros.
     */
    private void initMonsterCardDeck(){
        unusedMonsters = Cards.initializeMonsters();
        shuffleMonsters();
    }
    /**
     * @brief Inicializa el mazo de cartas de Sectarios
     */    
    private void initCultistCardDeck(){
        unusedCultists = new ArrayList();
        unusedCultists = Cards.initializateCultists();
        shuffleCultists();
    }
    
    /**
     * @brief Baraja el mazo de cartas d tesoros unusedTreasures.
     */
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }

    /**
     * @brief Baraja el mazo de cartas de monstruos unusedMonsters.
     */
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    /**
     * @brief Baraja el mazo de cartas de sectarios unusedCultists
     */
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    //PÚBLICOS

    public static CardDealer getInstance(){
        if(instance == null)
            instance = new CardDealer();
        return instance;
    }
    
    /**
     * @brief Devuelve el siguiente tesoro que hay en el mazo de tesoros y lo elimina
     * de él. Si el mazo está vacío, pasa el mazo de descartes al mazo de tesoros y
     * lo baraja, dejando el mazo de descartes vacío.
     * @return siguiente tesoro
     */
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            unusedTreasures = (ArrayList<Treasure>) usedTreasures.clone();
            usedTreasures.clear();
            shuffleTreasures();
        }
        
        Treasure t = new Treasure();
        t = unusedTreasures.get(0);
        unusedTreasures.remove(0);
        usedTreasures.add(t);
        return t;
    }
    /**
     * @brief Devuelve el siguiente monstruo que hay en el mazo de monstruos y lo
     * elimina de él. Si el mazo está vacío, pasa el mazo de descartes al mazo
     * de tesoros y lo baraja, dejando el mazo de descartes vacío.
     * @return siguiente monstruo
     */
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            unusedMonsters = (ArrayList<Monster>) usedMonsters.clone();
            usedMonsters.clear();
            shuffleMonsters();
        }
        
        Monster m = new Monster();
        m = unusedMonsters.get(0);
        unusedMonsters.remove(0);
        usedMonsters.add(m);
        return m;
    }
    /** 
     * @brief Devuelve el siguiente sectario que hay en el mazo de sectarios y lo
     * elimina de él
     */
    public Cultist nextCultist(){
        Cultist temp;
        if(unusedCultists.isEmpty()){
            return null;
        }
        else{
            temp = unusedCultists.get(0);
            unusedCultists.remove(0);
            return temp;
        }
    }    
    /**
     * @brief Introduce en el mazo de descartes de tesoros (usedTreasures) el
     * tesoro t.
     * @param t tesoro a introducir.
     */
    public void giveTreasureBack(Treasure t){
        unusedTreasures.remove(t);
        usedTreasures.add(t);
    }

    /**
     * @brief Introduce en el mazo de descartes de monstruos (usedMonsters) al
     * monstruo m.
     * @param m
     */
    public void giveMonsterBack(Monster m){
        unusedMonsters.remove(m);
        usedMonsters.add(m);
    }
    public void initCards(){
      initTreasureCardDeck();
      initMonsterCardDeck();
      initCultistCardDeck();
    }
}
