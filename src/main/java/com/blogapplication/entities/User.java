package com.blogapplication.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	@Size(min = 4,message = "Username must be minimum of 4 Characters")
	@Column(name="user_name",nullable=false,length=100)
	private String name;
	@NotEmpty
	@Email(message ="Email address is not valid !!")
	private String email;
	@NotEmpty
	@Size(min = 5 ,max = 100 , message = "Password must be of length >=5 and <= 100")
	private String password;
	@NotEmpty
	private String about;

	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user",referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="role",referencedColumnName="id"))
	private Set<Role> roles = new HashSet<>();

}
