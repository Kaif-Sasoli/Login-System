
package loginsystem.model;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;
import java.util.ArrayList;

public class Users {
    @XmlElement(name = "user")
    private List<User> users = new ArrayList<>();
    
    
    public List<User> getUsers() {
        return users;
    }
}
