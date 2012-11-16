package team.goodluck.modelo.objetosnegocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persona", catalog = "GOODLUCK-DATA")
public class Persona implements java.io.Serializable {

	private static final long serialVersionUID = -6392380033713383485L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_persona", unique = true, nullable = false)
	private Integer id;
	@Column(name = "per_nombre", nullable = false, length = 50)
	private String nombre;
	@Column(name = "per_apellido_paterno", nullable = false, length = 20)
	private String apellidoPaterno;
	@Column(name = "per_apellido_materno", nullable = false, length = 20)
	private String apellidoMaterno;
	@Temporal(TemporalType.DATE)
	@Column(name = "per_fecha_nacimiento", nullable = false, length = 10)
	private Date fechaNacimiento;
	@Column(name = "per_sexo", nullable = false)
	private byte sexo;
	@Column(name = "per_correo_electronico", nullable = false, length = 50)
	private String correoElectronico;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Persona() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public byte getSexo() {
		return sexo;
	}

	public void setSexo(byte sexo) {
		this.sexo = sexo;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
