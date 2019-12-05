package ie.com.Conor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "USER_DETAILS")
public class UserDetails {
	public UserDetails(String firstName, String lastName, String email, String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email= email;
			this.password = password;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	public UserDetails(String firstName, String lastName, String email, String password,
		boolean userEnabled, Role userRole) {

	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.userEnabled = userEnabled;
	this.userRole = userRole;
}
	@Column
	@NotNull
	@Email
	private String email;
	
	@Column
	@Size(min=8)
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	private boolean userEnabled;
	
	@OneToOne
	@JoinColumn(name = "roleEmail")
	Role userRole;
	
	@OneToMany
	@JsonIgnore
	List<Job> userJobs;
	
	@OneToMany
	@JsonIgnore
    private List<Bid> bids = new ArrayList<Bid>();
}