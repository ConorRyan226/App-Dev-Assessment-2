package ie.com.Conor.Form;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//test class
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobForm {
	
	@Size(min=2, max=30)
	private String jobTitle;
	@Size(min=2, max=30)
	private String jobDesc;
	private int jobId;;
	
}
