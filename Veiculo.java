public class Veiculo {
    private String placa;
    private double taxaPedagio;

    public Veiculo(){
        this.placa = gerarPlacaAleatoria();
    }

    public String getPlaca(){
        return placa;
    }

    public String gerarLetras() {
        String letras = "";
        int n = 'Z' - 'A' + 1;
        for (int i = 0; i < 3; i++) {
            char c = (char) ('A' + Math.random() * n);
            letras += c;
        }
        return letras;
    }

    public String gerarNumeros() {
        String numeros = "";
        int n = '9' - '0' + 1;
        for (int i = 0; i < 4; i++) {
            char c = (char) ('0' + Math.random() * n);
            numeros += c;
        }
        return numeros;
    }

    public String gerarPlacaAleatoria() {
        String placaVeiculo;
        String letras;
        letras = gerarLetras();
        String numeros = gerarNumeros();
        placaVeiculo = letras + numeros;
        return placaVeiculo;
    }

    public double getTaxaPedagio() {
        return taxaPedagio;
    }

    public void setTaxaPedagio(double taxaPedagio) {
        this.taxaPedagio = taxaPedagio;
    }
}
