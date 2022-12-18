package com.ReCykleApp.module;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ReCykleApp.FunctionModule.AskForDonation;
import com.ReCykleApp.FunctionModule.BookingQueue;
import com.ReCykleApp.FunctionModule.Delivery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationBox {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "u_id", referencedColumnName = "userId")
	private User donatedBy;

	@JsonIgnore
	private LocalDateTime registerTime;

	@JsonIgnore
	private LocalDateTime expiDateTime;

	private Double price;

	@ManyToOne
	@JoinColumn(name = "Address", referencedColumnName = "id")
	private Addresses addresses;

	@ManyToOne
	@JoinColumn(name = "category", referencedColumnName = "id")
	private DCategory category;

	// the product that donate =? Book, Cloth, Food
	private Integer subCategoryId;

	@OneToMany(mappedBy = "donationId", cascade = CascadeType.ALL)
	private List<Delivery> deliveries = new ArrayList<>();

	@OneToMany(mappedBy = "donationId", cascade = CascadeType.ALL)
	private List<AskForDonation> askForDonations = new ArrayList<>();


	@OneToMany(mappedBy = "donationId", cascade = CascadeType.ALL)
	private List<BookingQueue> bookingQueue = new ArrayList<>();

	
}
