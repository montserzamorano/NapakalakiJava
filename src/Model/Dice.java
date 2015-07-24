/**
 *
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */

package Model;

public class Dice {
    private static Dice instance = null;
    
    /***********
     * MÉTODOS *
     ***********/
    
    //CONSTRUCTOR 
    /*se privatiza el constructor para que no se pueda hacer
    un new Dice desde otro lugar que no sea dentro de la
    misma clase*/
    private Dice(){}
    
    //PÚBLICOS
    public static Dice getInstance(){
        if(instance == null)
            instance = new Dice();
        return instance;
    }
    
    /**
     * @brief Genera un número aleatorio entre 1 y 6.
     * @return Número aleatorio generado.
     */
    public int nextNumber(){
        int numAleatorio = (int) (Math.random()*6 + 1);
        //System.out.println("Resultado de tirar el dado: " + Integer.toString(numAleatorio) + "\n");
        return numAleatorio;
    }
}
