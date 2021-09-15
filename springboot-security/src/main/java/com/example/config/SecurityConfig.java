package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dhl
 * @datetime 2021/8/3  16:39
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制授权的规则
        // 启用密码验证
        http.authorizeRequests()
                // 首页所有人可以访问，功能页面只有有权限的人才可以访问
                .antMatchers("/").permitAll()
                // vip1用户访问才能
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 开启登录页面
        http.formLogin();
        // 开启记住我功能，cookie默认保存两周
        http.rememberMe().rememberMeParameter("remember");
        // 防止网站功能
        http.csrf().disable();
        // 开启登出功能，登出成功返回主页面
        http.logout().logoutSuccessUrl("/");
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // 开启密码编码（因为我们的密码是java文件发送出去的，而要得到密码就需要很简单的反编译即可，因此我们就需要对其进行更换编码格式）
                .passwordEncoder(new BCryptPasswordEncoder())
                // 添加用户的认证设置，用户名，密码，权限
                .withUser("wenze").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
                // 添加and()方法可以在之后继续添加其他的认证设置
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}