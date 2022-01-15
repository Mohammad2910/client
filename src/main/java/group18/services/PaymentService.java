package group18.services;

import group18.domain.Payment;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class PaymentService {

	//building the client and the target
	Client client = ClientBuilder.newClient();
	WebTarget target = client.target("http://localhost:8080/payment");

	/**
	 * Add payment
	 *
	 * @param costumerId
	 * @param merchantId
	 * @param amount
	 */
	public void add(String costumerId, String merchantId, String amount) {
		Payment payment = new Payment(costumerId, merchantId, amount);
		Response response  = target
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(payment, MediaType.APPLICATION_JSON));
	}

	/**
	 * Get a list of payments
	 */
	public ArrayList<Payment> getList() {
		return target.path("list").request().get(new GenericType<ArrayList<Payment>>() {});
	}
}
