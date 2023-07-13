https://medium.com/@truongbui95/jwt-authentication-and-authorization-with-spring-boot-3-and-spring-security-6-2f90f9337421
https://www.javaguides.net/2023/05/spring-boot-spring-security-jwt-mysql.html#:~:text=It%20is%20a%20compact%2C%20self,signature%20contained%20within%20the%20JWT.

POST-  http://localhost:8080/api/auth/login
{
    "username":"user",
    "password":"user"
}

GET - http://localhost:8080/getAllEmployee
request  Header
Authorization :  Bearer {{Token}}

Note :- change values of middle(.[changevalue].) of the token to verify it is valid or not.