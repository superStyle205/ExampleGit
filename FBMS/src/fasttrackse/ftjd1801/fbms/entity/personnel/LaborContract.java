package fasttrackse.ftjd1801.fbms.entity.personnel;
// Generated Dec 26, 2018 8:20:37 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LaborContract generated by hbm2java
 */
@Entity
@Table(name = "labor_contract", catalog = "project")
public class LaborContract implements java.io.Serializable {

	private Integer idContract;
	private String typeOfContract;
	private Integer dayOfRest;
	private String monthlySalary13;
	private Integer idEmployee;

	public LaborContract() {
	}

	public LaborContract(String typeOfContract, Integer dayOfRest, String monthlySalary13, Integer idEmployee) {
		this.typeOfContract = typeOfContract;
		this.dayOfRest = dayOfRest;
		this.monthlySalary13 = monthlySalary13;
		this.idEmployee = idEmployee;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_contract", unique = true, nullable = false)
	public Integer getIdContract() {
		return this.idContract;
	}

	public void setIdContract(Integer idContract) {
		this.idContract = idContract;
	}

	@Column(name = "typeOfContract", length = 45)
	public String getTypeOfContract() {
		return this.typeOfContract;
	}

	public void setTypeOfContract(String typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	@Column(name = "dayOfRest")
	public Integer getDayOfRest() {
		return this.dayOfRest;
	}

	public void setDayOfRest(Integer dayOfRest) {
		this.dayOfRest = dayOfRest;
	}

	@Column(name = "monthlySalary13", length = 45)
	public String getMonthlySalary13() {
		return this.monthlySalary13;
	}

	public void setMonthlySalary13(String monthlySalary13) {
		this.monthlySalary13 = monthlySalary13;
	}

	@Column(name = "id_employee")
	public Integer getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

}
