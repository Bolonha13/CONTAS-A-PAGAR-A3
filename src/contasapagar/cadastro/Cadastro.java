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
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite apenas números.");
                valido = false;
            }
        } while (!valido);
        return documento;
    }
    
    // TESTE TEMPORÁRIO - apagar antes do commit
    public static void main(String[] args) {
        Cadastro c = new Cadastro();
        int doc = c.lerDocumento(new ListaContas());
        System.out.println("Documento lido: " + doc);
    }
}