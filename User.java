package IRCTC;

public class User {
    String Name;
    int Id;
    String Password;

    public User(String name, int id, String password) {
        this.Name = name;
        this.Id = id;
        this.Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Id=" + Id +
                ", Password='" + Password + '\'' +
                '}';
    }
}
