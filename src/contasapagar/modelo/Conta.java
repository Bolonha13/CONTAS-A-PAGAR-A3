package contasapagar.modelo;

public class Conta { //atributos
    private int documento; 
    private String descricao; 
    private String beneficiario; 
    private double valor; 
    private String dataVencimento;
    
    public Conta (int documento, String descricao, String beneficiario, double valor, String dataVencimento) { //Construtor
        this.documento = documento;
        this.descricao = descricao;
        this.beneficiario = beneficiario;
        this.valor = valor;
        this.dataVencimento = dataVencimento; //indica que estamos preenchendo os atributos da própria conta com os valores recebidos pelo construtor
    }
    
    public int getDocumento() { //Métodos de acesso (getters)
        return documento;
    }
    
    public String getDescricao () {
        return descricao;
    }
    
    public String getBeneficiario () {
        return beneficiario;
    }
    
    public double getValor () {
        return valor;
    }
    
    public String getDataVencimento () {
        return dataVencimento;
    }
}