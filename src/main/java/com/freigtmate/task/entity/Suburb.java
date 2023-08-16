package com.freigtmate.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 *  @author hitesh.bidve
 *  @implnote Suburb Entity class for data operations. Here Builder pattern used with 
 *            lombok functionality.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Suburb
{
	/*
	 * Here we are using Id with GeneratedValue annotation with strategy IDENTITY for 
	 * telling our DB to store primary key in the identity column which is a default 
	 * column in SQL for default auto incremented primary key generation. 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	/*
	 * Applying contraints through validation @NotBlank & @Column annotations.
	 */
	@NotBlank(message = "Please Enter atleast one character")
	@Column(name = "SuburbName", unique = true)
	private String suburbName;
	
	/*
	 * Applying contraints through validation @Size & @Column annotations.
	 */
	@Size(min = 6, message = "Enter Minimum 6 character",max = 6)
	@Column(name = "PostCode")
	private String postCode;

}
