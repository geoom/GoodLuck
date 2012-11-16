package team.goodluck.modelo.servicio;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:testingContext.xml"})
public class UsuarioServicioTester extends AbstractTestNGSpringContextTests {

	private static Logger log = Logger.getLogger(UsuarioServicioTester.class);

	@Autowired
	private IUsuarioServicio usuarioServicio;

	Map<String, String> datosRecogidos;

	private Map<String, String> crearDatos(String nombreUsuario, String clave) {
		Map<String, String> datosUsuario = new HashMap<String, String>();
		datosUsuario.put("nombre",nombreUsuario);
		datosUsuario.put("clave",clave);
		return datosUsuario;
	}

	@BeforeClass
	public void beforeClass() {
		log.debug("BeforeClass ejecutandose...");
	}
	
	@BeforeTest
    public void beforeTest() {
		log.debug("BeforeTest ejecutandose...");
	}
	
	@BeforeMethod
    public void beforeMethod() {
		log.debug("BeforeMethod ejecutandose...");
	}	

	@Test
	public void usuarioDeberiaSerValido() {
		datosRecogidos = crearDatos("gmejia", "sistemas");
		Assert.assertEquals(true, usuarioServicio.autentificar(datosRecogidos));
	}
	
	@Test
	public void usuarioNoDeberiaSerValido(){
		datosRecogidos = crearDatos("cualquira", "23456");
		Assert.assertEquals(false, usuarioServicio.autentificar(datosRecogidos));
	}
	
	@AfterClass
    public void afterClass() {
		log.debug("AfterClass ejecutandose...");
	}
	
	@AfterTest
    public void afterTest() {
		log.debug("AfterTest ejecutandose...");
	}
	
	@AfterMethod
    public void afterMethod() {
		log.debug("AfterMethod ejecutandose...");
	}

}
