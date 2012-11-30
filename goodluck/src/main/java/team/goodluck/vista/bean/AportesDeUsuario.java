package team.goodluck.vista.bean;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAporteServicio;

@Controller
@Scope("view")
public class AportesDeUsuario implements java.io.Serializable{

	private static final long serialVersionUID = -1697701904710973739L;
	static final Logger log = Logger.getLogger(BusquedaBean.class);
	private List<Aporte> aportesDeUsuario;
	private Aporte aporteSeleccionado;
	private Usuario usuarioLogeado;
	@Autowired
	private IAporteServicio aporteServicio;
	
	public void init(){
//		cargarAportes();
	}
	
	private void cargarAportes(){
		aportesDeUsuario=aporteServicio.encontrarAportesDeUsuario(usuarioLogeado);
	}

	public List<Aporte> getAportesDeUsuario() {
		return aportesDeUsuario;
	}

	public void setAportesDeUsuario(List<Aporte> aportesDeUsuario) {
		this.aportesDeUsuario = aportesDeUsuario;
	}

	public Aporte getAporteSeleccionado() {
		return aporteSeleccionado;
	}

	public void setAporteSeleccionado(Aporte aporteSeleccionado) {
		this.aporteSeleccionado = aporteSeleccionado;
	}
	
}
