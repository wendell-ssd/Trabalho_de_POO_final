package entidades;

import java.util.ArrayList;

/**
 * Classe que representa um Hotel.
 * Contém 5 objetos do tipo:
 * String que representam o nome do hotel, o cep e a cidade;
 * Uma ListaEncadeada de objetos do tipo Quarto, que representam os quartos
 * presentes no hotel;
 * Um numérico (inteiro), que representa a quantidade de estrelas do hotel;
 * todos os objetos tem seus gets e sets respectivamente associados.
 * 
 * @author Igor de Vasconcelos
 */

public class Hotel {
    private String nome;
    private String cep;
    private ArrayList<Quarto> quartos;
    private int estrelas;
    private Local local;

    /**
     * Construtor da classe hotel, todos os parâmetros precisam ser preenchidos.
     * 
     * @param nome     Nome do hotel;
     * @param cep      CEP referente ao hotel;
     * @param quartos  Lista encadeada que representa os quartos presentes em um
     *                 hotel;
     * @param estrelas Inteiro que representa a quantidade de estrelas do hotel;
     * @param cidade   String que representa a cidade que o hotel está localizado.
     */
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

    /**
     * Método que percorre a lista de quartos e nos diz a quantidade de quartos não
     * reservados.
     * 
     * @return um inteiro que representa a quantidade de quartos não reservados.
     */
    public int getQuartosDisponiveis() {
        int quantidade = 0;
        for (Quarto quarto : this.quartos) {
            if (!quarto.getAlugado()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    /**
     * Altera o método toString para nos dar nome, quantidade de estrelas, cep e
     * quantidade de quartos disponíveis em um hotel.
     * 
     * @return String que representam as características mais importantes de um
     *         hotel.
     */
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
