package com.example.dietmaker.classes;

public class DietaGanharPeso {
    //private int foto;

    private String titulo;
    private String horario;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public DietaGanharPeso(){

    }

    public DietaGanharPeso(/*int foto,*/ String titulo, String horario) {
     //   this.foto = foto;
        this.titulo = titulo;
        this.horario = horario;
        this.expanded = false;
    }

    /*public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
