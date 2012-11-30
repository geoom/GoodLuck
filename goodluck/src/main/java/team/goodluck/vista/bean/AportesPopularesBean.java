package team.goodluck.vista.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.servicio.ISugerenciaServicio;

@Controller
@Scope("singleton")
public class AportesPopularesBean implements java.io.Serializable {

	private static final long serialVersionUID = -8413762390410533127L;
	static final Logger log = Logger.getLogger(AportesPopularesBean.class);
	private List<Aporte> aportesMasVotados;
	private Aporte aporteSeleccionado;
	@Autowired
	private ISugerenciaServicio sugerenciaServicio;

	@PostConstruct
	public void init() {
		 cargarAportesPopulares();
	}

	private void cargarAportesPopulares() {
		aportesMasVotados = sugerenciaServicio.obtenerLoMasVotado();
	}

	public List<Aporte> getAportesMasVotados() {
		return aportesMasVotados;
	}

	public void setAportesMasVotados(List<Aporte> aportesMasVotados) {
		this.aportesMasVotados = aportesMasVotados;
	}

	public Aporte getAporteSeleccionado() {
		return aporteSeleccionado;
	}

	public void setAporteSeleccionado(Aporte aporteSeleccionado) {
		this.aporteSeleccionado = aporteSeleccionado;
	}

}
