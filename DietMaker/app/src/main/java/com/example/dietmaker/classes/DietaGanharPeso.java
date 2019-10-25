package com.example.dietmaker.classes;

public class DietaGanharPeso {
   // private int foto;
    private String tipo;
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

    public DietaGanharPeso(/*int foto,*/ String tipo, String horario) {
     //   this.foto = foto;
        this.tipo = tipo;
        this.horario = horario;
        this.expanded = false;
    }

    /*public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }*/

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
