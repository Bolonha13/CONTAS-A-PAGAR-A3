package modelo;

public class Conta {
    // Atributos da conta 

    private String documento;
    private String descricao;
    private String datavencimento;
    private double valor;
    private boolean paga;

    // Construtor da conta
    public Conta(String documento, String descricao, String datavencimento, double valor, boolean paga) {
        this.documento = documento;
        this.descricao = descricao;
        this.paga = paga;
        this.valor = valor;
        this.datavencimento = datavencimento;
    }
    // Getter do documento

    public String getDocumento() {
        return documento;

    }

    // Getter da descricao
    public String getDescricao() {
        return descricao;
    }

    // Getter da data de vencimento
    public String getDatavencimento() {
        return datavencimento;
    }

    // Getter do valor
    public double getValor() {
        return valor;
    }

    // Getter do status de pagamento
    public boolean isPaga() {
        return paga;
    }
// Setter da descrição

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
