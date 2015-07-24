package Model;

/**
 * Clase Cards (visibilidad de paquete). Contiene las cartas que se usarán
 * durante el juego.
 * @author Montse Rodríguez Zamorano
 * @author Mª del Mar Alguacil Camarero
 */

import java.util.ArrayList;
import java.util.Arrays;

class Cards {
    private static final int MAX = 8; //número máximo de tesoros visibles
    private static final int MAXBONUS = 0; //actuar con bonus mayor
   /**
     * @brief Método de inicialización de la lista de monstruos
     * @return Lista de monstruos
     */
    
    public static ArrayList<Monster> initializeMonsters(){
        ArrayList<Monster> monstruos = new ArrayList();
        
        BadConsequence badConsequence;
        Prize prize;
        
        /* 3 byankhees de bonanza */
        badConsequence = new BCSpecificTreasures("Pierdes tu armadura visible y "
                + "otra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        monstruos.add(new Monster("3 byankhees de bonanza", 8 , badConsequence, prize));
        
        /* Chubithulhu */
        badConsequence = new BCSpecificTreasures("Embobados con el lindo primigenio "
                + "te descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Chubithulhu",2, badConsequence, prize));
        
        /*El sopor de Dunwich*/ 
        badConsequence = new BCSpecificTreasures("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich",2, badConsequence, prize));
        
         
        /* Ángeles de la noche ibicenca */
        badConsequence = new BCSpecificTreasures("Te atrapan para llevarte de fiesta "
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible "
                + "y 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, 
                badConsequence, prize));
        
        /* El gorrón en el umbral */
        badConsequence = new BCNumberOfTreasures("Pierdes todos tus tesoros visibles",
                0, MAX, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, 
                prize));
        
        /* H.P. Munchcraft */
        badConsequence = new BCSpecificTreasures("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        /* Bichgooth */
        badConsequence = new BCSpecificTreasures("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bichgooth",2, badConsequence,prize));
        
        /* El rey de la rosa */
        badConsequence = new BCNumberOfTreasures("Pierdes 5 niveles y "
                + "3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /* La que redacta en las tinieblas */
        badConsequence = new BCNumberOfTreasures("Toses los pulmones y pierdes dos "
                + "niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("La que redacta en las tinieblas",2, 
                badConsequence, prize));
        
        /* Los hondos */
        badConsequence = new BCDeath("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente", true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los hondos",8, badConsequence, prize));
        
        /* Semillas Cthulhu */
        badConsequence = new BCNumberOfTreasures("Pierdes 2 niveles y 2 tesoros "
                + "ocultos", 2, 0, 2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        /* Dameargo */
        badConsequence = new BCSpecificTreasures("Te intentas escaquear. Pierdes una "
                + "mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        /* Pollipólipo volante */
        badConsequence = new BCNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles",
                3, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        /* Yskhtihyssg-Goth */
        badConsequence = new BCDeath("No le hace gracia que pronuncien "
                + "mal su nombre. Estas muerto", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        /* Familia feliz */
        badConsequence = new BCDeath("La familia te atrapa. Estas muerto",
                true);
        prize = new Prize(4,1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /* Roboggoth */
        badConsequence = new BCSpecificTreasures("La quinta directiva primaria te "
                + "obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        /* El espia */
        badConsequence = new BCSpecificTreasures("Te asusta en la noche. Pierdes un "
                + "casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espia", 5, badConsequence, prize));
        
        /* El Lenguas */
        badConsequence = new BCNumberOfTreasures("Menudo susto te llevas. Pierdes 2 "
                + "niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El Lenguas" , 20, badConsequence, prize));
        
        /* Bicéfalo */
        badConsequence = new BCSpecificTreasures("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos", 3, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND,
                        TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), 
                new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        //MONSTRUOS CON SECTARIOS
        
        /*El mal indecible impronunciable*/
        
        badConsequence = new BCSpecificTreasures("Pierdes una mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3,1);
        monstruos.add(new Monster("El mal indecible impronunciable",10, badConsequence,prize, -2));
        
        /*Testigos oculares*/
        
        badConsequence = new BCNumberOfTreasures("Pierdes tus tesoros visibles. Jajaja",0,
        MAX, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Testigos oculares",6,badConsequence,prize, 2));
        
        /*El gran cthulhu*/
        
        badConsequence = new BCDeath("Hoy no es tu día de suerte. Mueres",true);
        prize = new Prize(2,5);
        monstruos.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
        
        /*Serpiente político*/
        
        badConsequence = new BCNumberOfTreasures("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Serpiente político",8, badConsequence, prize,-2));
        
        /*Felpuggoth*/
        
        badConsequence = new BCSpecificTreasures("Pierdes tu casco y tu armadura visible. "
        + "Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1,1);
        monstruos.add(new Monster("Felpuggoth",2,badConsequence, prize, 5));
        
        /*Shoggoth*/
        
        badConsequence = new BCNumberOfTreasures("Pierdes dos niveles", 2, 0,0);
        prize = new Prize(4,2);
        monstruos.add(new Monster("Shoggoth", 16, badConsequence, prize,-4));
        
        /*Lolitagooth*/
        
        badConsequence = new BCNumberOfTreasures("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
        
        return monstruos;
    }
    
    /**
     * @brief Inicializa la baraja de cartas de tesoros
     * @return 
     */
    
    public static ArrayList<Treasure> initializateTreasures(){
        ArrayList <Treasure> t;
        t = new ArrayList();
        t.add(new Treasure("¡Sí, mi amo!", 0, 4,7, TreasureKind.HELMET));
        t.add(new Treasure("Botas de investigación", 600, 3,4, TreasureKind.SHOE));
        t.add(new Treasure("Capucha de Cthulhu", 500, 3,5, TreasureKind.HELMET));
        t.add(new Treasure("A prueba de babas", 400, 2,5,TreasureKind.ARMOR));
        t.add(new Treasure("Botas de lluvia ácida", 800, 1,1, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Casco minero", 400, 2,4, TreasureKind.HELMET));
        t.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
        t.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
        t.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
        t.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));
        t.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));
        t.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        t.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        t.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        t.add(new Treasure("La fueza de Mr.T", 1000, MAXBONUS, MAXBONUS, TreasureKind.NECKLACE));
        t.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        t.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        t.add(new Treasure("Necro-playboycón", 300, 3, 5, TreasureKind.ONEHAND));
        t.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
        t.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Linterna a dos manos", 400, 3, 6, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
        t.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        t.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        t.add(new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.ARMOR));
        t.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        t.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
        t.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
        
        return t;
    }
    
    /**
    * @brief Inicializa la baraja de cartas de sectarios 
    */
    public static ArrayList<Cultist> initializateCultists(){
        ArrayList<Cultist> c;
        c = new ArrayList();
        c.add(new Cultist("Sectario",1));
        c.add(new Cultist("Sectario",2));
        c.add(new Cultist("Sectario",1));
        c.add(new Cultist("Sectario",2));
        c.add(new Cultist("Sectario",1));
        c.add(new Cultist("Sectario",1));
        return c;
    }
    
}