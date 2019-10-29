package com.example.dietmaker.classes;

public class DietaPerderPeso {
    private String titulo;
    private String horario;
   // private String subtitulo;
    private String conteudo;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }


    public DietaPerderPeso(){

    }

    public DietaPerderPeso(/*int foto,*/ String titulo, String subtitulo, String conteudo, String horario) {
        //this.foto = foto;
        this.titulo = titulo;
        this.horario = horario;
       // this.subtitulo = subtitulo;
        this.conteudo = conteudo;
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

   /* public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }*/

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
