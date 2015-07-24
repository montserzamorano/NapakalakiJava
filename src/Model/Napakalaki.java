package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */
import java.util.ArrayList;

public class Napakalaki {
    private static Napakalaki instance = null;
    private Monster currentMonster = null;
    private Player currentPlayer = null;
    private ArrayList<Player> players;
    private static final int MAX = 3; //constante para decidir número de jugadores
    private int currentPlayerIndex;
    /***********
     * MÉTODOS *
     ***********/
    
    //CONSTRUCTOR 
    /*se privatiza el constructor para que no se pueda hacer
    un new Napakalaki desde otro lugar que no sea dentro de la
    misma clase*/
    private Napakalaki(){
        players = new ArrayList();
        currentPlayerIndex = -1;
    }    
    /**
     * @brief Inicializa el array de jugadores.
     * @param names array de String que contiene el nombre de los jugadores
     * @pre El tamaño del array no puede ser mayor que el número máximo de jugadores.
     */
    public void initPlayers(ArrayList<String> names){
        if(names.size() > MAX)
            System.out.println("Demasiados jugadores");
        else{
            for (String name : names) {
                Player p;
                p = new Player(name);
                players.add(p);
            }
        }
    }
    /**
     * @return Siguiente jugador
     */
    private Player nextPlayer(){
        if(currentPlayerIndex == -1){ //se trata del primer turno
            currentPlayerIndex = new Double(Math.random() *players.size()).intValue();
        }
        else{
            if(currentPlayerIndex == players.size() - 1){ //si es el último jugador de la ronda, vuelve al primero
                currentPlayerIndex = 0;
            }
            else{ //en otro caso, avanzamos uno
                currentPlayerIndex += 1;
            }
        }
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }
    
    //PÚBLICOS
    public static Napakalaki getInstance(){
        if(instance == null)
            instance = new Napakalaki();
        return instance;
    }
    /**
     * @brief Se encarga de inicializar el juego
     * @param players nombres de los jugadores
     */
    public void initGame(ArrayList <String> players){
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        dealer.initCards();
        initPlayers(players);
        nextTurn();
    }
    public CombatResult combat(){
        CombatResult comb = currentPlayer.combat(currentMonster);
        CardDealer dealer;
        dealer = CardDealer.getInstance();
        if(comb == CombatResult.LOSEANDCONVERT){
            Cultist c = dealer.nextCultist();
            CultistPlayer cP= new CultistPlayer(currentPlayer,c);
            players.set(currentPlayerIndex, cP);
            currentPlayer = cP;
        }
        dealer.giveMonsterBack(currentMonster);
        return comb;
    }
    public void discardVisibleTreasure(Treasure t){
        currentPlayer.discardVisibleTreasure(t);
    }
    public void discardHiddenTreasure(Treasure t){
        currentPlayer.discardHiddenTreasure(t);
    }
    public boolean makeTreasureVisible(Treasure t){
        return currentPlayer.makeTreasureVisible(t);
    }
    public boolean nextTurn(){
        boolean stateOK;
        stateOK = nextTurnAllowed();

        CardDealer dealer;
        dealer = CardDealer.getInstance();
        
        if(stateOK){
            currentPlayer = nextPlayer();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
            currentMonster = dealer.nextMonster();
        }
        
        return stateOK;
    }
    /**
     * @brief Comprueba si el jugador activo cumple con las reglas del juego para
     * poder terminar su turno.
     * @return false si el jugador activo no puede pasar de turno y true en
     * caso contrario
     */
    public boolean nextTurnAllowed(){
        //caso primer turno
        if(currentPlayer==null){
            return true;
        }
        else{
            return currentPlayer.validState();
        }
    }
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        return currentPlayer.canMakeTreasureVisible(t);
    }
    
    //Consultores

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
    
}