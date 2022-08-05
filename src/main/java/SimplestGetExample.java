import java.util.ArrayList;
import java.util.Arrays;

import com.example._3_1_5.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;

public class SimplestGetExample {

    static final String URL = "http://94.198.50.185:7081/api/users";
    static RestTemplate restTemplate = new RestTemplate();
//
//    static final String createUser = "http://94.198.50.185:7081/api/users";
//    static final String URL_EMPLOYEES_JSON = "http://localhost:8080/employees.json";
    public static void main(String[] args) {

//    HttpHeaders headers = new HttpHeaders();
//
//		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
//		headers.setContentType(MediaType.APPLICATION_JSON);
//    HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
//            HttpMethod.GET, entity, String.class);
//    List<String> cookies = response.getHeaders().get("Set-Cookie");
//    String result = response.getBody();
//		System.out.println(result);
//
//
//    User user = new User(3L,"James","Brown", (byte) 21);
//
//    RestTemplate rest = new RestTemplate();
//
//    headers.set("Cookie", cookies.stream().collect(Collectors.joining(";")));
//    HttpEntity<User> requestBody = new HttpEntity<>(headers);
//
//    ResponseEntity<User> result1
//            = restTemplate.exchange(createUser,HttpMethod.POST, requestBody, User.class);
//
//        Object result2 = result1.getBody();
//        System.out.println(result2.toString());
        useExchangedMethodsOfRestTemplate();
    }
    private static void useExchangedMethodsOfRestTemplate(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	    headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
///////////////////////////////////////////////////////////////////////////
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL,
                HttpMethod.GET,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userlist = responseEntity.getBody();
        System.out.println("response body - " + userlist);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");
        System.out.println("/////////////////////////////////////////////////////////////////////////////");
        System.out.println(cookies);

        System.out.println("response headers - " + responseHeaders);
        //////////////////////////////////////////////////////
        User user = new User(3L,"James","Brown",(byte)8);
        headers.set("Cookie", responseHeaders.toString());
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        System.out.println("headers - " + headers);
        requestEntity = new HttpEntity<>(user, headers);
        System.out.println("requestEntity " + requestEntity);
        ResponseEntity<String> response = restTemplate.postForEntity(URL,
                requestEntity,
                String.class);
        HttpStatus statusCode2 = response.getStatusCode();
        System.out.println("status code - " + statusCode2);
        String userDetails = response.getBody();
        System.out.println("user object - " + userDetails);
        HttpHeaders responseHeaders2 = response.getHeaders();
        System.out.println("response headers - " + responseHeaders2);
    }


    }
//        ResponseEntity<User> responseUser = restTemplate.exchange(URL,
//                HttpMethod.GET,
//                requestEntity,
//                User.class);
//        User userBody = responseUser.getBody();
//        System.out.println("user object - " + userBody);