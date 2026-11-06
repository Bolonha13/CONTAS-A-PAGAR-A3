package contasapagar.relatorios;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;

public class Relatorios {

    public void contasPorPeriodo(ListaContas lista, String dataInicial, String dataFinal) {

        int inicio = converterData(dataInicial);
        int fim = converterData(dataFinal);

        Conta[] contasPeriodo = new Conta[lista.getQuantidade()];
        int quantidadePeriodo = 0;

        for (int i = 0; i < lista.getQuantidade(); i++) {

            Conta conta = lista.getConta(i);
            int vencimento = converterData(conta.getDataVencimento());

            if (vencimento >= inicio && vencimento <= fim) {
                contasPeriodo[quantidadePeriodo] = conta;
                quantidadePeriodo++;
            }
        }

        // Ordena as contas por data de vencimento
        for (int i = 0; i < quantidadePeriodo - 1; i++) {
            for (int j = i + 1; j < quantidadePeriodo; j++) {

                int data1 = converterData(contasPeriodo[i].getDataVencimento());
                int data2 = converterData(contasPeriodo[j].getDataVencimento());

                if (data1 > data2) {
                    Conta auxiliar = contasPeriodo[i];
                    contasPeriodo[i] = contasPeriodo[j];
                    contasPeriodo[j] = auxiliar;
                }
            }
        }

        System.out.println("RELATÓRIO DE CONTAS POR PERÍODO");

        if (quantidadePeriodo == 0) {
            System.out.println("Nenhuma conta encontrada nesse período.");
        }

        for (int i = 0; i < quantidadePeriodo; i++) {

            Conta conta = contasPeriodo[i];

            System.out.println("Documento: " + conta.getDocumento());
            System.out.println("Descrição: " + conta.getDescricao());
            System.out.println("Beneficiário: " + conta.getBeneficiario());
            System.out.println("Valor: " + conta.getValor());
            System.out.println("Vencimento: " + conta.getDataVencimento());
            System.out.println("----------------");
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