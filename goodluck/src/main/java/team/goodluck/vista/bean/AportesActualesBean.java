package team.goodluck.vista.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.ISugerenciaServicio;

@Controller
@Scope("session")
public class AportesActualesBean implements java.io.Serializable{

	private static final long serialVersionUID = 8513834785095024478L;
	static final Logger log = Logger.getLogger(AportesActualesBean.class);
	private List<Aporte> aportesMasBuscados;
	private Usuario usuarioLogeado;
	private Aporte aporteSeleccionado;
	@Autowired
	private ISugerenciaServicio sugerenciaServicio;

	@PostConstruct
	public void init(){
//		cargarAportesActuales();
	}
	
	private void cargarAportesActuales(){
		aportesMasBuscados=sugerenciaServicio.obtenerLoMasActual(usuarioLogeado);
	}

	public List<Aporte> getAportesMasBuscados() {
		return aportesMasBuscados;
	}

	public void setAportesMasBuscados(List<Aporte> aportesMasBuscados) {
		this.aportesMasBuscados = aportesMasBuscados;
	}

	public Aporte getAporteSeleccionado() {
		return aporteSeleccionado;
	}

	public void setAporteSeleccionado(Aporte aporteSeleccionado) {
		this.aporteSeleccionado = aporteSeleccionado;
	}
	
	
	
}
