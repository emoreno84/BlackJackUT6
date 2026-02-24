public class Carta {
    private String palo;
    private String valor;
    private int puntos;

    public Carta(String palo, String valor, int puntos) {
        this.palo = palo;
        this.valor = valor;
        this.puntos = puntos;
    }

    public String getPalo() {
        return palo;
    }

    public String getValor() {
        return valor;
    }

    public int getPuntos() {
        return puntos;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(valor + " de " + palo + "\n");
        return str.toString();
    }
}
