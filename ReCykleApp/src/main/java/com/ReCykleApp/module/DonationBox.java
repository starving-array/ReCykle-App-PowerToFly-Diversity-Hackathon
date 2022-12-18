package com.ReCykleApp.module;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ReCykleApp.FunctionModule.AskForDonation;
import com.ReCykleApp.FunctionModule.BookingQueue;
import com.ReCykleApp.FunctionModule.Delivery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
