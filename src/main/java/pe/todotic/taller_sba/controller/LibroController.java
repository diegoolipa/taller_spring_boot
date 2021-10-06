package pe.todotic.taller_sba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.taller_sba.model.Libro;
import pe.todotic.taller_sba.repo.LibroRepository;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("")
    List<Libro> index(){
        return libroRepository.findAll();
    }

    @PostMapping
    Libro crear(@RequestBody Libro libro){
        return libroRepository.save(libro);
    }

    @PutMapping("{id}")
    Libro actualizar(@PathVariable Integer id, @RequestBody Libro libro){
        Libro libroFronDb = libroRepository.getById(id);
        libroFronDb.setTitulo(libro.getTitulo());
        libroFronDb.setPrecio(libro.getPrecio());
        libroFronDb.setEstado(libro.getEstado());
        return libroRepository.save(libroFronDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void eliminar(@PathVariable Integer id){
        Libro libro = libroRepository.getById(id);
        libroRepository.delete(libro);
    }

}
