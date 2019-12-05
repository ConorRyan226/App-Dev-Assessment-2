package ie.com.Conor.entities;

import javax.persistence.Column;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bid {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bidId;
	
	@Column(nullable=false)
	public double bidValue;

	
	@ManyToOne( fetch=FetchType.EAGER)
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Job job;
	
	public Bid(int bidValue, Job job) {
		// TODO Auto-generated constructor stub
		this.bidValue = bidValue;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Bid [value=" + bidValue + ", job="+ job  + "]";
	}

	
}
