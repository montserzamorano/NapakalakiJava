package Model;

import java.util.ArrayList;
import java.util.Arrays;
import GUI.*;

/**
 *
 * @author Montse R. Zamorano
 */

public class Main {
    public static void main(String[] args){
        ArrayList <String> names = new ArrayList();    
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        PlayerNamesCapture namesCapture=new PlayerNamesCapture(napakalakiView,true);
        
        names = namesCapture.getNames();
        Dice.createInstance(napakalakiView);
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
    }
}
