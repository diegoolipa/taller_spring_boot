package pe.todotic.taller_sba.web.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UsuarioDTO {

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    private String nombreCompleto;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String rol;

    @NotBlank
    private String estado;
}
