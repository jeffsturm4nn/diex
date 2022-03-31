package model.util;

/**
 *
 * @author Jefferson Sales
 *
 */

public final class EmailUtil {

    private EmailUtil() {

    }

    public static void validarEmail(String email) {

	if(email == null) {
	    throw new NullPointerException("Erro: O e-mail inserido é inválido.");
	}
	else if(!email.matches("^\\b[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}\\b")) {
	    throw new IllegalArgumentException("Erro: O e-mail inserido é inválido.");
	}
    }
}
