package contasapagar.baixa;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;
import javax.swing.JOptionPane;

public class Baixa {

    public void realizarBaixa(ListaContas lista) {

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
        }
    }
}