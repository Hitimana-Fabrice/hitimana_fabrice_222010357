package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Excerciselogs {
                    private int Log_id ;
					private  String User_id;
					private  String Date;
					private String ExerciseType;
					private String DurationMinutes;
					private String CaloriesBurned;
					 public Excerciselogs()  {}
					public Excerciselogs(int Log_id ,  String User_id,  String Date, String ExerciseType, String DurationMinutes,
							String CaloriesBurned) {
						this.Log_id  = Log_id ;
						this.User_id = User_id;
						this.Date = Date;
						this.ExerciseType = ExerciseType;
						this.DurationMinutes =DurationMinutes;
						this.CaloriesBurned = CaloriesBurned;
						
					}
					public Excerciselogs(String User_id,  String Date, String ExerciseType, String DurationMinutes,
							String CaloriesBurned) {
						this.User_id = User_id;
						this.Date = Date;
						this.ExerciseType = ExerciseType;
						this.DurationMinutes =DurationMinutes;
						this.CaloriesBurned = CaloriesBurned;
					}
				
				public int getLog_id() {
						return Log_id;
					}
					public void setLog_id(int log_id) {
						Log_id = log_id;
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
					public String getExerciseType() {
						return ExerciseType;
					}
					public void setExerciseType(String exerciseType) {
						ExerciseType = exerciseType;
					}
					public String getDurationMinutes() {
						return DurationMinutes;
					}
					public void setDurationMinutes(String durationMinutes) {
						DurationMinutes = durationMinutes;
					}
					public String getCaloriesBurned() {
						return CaloriesBurned;
					}
					public void setCaloriesBurned(String caloriesBurned) {
						CaloriesBurned = caloriesBurned;
					}
					//Method to establish database connection
					private Connection getConnection() throws SQLException {
					    String url = "jdbc:mysql://localhost/smart_health_management_system";
					    String User= "222010357";
					    String password = "";
					    return DriverManager.getConnection(url, User, password);
					}
					public void insertData() {
					    String sql = "INSERT INTO exerciselogs (User_id, Date, ExerciseType, DurationMinutes, CaloriesBurned) VALUES (?, ?, ?, ?, ?)";
					    try (Connection con = getConnection();
					            PreparedStatement statement = con.prepareStatement(sql)) {
					        statement.setString(1, this.User_id);
					        statement.setString(2, this.Date);
					        statement.setString(3, this.ExerciseType);
					        statement.setString(4, this.DurationMinutes);
					        statement.setString(5, this.CaloriesBurned);
					        int rowsInserted = statement.executeUpdate();
					        if (rowsInserted > 0) {
					            JOptionPane.showMessageDialog(null, "Exercise log inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
					        } else {
					            JOptionPane.showMessageDialog(null, "Failed to insert exercise log!", "Error", JOptionPane.ERROR_MESSAGE);
					        }
					    } catch (SQLException e) {
					        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
					    }
					}
					public void readWithLogID(int inputLogID) {
					    String sql = "SELECT * FROM exerciselogs WHERE Log_id = ?";
					    try (Connection con = getConnection();
					         PreparedStatement statement = con.prepareStatement(sql)) {
					        statement.setInt(1, inputLogID);
					        ResultSet resultSet = statement.executeQuery();
					        if (resultSet.next()) {
					            this.User_id = resultSet.getString("User_id");
					            this.Date = resultSet.getString("Date");
					            this.ExerciseType = resultSet.getString("ExerciseType");
					            this.DurationMinutes = resultSet.getString("DurationMinutes");
					            this.CaloriesBurned = resultSet.getString("CaloriesBurned");
					        } else {
					            JOptionPane.showMessageDialog(null, "No data found with Log ID: " + inputLogID, "Read Error", JOptionPane.ERROR_MESSAGE);
					        }
					    } catch (SQLException e) {
					        JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
					    }
					}

					    public void update(int inputLog_id ) {
					   	 
					       String sql = "UPDATE exerciselogs SET User_id=?, Date=?,ExerciseType=?,DurationMinutes=?,CaloriesBurned=? WHERE Log_id =?";

					       try (Connection con = getConnection();
					               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					           preparedStatement.setString(1, this.User_id);
					           preparedStatement.setString(2, this.Date);
					           preparedStatement.setString(3, this.ExerciseType);
					           preparedStatement.setString(4, this.DurationMinutes);
					           preparedStatement.setString(5, this.CaloriesBurned);
					           preparedStatement.setInt(6, inputLog_id );

					           int rowsAffected = preparedStatement.executeUpdate();

					           if (rowsAffected > 0) {
					               JOptionPane.showMessageDialog(null, "Data update successfully!", "After upDate", JOptionPane.INFORMATION_MESSAGE);
					           } else {
					               JOptionPane.showMessageDialog(null, "No data found with Excerciselogs: " + inputLog_id , "UpExerciseType Error", JOptionPane.ERROR_MESSAGE);
					           }
					       } catch (SQLException e) {
					           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
					       }
					   }

					   public void delete(int inputLog_id ) {
					  
					       String sql = "DELETE FROM exerciselogs WHERE Log_id =?";

					       try (Connection con = getConnection();
					               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					           preparedStatement.setInt(1, inputLog_id );

					           int rowsAffected = preparedStatement.executeUpdate();

					           if (rowsAffected > 0) {
					               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
					           } else {
					               JOptionPane.showMessageDialog(null, "No data found with Excerciselogs : " + inputLog_id , "Delete Error", JOptionPane.ERROR_MESSAGE);
					           }
					       } catch (SQLException e) {
					           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
					       }
					   }
					}






