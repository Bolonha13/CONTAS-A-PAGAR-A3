package contasapagar.baixa;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;
import javax.swing.JOptionPane;

public class Baixa {

    public void realizarBaixa(ListaContas lista) {
        String novaBaixa;

        do {
            String texto = JOptionPane.showInputDialog("Informe o documento:");

            if (texto == null) {
                return;
            }

            int documento = Integer.parseInt(texto);

            Conta conta = lista.consultar(documento);

            if (conta == null) {
                JOptionPane.showMessageDialog(null, "Conta nao encontrada.");

            } else if (conta.getValor() <= 0) {
                JOptionPane.showMessageDialog(null, "Conta ja quitada.");

            } else {
                int doc = conta.getDocumento();
                String descricao = conta.getDescricao();
                String beneficiario = conta.getBeneficiario();
                double valor = conta.getValor();

                JOptionPane.showMessageDialog(null, "Documento: " + doc);
                JOptionPane.showMessageDialog(null, "Descricao: " + descricao);
                JOptionPane.showMessageDialog(null, "Beneficiario: " + beneficiario);
                JOptionPane.showMessageDialog(null, "Valor atual: R$ " + valor);
                String pagamento = JOptionPane.showInputDialog("Informe o valor do pagamento:");

                if (pagamento == null) {
                    return;
                }

                double valorPago = Double.parseDouble(pagamento);
                while (valorPago <= 0 || valorPago > valor) {

                    JOptionPane.showMessageDialog(null, "Valor de pagamento invalido.");

                    pagamento = JOptionPane.showInputDialog("Informe novamente o valor:");

                    if (pagamento == null) {
                        return;
                    }

                    valorPago = Double.parseDouble(pagamento);
                }
                double valorFinal = valor - valorPago;

                JOptionPane.showMessageDialog(null, "Valor final: R$ " + valorFinal);
                String confirma = JOptionPane.showInputDialog("Confirma baixa? (S/N)");
                while (confirma != null && !"S".equalsIgnoreCase(confirma) && !"N".equalsIgnoreCase(confirma)) {
                    JOptionPane.showMessageDialog(null, "Resposta invalida.");
                    confirma = JOptionPane.showInputDialog("Digite S ou N:");
                }
                if ("S".equalsIgnoreCase(confirma)) {
                    conta.setValor(valorFinal);
                    JOptionPane.showMessageDialog(null, "Baixa realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Baixa cancelada.");

                }

            }
            novaBaixa = JOptionPane.showInputDialog("Deseja realizar outra baixa? (S/N)");

            while (novaBaixa != null && !"S".equalsIgnoreCase(novaBaixa) && !"N".equalsIgnoreCase(novaBaixa)) {
                JOptionPane.showMessageDialog(null, "Resposta invalida.");
                novaBaixa = JOptionPane.showInputDialog("Digite S ou N:");
            }

        } while ("S".equalsIgnoreCase(novaBaixa));
    }
}
