public class Nodo {
    public Veiculo elemento;
    public Nodo proximo;

    public Nodo (Veiculo e) {
        this.elemento = e;
        proximo = null;
    }

    public Veiculo getElemento(){
        return elemento;
    }
}