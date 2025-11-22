package org.example.outh2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("/secure")
    public String securePage(Authentication authentication) {
        if(authentication instanceof OAuth2AuthenticationToken oauthToken){
            System.out.println("=== OAuth Login ===");
            System.out.println("Provider = " + oauthToken.getAuthorizedClientRegistrationId());

            oauthToken.getPrincipal().getAttributes().forEach((key, value) -> {
                System.out.println(key + " = " + value);
            });
        }
        return "secure.html"; // ضع HTML صالح هنا
    }
}
