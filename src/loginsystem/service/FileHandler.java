
package loginsystem.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import loginsystem.model.User;
import loginsystem.model.Users;
import jakarta.xml.bind.JAXB;
import java.io.BufferedWriter;
import loginsystem.utils.AlertUtils;


public class FileHandler {


        private static final Path FILE_PATH = Paths.get(
        System.getProperty("user.home"), ".loginSystem", "user.xml");
        
        
        public static boolean saveUser(User user) throws IOException {
            
          Files.createDirectories(FILE_PATH.getParent());
          Users users = new Users();
          
          
          if(Files.exists(FILE_PATH) && Files.size(FILE_PATH) > 0) {
              try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
                  users = JAXB.unmarshal(reader, Users.class);
            }
          
            // Check user Exists?
            for (User u : users.getUsers()){
              if(user.getEmail().equalsIgnoreCase(u.getEmail())) {
                  AlertUtils.showWarning("User Already Exist");
                  return false;
              }
          }
              
      }
         
        // Overwrite file
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
               users.getUsers().add(user);
              JAXB.marshal(users, writer);
        }
        
        return true;
    }
        
        
    public static Users loadUsers() throws IOException {
        
        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)){
            
          Users users = JAXB.unmarshal(reader, Users.class);
          return users;
        }
    }
    
    public static boolean deleteUser(User user) throws IOException {
         Users users;

    try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
        users = JAXB.unmarshal(reader, Users.class);
    }

        boolean removed = users.getUsers().removeIf(u ->
        u.getEmail().equalsIgnoreCase(user.getEmail())
    );

        if (removed) {
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
            JAXB.marshal(users, writer);
        }
        return true;
    }

        return false; 
    }
        
}
