package Principal;

import modelo.ConversorDeMoedas;
import modelo.Menu;


import java.util.Scanner;

public class Main {
    private static final String KEY_API = "437bb082e838a8a65ff087e4";

    public static void main(String[] args) {
        ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas(KEY_API);
        Menu menu = new Menu(conversorDeMoedas);
        int index;
        do {
            menu.exibirMenu();
            index = lerInt();
            menu.escolhaIndex(index);
        } while (index != 0);
    }
    public static int lerInt() {
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Dado inválido...");
            System.out.println("Informe um dado válido:");
            return lerInt();
        }
    }

}