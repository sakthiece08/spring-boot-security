# spring-boot-security

Levering spring-boot-3.x which uses below Spring security libraries:

1. spring-security-core-6.1.4
2. spring-security-web-6.1.4
3. spring-security-config-6.1.4

## In-Memeory
Class **InMemoryUserDetailsManager** implements UserDetailsManager, UserDetailsPasswordService

## JDBC
Class **JdbcUserDetailsManager** extends JdbcDaoImpl implements UserDetailsManager, GroupManager 

Default schema path:
 "org/springframework/security/core/userdetails/jdbc/**users.ddl**";
