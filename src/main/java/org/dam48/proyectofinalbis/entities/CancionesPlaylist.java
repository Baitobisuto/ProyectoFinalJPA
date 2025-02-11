package org.dam48.proyectofinalbis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones_playlist")
public class CancionesPlaylist {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cancion", nullable = false)
    private Canciones idCancion;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_playlist", nullable = false)
    private Playlist idPlaylist;

    public Canciones getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Canciones idCancion) {
        this.idCancion = idCancion;
    }

    public Playlist getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Playlist idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

}