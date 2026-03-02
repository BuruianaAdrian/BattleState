package _4ain.battlestate.model;

import java.util.ArrayList;

public abstract class Personaggio {
    private String nome;
    private int hp;
    private ArrayList<Attacco> attacchi;// serve per tutti i attacchi
    private int difesa;

    public Personaggio(String nome, int hp, ArrayList<Attacco> attacchi, int difesa) {
        this.nome = nome;
        this.hp = hp;
        this.attacchi = attacchi;
        this.difesa = difesa;
    }

    public boolean èVivo() {
        return hp > 0;
    }

    public void riceviDanno(int danno){
        hp =- danno;
        if(hp < 0){
            hp = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Attacco> getAttacchi() {
        return attacchi;
    }

    public int getDifesa() {
        return difesa;
    }
}
