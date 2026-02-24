import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlackJack {
    private Baraja baraja;
    private Map<Jugador, List<Carta>> manos;
    private Map<Jugador, Integer> apuestas;
    private List<Carta> crupier;

    public BlackJack(Map<Jugador, List<Carta>> manos, Map<Jugador, Integer> apuestas){
        this.manos = manos;
        this.apuestas = apuestas;
        baraja = new Baraja();
        crupier = new ArrayList<>();
    }

    public int calcularPuntuacion(List<Carta> mano){
        int puntuacion = 0;
        int numAses = 0;
        for (Carta carta : mano){
            puntuacion += carta.getPuntos();
            if (carta.getValor().equals("As")){
                numAses++;
            }
        }
        while (puntuacion > 21 && numAses > 0){
            puntuacion -= 10;
            numAses--;
        }
        return puntuacion;
    }

    public void mostrarMano(Map.Entry<Jugador, List<Carta>> entry){
        System.out.println("Cartas de " + entry.getKey().getNombre());
        for (Carta carta : entry.getValue()){
            System.out.print(carta.toString());
        }
    }

    public void jugar(){
        crupier.add(baraja.repartirCarta());
        int puntuacionAux;
        for (Jugador jugador : manos.keySet()){
            manos.get(jugador).add(baraja.repartirCarta());
            manos.get(jugador).add(baraja.repartirCarta());
            puntuacionAux = calcularPuntuacion(manos.get(jugador));
            apuestas.put(jugador, puntuacionAux);
        }
    }

}
