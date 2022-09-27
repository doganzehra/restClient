package com.bilgeadam.restClient;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bilgeadam.restClient.model.Ogretmen;

/**
 * Hello world!
 *
 */
public class App {
	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		// getByIdExchange();
		// getById();
		// save();
		// deleteById();
		// getAllEski();
		// getAll();
		// findByName();
		// getByWithHeader();

		// localhost:8080/ogretmen/getAll
		// localhost:8080/ogretmen/getById/1
		// localhost:8080/ogretmen/getBy?id=1
		// localhost:8080/ogretmen/findByName?name=ze
		// localhost:8080/ogretmen/getByWithHeader
		// localhost:8080/ogretmen/save
		// localhost:8080/ogretmen/deleteById/1
	}

	public static void getByWithHeader() {
		String url = "http://localhost:8080/ogretmen/getByWithHeader";
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", "1");
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		ResponseEntity<Ogretmen> response = restTemplate.exchange(url, HttpMethod.GET, entity, Ogretmen.class);
		Ogretmen ogretmen = response.getBody();
		System.err.println(ogretmen.toString());
	}

	public static void findByName() {
		String url = "http://localhost:8080/ogretmen/findByName?name={name}";
		Map<String, Object> pathParameters = new HashMap<>();
		pathParameters.put("name", "ze");
		ResponseEntity<Ogretmen[]> response = restTemplate.getForEntity(url, Ogretmen[].class, pathParameters);
		Ogretmen[] body = response.getBody();
		for (Ogretmen ogretmen : body) {
			System.err.println(ogretmen);
		}
	}

	public static void getAllEski() {
		String url = "http://localhost:8080/ogretmen/getAll";
		ResponseEntity<List> response = restTemplate.getForEntity(URI.create(url), List.class);
		System.err.println(response.getBody().toString());
	}

	public static void getAll() {
		String url = "http://localhost:8080/ogretmen/getAll";
		ResponseEntity<Ogretmen[]> response = restTemplate.getForEntity(URI.create(url), Ogretmen[].class);
		System.err.println(response.getBody()[0]);
	}

	public static void save() {
		String url = "http://localhost:8080/ogretmen/save";
		Ogretmen ogretmen = new Ogretmen("Hasan", true);
		ResponseEntity<String> response = restTemplate.postForEntity(url, ogretmen, String.class);
		System.err.println(response.getBody().toString());
	}

	public static void insert() {
		RestTemplate template = new RestTemplate();
		URI url = URI.create("http://localhost:8080/ogretmen/insert");
		LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("username", "numan");
		HttpEntity<Ogretmen> request = new HttpEntity<>(new Ogretmen("Ali", true), headers);
		ResponseEntity<String> response = template.postForEntity(url, request, String.class);
		System.err.println(response.getBody() + " - " + response.getStatusCodeValue());
	}

	public static void deleteById() {
		String url = "http://localhost:8080/ogretmen/deleteById/{id}";
		Map<String, Object> pathParameters = new HashMap<>();
		pathParameters.put("id", 3);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class,
				pathParameters);
		System.err.println(response.getBody().toString());
	}

	public static void getByIdExchange() {
		// localhost:8080/ogretmen/getById/{id}
		String url = "http://localhost:8080/ogretmen/getBy?id={id}";
		Map<String, Object> pathParameters = new HashMap<>();
		pathParameters.put("id", 1);
		ResponseEntity<Ogretmen> response = restTemplate.exchange(url, HttpMethod.GET, null, Ogretmen.class,
				pathParameters);
		if (response.getStatusCode() == HttpStatus.OK) {
			Ogretmen ogretmen = response.getBody();
			System.err.println(ogretmen.toString());
		}
	}

	public static void getById() {
		String url = "http://localhost:8080/ogretmen/getById/{id}";
		Map<String, Object> pathParameters = new HashMap<>();
		pathParameters.put("id", 1);
		ResponseEntity<Ogretmen> response = restTemplate.getForEntity(url, Ogretmen.class, pathParameters);
		Ogretmen ogretmen = response.getBody();
		System.err.println(ogretmen.toString());

	}
}
