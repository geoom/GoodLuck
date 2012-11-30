package team.goodluck.vista.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAporteServicio;

@Controller
@Scope("session")
public class GestorAportesBean implements java.io.Serializable {

	private static final long serialVersionUID = -1697701904710973739L;
	static final Logger log = Logger.getLogger(BusquedaBean.class);

	private DataModel<Aporte> datosTablaAportes;
	private List<Aporte> listaAportes;

	private Aporte aporteSeleccionado;
	private Usuario usuarioLogeado;

	@Autowired
	private IAporteServicio aporteServicio;

	@PostConstruct
	public void init() {
		cargarAportes();
		datosTablaAportes = new ListDataModel<Aporte>(listaAportes);
	}

	private void cargarAportes() {
		listaAportes = aporteServicio.encontrarAportesDeUsuario(usuarioLogeado);
	}
	
	public void editarAporte(){
		Aporte aporteSeleccionado = datosTablaAportes.getRowData();
		log.debug("se procede a editar a "+ aporteSeleccionado.getTitulo());
	}
	
	public void eliminarAporte(){
		Aporte aporteSeleccionado = datosTablaAportes.getRowData();
		listaAportes.remove(aporteSeleccionado);
		log.debug("se ha eliminado a "+ aporteSeleccionado.getTitulo());
	}

	public DataModel<Aporte> getDatosTablaAportes() {
		return datosTablaAportes;
	}

	public void setDatosTablaAportes(DataModel<Aporte> datosTablaAportes) {
		this.datosTablaAportes = datosTablaAportes;
	}

	public List<Aporte> getListaAportes() {
		return listaAportes;
	}

	public void setListaAportes(List<Aporte> listaAportes) {
		this.listaAportes = listaAportes;
	}

	public Aporte getAporteSeleccionado() {
		return aporteSeleccionado;
	}

	public void setAporteSeleccionado(Aporte aporteSeleccionado) {
		this.aporteSeleccionado = aporteSeleccionado;
	}

}
