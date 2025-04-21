package com.blogapplication.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Role {
	@Id
	private int id;
	private String name;
	
	
}
