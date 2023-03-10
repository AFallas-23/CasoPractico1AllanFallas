package com.casopractico.service;

import com.casopractico.entity.Pelicula;
import java.util.List;

public interface IPeliculaService {

    public List<Pelicula> getAllPeliculas();
    public Pelicula getPeliculaById(long id);
    public void savePelicula(Pelicula pelicula);
    public void delete(long id);

}
