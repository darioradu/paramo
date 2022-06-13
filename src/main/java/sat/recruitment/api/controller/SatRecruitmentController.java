package sat.recruitment.api.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sat.recruitment.dao.DuplicatedException;
import sat.recruitment.service.IUserService;

@RestController
@RequestMapping(value = "/api/v1")
public class SatRecruitmentController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping(value = "/create-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createUser(@Valid @RequestBody User messageBody) {

		try {
			userService.save(messageBody);
		}catch(DuplicatedException de) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, de.getMessage());
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
	}

}
