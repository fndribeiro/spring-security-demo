# Spring Security Demo
Spring Boot project with Spring Security for studying purposes.

This project covers Authentication, Authorization, Users, Roles, CORs, CSRF, Filters, JWT and OAUTH2.

## Features:

a) Cloud MongoDB server as database to store users. It's configuration and password must be set in environment variables.

b) Bcrypt for password hashing.

c) Custom authentication provider that checks user granted authorities.

d) Custom validation filter that checks if username has "test" in it.

e) Token based authentication with JWT.

f) Oauth2 Github as authorization server. Client secret and client id must be set in environment variables.

g) Method security.

h) Some endpoints are protected, others are not or depends on roles.

# All credits to Eazy Bytes!

This project is built following the Udemy course by https://github.com/eazybytes:

https://www.udemy.com/course/spring-security-zero-to-master/
