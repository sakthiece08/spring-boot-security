# spring-boot-security

Levering spring-boot-3.x which uses below Spring security libraries:

1. spring-security-core-6.1.4
2. spring-security-web-6.1.4
3. spring-security-config-6.1.4

## In-Memeory

In the previous versions of Spring, we used to extend **WebSecurityConfigureAdapter** class and override below methods:

- configure(AuthenticationManagerBuilder)
- configure(HttpSecurity)
  
In Spring-security 6, we extend the class **InMemoryUserDetailsManager** implements UserDetailsManager, UserDetailsPasswordService

**SecurityFilterChain** and **InMemoryUserDetailsManager** beans to be configured as shown below:

<img width="1710" alt="image" src="https://github.com/sakthiece08/spring-boot-security/assets/41096775/71c0860d-3107-42c2-8184-224432179624">


## JDBC
Class **JdbcUserDetailsManager** extends JdbcDaoImpl implements UserDetailsManager, GroupManager 

Default schema path:
 "org/springframework/security/core/userdetails/jdbc/**users.ddl**";
