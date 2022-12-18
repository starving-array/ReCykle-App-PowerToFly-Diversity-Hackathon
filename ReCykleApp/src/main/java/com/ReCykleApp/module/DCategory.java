package com.ReCykleApp.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
