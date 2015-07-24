package Model;

/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */

public class Cultist implements Card{
    private String name; //nombre
    private int gainedLevels; //niveles ganados por cada sectario en juego
    public Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    @Override
    public int getBasicValue(){
        return gainedLevels;
    }
    @Override
    public int getSpecialValue(){
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    
    @Override
    public String toString(){
        return "\nNAME CULTIST: " + name + "\nGained levels: " + 
                Integer.toString(gainedLevels) + "\n";
    }
}
