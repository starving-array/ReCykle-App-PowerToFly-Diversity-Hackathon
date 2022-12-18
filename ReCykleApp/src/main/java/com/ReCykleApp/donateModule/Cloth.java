package com.ReCykleApp.donateModule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
