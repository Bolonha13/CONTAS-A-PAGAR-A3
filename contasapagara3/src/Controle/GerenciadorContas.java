package Controle;

import modelo.Conta;

public class GerenciadorContas {

    // Vetor para armazenar as contas
    private Conta[] contas = new Conta[100];

    // Controle da quantidade de contas cadastradas
    private int quantidade = 0;

    // Método para adicionar uma conta
    public boolean adicionarConta(Conta conta) {

        if (conta == null || documentoExiste(conta.getDocumento())) {
            return false;
        }

        if (quantidade < contas.length) {
            contas[quantidade] = conta;
            quantidade++;

            return true;
        }

        return false;
    }

    // Método para buscar uma conta pelo documento
    public Conta buscarPorDocumento(String documento) {

        for (int i = 0; i < quantidade; i++) {

            if (contas[i].getDocumento().equals(documento)) {
                return contas[i];
            }
        }

        return null;
    }

    // Método para consultar a quantidade de contas
    public int getQuantidade() {
        return quantidade;
    }

    // Método para consultar uma conta pela posição
    public Conta getConta(int indice) {

        if (indice >= 0 && indice < quantidade) {
            return contas[indice];
        }

        return null;
    }

    // Método para verificar se o documento já existe
    public boolean documentoExiste(String documento) {
        return buscarPorDocumento(documento) != null;
    }

}
