package com.example.pzs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfiguration {

    @Bean
    PasswordEncoder passwordEncoder() {
//        String idForEncode = "bcrypt";
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put(idForEncode, new BCryptPasswordEncoder());
//        encoders.put("noop", NoOpPasswordEncoder.getInstance());
//        encoders.put("sha256", new StandardPasswordEncoder());
//        return new DelegatingPasswordEncoder(idForEncode, encoders);
//
//        return NoOpPasswordEncoder.getInstance();
//
        return new BCryptPasswordEncoder();
    }

}
