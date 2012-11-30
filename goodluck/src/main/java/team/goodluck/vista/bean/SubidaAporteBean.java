package team.goodluck.vista.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.servicio.IAporteServicio;

@Controller
@Scope("request")
public class SubidaAporteBean implements java.io.Serializable {

	private static final long serialVersionUID = 428086400898999067L;
	static final Logger log = Logger.getLogger(SubidaAporteBean.class);
	private Aporte aporte;
	private UploadedFile archivoPortada; // imagen
	private UploadedFile archivoAporte; // pdf
	private String contexto;
	@Autowired
	private IAporteServicio aporteServicio;

	private String rutaDestinoImagen = "C:\\GOODLUCK\\IMAGEN\\";
	private String rutaDestinoAporte = "C:\\GOODLUCK\\APORTE\\";

	@PostConstruct
	public void init() {
		aporte = new Aporte();
		archivoAporte = new DefaultUploadedFile();
	}
	
	public String accionSubirAporte() {
		String destino = "aportes";
		almacenar(archivoPortada, rutaDestinoImagen);
		almacenar(archivoAporte, rutaDestinoAporte);
		// aporteServicio.registrarAporte(aporte, obtenerContexto());
		return destino;
	}
	
	public void almacenar(UploadedFile archivo,String rutaAlmacen){
		try {
			copyFile(archivo.getFileName(),
					archivo.getInputstream(),rutaAlmacen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<String> obtenerContexto() {
		String[] etiquetas = contexto.split(",");
		return Arrays.asList(etiquetas);
	}

	public void copyFile(String fileName, InputStream in, String rutaAlmacen) {
		try {
			log.trace("intentando copiar");
			OutputStream out = new FileOutputStream(new File(rutaAlmacen
					+ fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("Nuevo archivo almacenado!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Aporte getAporte() {
		return aporte;
	}

	public void setAporte(Aporte aporte) {
		this.aporte = aporte;
	}

	public UploadedFile getArchivoPortada() {
		return archivoPortada;
	}

	public void setArchivoPortada(UploadedFile archivoPortada) {
		this.archivoPortada = archivoPortada;
	}

	public UploadedFile getArchivoAporte() {
		return archivoAporte;
	}

	public void setArchivoAporte(UploadedFile archivoAporte) {
		this.archivoAporte = archivoAporte;
	}

}
