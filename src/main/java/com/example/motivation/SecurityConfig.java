package com.example.motivation;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

    http.formLogin(login -> login                                   //フォーム認証の設定記述開始
        .loginProcessingUrl("/user/login")            //ユーザー名、パスワードの送信先URL
        .loginPage("/user/login")                        //ログイン画面のURL
        .usernameParameter("username")           //ユーザ名のリクエストパラメータ名を設定
        .passwordParameter("password")           //パスワードのリクエストパラメータ名を設定
        .defaultSuccessUrl("/motivation/index")  //ログイン成功後のリダイレクト先URL
        .failureUrl("/login?error")       //ログイン失敗後のリダイレクト先URL
        .permitAll()                                                //ログイン画面は未ログインでもアクセス可能
    ).logout(logout -> logout                                       //ログアウトの設定記述開始
            .logoutSuccessUrl("/login")           //ログアウト成功後のリダイレクト先URL
    ).authorizeHttpRequests(authz -> authz                          //URLごとの認可設定記述開始
      .mvcMatchers("/user/new").permitAll()
      .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
      .permitAll()                                                  //cssなどはログインなしでもアクセス可能
      .anyRequest().authenticated()
    );

    return http.build();
  }

  @Bean
  public PasswordEncoder PasswordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
