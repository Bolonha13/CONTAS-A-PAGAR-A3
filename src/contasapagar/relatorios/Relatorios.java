package contasapagar.relatorios;

import javax.swing.JOptionPane;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;

public class Relatorios {

    public void contasPorPeriodo(ListaContas lista) { //Pede as datas, filtra as contas a pagar do período e mostra em uma janela só

        String dataInicial = pedirData("Digite a data inicial (dd/mm/aaaa):");
        if (dataInicial == null) {
            return; // Usuário cancelou a entrada
        }

        String dataFinal = pedirData("Digite a data final (dd/mm/aaaa):");
        if (dataFinal == null) {
            return; // Usuário cancelou a entrada
        }

        int inicio = converterData(dataInicial);
        int fim = converterData(dataFinal);

        if (inicio > fim) {
            JOptionPane.showMessageDialog(null, "A data inicial não pode ser maior que a data final.");
            return;
        }

        Conta[] contasPeriodo = new Conta[lista.getQuantidade()];
        int quantidadePeriodo = 0;

        for (int i = 0; i < lista.getQuantidade(); i++) { // Só considera contas do período que ainda têm valor para pagar

            Conta conta = lista.getConta(i);
            int vencimento = converterData(conta.getDataVencimento());

            if (vencimento >= inicio && vencimento <= fim && conta.getSaldo() > 0) {
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

        // Monta o texto do relatório para mostrar em uma janela só
        StringBuilder texto = new StringBuilder();
        texto.append("CONTAS A PAGAR POR PERÍODO\n");
        texto.append(dataInicial + " a " + dataFinal + "\n\n");
        texto.append("VENCIMENTO | VALOR | SALDO | DOCUMENTO | DESCRIÇÃO | BENEFICIÁRIO\n");
        texto.append("--------------------------------------------------------------\n");

        if (quantidadePeriodo == 0) {
            texto.append("Nenhuma conta a pagar encontrada nesse período.");
        }

        for (int i = 0; i < quantidadePeriodo; i++) {

            Conta conta = contasPeriodo[i];

            texto.append(conta.getDataVencimento() + " | "
                    + String.format("%.2f", conta.getValor()) + " | "
                    + String.format("%.2f", conta.getSaldo()) + " | "
                    + conta.getDocumento() + " | "
                    + conta.getDescricao() + " | "
                    + conta.getBeneficiario() + "\n");
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }

    // Pede uma data até ser válida; devolve null se o usuário cancelar
    private String pedirData(String mensagem) {

        while (true) {
            String texto = JOptionPane.showInputDialog(mensagem);

            if (texto == null) {
                return null;
            }

            texto = texto.trim();

            if (dataValida(texto)) {
                return texto;
            }

            JOptionPane.showMessageDialog(null, "Data inválida. Use o formato dd/mm/aaaa.");
        }
    }

    // Confere se a data está no formato dd/mm/aaaa e com valores possíveis
    private boolean dataValida(String data) {

        String[] partes = data.split("/");

        if (partes.length != 3) {
            return false;
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            return dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1900;
        } catch (NumberFormatException e) {
            return false;
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