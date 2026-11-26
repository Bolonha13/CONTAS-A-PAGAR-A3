package contasapagar.cadastro;

import contasapagar.estrutura.ListaContas;
import contasapagar.modelo.Conta;
import javax.swing.JOptionPane;

public class Cadastro {

    private int lerDocumento(ListaContas lista) {
        int documento = 0;
        boolean valido;
        do {
            valido = true;

            String texto = JOptionPane.showInputDialog("Informe o documento");
            if (texto == null) {
                return 0;
            }
            try {
                documento = Integer.parseInt(texto);
                if (documento <= 0) {
                    JOptionPane.showMessageDialog(null, "Erro: o documento deve ser maior que zero.");
                    valido = false;
                } else if (lista.consultar(documento) != null) {
                    JOptionPane.showMessageDialog(null, "Erro: documento já cadastrado.");
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: digite apenas números.");
                valido = false;
            }
        } while (!valido);
        return documento;
    }

    private String lerTexto(String pergunta) {
        String texto;
        boolean valido;
        do {
            valido = true;
            texto = JOptionPane.showInputDialog(pergunta);
            if (texto == null) {
                return null;
            }
            if (texto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: este campo não pode ficar vazio.");
                valido = false;
            }
        } while (!valido);
        return texto.trim();
    }
}