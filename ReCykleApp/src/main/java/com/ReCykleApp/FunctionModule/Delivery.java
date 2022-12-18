package com.ReCykleApp.FunctionModule;

import java.time.LocalDateTime;

import com.ReCykleApp.module.DonationBox;
import com.ReCykleApp.module.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDateTime takenTime;
	private Integer qunatity;

	@ManyToOne
	@JoinColumn(name = "u_id", referencedColumnName = "userId")
	private User donationTaken;

	@ManyToOne
	@JoinColumn(name = "d_id", referencedColumnName = "id")
	private DonationBox donationId;

}
