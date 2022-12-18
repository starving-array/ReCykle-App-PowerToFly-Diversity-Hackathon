package com.ReCykleApp.module;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

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
public class Addresses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank
	private String houseNo; // dao search

	@NotBlank
	private String floorNo;

	@NotBlank
	private String contact;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PIN", referencedColumnName = "id")
	private PostalCodes postalCode; // dao search

	@OneToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
	private List<DonationBox> donationBoxs = new ArrayList<>();

}
