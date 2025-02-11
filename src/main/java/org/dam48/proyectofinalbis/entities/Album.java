package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('albums_id_album_seq')")
    @Column(name = "id_album", nullable = false)
    private Integer id;

    @Column(name = "titulo_album", nullable = false)
    private String tituloAlbum;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista")
    private Artista idArtista;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "anio_lanzamiento")
    private Integer anioLanzamiento;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY) // Añade esta línea
    private List<Canciones> canciones;

    public List<Canciones> getCanciones() { // Getter para la lista de canciones
        return canciones;
    }

    public void setCanciones(List<Canciones> canciones) {
        this.canciones = canciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public Artista getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Artista idArtista) {
        this.idArtista = idArtista;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(Integer anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

}