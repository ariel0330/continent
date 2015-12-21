import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeeFichero {
	public static String leer(String dirArchivo){
		      File archivo = null;
		      FileReader fr = null;
		      BufferedReader br = null;
		      String salida="";
		      try {
		         archivo = new File (dirArchivo);
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		         String linea;
		         while((linea=br.readLine())!=null)
		        	 salida+=linea;
		         
		         return salida;
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
			return null;
		   }
		}
