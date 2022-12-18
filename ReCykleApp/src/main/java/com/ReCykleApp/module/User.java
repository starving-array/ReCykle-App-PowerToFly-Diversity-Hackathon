package com.ReCykleApp.module;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ReCykleApp.FunctionModule.AskForDonation;
import com.ReCykleApp.FunctionModule.BookingQueue;
import com.ReCykleApp.FunctionModule.Delivery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotBlank(message = "Firstname can't be blank")
	private String Name;

	@NotBlank(message = "aadhar can't be blank")
	@Column(unique = true)
	private String aadharNo;

	@Size(max = 10, min = 10, message = "Phone should be 10 char")
	private String contact;

	// optional
	@Email(message = "Enter correct email format")
	private String email;

	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,12}$", message = "Please enter a valid password which include upperCase lowerCase specialCharector number and character between 8 to 12")
	private String password;

	@Past(message = "Date of brith can't be in future")
	private LocalDate date_of_birth;

	@JsonIgnore
	private LocalDateTime registrationDate;
	@JsonIgnore
	private LocalDateTime dateModified;
	
	
	@OneToMany(mappedBy = "donatedBy", cascade = CascadeType.ALL)
	private List<DonationBox> donationGiven = new ArrayList<>();

	

	@OneToMany(mappedBy = "donationTaken", cascade = CascadeType.ALL)
	private List<Delivery> deliveries = new ArrayList<>();

	@OneToMany(mappedBy = "donationFor", cascade = CascadeType.ALL)
	private List<AskForDonation> askForDonations = new ArrayList<>();


	@OneToMany(mappedBy = "bookedBy", cascade = CascadeType.ALL)
	private List<BookingQueue> bookingQueue = new ArrayList<>();

	

}
