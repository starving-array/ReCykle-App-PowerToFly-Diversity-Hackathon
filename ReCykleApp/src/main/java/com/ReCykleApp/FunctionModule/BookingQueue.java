package com.ReCykleApp.FunctionModule;

import java.time.LocalDateTime;

import com.ReCykleApp.module.DonationBox;
import com.ReCykleApp.module.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class BookingQueue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDateTime takenTime;
	private Integer qunatity;

	@ManyToOne
	@JoinColumn(name = "u_id", referencedColumnName = "userId")
	private User bookedBy;

	@Enumerated(EnumType.ORDINAL)
	private STATUS status;

	@ManyToOne
	@JoinColumn(name = "d_id", referencedColumnName = "id")
	private DonationBox donationId;
}
