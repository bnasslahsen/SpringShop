package fr.training.spring.shop.web.utils;

import org.slf4j.Logger;

public class Utils {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Utils.class);

	public static String getUri(RestClientProperties clientProperties, String uri) {
		StringBuilder sb = new StringBuilder();
		sb.append(clientProperties.getUrl());
		sb.append(clientProperties.getApiPath());
		sb.append(uri);
		LOG.info("URL is '" + sb.toString() + ".");
		return sb.toString();
	}
}
