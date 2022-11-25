package wheels.Mediador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificacionTextoTest {

    @Test
    void obtenerVerificacion() {
       VerificacionTexto verificacionTexto =VerificacionTexto.obtenerVerificacion();
    }

    @Test
    void verificarTextoVacio() {
        VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
        String String = java.lang.String.valueOf(new int[]{1, 2, 3, 4});
        verificacionTexto.verificarTextoVacio(String);
    }

    @Test
    void verificarEsNumero() {
        VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
        String String = java.lang.String.valueOf(new int[]{1, 2, 3, 4});
        verificacionTexto.verificarEsNumero(String);
    }

    @Test
    void verificarEsCorreo() {
        VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
        String String = java.lang.String.valueOf(new int[]{1, 2, 3, 4});
        verificacionTexto.verificarEsCorreo(String);
    }
    @Test
    void verificarEsCorreoF(){
        VerificacionTexto verificacionTexto = VerificacionTexto.obtenerVerificacion();
        String name = null;
        assertFalse(verificacionTexto.verificarEsCorreo(name));
    }

}