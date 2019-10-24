package com.example.dietmaker;

public class DietaGanho {
    private int foto;
    private String dieta;
    private String tipo;
    private String horario;

    public DietaGanho(){

    }

    public DietaGanho(int foto, String dieta, String tipo, String horario) {
        this.foto = foto;
        this.dieta = dieta;
        this.tipo = tipo;
        this.horario = horario;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
