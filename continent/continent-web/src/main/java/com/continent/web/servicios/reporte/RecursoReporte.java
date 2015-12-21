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
				JasperReport reporte = (JasperReport) JRLoader.loadObject(jasperStream);
			    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaUsuarios));
			    JRXlsxExporter exporter = new JRXlsxExporter();
			    exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			    exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("D:/reportePDF.xlsx"));
			    exporter.exportReport();
		} catch (IOException | JRException e) {
			
			e.printStackTrace();
		}
		 System.out.print("SALIDAA");
	}
}
