package test;

public class UserResponse {

    private String email;
    private String pw;

    private UserRole userRole;
    public UserResponse(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public UserResponse(String email, String pw, UserRole userRole) {
        this.email = email;
        this.pw = pw;
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Object getRole() {
        return null;
    }
}
