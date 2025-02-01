package org.jsp.zomato.exceptionclasses;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvalidCredentialException extends RuntimeException{
	String message="Invalid Credentials";

	@Override
	public String getMessage() {
		return this.message;
	}

}
