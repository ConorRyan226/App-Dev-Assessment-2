package ie.com.Conor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	private String userEmail;
	@Column
	private String roleDescription;
} //ADD @DATA

