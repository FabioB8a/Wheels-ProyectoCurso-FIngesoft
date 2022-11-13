package wheels.Persistencia.DTO;

import java.util.Date;

public class ConductorDTO extends UsuarioDTO{

    private String cedulaConductor;
    private String marcaAuto;
    private String modeloAuto;
    private String placaAuto;
    private String polizaAuto;
    private String chasisAuto;
    private Date fechaExpAuto;

    public ConductorDTO(String nombreCompleto, String nombreUsuario, String contraseña, String universidad, String telefono, String cedulaConductor, String marcaAuto, String modeloAuto, String placaAuto, String polizaAuto, String chasisAuto, Date fechaExpAuto) {
        super(nombreCompleto, nombreUsuario, contraseña, universidad, telefono);
        this.cedulaConductor = cedulaConductor;
        this.marcaAuto = marcaAuto;
        this.modeloAuto = modeloAuto;
        this.placaAuto = placaAuto;
        this.polizaAuto = polizaAuto;
        this.chasisAuto = chasisAuto;
        this.fechaExpAuto = fechaExpAuto;
    }

    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public String getPlacaAuto() {
        return placaAuto;
    }

    public String getPolizaAuto() {
        return polizaAuto;
    }

    public String getChasisAuto() {
        return chasisAuto;
    }

    public Date getFechaExpAuto() {
        return fechaExpAuto;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public void setPlacaAuto(String placaAuto) {
        this.placaAuto = placaAuto;
    }

    public void setPolizaAuto(String polizaAuto) {
        this.polizaAuto = polizaAuto;
    }

    public void setChasisAuto(String chasisAuto) {
        this.chasisAuto = chasisAuto;
    }

    public void setFechaExpAuto(Date fechaExpAuto) {
        this.fechaExpAuto = fechaExpAuto;
    }
}
