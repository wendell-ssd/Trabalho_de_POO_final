package entidades;

public class Passagem {
    private static int geradorID = 0;
    private int id;
    private Viajante viajante;
    private Viagem viagem;

    public Passagem(Viajante viajante, Viagem viagem) {
        geradorID++;
        this.id = geradorID;
        this.viajante = viajante;
        this.viagem = viagem;
    }

    public static int getGeradorID() {
        return geradorID;
    }

    public static void setGeradorID(int geradorID) {
        Passagem.geradorID = geradorID;
    }

    public Viajante getViajante() {
        return viajante;
    }

    public void setViajante(Viajante viajante) {
        this.viajante = viajante;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Viagem getViagem() {
        return viagem;
    }
}
