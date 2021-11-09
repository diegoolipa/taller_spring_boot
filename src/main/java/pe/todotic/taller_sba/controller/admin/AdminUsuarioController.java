package pe.todotic.taller_sba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.taller_sba.model.Libro;
import pe.todotic.taller_sba.model.Usuario;
import pe.todotic.taller_sba.repo.LibroRepository;
import pe.todotic.taller_sba.repo.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @GetMapping("")
    List<Usuario> index(){
        return usuarioRepository.findAll();
    }

    @GetMapping("{id:[0-9]+}")
    Usuario get(@PathVariable Integer id){
        return usuarioRepository.findById(id).get();
    }

    @PostMapping
    Usuario crear(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("{id}")
    Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario usuarioFronDb = usuarioRepository.getById(id);
        usuarioFronDb.setNombres(usuario.getNombres());
        usuarioFronDb.setApellidos(usuario.getApellidos());
        usuarioFronDb.setEmail(usuario.getEmail());
        usuarioFronDb.setEstado(usuario.getEstado());
        return usuarioRepository.save(usuarioFronDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void eliminar(@PathVariable Integer id){
        Usuario usuario = usuarioRepository.getById(id);
        usuarioRepository.delete(usuario);
    }

}
