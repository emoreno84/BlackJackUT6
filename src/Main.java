import java.util.*;
import java.util.random.RandomGenerator;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

    private static BlackJack blackJack;

    public static void main(String[] args) {
        System.out.println("Bienvenido al BlackJack 21");
        System.out.println("Para empezar, indique los nombres de los jugadores");
        boolean respuesta;
        List<String> listadoNombres = new ArrayList<>();
        do{
            System.out.println("Jugador " + (listadoNombres.size() + 1) + ":");
            listadoNombres.add(teclado.next());
            System.out.println("¿Más jugadores? s/N");
            if (teclado.next().equalsIgnoreCase("s")){
                respuesta = true;
            }
            else {
                respuesta = false;
            }
        }while (respuesta);

        blackJack = new BlackJack(getMapaJugadores(listadoNombres), getMapaJugadoresPuntuacion(listadoNombres));

    }

    /*
    Cada jugador (el parámetro) pedirá una carta, y se calculará su puntación, si esta sigue
    menor o igual a 21, se le da la opción de seguir o plantarse.
     */
    private static void turnoJugador(Jugador jugador){
        System.out.println("Turno de " + jugador.getNombre());
        System.out.println("¿Quiere otra carta? s/N");
        List<Carta> listadoCartas = blackJack.getManos().get(jugador);
        while(teclado.next().equalsIgnoreCase("s") && blackJack.calcularPuntuacion(listadoCartas) < 21){
            Carta carta = blackJack.getBaraja().repartirCarta();
            listadoCartas.add(carta);
            blackJack.getManos().put(jugador, listadoCartas);
            Map.Entry<Jugador, List<Carta>> entrada = Map.entry(jugador, listadoCartas);
            blackJack.mostrarMano(entrada);
            System.out.println("¿Quiere otra carta? s/N");
        }
    }

    /*
    Turno del crupier
     */
    private static void turnoCrupier(){
        while (blackJack.calcularPuntuacion(blackJack.getCrupier()) < 17){
            blackJack.getCrupier().add(blackJack.getBaraja().repartirCarta());
            Jugador crupierJug = new Jugador("Crupier");
            blackJack.mostrarMano(Map.entry(crupierJug, blackJack.getCrupier()));
            teclado.next();
        }
    }

    /*
    Calcula los resultados y devuelve el jugador que gana, si gana el crupier
    devuelve null.
     */
    private static Jugador calcularResultados(){
        int puntuacionGanadora = 0;
        Jugador jugadorGanador = null;
        for (Jugador jugador : blackJack.getApuestas().keySet()){
            if (blackJack.getApuestas().get(jugador) > puntuacionGanadora && blackJack.getApuestas().get(jugador) <= 21){
                puntuacionGanadora = blackJack.getApuestas().get(jugador);
                jugadorGanador = jugador;
            }
        }
        int puntuacionCrupier = blackJack.calcularPuntuacion(blackJack.getCrupier());
        if (jugadorGanador != null && puntuacionGanadora > puntuacionCrupier){
            return jugadorGanador;
        }
        return null;
    }

    private static Map<Jugador, List<Carta>> getMapaJugadores(List<String> listadoNombres){
        Map<Jugador, List<Carta>> mapaJugadores = new HashMap<>();
        Jugador jugadorAux;
        for (String nombre : listadoNombres){
            jugadorAux = new Jugador(nombre);
            mapaJugadores.put(jugadorAux, new ArrayList<>());
        }
        return mapaJugadores;
    }

    private static Map<Jugador, Integer> getMapaJugadoresPuntuacion(List<String> listadoNombres){
        Map<Jugador, Integer> mapaJugadoresPuntuacion = new HashMap<>();
        Jugador jugadorAux;
        for (String nombre : listadoNombres){
            jugadorAux = new Jugador(nombre);
            mapaJugadoresPuntuacion.put(jugadorAux, 0);
        }
        return mapaJugadoresPuntuacion;
    }


}