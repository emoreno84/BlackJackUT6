import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baraja {

    private final String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
    private final String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final int[] puntos = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    private List<Carta> baraja;

    public Baraja(){
        baraja = new ArrayList<>();
        inicializarBaraja();
    }

    public void inicializarBaraja(){
        baraja.clear();
        Carta cartaAux;
        for (String palo : palos){
            for (int i = 0; i < valores.length; i++){
                cartaAux = new Carta(palo, valores[i], puntos[i]);
                baraja.add(cartaAux);
            }
        }
        Collections.shuffle(baraja);
    }

    public Carta repartirCarta(){
        //Carta cartaAux = baraja.get(baraja.size() - 1);
        Carta cartaAux1 = baraja.getLast();
        baraja.removeLast();
        return cartaAux1;
    }

}
