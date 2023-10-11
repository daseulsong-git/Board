package com.board.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id 				
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	private String content;	
	
	private Date regDate = new Date();
	
	private int cnt;	
}
