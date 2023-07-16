package com.gl.tta.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Tickets")
@NoArgsConstructor

public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tile")
	private String title;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "content")
	private String content;

	@Column(name = "create_date")
	private Date createDate;

}
