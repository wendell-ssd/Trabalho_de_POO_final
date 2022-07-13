package entidades;

import java.util.ArrayList;

public class Hotel {
    private String nome;
    private String cep;
    private ArrayList<Quarto> quartos;
    private int estrelas;
    private Local local;

    public Hotel(String nome, String cep, ArrayList<Quarto> quartos, int estrelas, Local local) {
        this.nome = nome;
        this.cep = cep;
        this.quartos = quartos;
        this.estrelas = estrelas;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ArrayList<Quarto> getQuartos() {
        return this.quartos;
    }

    public int getQuantidadeQuartos() {
        return quartos.size();
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public double getDiaria() {
        double diaria = 100 + 50 * estrelas;
        return diaria;
    }

    public int getQuartosDisponiveis() {
        int quantidade = 0;
        for (Quarto quarto : this.quartos) {
            if (!quarto.getAlugado()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public String toString() {
        String string = "";
        string = string + "Nome: " + this.nome + "\n" +
                "Estrelas: " + this.estrelas + "\n" +
                "CEP: " + this.cep +
                "Quartos disponiveis: " + this.getQuartosDisponiveis() + "\n";
        return string;
    }

    public Local getlocal() {
        return this.local;
    }

    public void setlocal(Local local) {
        this.local = local;
    }
}
