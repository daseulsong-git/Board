package com.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	
}
