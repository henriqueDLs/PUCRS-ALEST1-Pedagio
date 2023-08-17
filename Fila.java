public class Fila {

    private Nodo inicio;
    private Nodo fim;
    private int quantidade;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void adicionarNaFila(Veiculo e) {
        Nodo novoElemento = new Nodo(e);

        if(vazia()) {
            this.inicio = novoElemento;
            this.fim = novoElemento;
        }
        else {
            Nodo antigoFim = this.fim;
            antigoFim.proximo = novoElemento;
            this.fim = novoElemento;
        }
        quantidade++;
    }

    public void removerDaFila() {
        if(!vazia()) {
            this.inicio = this.inicio.proximo;
            quantidade--;
        }
    }

    public Veiculo getInicio(){
        if(inicio!=null){return inicio.getElemento();}
        return null;
    }

    public boolean vazia() {
        return this.quantidade==0;
    }

    public void imprimir() {
        String s = "[";
        Nodo nodoAux = this.inicio;
        while(nodoAux!=null) {
            s = s + " " + nodoAux.getElemento().getPlaca() + " ";
            nodoAux = nodoAux.proximo;
        }
        s = s + "]";
        System.out.println(s);
    }

}