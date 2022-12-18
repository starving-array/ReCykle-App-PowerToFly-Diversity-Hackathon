package com.ReCykleApp.FunctionModule;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ReCykleApp.module.DonationBox;
import com.ReCykleApp.module.User;

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
