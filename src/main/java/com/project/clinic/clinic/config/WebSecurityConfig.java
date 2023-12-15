//package com.project.clinic.clinic.config;
//
//import org.apache.catalina.realm.AuthenticatedUserRealm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig implements WebMvcConfigurer {
//
//        @Autowired
//        private DataSource dataSource;
//        @Autowired
//        public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
//            authBuilder.jdbcAuthentication()
//                    .dataSource(dataSource)
//                    ;
//        }
//
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests((requests) -> requests
//                            .requestMatchers("/").permitAll()
//                            .requestMatchers("/patientcreate").permitAll()
//                            .requestMatchers("/adminlogin").permitAll()
//                            .requestMatchers("/doctrologin").permitAll()
//                            .requestMatchers("/test").permitAll()
//                            .requestMatchers("/patientlogin").permitAll()
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