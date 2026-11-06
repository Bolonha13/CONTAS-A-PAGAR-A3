package contasapagar.estrutura;

import contasapagar.modelo.Conta;

public class ListaContas {

    private Conta[] contas;
    private int quantidade;

    public ListaContas() {
        contas = new Conta[100];
        quantidade = 0;
    }

    public void adicionar(Conta conta) {
        if (quantidade < contas.length) {
            contas[quantidade] = conta;
            quantidade++;
        }
    }

    public Conta consultar(int documento) {
        for (int i = 0; i < quantidade; i++) {
            if (contas[i].getDocumento() == documento) {
                return contas[i];
            }
        }
        return null;
    }

    public boolean excluir(int documento) {
        for (int i = 0; i < quantidade; i++) {
            if (contas[i].getDocumento() == documento) {

                for (int j = i; j < quantidade - 1; j++) {
                    contas[j] = contas[j + 1];
                }

                quantidade--;
                contas[quantidade] = null;
                return true;
            }
        }
        return false;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Conta getConta(int indice) {
        return contas[indice];
    }
}