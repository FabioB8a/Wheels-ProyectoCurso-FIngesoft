package wheels.Persistencia.DTO;

import lombok.Getter;
import lombok.Setter;

public class PasajeroDTO extends UsuarioDTO {
    @Getter
    @Setter
    private String codigo;

    public PasajeroDTO(String nombreCompleto, String nombreUsuario, String contraseña, String universidad, String telefono, String codigo) {
        super(nombreCompleto, nombreUsuario, contraseña, universidad, telefono);
        this.codigo = codigo;
    }

}
