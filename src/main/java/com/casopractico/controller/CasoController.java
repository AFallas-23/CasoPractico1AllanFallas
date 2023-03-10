package com.casopractico.controller;

import com.casopractico.entity.Pelicula;
import com.casopractico.entity.Sala;
import com.casopractico.service.IPeliculaService;
import com.casopractico.service.ISalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CasoController {

    @Autowired
    private IPeliculaService peliculaService;

    @Autowired
    private ISalaService salaService;

    @GetMapping("/pelicula")
    public String index(Model model) {
        List<Pelicula> listaPelicula = peliculaService.getAllPeliculas();
        model.addAttribute("titulo", "¡Bienvenido a Cinelitas!");
        model.addAttribute("peliculas", listaPelicula);
        return "peliculas";
    }

    @GetMapping("/peliculaN")
    public String crearPelicula(Model model) {
        List<Sala> listaSalas = salaService.listSala();
        model.addAttribute("pelicula", new Pelicula());
        model.addAttribute("salas", listaSalas);
        return "crear";
    }

    @PostMapping("/save")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.savePelicula(pelicula);
        return "redirect:/pelicula";
    }

    @GetMapping("/editPelicula/{id}")
    public String editarPelicula(@PathVariable("id") Long idPelicula, Model model) {
        Pelicula pelicula = peliculaService.getPeliculaById(idPelicula);
        List<Sala> listaSalas = salaService.listSala();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("salas", listaSalas);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPelicula(@PathVariable("id") Long idPelicula) {
        peliculaService.delete(idPelicula);
        return "redirect:/pelicula";
    }
}
