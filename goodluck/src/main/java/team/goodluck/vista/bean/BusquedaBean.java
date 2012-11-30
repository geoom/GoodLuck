package team.goodluck.vista.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAporteServicio;
import team.goodluck.modelo.servicio.ISugerenciaServicio;

@Controller
@Scope("request")
public class BusquedaBean implements java.io.Serializable {

	private static final long serialVersionUID = 1118996546649913694L;
	static final Logger log = Logger.getLogger(BusquedaBean.class);
	private String contexto;
	private String descripcion;
	private List<Aporte> resultadosBusqueda;
	@Autowired
	private IAporteServicio aporteServicio;
	@Autowired
	private ISugerenciaServicio sugerenciaServicio;
	@Autowired
	@Qualifier("accesoBean")
	private AccesoBean accesoBean;

	@PostConstruct
	public void init() {
		descripcion = " ";
	}

	public String obtenerResultados() {
		List<String> etiquetas=obtenerContexto();
		resultadosBusqueda = aporteServicio.encontrarAportesPorContextoTitulo(descripcion, etiquetas);
		for (Aporte a : resultadosBusqueda) {
			System.out.println(a.getId());
		}
		recordarBusquedas(etiquetas);
		return "resultados.xhtml";
	}

	private void recordarBusquedas(List<String> etiquetas){
	 	sugerenciaServicio.registrarBusqueda(accesoBean.getUsuario(), etiquetas);
	}
	
	private List<String> obtenerContexto() {
		String[] etiquetas = contexto.split(",");
		return Arrays.asList(etiquetas);
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
