import java.util.*;

public class Main {
    private static Scanner teclado = new Scanner(System.in);

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

        BlackJack blackJack = new BlackJack(getMapaJugadores(listadoNombres), getMapaJugadoresPuntuacion(listadoNombres));

    }

    /*
    Cada jugador (el parámetro) pedirá una carta, y se calculará su puntación, si esta sigue
    menor o igual a 21, se le da la opción de seguir o plantarse.
     */
    private static void turnoJugador(Jugador jugador){

    }

    /*
    Turno del crupier
     */
    private static void turnoCrupier(){

    }

    /*
    Calcula los resultados y devuelve el jugador que gana, si gana el crupier
    devuelve null.
     */
    private static Jugador calcularResultados(){
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