//package com.project.clinic.clinic.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig  {
//
//        @Autowired
//        //private DataSource dataSource;
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests((requests) -> requests
//                            .requestMatchers("/").permitAll()
//                            .requestMatchers("/patientcreate").permitAll()
//                            .requestMatchers("/Sigin").permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .formLogin((form) -> form
//                            .loginPage("/login")
//                            .permitAll()
//                    )
//                    .logout((logout) -> logout.permitAll());
//
//            return http.build();
//        }
//
//
//        @Bean
//        public PasswordEncoder passwordEncoder(){
//            return new BCryptPasswordEncoder();
//        }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
//        return (web) ->web.ignoring().requestMatchers("/assets/**","/forms/**");
//    }
//
//}
