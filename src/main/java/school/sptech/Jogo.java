package school.sptech;

import java.time.LocalDate;

public class Jogo {
    private String codigo;
    private String nome;
    private String genero;
    private Double preco;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Jogo(){

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAvaliacaoDescricao (){
        if (avaliacao >= 4.5){
            return "EXCELENTE";
        } else if (avaliacao >= 3.5){
            return "BOM";
        } else if (avaliacao >= 2.5){
            return "REGULAR";
        } else {
            return "RUIM";
        }
    }
}
