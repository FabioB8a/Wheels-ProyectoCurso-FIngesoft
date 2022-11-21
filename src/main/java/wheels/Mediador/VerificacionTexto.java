package wheels.Mediador;

import java.util.Arrays;
import java.util.regex.Pattern;

public class VerificacionTexto implements IVerificacionTexto{

    private static VerificacionTexto singleton;

    private VerificacionTexto()
    {

    }

    public static VerificacionTexto obtenerVerificacion()
    {
        if(singleton==null)
        {
            singleton = new VerificacionTexto();
        }
        return singleton;
    }

    public boolean verificarTextoVacio(String...campos)
    {
        return Arrays.stream(campos).anyMatch(n->n.equals(""));
    }

    // Expresión Lambda verificación String sea un número
    public boolean verificarEsNumero(String...campos)
    {
        return Arrays.stream(campos).allMatch(n->n.chars().allMatch( Character::isDigit ));
    }

    // Función verificación de correo electrónico: Tomado de: <https://www.geeksforgeeks.org/check-email-address-valid-not-java/>
    private static boolean esValidoCorreo(String correo) {
        String correoRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(correoRegex);
        if (correo == null)
            return false;
        return pat.matcher(correo).matches();
    }

    // Expresión Lambda verificación String sea un correo
    public boolean verificarEsCorreo(String...campos)
    {
        return Arrays.stream(campos).allMatch(VerificacionTexto::esValidoCorreo);
    }
}
