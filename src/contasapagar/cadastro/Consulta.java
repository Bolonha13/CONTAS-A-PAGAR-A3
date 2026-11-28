package contasapagar.cadastro;

import javax.swing.JOptionPane;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;

public class Consulta {

    // Consulta contas pelo número do documento, repetindo enquanto o usuário quiser
    public void consultar(ListaContas lista) {
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
                    JOptionPane.showMessageDialog(null,
                            "CONSULTA DE CONTA\n\n"
                            + "Documento: " + conta.getDocumento() + "\n"
                            + "Descrição: " + conta.getDescricao() + "\n"
                            + "Beneficiário: " + conta.getBeneficiario() + "\n"
                            + "Valor: " + String.format("%.2f", conta.getValor()) + "\n"
                            + "Saldo: " + String.format("%.2f", conta.getSaldo()) + "\n"
                            + "Vencimento: " + conta.getDataVencimento());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Documento inválido. Digite apenas números.");
            }

            nova = JOptionPane.showConfirmDialog(null, "Nova consulta?", "Consulta",
                    JOptionPane.YES_NO_OPTION);

        } while (nova == JOptionPane.YES_OPTION);
    }
}