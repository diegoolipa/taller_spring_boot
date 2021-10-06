package pe.todotic.taller_sba.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public  class Libro {
    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;

    private Float precio;

    private Boolean estado;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

}