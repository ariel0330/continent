package com.continent.web.servicios.reporte;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.continent.web.dto.UserDTO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RecursoReporte {
	
	
	
	public static void generaReporte(List<UserDTO> listaUsuarios)
	{
		final DefaultResourceLoader loader = new DefaultResourceLoader();
		 Map<String, Object> parametros = new HashMap<String, Object>();
		 Resource resource = loader.getResource("jasper/reporteEjemplo.jasper");
		 try {
			InputStream jasperStream =  resource.getInputStream();
//			 response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//				response.setHeader("Content-Disposition", "attachment; filename=\"Info-Coordenadas.xlsx\";");
//				ServletOutputStream out = response.getOutputStream();
				
				
			    JasperReport reporte = (JasperReport) JRLoader.loadObject(jasperStream);
			    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaUsuarios));
			    JRXlsxExporter exporter = new JRXlsxExporter();
			    exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//			    exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
			    exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("D:/reportePDF.xlsx"));
			    exporter.exportReport();
		} catch (IOException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.print("SALIDAA");
	}
	
//	
//	// CFR - DEOPTL INI 03/03/2015
////		@RequestMapping(value = "/ExpCoord")
//	    public void obtenerListado(Model model,HttpSession session,HttpServletRequest request, HttpServletResponse response,@RequestParam("codUnicom") String codUnicom,
//	    		@RequestParam("rutas") String rutas,@RequestParam("codEmpresa") String codEmpresa, 
//	    		@RequestParam("numItin") String numItin,  
//	    		@RequestParam("flecturaInicio") String flecturaInicio, @RequestParam("flecturaFinal") String flecturaFinal) throws ServletException, IOException, Exception{
//		
//		    if(codUnicom.equals("") || codUnicom.equals(" , ")|| codUnicom.equals(" "))
//		    	codUnicom=null;
//		    if(rutas.equals(""))
//		    	rutas=null;
//		    if(codEmpresa.equals(""))
//		    	codEmpresa=null;	 
//		    if(numItin.equals(""))
//		    	numItin=null;		
//		    if(flecturaInicio.equals(""))
//		    	flecturaInicio=null;	
//		    if(flecturaFinal.equals(""))
//		    	flecturaFinal=null;		
//
////		    List <EnviosGPS> listaEnvio=servicioEnvioGPS.listarCoordenadas(codUnicom,rutas,numItin,flecturaInicio,flecturaFinal,null,codEmpresa);
//
//				model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
//				 String fecha;
//			        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//				String Reporte=null;
//		        Map<String, Object> parametros = new HashMap<String, Object>();
//		        
//				Reporte="reporteCoordenadas.jasper";
//				parametros.put("images", request.getRealPath("/resources/images/imagen.jpg"));
//			    InputStream jasperStream = servletContext.getResourceAsStream("/resources/jasper/"+Reporte);
//			    
//			    fecha = sdf.format(Calendar.getInstance().getTime());
//			    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//				// response.setContentType("application/x-download" );
//				// response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
//				response.setHeader("Content-Disposition", "attachment; filename=\"Info-Coordenadas-"+fecha+".xlsx\";");
//				
//				ServletOutputStream out = response.getOutputStream();
//				
//				
//			    JasperReport reporte = (JasperReport) JRLoader.loadObject(jasperStream);
//			    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaEnvio));
//			    JRXlsxExporter exporter = new JRXlsxExporter();
//			    exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//			    exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, out);
//			    exporter.exportReport();
//			    
//			   
////				byte [] abc=JasperExportManager.exportReportToPdf(jasperPrint);
////				ServletOutputStream sos=response.getOutputStream();
////				response.setContentType("application/pdf");
////				response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");
////				sos.write(abc,0,abc.length);
////				sos.flush();
////				sos.close();
//			
//		}

}
