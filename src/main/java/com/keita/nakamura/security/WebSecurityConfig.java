package com.keita.nakamura.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.keita.nakamura.service.LoginUserDetailsService;

/**
 * WebSecurity設定
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginUserDetailsService loginUserDetailsService;

    /**
     * パスワードのアルゴリズムをBCryptに設定
     * フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * 静的リソースの設定(WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //静的リソースをセキュリティ対象外に設定
        web.ignoring().antMatchers("/css/**", "/js/**", "/assets/**", "/webjars/**");
    }

    /**
     * HTTPリクエストの設定(HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // ログイン不要でアクセス可能に設定
                .antMatchers("/login", "/companies/index", "/users/**").permitAll()
                // 上記以外は直リンク禁止
                .anyRequest().authenticated()
            .and()
            .formLogin()
                // ログイン処理のパス
                .loginProcessingUrl("/login")
                // ログインページ
                .loginPage("/login")
                // ログイン時のキー：名前
                .usernameParameter("name")
                // ログイン時のパスワード
                .passwordParameter("password")
                // ログイン画面でフォームを送信する際のURL
                .loginProcessingUrl("/login")
                // ログイン成功時の遷移先
                .defaultSuccessUrl("/companies/index", true)
                // ログインエラー時の遷移先 ※パラメーターに「error」を付与
                .failureUrl("/login?error")
            .and()
            .logout()
                .logoutUrl("/logout")
                // ログアウト時の遷移先 POSTでアクセス
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    /**
     * ユーザー名・パスワード。ロールの設定(AuthenticationManager)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth
            .userDetailsService(loginUserDetailsService);
//            .inMemoryAuthentication()
//                .withUser("user").password(encoder.encode("password")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder.encode("password")).roles("ADMIN");
    }
}
