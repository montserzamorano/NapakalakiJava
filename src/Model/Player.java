package Model;


/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
import java.util.ArrayList;

public class Player {
    private static int LEVELVALUE=1000;//cada nivel se puede comprar con 1000 piezas
    private boolean dead = true;
    private String name;
    private int level;
    private static final int MAXHIDDENTREASURES = 4; //Constante
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence;
    

    /***********
     * MÉTODOS *
     ***********/

    //CONSTRUCTORES
    /**
     * @brief Constructor por defecto
     */
    public Player(){
        this.dead = true;
        this.name = "";
        this.level = 0;
        this.visibleTreasures = new ArrayList();
        this.hiddenTreasures = new ArrayList();
        //this.pendingBadConsequence = new BadConsequence();
    }
    /**
     * @brief Constructor por parámetros
     * @param n nombre del jugador
     * @param l nivel
     * @param v tesoros visibles
     * @param h tesoros ocultos
     */
    /*public Player(String n, ArrayList <Treasure> v, ArrayList<Treasure> h, BadConsequence pending){
        this.dead = false;
        this.name = n;
        this.level = 1;
        this.visibleTreasures = new ArrayList();
        visibleTreasures = (ArrayList<Treasure>) v.clone();
        this.hiddenTreasures = new ArrayList();
        hiddenTreasures = (ArrayList<Treasure>) h.clone();
        if(null != pending)
            this.pendingBadConsequence = new BadConsequence(pending);
        else
            this.pendingBadConsequence = null;

    }*/
    /**
     * @brief Crea un jugador para iniciar el juego con un determinado nombre
     * @param n nombre del jugador
     */
    public Player(String n){
        this.name = n;
        this.level = 1;
    }
    /**
     * @brief Constructor de copia
     * @param p objeto a copiar
     */
    public Player(Player p){
       this.dead = p.dead;
       this.name = p.name;
       this.level = p.level;
       this.visibleTreasures = new ArrayList();
       visibleTreasures = (ArrayList<Treasure>) p.getVisibleTreasures().clone();
       this.hiddenTreasures = new ArrayList();
       hiddenTreasures = (ArrayList<Treasure>) p.getHiddenTreasures().clone();
       //this.pendingBadConsequence = new BadConsequence(p.pendingBadConsequence);
       this.pendingBadConsequence = p.pendingBadConsequence;
    }

    //PRIVADOS
    /**
     * @brief Devuelve la vida al jugador, modificando el atributo
     * correspondiente.
     */
    private void bringToLive(){
        dead = false;
    }

    /**
     * @brief Incrementa el nivel del jugador en i nivles, teniendo en cuenta
     * las reglas del juego.
     * @param i niveles a incrementar
     */
    private void incrementLevels(int i){
        level += i;
    }

    /**
     * @brief Decrementa el nivel del jugador en i nivles, teniendo en cuenta
     * las reglas del juego.
     * @param i niveles a decrementar
     */
    private void decrementLevels(int i){
        if((level-i) >= 1)
            level -= i;
        else{
            level = 1;
        }
    }

    /**
     * @brief Asigna el mal rollo al jugador, dándole valor al atributo
     * pendingBadConsequence.
     * @param b
     */
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    /**
     * @brief cuando el jugador muere en un combate, esta operación es la encargada
     * de dejarlo sin tesoros, ponerle el nivel a 1 e indicar que está muerto, en
     * el atributo correspondiente.
     */
    private void die(){
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        for(Treasure treasure :visibleTreasures){
            dealer.giveTreasureBack(treasure);
        }
        visibleTreasures.clear();
        for(Treasure treasure :hiddenTreasures){
            dealer.giveTreasureBack(treasure);
        }
        hiddenTreasures.clear();
        dead = true;
        level = 1;
    }
    private void discardNecklaceIfVisible(){
        boolean encontrado = false;
        for(int i=0; i<visibleTreasures.size() && !encontrado; i++){
            if(visibleTreasures.get(i).getType() == TreasureKind.NECKLACE){
                //entregar carta al cardDealer
                CardDealer dealer;
                dealer = CardDealer.getInstance();
                dealer.giveTreasureBack(visibleTreasures.get(i));
                //eliminarla de las cartas visibles
                visibleTreasures.remove(visibleTreasures.get(i));
                encontrado = true; //para salir del bucle
            }
        }
    }
    /**
     * @brief Cambia el estado de jugador a muerto si no tiene ni tesoros
     * visibles ni ocultos, modificando el correspondiente atributo.
     */
    private void dieIfNoTreasures(){
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }

    /**
     * @param i niveles que compra
     * @return valor booleano: true si con los niveles que compra no gana la partida y
     * false en caso contrario.
     */
    private boolean canIBuyLevels(int i){
        int newLevels = level + i;
        return newLevels<10;
    }

    //PROTEGIDOS
    protected float computeGoldCoinsValue(ArrayList <Treasure> t){
      float value = 0;
      for(Treasure v :t){
          value += v.getGoldCoins();
      }
      return value/LEVELVALUE;
    }

    //PÚBLICOS
    /**
     * @brief Cuando el jugador gana el combate, esta operación es la encargada de
     * aplicar el buen rollo al jugador, sumando los niveles correspondientes y
     * robando los tesoros indicados en el buen rollo del monstruo.
     * @param p tesoro a aplicar
     */
    public void applyPrize(Prize p){
        int nLevels = p.getLevels();
        incrementLevels(nLevels);
        int nPrize = p.getTreasures();
        Treasure treasure;
        //llamar al carDealer
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        for(int i=0; i<nPrize; i++){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    public CombatResult combat(Monster m){
        CombatResult combat;
        int myLevel = getCombatLevel();
        int levelMonster = getOponentLevel(m);
        if(myLevel>levelMonster){
            Prize prize;
            prize = new Prize(m.getPrize());
            applyPrize(prize);
            if(level == 10)
                combat = CombatResult.WINANDWINGAME;
            else
                combat = CombatResult.WIN;
        }
        else{
            Dice dice;
            dice = Dice.getInstance();
            int escape = dice.nextNumber();
            if(escape < 5){
                BadConsequence bad;
                //bad = new BadConsequence(m.getBadConsequence());
                bad = m.getBadConsequence();
                if(bad.kills()){
                    die();
                    combat = CombatResult.LOSEANDDIE;
                }
                else{
                    applyBadConsequence(bad);
                    //if(isDead())
                    //    combat = CombatResult.LOSEANDDIE;
                    //else{
                        if(shouldConvert()){
                            combat = CombatResult.LOSEANDCONVERT;
                        }
                        else{
                            combat = CombatResult.LOSE;
                        }
                    //}
                }
                
            }
            else{//escape 5 o 6
                combat = CombatResult.LOSEANDESCAPE;
            }
        }
        discardNecklaceIfVisible();
        return combat;
    }
    public void applyBadConsequence(BadConsequence bad){
            int nLevels = bad.getLevels();
            decrementLevels(nLevels);

            BadConsequence pendingBad;
            pendingBad = bad.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
            setPendingBadConsequence(pendingBad);
    }
    public boolean canMakeTreasureVisible(Treasure t){
        boolean posible = true;
        int numManos=0;
        for(int i=0; i<visibleTreasures.size() && posible; i++){
            if(t.getType() == TreasureKind.NECKLACE){
                if(visibleTreasures.get(i).getType() == TreasureKind.NECKLACE){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.HELMET){
                if(visibleTreasures.get(i).getType() == TreasureKind.HELMET){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.ARMOR){
                if(visibleTreasures.get(i).getType() == TreasureKind.ARMOR){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.SHOE){
                if(visibleTreasures.get(i).getType() == TreasureKind.SHOE){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.BOTHHANDS){
                if(visibleTreasures.get(i).getType() == TreasureKind.ONEHAND ||
                       visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS){
                    posible = false;
                }
            }
            if(t.getType() == TreasureKind.ONEHAND){
                if(visibleTreasures.get(i).getType() == TreasureKind.ONEHAND){
                    numManos++;
                    if(numManos >=2){
                        posible = false;
                    }
                }
                if(visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS){
                    posible = false;
                }
            }
        }
        return posible;
    }
    public boolean makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
        return canMakeTreasureVisible(t);
    }
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
        dieIfNoTreasures();
    }
    public boolean buyLevels(ArrayList <Treasure> visible, ArrayList <Treasure> hidden){
        float levels = computeGoldCoinsValue(visible);
        levels += computeGoldCoinsValue(hidden);
        boolean canI = canIBuyLevels((int) levels);
        if(canI){
            incrementLevels((int) levels);
            for(Treasure t :visible){
                discardVisibleTreasure(t);
            }
            for(Treasure t :hidden){
                discardHiddenTreasure(t);
            }
        }
        return canI;
    }

    /**
     * @brief Devuelve true cuando el jugador no tiene ningún mal rollo que
     * cumplir y no tiene más de 4 tesoros ocultos y false en caso contrario.
     * @return true si el estado es válido y false en caso contrario.
     */
    public boolean validState(){
        boolean valid = (((pendingBadConsequence ==null) ||
                pendingBadConsequence.isEmpty())) &&
                (hiddenTreasures.size() <= 4);

        return valid;
    }
    public void initTreasures(){
        bringToLive();
        //lanzar el dado y llamar al cardDealer
        Dice dice;
        dice = Dice.getInstance();
        int number = dice.nextNumber();
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        
        if(number == 1){
            Treasure treasure;
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        else if(number == 6){
            Treasure treasure;
            for(int i=0; i<3; i++){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
        else{
            Treasure treasure;
            for(int i=0; i<2; i++){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }  
        }
    }

    /**
     * @return true cuando el jugador tiene algún tesoro visible y  false en
     * caso contrario.
     */
    public boolean hasVisibleTreasures(){
        boolean has;
        has = visibleTreasures.size() > 0;
        return has;
    }

    //Consultores
    /**
     * @return true si el jugador está muerto, false en caso contrario.
     */
    public boolean isDead(){
        return dead;
    }
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    /**
     * @brief Devuelve el nivel de combate del jugador, que viene dado por su
     * nivel más los bonus que le proporcionan los tesoros que tenga equipados,
     * según las reglas del juego.
     * @return Nivel de combate
     */
    public int getCombatLevel(){
       boolean neck = false;
       int total = 0;
       for(int i=0; i<visibleTreasures.size() && !neck; i++){
           if(visibleTreasures.get(i).getType() == TreasureKind.NECKLACE)
               neck = true;
       }
       for(Treasure c :visibleTreasures){
           if(neck){
               total += c.getMaxBonus();
           }
           else{
               total += c.getMinBonus();
           }
       }
       total += level;
       return total;
    }
    public ArrayList <Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    public ArrayList <Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    /**
     *
     * @return Estado del jugador
     */
    @Override
    public String toString(){
        return name + "\n   Level: " + Integer.toString(level) + 
                "\n   Combat Level: " + Integer.toString(getCombatLevel());
    }
    
    public BadConsequence getBC(){
        return pendingBadConsequence;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getBasicValue();
    }
    protected boolean shouldConvert(){
        Dice dice;
        dice = Dice.getInstance();
        return dice.nextNumber() == 6;
    }
    
    //Modificadores
    public void setVisibleTreasures(ArrayList<Treasure> v){
        for(Treasure t: v)
            visibleTreasures.add(t);
    }
    
    public void setHiddenTreasures(ArrayList<Treasure> h){
        for(Treasure t: h)
            hiddenTreasures.add(t);
    }
}
