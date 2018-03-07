package fr.training.spring.shop.ws;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculControllerWS {

	@RequestMapping(value = "/somme/{a}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public int sommer(@PathVariable("a") int a, int b) {
		return a + b;
	}
}
