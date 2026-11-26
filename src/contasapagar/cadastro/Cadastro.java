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

            String texto = JOptionPane.showInputDialog("Informe o documento: ");
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

    private double lerValor() {
        double valor = 0;
        boolean valido;
        do {
            valido = true;
            String texto = JOptionPane.showInputDialog("Informe o valor: ");
            if (texto == null) {
                return 0;
            }
            try {
                valor = Double.parseDouble(texto.replace(",", "."));
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(null, "Erro: o valor deve ser maior que zero.");
                    valido = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: digite um valor numérico. Ex: 150,50");
                valido = false;
            }
        } while (!valido);
        return valor;
    }

    private String lerData() {
        String data;
        boolean valido;
        do {
            valido = true;
            data = JOptionPane.showInputDialog("Informe a data de vencimento (dd/mm/aaaa): ");
            if (data == null) {
                return null;
            }
            String[] partes = data.split("/");
            if (partes.length != 3) {
                JOptionPane.showMessageDialog(null, "Erro: use o formato dd/mm/aaaa.");
                valido = false;
            } else {
                try {
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int ano = Integer.parseInt(partes[2]);

                    if (mes < 1 || mes > 12 || ano < 2000 || ano > 2100) {
                        JOptionPane.showMessageDialog(null, "Erro: mês ou ano inválido.");
                        valido = false;
                    } else {
                        // descobre quantos dias tem o mês
                        int diasDoMes;
                        if (mes == 2) {
                            if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
                                diasDoMes = 29; // ano bissexto
                            } else {
                                diasDoMes = 28; // ano não bissexto
                            }
                        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                            diasDoMes = 30;
                        } else {
                            diasDoMes = 31;
                        }

                        if (dia < 1 || dia > diasDoMes) {
                            JOptionPane.showMessageDialog(null, "Erro: dia inválido para este mês.");
                            valido = false;
                        }
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: a data deve ter apenas números e barras.");
                    valido = false;
                }
            }
        } while (!valido);
        return data;
    }

    public void incluir(ListaContas lista) {
        // Lê os dados; se a pessoa cancelar em qualquer um, volta ao menu
        int documento = lerDocumento(lista);
        if (documento == 0) {
            return;
        }
        String descricao = lerTexto("Informe a descrição:");
        if (descricao == null) {
            return;
        }
        String beneficiario = lerTexto("Informe o beneficiário:");
        if (beneficiario == null) {
            return;
        }
        double valor = lerValor();
        if (valor == 0) {
            return;
        }
        String vencimento = lerData();
        if (vencimento == null) {
            return;
        }

        // Mostra o resumo e pede confirmação
        String resumo = "DOCUMENTO: " + documento
                + "\nDESCRIÇÃO: " + descricao
                + "\nBENEFICIÁRIO: " + beneficiario
                + "\nVALOR: R$ " + String.format("%.2f", valor)
                + "\nVENCIMENTO: " + vencimento;

        int resposta = JOptionPane.showConfirmDialog(null, resumo + "\n\nConfirma inclusão?",
                "Inclusão de conta", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            lista.adicionar(new Conta(documento, descricao, beneficiario, valor, vencimento));
            JOptionPane.showMessageDialog(null, "Conta incluída com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Inclusão cancelada.");
        }
    }
}