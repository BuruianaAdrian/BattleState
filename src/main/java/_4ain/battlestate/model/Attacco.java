package _4ain.battlestate.model;

public class Attacco {
    private String nome;
    private int danno;
    private TipoAttaco tipo;

    public Attacco(String nome, int danno, TipoAttaco tipo) {
        this.nome = nome;
        this.danno = danno;
        this.tipo = tipo;
    }

    public int calcolaDanno(){
        return danno;
    }

    public TipoAttaco getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

}
