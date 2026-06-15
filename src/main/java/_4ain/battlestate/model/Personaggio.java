package _4ain.battlestate.model;

import java.util.ArrayList;

public abstract class Personaggio {
    private String nome;
    private int hp;
    private ArrayList<Attacco> attacchi;// serve per tutti i attacchi
    private boolean inDifesa;
    private int energia;

    public Personaggio(String nome, int hp, ArrayList<Attacco> attacchi, boolean inDifesa, int energia) {
        this.nome = nome;
        this.hp = hp;
        this.attacchi = attacchi;
        this.inDifesa = false;
        this.energia = energia;
    }

    public boolean èVivo() {
        return hp > 0;
    }

    public void riceviDanno(int danno){
        hp -= danno;
        if(hp < 0){
            hp = 0;
        }
    }

    public void addAttacco(Attacco a){
        attacchi.add(a);
    }
    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Attacco> getAttacchi(){
        return attacchi;
    }

    public boolean isInDifesa() {
        return inDifesa;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setInDifesa(boolean inDifesa) {
        this.inDifesa = inDifesa;
    }

    public void setAttacchi(ArrayList<Attacco> attacchi) {
        this.attacchi = attacchi;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
