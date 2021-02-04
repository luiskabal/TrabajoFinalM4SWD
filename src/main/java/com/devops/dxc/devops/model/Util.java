package com.devops.dxc.devops.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class Util {

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * 
     * @param ahorro
     * @param sueldo
     * @return
     * @throws IOException 
     */
    public static int getDxc(int ahorro, int sueldo){
        try {
			if(((ahorro*0.1)/getUf()) > 150 ){
			    return (int) (150*getUf()) ;
			} else if((ahorro*0.1)<=1000000 && ahorro >=1000000){
			    return (int) 1000000;
			} else if( ahorro <=1000000){
			    return (int) ahorro;
			} else {
			    return (int) (ahorro*0.1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }
    
    /**
     * Permite obtener el impuesto de acuerdo al sueldo anual
     * @param ahorro
     * @param sueldo
     * @return
     */
    public static float getImpuesto(int ahorro, int sueldo){
    	int rentaAnual = sueldo*12;
    	
    	if(rentaAnual >= 17864280 && rentaAnual <= 29773800) {
    		return (int) (getDxc(ahorro, sueldo)*0.08);
    	} else if(rentaAnual >= 29700000 && rentaAnual <= 41600000) {
    		return (int) (getDxc(ahorro, sueldo)*0.135);
    	} else if(rentaAnual >= 41600000 && rentaAnual <= 53500000) {
    		return (int) (getDxc(ahorro, sueldo)*0.23);
    	} else if(rentaAnual >= 53500000 &&  rentaAnual <= 71400000) {
    		return (int) (getDxc(ahorro, sueldo)*0.304);
    	}else if(rentaAnual >= 71400000) {
    		return (int) (getDxc(ahorro, sueldo)*0.35);
    	}else
    		return 0;
    }
    
    /**
     * Permite obtener el saldo restante luego del retiro del 10%
     * @param ahorro
     * @param sueldo
     * @return
     */
    public static int getSaldoRestante(int ahorro, int sueldo){
        try {
			if(((ahorro*0.1)/getUf()) > 150 ){
				int retiro = (int) (150*getUf());
			    return (ahorro - retiro) ;
			} else if((ahorro*0.1)<=1000000 && ahorro >=1000000){
			    return (int) ( ahorro - 1000000 );
			} else if( ahorro <=1000000){
			    return 0;
			} else {
			    return (int) ( ahorro - (ahorro*0.1) );
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }

    /**
     * 
     * @param rd
     * @return
     * @throws IOException
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }
       
    /**
     * Método que retorna el valor de la UF.  Este método debe ser refactorizado por una integración a un servicio
     * que retorne la UF en tiempo real.  Por ejemplo mindicador.cl
     * @return
     * @throws IOException 
     */
    public static float getUf() throws IOException{
    	InputStream is = new URL("https://mindicador.cl/api").openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject obj = new JSONObject(jsonText);
          return obj.getJSONObject("uf").getInt("valor");
          
        } finally {
          is.close();
        }
    }    
}
