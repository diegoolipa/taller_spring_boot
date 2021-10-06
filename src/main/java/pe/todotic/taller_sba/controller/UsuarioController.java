package pe.todotic.taller_sba.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.taller_sba.model.Libro;
import pe.todotic.taller_sba.model.Usuario;
import pe.todotic.taller_sba.repo.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    List<Usuario> index(){
        return usuarioRepository.findAll();
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
        usuarioFronDb.setNombreCompleto(usuario.getNombreCompleto());
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
