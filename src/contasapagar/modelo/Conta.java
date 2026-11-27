package contasapagar.modelo;

public class Conta {

    // Atributos
    private int documento;
    private String descricao;
    private String beneficiario;
    private double valor;   // valor original da despesa (não muda na baixa)
    private double saldo;   // quanto ainda falta pagar (diminui na baixa)
    private String dataVencimento;

    // Construtor: a conta começa devendo o valor inteiro
    public Conta(int documento, String descricao, String beneficiario, double valor, String dataVencimento) {
        this.documento = documento;
        this.descricao = descricao;
        this.beneficiario = beneficiario;
        this.valor = valor;
        this.saldo = valor;
        this.dataVencimento = dataVencimento;
    }

    // Retorna o número do documento
    public int getDocumento() {
        return documento;
    }

    // Retorna a descrição da conta
    public String getDescricao() {
        return descricao;
    }

    // Retorna o beneficiário
    public String getBeneficiario() {
        return beneficiario;
    }

    // Retorna o valor original da despesa
    public double getValor() {
        return valor;
    }

    // Retorna o saldo devedor atual
    public double getSaldo() {
        return saldo;
    }

    // Retorna a data de vencimento
    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Atualiza o saldo devedor (usado na baixa)
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}