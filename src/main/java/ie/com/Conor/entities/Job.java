package ie.com.Conor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public Job(String jobTitle, String jobDesc, UserDetails userDetails) {
		// TODO Auto-generated constructor stub
		this.jobTitle = jobTitle;
		this.jobDesc = jobDesc;
		this.userDetails = userDetails;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int jobId;
	

	@Column(nullable=false)
	private String jobTitle;

	@Column(nullable=false)
	private String jobDesc;
	
	@OneToMany( mappedBy="job", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Bid> bids = new ArrayList<Bid>();
	
	@ManyToOne
	UserDetails userDetails;
}
