package school.sptech;


import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.JogoInvalidoException;
import school.sptech.exception.JogoNaoEncontradoException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public class Empresa {
    private String nome;
    private List<Jogo> jogos;

    public Empresa (){
        this.jogos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarJogo (Jogo jogo) throws JogoInvalidoException{
        LocalDate dataAtual = now();
        if (jogo == null  ||
                jogo.getCodigo() == null || jogo.getCodigo().isBlank() ||
                jogo.getNome() == null || jogo.getNome().isBlank() ||
                jogo.getGenero() == null || jogo.getGenero().isBlank() ||
                jogo.getPreco() == null || jogo.getPreco() <= 0 ||
                jogo.getAvaliacao() == null || jogo.getAvaliacao() < 0.0 || jogo.getAvaliacao() > 5.0 ||
                jogo.getDataLancamento() == null || jogo.getDataLancamento().isAfter(dataAtual)
        ) {
            throw new JogoInvalidoException();
        } else {
            jogos.add(jogo);
        }

    }

    public Jogo buscarJogoPorCodigo (String codigo) throws ArgumentoInvalidoException, JogoNaoEncontradoException{
        if (codigo == null || codigo.isBlank()){
            throw new ArgumentoInvalidoException();
        } else {
            for (Jogo jogo: jogos){
                if (jogo.getCodigo().equals(codigo)){
                    return jogo;
                }
            }
            throw new JogoNaoEncontradoException();
        }
    }

    public void removerJogoPorCodigo (String codigo) throws ArgumentoInvalidoException, JogoNaoEncontradoException{
        if (codigo == null || codigo.isBlank()){
            throw new ArgumentoInvalidoException();
        } else {
            for (int i = 0; i< jogos.size(); i++){
                if (jogos.get(i).getCodigo().equals(codigo)){
                    jogos.remove(jogos.get(i));
                    return;
                }
            }
            throw new JogoNaoEncontradoException();
        }
    }

    public Jogo buscarJogoComMelhorAvaliacao () throws JogoNaoEncontradoException{
        if (jogos.size() == 0){
            throw new JogoNaoEncontradoException();
        }
        Jogo inicio = jogos.get(0);
        List<Jogo> maiores = new ArrayList<>();
        Jogo jogoMaisRecente = null;

        for (Jogo jogo: jogos){
            if (inicio.getAvaliacao() < jogo.getAvaliacao()){
                inicio = jogo;
            }
        }
        for (Jogo jogo:jogos){
            if (inicio.getAvaliacao().equals(jogo.getAvaliacao())){
                if (inicio.getDataLancamento().isAfter(jogo.getDataLancamento())){
                    jogoMaisRecente = inicio;
                } else {
                    jogoMaisRecente = jogo;
                }
            }
        }
        return jogoMaisRecente;
    }

    public List<Jogo> buscarJogoPorPeriodo (LocalDate dataInicio, LocalDate dataFim) throws ArgumentoInvalidoException{
        List<Jogo> jogosNaData = new ArrayList<>();

        if (dataInicio == null || dataFim == null || dataFim.isBefore(dataInicio)){
            throw new ArgumentoInvalidoException();
        }
        for (Jogo jogo: jogos){
            if (jogo.getDataLancamento().isAfter(dataInicio) && jogo.getDataLancamento().isBefore(dataFim)){
                jogosNaData.add(jogo);
            }
        }
        return jogosNaData;
    }

}
