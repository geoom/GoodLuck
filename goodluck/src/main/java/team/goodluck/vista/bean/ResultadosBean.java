package team.goodluck.vista.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resources;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;

@Controller
@Scope("request")
public class ResultadosBean implements java.io.Serializable{

	private static final long serialVersionUID = -3740210894626070539L;
	static final Logger log = Logger.getLogger(ResultadosBean.class);
	private List<Aporte> resultadosBusqueda;
	private Aporte aporteSeleccionado;
	
	
//	@PostConstruct	
//	public void init(){
//		aporteSeleccionado=new Aporte();
//		for (Aporte a : resultadosBusqueda) {
//			System.out.println("------------ResultadosBEAN-------");
//			System.out.println(a.getId());
//		}
//	}
	
	public void seleccionarAporte(){
	}

	public List<Aporte> getResultadosBusqueda() {
		return resultadosBusqueda;
	}

	public void setResultadosBusqueda(List<Aporte> resultadosBusqueda) {
		this.resultadosBusqueda = resultadosBusqueda;
	}

	public Aporte getAporteSeleccionado() {
		return aporteSeleccionado;
	}

	public void setAporteSeleccionado(Aporte aporteSeleccionado) {
		this.aporteSeleccionado = aporteSeleccionado;
	}
	
}
