package edu.escuelaing.arsw.Networking.calcnumber;

/**
 * Clase calculadora con los metodos principales para calcular sin,cos,tan
 */
public class calculadora {
    /**
     * metodo que retorna el coseno
     * @param num valor que se quiere operar
     * @return retorna el resultado
     */
    public static Double calcCos(Double num){
        return Math.cos(num);
    }
    /**
     * metodo que retorna el tangente
     * @param num valor que se quiere operar
     * @return retorna el resultado
     */
    public static Double calcTan(Double num){
        return Math.tan(num);
    }
    /**
     * metodo que retorna el seno
     * @param num valor que se quiere operar
     * @return retorna el resultado
     */
    public static Double calcSin(Double num){
        return Math.sin(num);
    }
}
