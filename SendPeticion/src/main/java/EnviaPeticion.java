


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author cfriasb
 * 
 */
public class EnviaPeticion {

	static String url ="http://localhost:8080/continent-webservices/rest/";
	public static void main(String[] args) {
		/**
		 * Ejemplos de Json de alta y baja suscriptores
		alta
		{"shortcode":2323,"cliente":{"msIsdn":"50764842411","smscId":2},"susUser":3}
		Baja
		{"shortcode":2323,"cliente":{"msIsdn":"50764842411","smscId":2},"desUser":2}
		**/
		
		//Peticion de alta Suscripcion
		//peticiontEST();
		//Peticion de Baja Suscripcion
		peticiontESTBaja();
		
		
       
	}
	

	
	
	private static void peticiontESTBaja()
	{
		
		url+="suscripcion/baja";
		  try {
			    	  	ConexionesHttp.sendPost(url, LeeFichero.leer("Json.txt")); 

			  }
    	  
      catch(Exception IOe) {
    	 IOe.printStackTrace(); 
      }
	}
	
	
	private static void peticiontEST()
	{
		
		url+="suscripcion/alta";
		  try {
			    	  	ConexionesHttp.sendPost(url, LeeFichero.leer("Json.txt")); 

			  }
    	  
      catch(Exception IOe) {
    	 IOe.printStackTrace(); 
      }
	}

	public static InputStream getJsonFromServer(String _url)
	{
		try{
        	URL url = new URL(_url);
            URLConnection urlConnection = url.openConnection();
            return urlConnection.getInputStream();
        }catch(Exception e)
        {
        	return null;
        }
	}
	
	}


