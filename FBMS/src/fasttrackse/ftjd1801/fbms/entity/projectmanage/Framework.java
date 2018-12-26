package fasttrackse.ftjd1801.fbms.entity.projectmanage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Framework generated by hbm2java
 */
@Entity
@Table(name = "framework", catalog = "project")
public class Framework implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idFramework;
	private String technology;
	private String describes;

	public Framework() {
	}

	public Framework(String technology, String describes) {
		this.technology = technology;
		this.describes = describes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_framework", unique = true, nullable = false)
	public Integer getIdFramework() {
		return this.idFramework;
	}

	public void setIdFramework(Integer idFramework) {
		this.idFramework = idFramework;
	}

	@Column(name = "technology", length = 45)
	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Column(name = "describes", length = 65535)
	public String getDescribes() {
		return this.describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

}
