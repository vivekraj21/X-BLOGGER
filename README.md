# X-Blogger

![p1](https://www.thoughtco.com/thmb/u-gOIiVS6lpM0qwOUIHywfm9VOA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Blogger_logo_wordmark-673823a10bf8471f9e4e03d320cef539.jpg)


# Motto
- It is a SpringBoot application which provide REST APIs to admin for posting, updating, deleting blog whereas users can read and comment on post.


# Features :
- Authorization is added for users using Spring Security.
- Logged In Admin can post, update, delete blog.
- Logged In User can view blogs and comment on blogs.

# Responsibility : 
- Individual Project

# Tech-Stack :
  Java | SpringBoot | Spring Security | Lombok | PostMan | MySQL | Git | Swagger | Mapper
  
# Deployment :

- Copy the code and start it into your STS.
- Then make change in application.properties file according to your mySQL username and password.

- Then run the application as Spring Boot App.
- Once it starts,you can test your APIs on postman or swagger.
- To test on swagger : Browse "http://localhost:8080/swagger-ui/index.html#/"

![swagger1](https://user-images.githubusercontent.com/103635442/234675599-ebcd1c43-4053-46bd-a66c-65ce9733ad0c.png)



- 2) To Login User :
![login](https://user-images.githubusercontent.com/103635442/224434228-068e2a60-6f3d-48a8-8aec-cbc7a98b9232.png)
- You will get JWT after login successfully.
 
- 3) To Post blog : first provide blog details
![post](https://user-images.githubusercontent.com/103635442/224434339-28dcc672-2245-471f-b813-adbe5fd23c0b.png)
- Then go to header and provide in key : Authorization and in Value  : Bearer your_JWT and hit Send button.
- You can also watch all previous posted blogs ,find blog by Id etc.

