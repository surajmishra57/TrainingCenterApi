package com.example.trainingCenters.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class TrainingCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="center_id")
    private int id;
	@NotEmpty(message = "Provide Training Center Name")
	@Size(max=40,message = "Center Name must be less then 40 Characters")
	private String centerName;
	
	@Size(max=12,min=12,message = "Center Code must be 12 Characters")
	private String centerCode;
	private long capacity;
	@Autowired
	@Embedded
	private Address address;
	@OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JoinColumn(name="traing_center_id",referencedColumnName = "center_id")
	private List<Course> course;
	@NotEmpty(message = " Provide Training Center Email ")
	@Email(message = "Invalid Email")
	private String contectEmail;
	
	@Size(min=10,max=10,message="Phone Number Must Have 10 digits")
	@PositiveOrZero(message = "Provide Valid Phone Number Number")
	private String contectPhone;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	@PrePersist
	private void onCreate()
	{
		createdOn=new Date();
	}
	public TrainingCenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainingCenter(int id, String centerName, String centerCode, long capacity, Address address,
			List<Course> course, Date createdOn, String contectEmail, String contectPhone) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.capacity = capacity;
		this.address = address;
		this.course = course;
		this.createdOn = createdOn;
		this.contectEmail = contectEmail;
		this.contectPhone = contectPhone;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public  Date getStartDate() {
		return createdOn;
	}
	public void setStartDate(Date startDate) {
		this.createdOn = startDate;
	}
	public String getContectEmail() {
		return contectEmail;
	}
	public void setContectEmail(String contectEmail) {
		this.contectEmail = contectEmail;
	}
	public String getContectPhone() {
		return contectPhone;
	}
	public void setContectPhone(String contectPhone) {
		this.contectPhone = contectPhone;
	}
	@Override
	public String toString() {
		return "TrainingCenter [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode + ", capacity="
				+ capacity + ", address=" + address + ", course=" + course + ", createdOn=" + createdOn
				+ ", contectEmail=" + contectEmail + ", contectPhone=" + contectPhone + "]";
	}
	
	
	
}
