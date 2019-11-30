package ie.com.Conor.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Bid")

public class Bid {
	public Bid(double d) {
		// TODO Auto-generated constructor stub
		this.bidValue = d;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bidId;
	
	
	public double bidValue;
	
	@ManyToOne
	private Job bidJob;

	
	@ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Job jobId;

	@ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserDetails userDetails;
	
	
	public Bid(int bidValue, Job jobId, UserDetails userDetails) {
		this.bidValue = bidValue;
		this.jobId = jobId;
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "Bid [value=" + bidValue + ", job="+ jobId + "User=" + userDetails + "]";
	}

	
}
