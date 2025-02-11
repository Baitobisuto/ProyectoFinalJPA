package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Canciones {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "canciones_id_gen")
    @SequenceGenerator(name = "canciones_id_gen", sequenceName = "canciones_id_cancion_seq", allocationSize = 1)
    @Column(name = "id_cancion", nullable = false)
    private Integer id;

    @Column(name = "titulo_cancion", nullable = false)
    private String tituloCancion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album album;

    @Column(name = "duracion")
    private String duracion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setTituloCancion(String tituloCancion) {
        this.tituloCancion = tituloCancion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}