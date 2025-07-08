package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "https://regrutacija.netlify.app")
public class DialogflowWebhookController {

    @PostMapping("/webhook")
    public Map<String, Object> webhook(@RequestBody Map<String, Object> request) {
        Map<String, Object> queryResult = (Map<String, Object>) request.get("queryResult");
        String userMessage = (String) queryResult.get("queryText");

        String responseText = "Nisam razumeo poruku.";

        if (userMessage.toLowerCase().contains("pomoć")) {
            responseText = "Naravno, tu sam da pomognem!";
        } else if (userMessage.toLowerCase().contains("zdravo")) {
            responseText = "Zdravo! Kako mogu da ti pomognem?";
        }

        Map<String, Object> response = new HashMap<>();
        response.put("fulfillmentText", responseText);

        return response;
    }
    @GetMapping("/webhook")
    public String testWebhook() {
        return "Webhook endpoint je aktivan. Koristi POST zahtev da šalješ podatke.";
    }

}