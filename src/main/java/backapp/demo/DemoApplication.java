package backapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import backapp.demo.BackEnd.Data;
import backapp.demo.BackEnd.Response;
import backapp.demo.BackEnd.Support;

@SpringBootApplication
@RestController
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  	@GetMapping("/api")
		public ResponseEntity<Response> api() {
		Response response = new Response(1, 6, 12, 2);

		Data data1 = new Data(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg");
		response.getData().add(data1);

		Data data2 = new Data(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
		response.getData().add(data2);

		Data data3 = new Data(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg");
		response.getData().add(data3);

		Data data4 = new Data(4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg");
		response.getData().add(data4);

		Data data5 = new Data(5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg");
		response.getData().add(data5);

		Data data6 = new Data(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg");
		response.getData().add(data6);

		Support support = new Support("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
		response.setSupport(support);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*"); // add CORS header
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}
}