# X-Blogger

![p1](https://play-lh.googleusercontent.com/TxhHTR9swI-FYOeT_9Doi9cqN1AtkdZDNP5VoKz3ayJSAv-IUEON9skyQOoPhA7QHZlr)


# Motto
- It is a SpringBoot application which provide REST APIs to admin for posting, updating, deleting blog whereas users can comment on post.


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
- Then make change in application.properties file according to below image.
![p1](https://user-images.githubusercontent.com/103635442/224430921-04e25116-68d9-4075-9099-bbca4fee2fff.png)

- Then run the application as Spring Boot App.
- Once it starts,we can open PostMan to test the application.
- 1) To register user :
![p1](https://user-images.githubusercontent.com/103635442/224434119-5c10beb0-117a-498f-b728-98682aab4a21.png)

- 2) To Login User :
![login](https://user-images.githubusercontent.com/103635442/224434228-068e2a60-6f3d-48a8-8aec-cbc7a98b9232.png)
- You will get JWT after login successfully.
 
- 3) To Post blog : first provide blog details
![post](https://user-images.githubusercontent.com/103635442/224434339-28dcc672-2245-471f-b813-adbe5fd23c0b.png)
- Then go to header and provide in key : Authorization and in Value  : Bearer your_JWT and hit Send button.
- You can also watch all previous posted blogs ,find blog by Id etc.

