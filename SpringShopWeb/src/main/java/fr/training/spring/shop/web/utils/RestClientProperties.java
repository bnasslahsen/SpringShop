package fr.training.spring.shop.web.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * REST client properties.
 */
@Component
public class RestClientProperties {

	@Value("#{ restProperties['ws.api'] }")
	private String apiPath;

	@Value("#{ systemProperties['ws.url'] != null ? systemProperties['ws.url'] : restProperties['ws.url'] }")
	private String url;

	/**
	 * Gets base URI for the REST APIs.
	 */
	public String getApiPath() {
		return apiPath;
	}

	/**
	 * Gets URL.
	 */
	public String getUrl() {
		return url;
	}

}