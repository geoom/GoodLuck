package team.goodluck.vista.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.objetosnegocio.Etiqueta;
import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IAccesoServicio;
import team.goodluck.modelo.servicio.IAporteServicio;
import team.goodluck.modelo.servicio.ISugerenciaServicio;
import team.goodluck.modelo.servicio.IUsuarioServicio;

@Controller
@Scope("session")
public class UsuarioBean implements Serializable {

	static final Logger log = Logger.getLogger(UsuarioBean.class);
	private static final long serialVersionUID = 1900209508848559649L;
	private String clave;
	private Boolean habilitado;
	private String nombre;
	private Usuario usuario;
	
	@Autowired
	private IAporteServicio aporteServicio;

	@Autowired
	private IUsuarioServicio usuarioServicio;

	@Autowired
	private IAccesoServicio accesoServicio;
	
	@Autowired
	private ISugerenciaServicio sugerenciaServicio;

	@PostConstruct
	public void init() {
		habilitado = Boolean.TRUE;
		usuario=new Usuario();
	}

	public void validarIdentidad() {
//		if (accesoServicio.validarIdentidad(usuario)) {
//			log.debug("usuario identificado !");
//		} else {
//			log.debug("usuario NO identificado !!");
//		}
	}

	public void registrarBusqueda(){
//		sugerenciaServicio.registrarBusqueda(new Usuario(3), new Etiqueta(2));	
	}

	public void registrarAporte(){
		Aporte ap=new Aporte();
		ap.setTitulo("DCE");
		List<Etiqueta> etiquetas=new ArrayList<Etiqueta>();
		etiquetas.add(new Etiqueta(3));
		etiquetas.add(new Etiqueta(4));
		etiquetas.add(new Etiqueta(5));
		ap.setEtiquetas(etiquetas);
		ap.setUsuario(new Usuario(1));  
//		aporteServicio.registrarAporte(ap);
	}
	
	public void encontrarAportes(){
	 List<Aporte> aportesEncontrados=new ArrayList<Aporte>();
//	 aportesEncontrados=aporteServicio.encontrarAportesPorContextoTitulo("DCE","Programacion");
	 for(Aporte a:aportesEncontrados){
	  System.out.println(a.getId());	 
	 }
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}