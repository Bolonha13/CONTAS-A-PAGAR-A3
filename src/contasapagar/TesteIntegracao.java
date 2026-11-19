
package contasapagar;

import contasapagar.modelo.Conta;
import contasapagar.estrutura.ListaContas;
import contasapagar.relatorios.Relatorios;

public class TesteIntegracao {

    public static void main(String[] args) {

        ListaContas lista = new ListaContas();

        // Adicionando contas para o teste
        lista.adicionar(new Conta(1001, "Conta de luz", "Empresa A", 150.00, "05/11/2026"));
        lista.adicionar(new Conta(1002, "Conta de água", "Empresa B", 90.00, "10/11/2026"));
        lista.adicionar(new Conta(1003, "Internet", "Empresa C", 120.00, "05/12/2026"));

        // Testando consulta
        System.out.println("=== TESTE DE CONSULTA ===");

        Conta encontrada = lista.consultar(1002);

        if (encontrada != null) {
            System.out.println("Conta encontrada: " + encontrada.getDescricao());
        } else {
            System.out.println("Conta não encontrada.");
        }

        // Testando exclusão
        System.out.println("\n=== TESTE DE EXCLUSÃO ===");

        boolean excluida = lista.excluir(1002);

        System.out.println("Conta excluída? " + excluida);
        System.out.println("Conta ainda existe? " + (lista.consultar(1002) != null));
        System.out.println("Conta ainda inexistente? " + (lista.consultar(9999) == null));
        System.out.println("Exclusão de conta inexistente: " + lista.excluir(9999));

        // Testando relatório
        System.out.println("\n=== TESTE DE RELATÓRIO ===");

        Relatorios relatorios = new Relatorios();

        relatorios.contasPorPeriodo(lista, "01/11/2026", "30/11/2026");

        // Testando relatório vazio
        System.out.println("\n=== TESTE DE RELATÓRIO VAZIO ===");

        relatorios.contasPorPeriodo(lista, "01/01/2027", "31/01/2027");

        // Testando ordenação por data de vencimento
        System.out.println("\n=== TESTE DE ORDENAÇÃO ===");

        ListaContas listaOrdenacao = new ListaContas();

        listaOrdenacao.adicionar(new Conta(2001, "Internet", "Empresa A", 120.00, "15/11/2026"));
        listaOrdenacao.adicionar(new Conta(2002, "Água", "Empresa B", 90.00, "03/11/2026"));
        listaOrdenacao.adicionar(new Conta(2003, "Luz", "Empresa C", 150.00, "10/11/2026"));

        relatorios.contasPorPeriodo(listaOrdenacao, "01/11/2026", "30/11/2026");
    }
}
