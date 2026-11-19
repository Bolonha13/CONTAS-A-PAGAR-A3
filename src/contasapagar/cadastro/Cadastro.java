package contasapagar.cadastro;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;
import java.util.Scanner;

public class Cadastro {

    private Scanner teclado = new Scanner(System.in);

    private int lerDocumento(ListaContas lista) {
        int documento = 0;
        boolean valido;
        do {
            valido = true;

            System.out.print("DOCUMENTO : ");
            String texto = teclado.nextLine();
            try {
                documento = Integer.parseInt(texto);
                if (documento <= 0) {
                    System.out.println("Erro: o documento deve ser maior que zero.");
                    valido = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite apenas números.");
                valido = false;
            }
        } while (!valido);
        return documento;
    }
}