
package loginsystem.model;
import java.util.Random;
import java.lang.Exception;

public class User {
 
    private int userId;
    private String fullName;
    private String email;
    private String gender;
    private String password;
    private int age;
    
    public User () {
        this("", "", "", "", 0);
    }
    public User(String fullName, String email, String gender, String password, int age)  {
              
        Random random = new Random();
         this.userId =  1 + random.nextInt(999);
         this.fullName = fullName;
         this.email = email;
         this.gender = gender;
         this.password = password;
         this.age = age;
    }
    
    // Methods
    public int getUserId() {
        return userId;
    }
    
    
    public String getFullName() {
        return fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getPassword() {
        return password;
    }
    
    
    public int getAge() {
        return age;
    }
    
    public void setUserId(int id) {
        this.userId = id;
    }
    
    public void setFullName(String name) {
         this.fullName = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void setAge (int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "User [UserId: " + userId + ", FullName: " + fullName + ", Email: " + email +
                ", Gender: " + gender + ", Password: " + password + ", Age: " + age + "]";
    }
   
}
