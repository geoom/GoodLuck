package team.goodluck.vista.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.servicio.IAporteServicio;

@Controller
@Scope("request")
public class BusquedaBean implements java.io.Serializable {

	private static final long serialVersionUID = 1118996546649913694L;
	private String contexto;
	private String descripcion;
	private List<Aporte> resultadosBusqueda;
	@Autowired
	private IAporteServicio aporteServicio;

	@PostConstruct
	public void init() {
		descripcion = " ";
	}
	
	public String obtenerContexto() {
		String[] etiquetas = contexto.split(",");
		for (String s : etiquetas) {
			System.out.println(s);
		}
		resultadosBusqueda = aporteServicio.encontrarAportesPorContextoTitulo(descripcion, Arrays.asList(etiquetas));
		for (Aporte a : resultadosBusqueda) {
			System.out.println(a.getId());
		}
		return "resultados.xhtml";
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Aporte> getResultadosBusqueda() {
		return resultadosBusqueda;
	}

	public void setResultadosBusqueda(List<Aporte> resultadosBusqueda) {
		this.resultadosBusqueda = resultadosBusqueda;
	}

}
