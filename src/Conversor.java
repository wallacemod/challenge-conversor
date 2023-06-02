import java.text.DecimalFormat;

interface Moedas {
    double valorReal = 1;
    double valorDolar = 0.199;
    double valorEuro = 0.185;
    double valorLibrasEsterlinas = 0.159;
    double valorPesoArgentino = 47.902;
    double valorPesoChileno = 159.863;

    double converterMoedas(double valor, String nomeBase, String nomeConverter);
}

interface Temperatura {

}

class Conversor implements Moedas {
    public Conversor(){
        System.out.println("Conversor criado");
    }

    public double conseguirValor(String nome){
        double valorBase = 0;
        if(nome == "Real")
            valorBase = valorReal;
        if(nome == "Euro")
            valorBase = valorEuro;
        if(nome == "Dolar")
            valorBase = valorDolar;
        if(nome == "Libras")
            valorBase = valorLibrasEsterlinas;
        if(nome == "Peso Argentino")
            valorBase = valorPesoArgentino;
        if(nome == "Peso Chileno")
            valorBase = valorPesoChileno;
        return valorBase;
    }

    public double converterMoedas(double valor, String nomeBase, String nomeConverter){
        double resultado = ((1/conseguirValor(nomeBase)) * valor) * conseguirValor(nomeConverter);
        System.out.println(resultado);
        return resultado;
    }
}