

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConexionesHttp {
	
	private static String networkStatus = "REQ_OK";
	private static final String USER_AGENT = "Mozilla/5.0";
//	protected static final Logger log = Logger.getLogger(Messages.getString("ConexionesHttp.0"));
	
	public ConexionesHttp() {
	}
	
	/**
	 * Si falla retorna un InputStream con el detalle del error
	 * @param _url
	 * @return
	 */
	public static InputStream executeHttpsConnection(String _url)
	{
		try{
        	URL url = new URL(_url);
            URLConnection urlConnection = url.openConnection();
            return urlConnection.getInputStream();
        }catch(Exception e)
        {

//        	log.error("Conexion HTTP : " + e.getMessage());
        	networkStatus = "ERROR HTTP: La direcci�n " + _url;
        	return new ByteArrayInputStream(networkStatus.getBytes());
        }
	}
	
	/**
	 * Si falla; retorna null
	 * @param _url
	 * @return
	 */
	public static InputStream getJsonFromServer(String _url)
	{
		try{
        	URL url = new URL(_url);
            URLConnection urlConnection = url.openConnection();
            return urlConnection.getInputStream();
        }catch(Exception e)
        {

//        	log.error("getJSON : " + e.getMessage());
        	networkStatus = "ERROR HTTP: La direcci�n " + _url;
        	return null;
        }
	}

	public static String getNetworkStatus() {
		return networkStatus;
	}

	public static void setNetworkStatus(String networkStatus) {
		ConexionesHttp.networkStatus = networkStatus;
	}
	
	public static String sendPost(String url, String data) throws Exception {
	
		HttpURLConnection  con = (HttpURLConnection) new URL(url).openConnection();

		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept","*/*");
		con.setRequestProperty("Content-Type","application/json");
 
		// Send post request
		con.setDoOutput(true);
		con.setDoInput(true);

		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(data);
		wr.flush();
		wr.close();
		data = null;
 
		System.out.println("\nSending 'POST' request to URL : " + url);
		
		InputStream it = con.getInputStream();
		InputStreamReader inputs = new InputStreamReader(it);
 
		BufferedReader in = new BufferedReader(inputs);
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
 
		//print result
		System.out.println("Servidor dice : " + response.toString());
		return response.toString();
	}
}
