package _4ain.battlestate.model;

public class Attacco {
    private String nome;
    private int danno;
    private int costoEnergia;
    private TipoAttaco tipo;

    public Attacco(String nome, int danno, int costoEnergia, TipoAttaco tipo) {
        this.nome = nome;
        this.danno = danno;
        this.costoEnergia = costoEnergia;
        this.tipo = tipo;

    }

    public int calcolaDanno(){
        return danno;
    }

    public TipoAttaco getTipo() {
        return tipo;
    }

    public int getDanno() {
        return danno;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public String getNome() {
        return nome;
    }

}
