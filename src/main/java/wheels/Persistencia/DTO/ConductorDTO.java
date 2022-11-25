package wheels.Persistencia.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ConductorDTO extends UsuarioDTO {


    @Getter
    @Setter
    private String cedulaConductor;
    @Getter
    @Setter
    private String marcaAuto;
    @Getter
    @Setter
    private String modeloAuto;
    @Getter
    @Setter
    private String placaAuto;
    @Getter
    @Setter
    private String polizaAuto;
    @Getter
    @Setter
    private String chasisAuto;


    public ConductorDTO(String nombreCompleto, String nombreUsuario, String contraseña, String universidad, String telefono, String cedulaConductor, String marcaAuto, String modeloAuto, String placaAuto, String polizaAuto, String chasisAuto) {
        super(nombreCompleto, nombreUsuario, contraseña, universidad, telefono);
        this.cedulaConductor = cedulaConductor;
        this.marcaAuto = marcaAuto;
        this.modeloAuto = modeloAuto;
        this.placaAuto = placaAuto;
        this.polizaAuto = polizaAuto;
        this.chasisAuto = chasisAuto;

    }

}
