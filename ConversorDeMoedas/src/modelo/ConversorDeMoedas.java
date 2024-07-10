package modelo;

import java.util.Scanner;

public class ConversorDeMoedas {
    private final ConsultaValor consultaValor;

    public ConversorDeMoedas(String key) {
        this.consultaValor = new ConsultaValor(key);
    }
    public void converterMoedas(String moedaOrigem, String moedaDestino) {
        try {
            System.out.println("Digite o valor em " + moedaOrigem + ": ");
            var valor = lerFloat();

            double taxa = consultaValor.getValorCambio(moedaOrigem, moedaDestino);
            double resultado = valor * taxa;
            System.out.println("O valor em" + moedaDestino + ": " + resultado + "\n");
        } catch (Exception e) {
            System.out.println("Erro...: " + e.getMessage());
        }
    }
    public static float lerFloat() {
        Scanner sc = new Scanner(System.in);
        try {
            return Float.parseFloat(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Dado inválido...");
            System.out.println("Informe um dado válido:");
            return lerFloat();
        }
    }
}
