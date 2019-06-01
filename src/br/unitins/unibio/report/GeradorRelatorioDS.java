package br.unitins.unibio.report;

import java.io.OutputStream;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class GeradorRelatorioDS {

	private String nomeArquivo;
	private Map<String, Object> params;
	private JRBeanCollectionDataSource dataSource;

	public GeradorRelatorioDS(String nomeArquivo, Map<String, Object> params, JRBeanCollectionDataSource dataSource) {
		this.nomeArquivo = nomeArquivo;
		this.params = params;
		this.dataSource = dataSource;
	}

	public void geraPDFRelatorio(OutputStream outputStream) {
		try {

			JasperPrint jasperPrint = JasperFillManager.fillReport(this.nomeArquivo + ".jasper", this.params,
					this.dataSource);

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
}
