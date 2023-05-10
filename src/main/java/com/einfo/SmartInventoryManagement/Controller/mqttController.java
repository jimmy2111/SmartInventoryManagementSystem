package com.einfo.SmartInventoryManagement.Controller;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.SmartInventoryManagement.Model.Order;
import com.einfo.SmartInventoryManagement.Model.Product;
import com.einfo.SmartInventoryManagement.Repo.BuyerRepo;
import com.einfo.SmartInventoryManagement.Repo.OrderRepo;
import com.einfo.SmartInventoryManagement.Services.BuyerServices;
import com.einfo.SmartInventoryManagement.Services.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;



@RestController

public class mqttController {

	@Autowired
	private BuyerRepo buyerRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private MqttClient mqttClient;
	
	@Autowired
	private BuyerServices buyerService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/publish")
	public void getpublish(@RequestBody Order order) throws MqttException, Exception {
		String topic="my/topic";
		ObjectMapper mapper=new ObjectMapper();
		String message=mapper.writeValueAsString(order);
		MqttMessage mqttMessage=new MqttMessage(message.getBytes());
		mqttClient.publish(topic,mqttMessage);
		System.out.println(mqttMessage);
	}
	@PostConstruct
	public void getSubscribe() throws MqttException,Exception{
		mqttClient.subscribe("my/topic", new IMqttMessageListener() {
	        @Override
	        public void messageArrived(String topic, MqttMessage message) throws Exception {
	            // handle the received message here
	        	
	            String payload = new String(message.getPayload());
	            ObjectMapper mapper=new ObjectMapper();
	            Order order=mapper.readValue(payload, Order.class);
	            orderRepo.save(order);
	            JSONObject jsonObject=new JSONObject(payload);
	            System.out.println(jsonObject.getInt("product_Id"));
	            System.out.println(jsonObject.getInt("product_quantity"));
	            
	            Product product=buyerService.getProductById(jsonObject.getInt("product_Id"));
	            System.out.println(product);
	            int leftQuantity=product.getProductquantity() - jsonObject.getInt("product_quantity");
	            int threshold = product.getProductthreshold();
	            System.out.println(threshold);
	            product.setProductquantity(leftQuantity);
	            buyerRepo.save(product);
	            System.out.println("Received message: " + payload + " product " + product);
	            if(leftQuantity < threshold) {
	            emailService.sendEmail("akshatgandhi1111@gmail.com","threshold" , "The product id is "+ product + " product quantity left is" + leftQuantity);
	            }
	          }
	    });
	}



@RequestMapping("/send/{productId}")
public void sendToDevice(@PathVariable Integer productId) throws MqttException, JsonProcessingException {
    String topic = "devices/messages";
    Product product = buyerRepo.findById(productId).orElse(null);
    //System.out.println(product);
    String message = "Product ID: " + productId ;
    MqttMessage mqttMessage = new MqttMessage(message.getBytes());
    
    mqttClient.publish(topic, mqttMessage);
}
    
    @PostConstruct
    public void subscribeToDevice() throws MqttException {
        String topic = "devices/messages";
        mqttClient.subscribe(topic, new IMqttMessageListener() {
        	@Override
        	public void messageArrived(String topic, MqttMessage message) throws Exception {
        	    String payload = new String(message.getPayload());
        	    //System.out.println(payload);
        	    Integer productId = null;
        	    Pattern pattern = Pattern.compile("\\d+"); // regular expression to match digits
        	    Matcher matcher = pattern.matcher(payload);
        	    if (matcher.find()) {
        	        productId = Integer.parseInt(matcher.group());
        	    }
        	    Product product = buyerRepo.findById(productId).orElse(null);
        	    System.out.println("Received message: " + payload + " for product: " + product);
        	}
        });
    }

}