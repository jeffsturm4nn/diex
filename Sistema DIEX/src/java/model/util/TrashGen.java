package model.util;

import java.util.Random;

/**
 * @author Jefferson Sales
 *
 */

public final class TrashGen {

    private static Random rand = new Random();

    private static char[] caracteres = new char[]{ 'a','b','c','d','e','f','g','h','i','j','k','l','m',
						   'n','o','p','q','r','s','t','u','v','x','y','w','z',
						   '1','2','3','4','5','6','7','8','9','0','+','-','=',
						   '_','*','&','%','$','@','!','>','<',':','#','~','^'};

    private TrashGen() {

    }

    public static int gerarInteiro(int limite) {
	return rand.nextInt(limite);
    }

    public static double gerarDouble() {
	return rand.nextDouble();
    }

    public static String gerarString(int tamMax) {
	return gerarString(tamMax,false,false,false);
    }

    public static String gerarString(int tamMax, boolean semSimb, boolean semCapt) {
	return gerarString(tamMax,semSimb,semCapt,false);
    }

    public static String gerarString(int tamMax, boolean semSimb, boolean semCapt, boolean tamRand) {

	String str = new String();
	int numSimb = 0;
	int length = 0;

	if(tamRand) {
	    length = rand.nextInt(tamMax);
	}
	else {
	    length = tamMax;
	}

	if(semSimb) {
	    numSimb = 16;
	}

	for (int i = 0; i < length; i++) {

	    char c = caracteres[rand.nextInt(caracteres.length-1-numSimb)];

	    if (semCapt == false) {

		int n = rand.nextInt(100);

		if (n >= 50 && Character.isLetter(c)) {
		    c = Character.toUpperCase(c);
		}
	    }
	    str += c;
	}

	return str;
    }
}
