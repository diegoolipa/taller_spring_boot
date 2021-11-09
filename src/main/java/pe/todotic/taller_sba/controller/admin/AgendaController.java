package pe.todotic.taller_sba.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.todotic.taller_sba.model.Agenda;
import pe.todotic.taller_sba.repo.AgendaRepository;
import pe.todotic.taller_sba.web.dto.AgendaDTO;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaController(AgendaRepository agendaRepository){
        this.agendaRepository=agendaRepository;
    }

    @GetMapping("")
    Page<Agenda> index(@PageableDefault(sort = "apellidos",size = 5)Pageable pageable){
        Page<Agenda> agendas = agendaRepository.findAll(pageable);
        return agendas;
    }

    @GetMapping("{id:[0-9]+}")
    Agenda get(@PathVariable Integer id){
        Agenda agenda = agendaRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return agenda;
    }

    @PostMapping
    Agenda crear(@RequestBody @Validated AgendaDTO agendaDTO){
        Agenda agenda = new ModelMapper().map(agendaDTO, Agenda.class);
        return agendaRepository.save(agenda);
    }


    @PutMapping("{id}")
    Agenda actualizar(@PathVariable Integer id, @RequestBody @Validated AgendaDTO agendaDTO){
        Agenda agendaFronDb = agendaRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
       ModelMapper mapper = new ModelMapper();
       mapper.map(agendaDTO,agendaFronDb);

        return agendaRepository.save(agendaFronDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void eliminar(@PathVariable Integer id){
        Agenda agenda = agendaRepository.getById(id);
        agendaRepository.delete(agenda);
    }

}
