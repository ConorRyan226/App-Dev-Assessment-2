package ie.com.Conor.Form;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BidForm {

	@NotNull
	private int bidId;
	private int bidValue;
	private int jobId;

	private int userId;
}