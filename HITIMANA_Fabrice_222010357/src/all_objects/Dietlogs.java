package all_objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Dietlogs {

    private int LogID;
    private String User_id;
    private String Date;
    private String MealType;
    private String FoodItem;
    private String Quantity;
    private String CaloriesConsumed;

    public Dietlogs() {
    }

    public Dietlogs(int LogID, String User_id, String Date, String MealType, String FoodItem, String Quantity,
            String CaloriesConsumed) {
        this.LogID = LogID;
        this.User_id = User_id;
        this.Date = Date;
        this.MealType = MealType;
        this.FoodItem = FoodItem;
        this.Quantity = Quantity;
        this.CaloriesConsumed = CaloriesConsumed;
    }

    public Dietlogs(String User_id, String Date, String MealType, String FoodItem, String Quantity,
            String CaloriesConsumed) {
        this.User_id = User_id;
        this.Date = Date;
        this.MealType = MealType;
        this.FoodItem = FoodItem;
        this.Quantity = Quantity;
        this.CaloriesConsumed = CaloriesConsumed;
    }
     
    
    public int getLogID() {
		return LogID;
	}

	public void setLogID(int logID) {
		LogID = logID;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getMealType() {
		return MealType;
	}

	public void setMealType(String mealType) {
		MealType = mealType;
	}

	public String getFoodItem() {
		return FoodItem;
	}

	public void setFoodItem(String foodItem) {
		FoodItem = foodItem;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getCaloriesConsumed() {
		return CaloriesConsumed;
	}

	public void setCaloriesConsumed(String caloriesConsumed) {
		CaloriesConsumed = caloriesConsumed;
	}

	private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/smart_health_management_system";
        String user = "222010357";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void insertData() {
        String sql = "INSERT INTO dietlog (User_id, Date, MealType, FoodItem, Quantity, CaloriesConsumed) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, this.User_id);
            statement.setString(2, this.Date);
            statement.setString(3, this.MealType);A
            statement.setString(4, this.FoodItem);
            statement.setString(5, this.Quantity);
            statement.setString(6, this.CaloriesConsumed);
            
            int rowsInserted = statement.executeUpdate();
            
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Dietlog inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert dietlog!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readWithLogID(int inputLogID) {
        String sql = "SELECT * FROM dietlog WHERE LogID = ?";
        try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, inputLogID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.User_id = resultSet.getString("User_id");
                this.Date = resultSet.getString("Date");
                this.MealType = resultSet.getString("MealType");
                this.FoodItem = resultSet.getString("FoodItem");
                this.Quantity = resultSet.getString("Quantity");
                this.CaloriesConsumed = resultSet.getString("CaloriesConsumed");
            } else {
                JOptionPane.showMessageDialog(null, "No data found with LogID: " + inputLogID, "Read Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(int inputLogID) {
        String sql = "UPDATE dietlog SET User_id = ?, Date = ?, MealType = ?, FoodItem = ?, Quantity = ?, CaloriesConsumed = ? WHERE LogID = ?";
        try (Connection con = getConnection(); PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, this.User_id);
            preparedStatement.setString(2, this.Date);
            preparedStatement.setString(3, this.MealType);
            preparedStatement.setString(4, this.FoodItem);
            preparedStatement.setString(5, this.Quantity);
            preparedStatement.setString(6, this.CaloriesConsumed);
            preparedStatement.setInt(7, inputLogID);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No data found with LogID: " + inputLogID, "Update Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int inputLogID) {
        String sql = "DELETE FROM dietlog WHERE LogID = ?";
        try (Connection con = getConnection(); PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, inputLogID);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "Delete Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No data found with LogID: " + inputLogID, "Delete Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

