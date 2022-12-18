package com.ReCykleApp.module;

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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
