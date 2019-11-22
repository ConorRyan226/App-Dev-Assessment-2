package ie.com.Conor.entities;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "JOB")

public class Job {
	
	public Job(String jobTitle, String jobDesc, UserDetails user) {
		// TODO Auto-generated constructor stub
		this.jobTitle = jobTitle;
		this.jobDesc = jobDesc;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobId;
	private String jobTitle;
	private String jobDesc;
	
	@OneToMany
	List<Bid> jobBids;
	//	@NotNull @Size(max = 10) add these to a form package 
	
	@ManyToOne
	UserDetails user;
}
