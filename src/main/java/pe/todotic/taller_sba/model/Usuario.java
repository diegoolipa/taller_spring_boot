package pe.todotic.taller_sba.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombres;

    private String apellidos;

    private String nombreCompleto;

    @Email
    private String email;

    private Boolean estado;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;
}
