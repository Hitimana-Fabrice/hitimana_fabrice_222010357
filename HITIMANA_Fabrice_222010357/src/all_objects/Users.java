package all_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Users {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String name;
    private String age;
    private Object gender;
    private String contactNumber;
    private String address;

    public Users() {}

    public Users(int userId, String username, String password, String email, String name, String age, Object gender,
                String contactNumber, String address) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/smart_health_management_system";
        String username = "222010357";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }

    public void insertData() {
        String sql = "INSERT INTO Users (Username, Password, Email, Name, Age, Gender, ContactNumber, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, this.username);
            statement.setString(2, this.password);
            statement.setString(3, this.email);
            statement.setString(4, this.name);
            statement.setString(5, this.age);
            statement.setObject(6, this.gender);
            statement.setString(7, this.contactNumber);
            statement.setString(8, this.address);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "User inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert user!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readWithUserId(int inputUserId) {
        String sql = "SELECT * FROM Users WHERE User_id = ?";
        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, inputUserId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                this.username = resultSet.getString("Username");
                this.password = resultSet.getString("Password");
                this.email = resultSet.getString("Email");
                this.name = resultSet.getString("Name");
                this.age = resultSet.getString("Age");
                this.gender = resultSet.getObject("Gender");
                this.contactNumber = resultSet.getString("ContactNumber");
                this.address = resultSet.getString("Address");
            } else {
                JOptionPane.showMessageDialog(null, "No user found with User_id: " + inputUserId, "Read Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(int inputUserId) {
        String sql = "UPDATE Users SET Username=?, Password=?, Email=?, Name=?, Age=?, Gender=?, ContactNumber=?, Address=? WHERE User_id=?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, this.username);
            preparedStatement.setString(2, this.password);
            preparedStatement.setString(3, this.email);
            preparedStatement.setString(4, this.name);
            preparedStatement.setString(5, this.age);
            preparedStatement.setObject(6, this.gender);
            preparedStatement.setString(7, this.contactNumber);
            preparedStatement.setString(8, this.address);
            preparedStatement.setInt(9, inputUserId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No user found with User_id: " + inputUserId, "Update Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int inputUserId) {
        String sql = "DELETE FROM Users WHERE User_id=?";
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, inputUserId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "Delete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No user found with User_id: " + inputUserId, "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void login() {
	       
        if (isValidUser(email, password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid username or password");
        }
    }
    
    private boolean isValidUser(String email, String password) {
        // TODO: Implement your user validation logic here
        // This could involve checking credentials against a database, file, or other storage
        
        // Example validation (replace with your actual logic):
        return email.equals("admin") && password.equals("password");
    }



}
