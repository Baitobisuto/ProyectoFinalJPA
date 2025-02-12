package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "albumes")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('albumes_id_album_seq')")
    @Column(name = "id_album", nullable = false)
    private Integer id;


    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "artista_id", nullable = false)
    private Artista artista;

    @Column(name = "url_imagen")
    private String urlImagen;

    @OneToMany(mappedBy = "album",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Cancion> canciones = new LinkedHashSet<>();

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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

}