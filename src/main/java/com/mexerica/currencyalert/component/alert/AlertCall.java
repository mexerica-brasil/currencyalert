package com.mexerica.currencyalert.component.alert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.studio.v2.flow.Execution;

@Component("call")
public class AlertCall implements StrategyAlert {
    
    @Value("${twilio.account-sid}")
    private String sid;

    @Value("${twilio.auth-token}")
    private String token;

    @Value("${twilio.to-phone}")
    private String toPhone;

    @Value("${twilio.from-phone}")
    private String fromPhone;

    @Value("${twilio.call-service-sid}")
    private String callServiceSid;

    public void sendAlert(String texto) {
        Twilio.init(sid, token);
        
        Execution execution = Execution.creator(callServiceSid,
                                                new com.twilio.type.PhoneNumber(toPhone),
                                                new com.twilio.type.PhoneNumber(fromPhone))
                                        .create();
        System.out.println(execution.getSid()); 
    }
}
