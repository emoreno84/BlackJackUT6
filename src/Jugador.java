public class Jugador {
    private String nombre;
    private int dinero;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.dinero = 100;
    }

    public String getNombre() {
        return nombre;
    }


    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}
