package com.mexerica.currencyalert.component.alert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component("zap")
public class AlertZap implements StrategyAlert {

    @Value("${twilio.account-sid}")
    private String sid;

    @Value("${twilio.auth-token}")
    private String token;

    @Value("${twilio.whatsapp-service-sid}")
    private String whatsappServiceSid;
    
    @Value("${twilio.whatsapp-to-phone}")
    private String whatsappToPhone;


    public void sendAlert(String texto) {
        Twilio.init(sid, token);
        Message message = Message.creator(new PhoneNumber(whatsappToPhone),
                                            whatsappServiceSid,
                                            texto) .create();

        System.out.println(message.getSid());   // Implement Zapier integration here
    }
}