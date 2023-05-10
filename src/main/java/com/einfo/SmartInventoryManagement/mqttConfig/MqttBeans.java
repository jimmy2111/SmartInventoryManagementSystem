package com.einfo.SmartInventoryManagement.mqttConfig;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MqttBeans implements MqttCallback{

	@Bean
	public MqttClient mqttClient() throws MqttException {
		String brokerUrl="ssl://e6b814278d0e4c818d1739308281e242.s1.eu.hivemq.cloud:8883";
		String clientId = "mqtt-client";
		MqttClient mqttClient = new MqttClient(brokerUrl,clientId);
		MqttConnectOptions mqttConnectOptions= new MqttConnectOptions();
		mqttConnectOptions.setUserName("akshat");
		String pass="Akshat@2001";
		mqttConnectOptions.setPassword(pass.toCharArray());
		mqttClient.connect(mqttConnectOptions);
		mqttClient.setCallback(this);
		mqttClient.subscribe("my/topic");
		if(mqttClient.isConnected()) {
			System.out.println("Connection Succesfull");
		}
		return mqttClient;
	}

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	
	
}
