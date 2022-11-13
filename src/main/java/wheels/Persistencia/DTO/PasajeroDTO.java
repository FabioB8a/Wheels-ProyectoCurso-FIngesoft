package wheels.Persistencia.DTO;

public class PasajeroDTO extends UsuarioDTO{
    private String codigo;

    public PasajeroDTO(String nombreCompleto, String nombreUsuario, String contraseña, String universidad, String telefono, String codigo) {
        super(nombreCompleto,nombreUsuario,contraseña,universidad,telefono);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
