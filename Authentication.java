package Auth;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, String> users = new HashMap<>();

    public void register(String username, String password) {
        users.put(username, password);
        System.out.println("User registered: " + username);
    }

    public boolean login(String username, String password) {
        return users.getOrDefault(username, "").equals(password);
    }
}
