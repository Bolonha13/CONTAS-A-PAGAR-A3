package contasapagar.cadastro;

import javax.swing.JOptionPane;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;

public class Exclusao {

    public void excluir(ListaContas lista) { // Exclui uma conta pelo documento, pedindo confirmação antes
        int nova;

        do {
            String texto = JOptionPane.showInputDialog("Informe o número do documento:");

            if (texto == null) {
                return;
            }

            try {
                int documento = Integer.parseInt(texto.trim());
                Conta conta = lista.consultar(documento);

                if (conta == null) {
                    JOptionPane.showMessageDialog(null, "Documento não cadastrado");
                } else {
                    int confirma = JOptionPane.showConfirmDialog(null,
                            "EXCLUSÃO DE CONTA\n\n"
                            + "Documento: " + conta.getDocumento() + "\n"
                            + "Descrição: " + conta.getDescricao() + "\n"
                            + "Beneficiário: " + conta.getBeneficiario() + "\n"
                            + "Valor: " + String.format("%.2f", conta.getValor()) + "\n"
                            + "Vencimento: " + conta.getDataVencimento() + "\n\n"
                            + "Confirma a exclusão?",
                            "Exclusão", JOptionPane.YES_NO_OPTION);

                    if (confirma == JOptionPane.YES_OPTION) {
                        lista.excluir(documento);
                        JOptionPane.showMessageDialog(null, "Conta excluída com sucesso.");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Documento inválido. Digite apenas números.");
            }

            nova = JOptionPane.showConfirmDialog(null, "Nova exclusão?", "Exclusão",
                    JOptionPane.YES_NO_OPTION);

        } while (nova == JOptionPane.YES_OPTION);
    }
}