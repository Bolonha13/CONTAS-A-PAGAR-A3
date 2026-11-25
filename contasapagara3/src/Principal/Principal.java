
package Principal;

import javax.swing.JOptionPane; 
import Controle.GerenciadorContas;

public class Principal {

    
    public static void main(String[] args) {
        
        GerenciadorContas gerenciador = new GerenciadorContas();

        int opcao;

        do {

            String entrada = JOptionPane.showInputDialog(
                    "===== SISTEMA DE CONTAS A PAGAR =====\n\n"
                    + "1 - Cadastrar conta\n"
                    + "2 - Consultar conta\n"
                    + "3 - Excluir conta\n"
                    + "4 - Dar baixa em conta\n"
                    + "5 - Relatórios\n"
                    + "6 - Sair\n\n"
                    + "Escolha uma opção:");

            if (entrada == null) {
                opcao = 6;
            } else {
                try {
                    opcao = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    opcao = 0;
                }
            }

      switch (opcao) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Cadastro de contas");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Consulta de contas");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Exclusão de contas");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Baixa de contas");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Relatórios");
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Encerrando sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 6);

    }
}
    

