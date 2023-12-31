package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double salary;
	private String jobTitle;
	private Date birthDate;
	
	private Sector sector;
	
	public Employee () {
	}

	public Employee(Integer id, String name, Double salary, String jobTitle, Date birthDate, Sector sector) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.jobTitle = jobTitle;
		this.birthDate = birthDate;
		this.sector = sector;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", jobTitle=" + jobTitle
				+ ", birthDate=" + birthDate + ", sector=" + sector + "]";
	}
	
	
}
