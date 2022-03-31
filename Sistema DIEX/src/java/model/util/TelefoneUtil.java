package model.util;

/**
 * @author Jefferson Sales
 *
 */

public final class TelefoneUtil {

    private TelefoneUtil() {

    }

    public static void validarTelefone(String telefone) {

	if(telefone == null) {
	    throw new NullPointerException("Erro: O telefone inserido é inválido.");
	}

	telefone = telefone.replace("-","");
	telefone = telefone.replace(".", "");
	telefone = telefone.replace("(", "");
	telefone = telefone.replace(")", "");

	if(!telefone.matches("\\d{8,11}")) {
	    throw new IllegalArgumentException("Erro: O telefone inserido é inválido.");
	}
    }
}
