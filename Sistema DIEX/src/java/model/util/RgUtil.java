package model.util;

public final class RgUtil {

    private RgUtil() {

    }

    public static void validarRG(String rg) throws IllegalArgumentException{

	if(rg == null) {
	    throw new NullPointerException("Erro: O RG inserido e invalido.");
	}
        
	rg = rg.replace(".", "");

	if(!rg.matches("\\d{7}")) {
	    throw new IllegalArgumentException("Erro: O RG inserido e invalido.");
	}
    }

}
