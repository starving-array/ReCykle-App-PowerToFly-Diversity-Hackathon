package com.ReCykleApp.module;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String categoryName;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<DonationBox> donationBoxs;
}
