package fasttrackse.ftjd1801.fbms.entity.projectmanage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="technology", catalog = "project")
public class Technology implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTechnology;
	private String nameTechnology;
	private String note;
	
	public Technology() {
		
	}

	public Technology( String nameTechnology, String note) {
		this.nameTechnology = nameTechnology;
		this.note = note;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "id_technology", unique = true, nullable = false)
	public Integer getIdTechnology() {
		return this.idTechnology;
	}
	public void setIdTechnology (Integer idTechnology) {
		this.idTechnology = idTechnology;
	}
	
	@Column(name = "name_technology", length = 45)
	@NotNull
	public String getNameTechnology() {
		return nameTechnology;
	}

	public void setNameTechnology(String nameTechnology) {
		this.nameTechnology = nameTechnology;
	}
	
	@Column(name = "note", length = 45)
	@NotNull
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
