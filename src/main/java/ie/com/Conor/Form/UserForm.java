package ie.com.Conor.Form;

import javax.validation.constraints.NotNull;
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
public class UserForm {
	@NotNull
	@Size(min=1, max=30)
	private String firstName;	
	private String lastName;
	private String email;
	private String password;
	
}
