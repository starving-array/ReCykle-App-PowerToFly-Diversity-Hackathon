package com.ReCykleApp.donateModule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cloth {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String sex;

	private Integer quantity;

	private String description;

	private String size;
}
