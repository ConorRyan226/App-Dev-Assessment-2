package ie.com.Conor.Form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
	
	@Size(min=2, max=30)
	private String firstName;
	@Size(min=2, max=30)
	private String lastName;
	private String email;
	@Size(min=4, max=10)
	private String password;
	
}
