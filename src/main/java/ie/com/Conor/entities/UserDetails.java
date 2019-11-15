package ie.com.Conor.entities;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
	private int id;
	
	@Column(nullable=false, unique=true)
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@OneToMany
	List<Job> userJobs;
	
	@OneToMany(fetch = FetchType.EAGER)
	//private Bid bids;
	List<Bid> bids;
}