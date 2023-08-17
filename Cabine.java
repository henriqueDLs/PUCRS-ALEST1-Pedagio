public class Cabine {
    private Fila f1 = new Fila();
    private double valorRecebido;
    private int tempoAtendimento;

    public void adicionarVeiculo(Veiculo v1){
        f1.adicionarNaFila(v1);
    }

    public void imprimeFila() {
        f1.imprimir();
    }

    public void removerCarroFila(){
        f1.removerDaFila();
    }

    public Veiculo getInicioFila(){
        Veiculo v1 = f1.getInicio();
        return v1;
    }

    public void adicionarValorRecebido(double valor){
        this.valorRecebido += valor;
    }

    public double getValorRecebido(){
        return valorRecebido;
    }

    public void setTempoAtendimento(int tempoAtendimento){this.tempoAtendimento = tempoAtendimento;}

    public void diminuirTempoAtendimento(){this.tempoAtendimento -= 10;}

    public int getTempoAtendimento(){return tempoAtendimento;}
}
