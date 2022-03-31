/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

/**
 *
 * @author JeffSturmann
 */

public final class HoraUtil {

    private HoraUtil() {

    }

    public static void validarHora(int horas, int minutos, int segundos) throws IllegalArgumentException
    {
        if( horas < 0 || horas > 23 ||
            minutos < 0 || horas > 59 ||
            segundos < 0 || segundos > 59)
        {
            throw new IllegalArgumentException("Erro: a hora inserida é inválida.");
        }
    }

    public static void validarHora(final String hora) throws IllegalArgumentException, NumberFormatException
    {
        if(hora == null){
            throw new NullPointerException("Erro: a hora inserida é inválida.");
        }
        else if(!hora.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")){
            throw new IllegalArgumentException();
        }
        else {
            final String[] valores = hora.split(":");
            final int horas = Integer.decode(valores[0]),
        	      minutos = Integer.decode(valores[1]),
        	      segundos = Integer.decode(valores[2]);

            validarHora(horas,minutos,segundos);
        }
    }
}
