package sat.recruitment.api.controller;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class User {
	@NotNull(message = "Field name is required")
	private String name;
	@NotNull(message = "Field email is required")
	private String email;
	@NotNull(message = "Field address is required")
	private String address;
	@NotNull(message = "Field phone is required")
	private String phone;
	private String userType;
	private Double money;
	
	public User() {
		
	}

	public User(String name, String email, String phone, String address, String userType, Double money) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.userType = userType;
		this.money = money;
	}
	
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if( !(o instanceof User) )
			return false;
		User user = (User)o;
		
		return  (  StringUtils.equalsIgnoreCase(email, user.getEmail()) 
				|| StringUtils.equalsIgnoreCase(phone, user.getPhone())
				|| (StringUtils.equalsIgnoreCase(name, user.getName())  && StringUtils.equalsIgnoreCase(address, user.getAddress()) )
				);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, money, name, phone, userType);
	}

}
