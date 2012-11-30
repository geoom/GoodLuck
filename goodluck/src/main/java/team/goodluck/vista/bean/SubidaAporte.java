package team.goodluck.vista.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import team.goodluck.modelo.objetosnegocio.Aporte;
import team.goodluck.modelo.servicio.IAporteServicio;

@Controller
@Scope("request")
public class SubidaAporte implements java.io.Serializable{

	private static final long serialVersionUID = 428086400898999067L;
	static final Logger log = Logger.getLogger(SubidaAporte.class);
	private Aporte aporte;
	private String contexto;
	@Autowired
	private IAporteServicio aporteServicio;

	public void init() {
		aporte = new Aporte();
	}

	public void subirAporte() {
		aporteServicio.registrarAporte(aporte, obtenerContexto());
	}

	private List<String> obtenerContexto() {
		String[] etiquetas = contexto.split(",");
		return Arrays.asList(etiquetas);
	}

}
