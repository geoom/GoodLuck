package team.goodluck.vista.bean;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Usuario;
import team.goodluck.modelo.servicio.IUsuarioServicio;

@Controller
@Scope("request")
public class EdicionUsuarioBean implements java.io.Serializable{
	static final Logger log = Logger.getLogger(EdicionUsuarioBean.class);
    private Usuario usuario;
    @Autowired
    private IUsuarioServicio usuarioServicio;
    @Autowired
    @Qualifier("accesoBean")
    private AccesoBean accesoBean;
    
    @PostConstruct
    public void init(){
    	usuario=accesoBean.getUsuario();
    	System.out.println("INYECCION FUNCIONA---------------------------"+usuario.getId()+usuario.getNombre());
    }
    
    public void editarUsuario(){
     usuarioServicio.actualizarUsuario(usuario);	
     accesoBean.setUsuario(usuario);
    }

    public String cancelar(){
     return "home.xmtl";	
    }
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
