package ie.com.Conor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	private double bidValue;
	
	@ManyToOne
	private Job bidJob;
	
	@ManyToOne
	private UserDetails userBid;
	
}
