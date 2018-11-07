package ucanuup.cc.config.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// https://blog.csdn.net/change_on/article/details/79521488  depends on 
// https://www.jianshu.com/p/e6655328b211 更加的详细具体解释 security 的基础配置信息
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests() 
                //我们指定任何用户都可以访问多个URL的模式。
                //任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL。                                                     
               .antMatchers("/out/**","/resources/**", "/signup", "/about/**", "/article/**", "/bbs/**", "/login", "/home","/index","/").permitAll()     

                //以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
                // 请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。               
               .antMatchers("/admin/**").hasRole("ADMIN")               
    
               //任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
               //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。              
               .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")       

               //任何以"/db/" 开头的URL只需要拥有 "ROLE_ADMIN" 和 "ROLE_DBA"其中一个权限的用户才可以访问。
               //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。          
               .antMatchers("/db/**").hasAnyRole("ADMIN", "DBA")    

                //尚未匹配的任何URL都要求用户进行身份验证
                .anyRequest().authenticated() 
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("username")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
