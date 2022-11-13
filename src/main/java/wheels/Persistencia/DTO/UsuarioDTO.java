package wheels.Persistencia.DTO;

public class UsuarioDTO {
    private String nombreCompleto;
    private String nombreUsuario;
    private String contraseña;
    private String universidad;
    private String telefono;

    public UsuarioDTO(String nombreCompleto, String nombreUsuario, String contraseña, String universidad, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.universidad = universidad;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
