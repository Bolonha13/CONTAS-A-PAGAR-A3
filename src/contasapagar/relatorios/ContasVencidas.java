package contasapagar.relatorios;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;
import javax.swing.JOptionPane;

public class ContasVencidas {

    public void contasVencidasPorPeriodo(ListaContas lista) {

        String dataInicial = JOptionPane.showInputDialog("Informe a data inicial (dd/mm/aaaa):");

        String dataFinal = JOptionPane.showInputDialog("Informe a data final (dd/mm/aaaa):");
        int inicio = converterData(dataInicial);
        int fim = converterData(dataFinal);
        String dataAtual = JOptionPane.showInputDialog("Informe a data atual (dd/mm/aaaa):");

        int hoje = converterData(dataAtual);

        Conta[] contasVencidas = new Conta[lista.getQuantidade()];

        int quantidadeVencidas = 0;

        for (int i = 0; i < lista.getQuantidade(); i++) {

            Conta conta = lista.getConta(i);

            int vencimento = converterData(conta.getDataVencimento());

            if (vencimento >= inicio && vencimento <= fim
                    && vencimento < hoje && conta.getValor() > 0) {

                contasVencidas[quantidadeVencidas] = conta;
                quantidadeVencidas++;
            }
        }
        for (int i = 0; i < quantidadeVencidas - 1; i++) {

            for (int j = i + 1; j < quantidadeVencidas; j++) {

                int data1 = converterData(contasVencidas[i].getDataVencimento());
                int data2 = converterData(contasVencidas[j].getDataVencimento());

                if (data1 > data2) {
                    Conta auxiliar = contasVencidas[i];
                    contasVencidas[i] = contasVencidas[j];
                    contasVencidas[j] = auxiliar;
                }
            }
        }
    }

    private int converterData(String data) {

        String[] partes = data.split("/");

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        return ano * 10000 + mes * 100 + dia;
    }
}
