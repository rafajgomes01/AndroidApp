package com.example.dietmaker.classes;

public class DietaGanharPeso {
    //private int foto;

    private String titulo;
    private String horario;
    //private String subtitulo;
    private String conteudo;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public DietaGanharPeso() {

    }

    public DietaGanharPeso(String titulo, String conteudo, String horario) {
        this.titulo = titulo;
        this.horario = horario;
        this.conteudo = conteudo;
        this.expanded = false;
    }


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

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }
}
