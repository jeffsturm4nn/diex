package model.util;

import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * @author Jefferson Sales
 *
 */
public final class DataUtil {

    public static void validarData(int dia, int mes, int ano) throws IllegalArgumentException{

	if(dia < 1 || dia > 31 ||
	   mes < 1 || mes > 12 ||
	   ano < 1 || ano > 9999)
	   {
	       throw new IllegalArgumentException();
	   }
    }

    public static void validarData(String data) throws IllegalArgumentException{

	if(data == null) {
	    throw new NullPointerException();
	}
	else if(!data.matches("\\d{1,2}/\\d{1,2}/\\d{1,4}")) {
	    throw new IllegalArgumentException();
	}
	else {
	    final String[] valores = data.split("/");

	    final int dia = Integer.parseInt(valores[0]),
		      mes = Integer.parseInt(valores[1]),
		      ano = Integer.parseInt(valores[2]);

	    validarData(dia,mes,ano);
	}
    }

    public static String dataAtual() {

	Calendar calendar = Calendar.getInstance();
	int dia = calendar.get(Calendar.DAY_OF_MONTH);
	int mes = calendar.get(Calendar.MONTH) + 1;
	int ano = calendar.get(Calendar.YEAR);

	return dia + "/" + mes + "/" + ano;
    }
  
}








