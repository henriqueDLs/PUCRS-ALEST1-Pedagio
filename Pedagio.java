import java.util.Scanner;

public class Pedagio {
    private static Scanner teclado = new Scanner(System.in);
    private Cabine c1 = new Cabine();
    private Cabine c2 = new Cabine();
    private Cabine c3 = new Cabine();
    private Cabine c4 = new Cabine();
    private Cabine c5 = new Cabine();

    public void iniciarSimulacao(){
        int tempo = 0;
        int totalVeiculos = 0;
        do {
            Veiculo v1 = gerarVeiculo();
            if (v1!=null){totalVeiculos++;v1.setTaxaPedagio(calcularValorRecebido(v1));}
            adicionarVeiculoCabine(v1);
            imprimirStatusCabines();
            System.out.println("Valor total recebido: " + (c1.getValorRecebido()+c2.getValorRecebido()+c3.getValorRecebido()+c4.getValorRecebido()+c5.getValorRecebido()));
            System.out.println("Numero total de veiculos que passaram pelo pedagio: " + totalVeiculos);
            tempo = tempo + 10;
            diminuirTempoCabine();
            aguardarTeclarParaContinuar();
        } while (tempo<300); // Simulacao de cinco minutos
    }

    public void aguardarTeclarParaContinuar(){
        System.out.println("Aperta qualquer tecla para continuar a simulacao: ");
        teclado.nextLine();
    }

    public void diminuirTempoCabine(){
        c1.diminuirTempoAtendimento();
        c2.diminuirTempoAtendimento();
        c3.diminuirTempoAtendimento();
        c4.diminuirTempoAtendimento();
        c5.diminuirTempoAtendimento();
        if(c1.getTempoAtendimento()<=0){if(c1.getInicioFila()!=null){c1.adicionarValorRecebido(c1.getInicioFila().getTaxaPedagio());}c1.removerCarroFila();}
        else if(c2.getTempoAtendimento()<=0){if(c2.getInicioFila()!=null){c2.adicionarValorRecebido(c2.getInicioFila().getTaxaPedagio());}c2.removerCarroFila();}
        else if(c3.getTempoAtendimento()<=0){if(c3.getInicioFila()!=null){c3.adicionarValorRecebido(c3.getInicioFila().getTaxaPedagio());}c3.removerCarroFila();}
        else if(c4.getTempoAtendimento()<=0){if(c4.getInicioFila()!=null){c4.adicionarValorRecebido(c4.getInicioFila().getTaxaPedagio());}c4.removerCarroFila();}
        else if(c5.getTempoAtendimento()<=0){if(c5.getInicioFila()!=null){c5.adicionarValorRecebido(c5.getInicioFila().getTaxaPedagio());}c5.removerCarroFila();}
    }

    public void adicionarVeiculoCabine(Veiculo v1){
        int cabineEscolha = (int) (1 + Math.random()*5);
        int tempoEspera = (int) (10 + Math.random()*61);
        if (cabineEscolha==1){if(v1!=null){c1.adicionarVeiculo(v1); if(c1.getTempoAtendimento()<=0){c1.setTempoAtendimento(tempoEspera);}}}
        else if(cabineEscolha==2){if(v1!=null){c2.adicionarVeiculo(v1); if(c2.getTempoAtendimento()<=0){c2.setTempoAtendimento(tempoEspera);}}}
        else if(cabineEscolha==3){if(v1!=null){c3.adicionarVeiculo(v1); if(c3.getTempoAtendimento()<=0){c3.setTempoAtendimento(tempoEspera);}}}
        else if(cabineEscolha==4){if(v1!=null){c4.adicionarVeiculo(v1); if(c4.getTempoAtendimento()<=0){c4.setTempoAtendimento(tempoEspera);}}}
        else if(cabineEscolha==5){if(v1!=null){c5.adicionarVeiculo(v1); if(c5.getTempoAtendimento()<=0){c5.setTempoAtendimento(tempoEspera);}}}
    }

    public double calcularValorRecebido(Veiculo v1){
        double valorRecebido = 0;
        if(v1 instanceof Moto){valorRecebido = 1.00;}
        else if(v1 instanceof Automovel){valorRecebido = 3.00;}
        else if(v1 instanceof Caminhao){valorRecebido = 10.00;}
        return valorRecebido;
    }

    public Veiculo gerarVeiculo(){
        Veiculo v1 = new Veiculo();
        int veiculoEscolha = (int) (Math.random()*4);
        if(veiculoEscolha==0){v1 = null;}
        else if(veiculoEscolha==1){v1 = new Moto();}
        else if(veiculoEscolha==2){v1 = new Automovel();}
        else if(veiculoEscolha==3){v1 = new Caminhao();}
        return v1;
    }

    public void imprimirStatusCabines(){
        System.out.println("Status das cabines:");
        System.out.println("===================================");
        System.out.println("Cabine 1: ");c1.imprimeFila();
        System.out.println("Cabine 2: ");c2.imprimeFila();
        System.out.println("Cabine 3: ");c3.imprimeFila();
        System.out.println("Cabine 4: ");c4.imprimeFila();
        System.out.println("Cabine 5: ");c5.imprimeFila();
        System.out.println("===================================");
    }
}
