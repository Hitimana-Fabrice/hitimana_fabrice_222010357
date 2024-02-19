package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Healthyrecords {
                    private int RecordID ;
					private  String User_id;
					private  String Date;
					private String Height;
					private String Weight;
					private String BloodPressureSystolic;
					private String BloodPressureDiastolic;
					private String HeartRate;
					private String BloodSugarLevel;
					private String CholesterolLevel;
					 public Healthyrecords()  {}
					public Healthyrecords(int RecordID ,  String User_id,  String Date, String Height, String Weight,
							String BloodPressureSystolic,String BloodPressureDiastolic,String HeartRate,String BloodSugarLevel,String CholesterolLevel) {
						this.RecordID  = RecordID ;
						this.User_id = User_id;
						this.Date = Date;
						this.Height = Height;
						this.Weight =Weight;
						this.BloodPressureSystolic = BloodPressureSystolic;
						this.BloodPressureDiastolic = BloodPressureDiastolic;
					}
					public Healthyrecords(String User_id,  String Date, String Height, String Weight,
							String BloodPressureSystolic,String BloodPressureDiastolic,String HeartRate,String BloodSugarLevel,String CholesterolLevel) {
						this.User_id = User_id;
						this.Date = Date;
						this.Height = Height;
						this.Weight =Weight;
						this.BloodPressureSystolic = BloodPressureSystolic;
						this.BloodPressureDiastolic = BloodPressureDiastolic;
					}
					
				public int getRecordID() {
						return RecordID;
					}
					public void setRecordID(int recordID) {
						RecordID = recordID;
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
					public String getHeight() {
						return Height;
					}
					public void setHeight(String height) {
						Height = height;
					}
					public String getWeight() {
						return Weight;
					}
					public void setWeight(String weight) {
						Weight = weight;
					}
					public String getBloodPressureSystolic() {
						return BloodPressureSystolic;
					}
					public void setBloodPressureSystolic(String bloodPressureSystolic) {
						BloodPressureSystolic = bloodPressureSystolic;
					}
					public String getBloodPressureDiastolic() {
						return BloodPressureDiastolic;
					}
					public void setBloodPressureDiastolic(String bloodPressureDiastolic) {
						BloodPressureDiastolic = bloodPressureDiastolic;
					}
					public String getHeartRate() {
						return HeartRate;
					}
					public void setHeartRate(String heartRate) {
						HeartRate = heartRate;
					}
					public String getBloodSugarLevel() {
						return BloodSugarLevel;
					}
					public void setBloodSugarLevel(String bloodSugarLevel) {
						BloodSugarLevel = bloodSugarLevel;
					}
					public String getCholesterolLevel() {
						return CholesterolLevel;
					}
					public void setCholesterolLevel(String cholesterolLevel) {
						CholesterolLevel = cholesterolLevel;
					}
					//Method to establish database connection
					private Connection getConnection() throws SQLException {
					    String url = "jdbc:mysql://localhost/smart_health_management_system";
					    String User= "222010357";
					    String password = "";
					    return DriverManager.getConnection(url, User, password);
					}

					    public void insertdater() {
					        String sql = "INSERT INTO healthyrecords (User_id,Date,Height,Weight,BloodPressureSystolic,BloodPressureDiastolic,HeartRate ,BloodSugarLevel,CholesterolLevel VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
					        try (Connection con = getConnection();
					                PreparedStatement statement = con.prepareStatement(sql)) {
					            statement.setString(1, this.User_id);
					            statement.setString(2, this.Date);
					            statement.setString(3, this.Height);
					            statement.setString(4, this.Weight);
					            statement.setString(5, this.BloodPressureSystolic);
					            statement.setString(6, this.BloodPressureDiastolic);
					            statement.setString(7, this.HeartRate);
					            statement.setString(8, this.BloodSugarLevel);
					            statement.setString(9, this.CholesterolLevel);
					            int rowsInserted = statement.executeUpdate();
					            if (rowsInserted > 0) {
					                JOptionPane.showMessageDialog(null, "Healthyrecords  inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
					            } else {
					                JOptionPane.showMessageDialog(null, "Failed to insert interview!", "Error", JOptionPane.ERROR_MESSAGE);
					            }
					        } catch (SQLException e) {
					            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
					        }
					    }

					    public void readWithRecordID (int inputRecordID ) {
					    	
					        String sql = "SELECT * FROM healthyrecords WHERE RecordID  = ?";

					        try (Connection con = getConnection();
					                PreparedStatement statement = con.prepareStatement(sql)) {
					            statement.setInt(1, inputRecordID );

					            ResultSet resultSet = statement.executeQuery();

					            if (resultSet.next()) {
					                this.User_id = resultSet.getString("User_id");
					                this.Date = resultSet.getString("Date");
					                this.Height = resultSet.getString("Height");
					                this.Weight= resultSet.getString("Weight");
					                this.BloodPressureSystolic = resultSet.getString("BloodPressureSystolic");
					                this.BloodPressureDiastolic = resultSet.getString("BloodPressureDiastolic");
					                this.HeartRate= resultSet.getString("HeartRate");
					                this.BloodSugarLevel = resultSet.getString("BloodSugarLevel");
					                this.CholesterolLevel = resultSet.getString("CholesterolLevel");
					            } else {
					                JOptionPane.showMessageDialog(null, "No data Healthyrecords found with Healthyrecords : " + inputRecordID , "Read Error", JOptionPane.ERROR_MESSAGE);
					            }
					        } catch (SQLException e) {
					            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
					        }
					    }
					    public void update(int inputRecordID ) {
					   	 
					       String sql = "UPDATE healthyrecords SET User_id=?,Date=?,Height=?,Weight=?,BloodPressureSystolic=?,BloodPressureDiastolic=?,HeartRate=?,BloodSugarLevel=?,CholesterolLevel=? WHERE RecordID =?";

					       try (Connection con = getConnection();
					               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					           preparedStatement.setString(1, this.User_id);
					           preparedStatement.setString(2, this.Date);
					           preparedStatement.setString(3, this.Height);
					           preparedStatement.setString(4, this.Weight);
					           preparedStatement.setString(5, this.BloodPressureSystolic);
					           preparedStatement.setString(6, this.BloodPressureDiastolic);
					           preparedStatement.setString(7, this.HeartRate);
					           preparedStatement.setString(8, this.BloodSugarLevel);
					           preparedStatement.setString(9, this.CholesterolLevel);
					           preparedStatement.setInt(10, inputRecordID );

					           int rowsAffected = preparedStatement.executeUpdate();

					           if (rowsAffected > 0) {
					               JOptionPane.showMessageDialog(null, "Data update successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
					           } else {
					               JOptionPane.showMessageDialog(null, "No data found with Healthyrecords: " + inputRecordID , "Update Error", JOptionPane.ERROR_MESSAGE);
					           }
					       } catch (SQLException e) {
					           JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
					       }
					   }

					   public void delete(int inputRecordID ) {
					  
					       String sql = "DELETE FROM healthyrecords WHERE RecordID =?";

					       try (Connection con = getConnection();
					               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
					           preparedStatement.setInt(1, inputRecordID );

					           int rowsAffected = preparedStatement.executeUpdate();

					           if (rowsAffected > 0) {
					               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
					           } else {
					               JOptionPane.showMessageDialog(null, "No data found with Healthyrecords : " + inputRecordID , "Delete Error", JOptionPane.ERROR_MESSAGE);
					           }
					       } catch (SQLException e) {
					           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
					       }
					   }
					}







