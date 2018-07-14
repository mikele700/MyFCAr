package com.example.unina.myfcar.Configurazione;

public class SettingSerie extends Setting {
    private NomeSerie nome;

    public SettingSerie(Integer id, Float v, NomeSerie n) {
        super(id, v);
        nome = n;
        // TODO Auto-generated constructor stub
    }

    public String getNome() {
        return nome.toString();
    }
}
