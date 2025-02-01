package org.jsp.zomato.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvalidUserIdException extends RuntimeException{
	
	private String message="Invalid Id";
	@Override
	public String getMessage() {
		return this.message;
	}

}
