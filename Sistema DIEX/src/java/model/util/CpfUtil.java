

package model.util;

/**
 *
 *
 * @author Jefferson Sales
 */

public final class CpfUtil {

    private CpfUtil() {

    }

    public static void validarCpf(String cpf) throws IllegalArgumentException  {

        if(cpf == null){
            throw new NullPointerException("Erro: CPF Inválido.");
        }

       cpf = cpf.replace("-","");
       cpf = cpf.replace(".","");

       if(!cpf.matches("\\d{11}")) {
	   throw new IllegalArgumentException("Erro: CPF Inválido.");
       }

       int d1=0, d2=0;
       int digito1=0, digito2=0, digitoString=0, resto=0;

       for(int n=1; n<cpf.length()-1; n++)
       {
           final char digAtual = cpf.charAt(n-1);

           if(Character.isDigit(digAtual))
           {
                digitoString = Integer.parseInt(Character.toString(digAtual));

                d1 = d1 + (11 - n) * digitoString;
                d2 = d2 + (12 - n) * digitoString;
           }
           else
           {
                throw new IllegalArgumentException("Erro: CPF Inválido.");
           }
       }

       resto = d1 % 11;

       if(resto < 2){
           digito1 = 0;
       }else{
           digito1 = 11 - resto;
       }

       d2 += 2 * digito1;

       resto = d2 % 11;

       if(resto < 2){
           digito2 = 0;
       } else {
           digito2 = 11 - resto;
       }

       final String digVerif = cpf.substring(9);
       final String digResult = String.valueOf(digito1) + String.valueOf(digito2);

       if(! digVerif.equals(digResult))
       {
           throw new IllegalArgumentException("Erro: O CPF inserido e invalido.");
       }
    }

}
