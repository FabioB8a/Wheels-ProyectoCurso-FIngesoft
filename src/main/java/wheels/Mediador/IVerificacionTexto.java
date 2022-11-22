package wheels.Mediador;

public interface IVerificacionTexto {
    boolean verificarEsCorreo(String...campos);
    boolean verificarEsNumero(String...campos);
    boolean verificarTextoVacio(String...campos);
}
