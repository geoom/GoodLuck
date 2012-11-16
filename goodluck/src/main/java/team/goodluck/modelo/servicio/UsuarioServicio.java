package team.goodluck.modelo.servicio;

import java.util.Map;
import org.springframework.stereotype.Service;

import team.goodluck.modelo.objetosnegocio.Usuario;

/**
 * 
 * @author GEORGE MEJIA
 */
@Service
public class UsuarioServicio implements IUsuarioServicio {

	@Override
	public Usuario cargar() {

		return null;
	}

	@Override
	public boolean autentificar(Map<String, String> datosUsuario) {
		String nombreEsperado = "gmejia";
		String claveEsperado = "sistemas";
		
		System.out.println(nombreEsperado + " :: " +claveEsperado);
		boolean habilitado = Boolean.TRUE;
		if (nombreEsperado.equals(datosUsuario.get("nombre").toString())
				&& claveEsperado.equals(datosUsuario.get("clave").toString())
				&& habilitado) {
			return true;
		}
		return false;
	}

}
