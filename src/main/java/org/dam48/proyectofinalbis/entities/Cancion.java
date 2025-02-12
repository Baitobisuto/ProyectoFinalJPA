package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @Version
    @Column(name = "version")
    private Integer version = 0;


    @Column(name = "duracion")
    private String duracion;

    @ManyToMany(mappedBy = "canciones")
    private Set<Playlist> playlists = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

}