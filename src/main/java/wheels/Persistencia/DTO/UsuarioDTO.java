package wheels.Persistencia.DTO;

import lombok.Getter;
import lombok.Setter;

public abstract class UsuarioDTO {
    @Getter
    @Setter
    private String nombreCompleto;
    @Getter
    @Setter
    private String nombreUsuario;
    @Getter
    @Setter
    private String contraseña;
    @Getter
    @Setter
    private String universidad;
    @Getter
    @Setter
    private String telefono;

    public UsuarioDTO(String nombreCompleto, String nombreUsuario, String contraseña, String universidad, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.universidad = universidad;
        this.telefono = telefono;
    }

}
