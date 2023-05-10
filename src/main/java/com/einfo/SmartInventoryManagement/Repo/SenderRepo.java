package com.einfo.SmartInventoryManagement.Repo;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.einfo.SmartInventoryManagement.Model.Sender;

public interface SenderRepo extends MongoRepository<Sender, String>{
	
}
