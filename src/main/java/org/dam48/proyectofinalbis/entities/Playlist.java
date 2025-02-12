package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('playlists_id_playlist_seq')")
    @Column(name = "id_playlist", nullable = false)
    private Integer id;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "nombre")
    private String nombre;

   // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // o CascadeType.ALL
   @JoinTable(name = "playlist_cancion",
           joinColumns = @JoinColumn(name = "playlist_id"),
           inverseJoinColumns = @JoinColumn(name = "cancion_id"))
    private Set<Cancion> canciones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

}