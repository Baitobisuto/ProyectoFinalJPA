package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlists_id_gen")
    @SequenceGenerator(name = "playlists_id_gen", sequenceName = "playlists_id_playlist_seq", allocationSize = 1)
    @Column(name = "id_playlist", nullable = false)
    private Integer id;

    @Column(name = "nombre_playlist", nullable = false)
    private String nombrePlaylist;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "descripcion", length = Integer.MAX_VALUE)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "canciones_playlist", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "id_playlist"), // Columna de clave foránea para Playlist
            inverseJoinColumns = @JoinColumn(name = "id_cancion") // Columna de clave foránea para Canciones
    )
    private Set<Canciones> canciones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Canciones> canciones) {
        this.canciones = canciones;
    }

}