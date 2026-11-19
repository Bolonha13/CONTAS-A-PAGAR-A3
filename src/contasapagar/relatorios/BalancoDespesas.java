package contasapagar.relatorios;

import contasapagar.modelo.Conta;

public class BalancoDespesas {
    // Calcula o total de todas as despesas
    public double calcularTotal(Conta[] contas, int quantidade) {

        double total = 0;

        for (int i = 0; i < quantidade; i++) {
            total = total + contas[i].getValor();
        }

        return total;
    }

    // Encontra o beneficiário com maior valor acumulado
    public String encontrarMaiorBeneficiario(
            Conta[] contas, int quantidade) {

        String maiorBeneficiario = "";
        double maiorValor = -1;

        for (int i = 0; i < quantidade; i++) {

            String beneficiario = contas[i].getBeneficiario();
            double soma = 0;

            for (int j = 0; j < quantidade; j++) {

                if (beneficiario.equalsIgnoreCase(
                        contas[j].getBeneficiario())) {

                    soma = soma + contas[j].getValor();
                }
            }

            if (soma > maiorValor) {
                maiorValor = soma;
                maiorBeneficiario = beneficiario;
            }
        }

        return maiorBeneficiario;
    }

    // Retorna o valor acumulado do maior beneficiário
    public double calcularValorMaiorBeneficiario(
            Conta[] contas, int quantidade) {

        String nome = encontrarMaiorBeneficiario(contas, quantidade);
        double total = 0;

        for (int i = 0; i < quantidade; i++) {

            if (nome.equalsIgnoreCase(contas[i].getBeneficiario())) {
                total = total + contas[i].getValor();
            }
        }

        return total;
    }
   
}
