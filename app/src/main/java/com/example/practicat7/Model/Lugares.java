package com.example.practicat7.Model;

public class Lugares
{
    private Long id;
    private String nombre;
    private Double latitud;
    private Double longitud;
    private String comentarios;
    private Float valoracion;
    private Integer categoria;

    public Lugares() {
        this.id = null;
        this.nombre = "";
        this.latitud = null;
        this.longitud = null;
        this.comentarios="";
        this.valoracion=0.0f;
        this.categoria=0;
    }

    public Lugares(String nombre, Double latitud, Double longitud, String comentarios, Float valoracion, Integer categoria) {
        this.id = null;
        this.nombre = nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.comentarios=comentarios;
        this.valoracion=valoracion;
        this.categoria=categoria;
    }

    public Lugares(Long id, String nombre, Double latitud, Double longitud, String comentarios, Float valoracion, Integer categoria) {
        this.id = id;
        this.nombre = nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.comentarios=comentarios;
        this.valoracion=valoracion;
        this.categoria=categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public Float getValoracion() {
        return valoracion;
    }
    public void setValoracion(Float valoracion) {
        this.valoracion = valoracion;
    }
    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Producto {" + "id=" + id + ", nombre='" + nombre + '\'' + ", latitud=" + latitud + ", longitud=" + longitud + ", comentarios=" + comentarios + ", valoracion=" + valoracion + ", categoria='" + categoria + '\'' + '}';
    }
}

