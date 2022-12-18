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
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String type;

	private Integer mealCount;

	private String description;
}
