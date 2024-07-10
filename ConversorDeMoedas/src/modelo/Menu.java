package modelo;

public class Menu {
    private final ConversorDeMoedas conversorDeMoedas;

    public Menu(ConversorDeMoedas conversorDeMoedas) {
        this.conversorDeMoedas = conversorDeMoedas;
    }

    public void exibirMenu() {
        System.out.println("1. BRL -> EUR");
        System.out.println("2. EUR -> USD");
        System.out.println("3. USD -> EUR");
        System.out.println("4. ARS -> BRL");
        System.out.println("5. CNY -> BRL");
        System.out.println("6. BRL -> CNY");
        System.out.println("7. BRL -> USD");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }

    public void escolhaIndex(int opcao) {
        switch (opcao) {
            case 1:
                conversorDeMoedas.converterMoedas("BRL", "EUR");
                break;
            case 2:
                conversorDeMoedas.converterMoedas("EUR", "USD");
                break;
            case 3:
                conversorDeMoedas.converterMoedas("USD", "EUR");
                break;
            case 4:
                conversorDeMoedas.converterMoedas("ARS", "BRL");
                break;
            case 5:
                conversorDeMoedas.converterMoedas("CNY", "BRL");
                break;
            case 6:
                conversorDeMoedas.converterMoedas("BRL", "CNY");
                break;
            case 7:
                conversorDeMoedas.converterMoedas("BRL", "USD");
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
