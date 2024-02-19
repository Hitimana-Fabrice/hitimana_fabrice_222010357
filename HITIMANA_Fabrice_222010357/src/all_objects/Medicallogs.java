package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Medicallogs {
	                    private int Medicallog_id ;
						private  String User_id;
						private  String Date;
						private String MedicationName;
						private String Dosage;
						private String Frequency;
						 public Medicallogs()  {}
						public Medicallogs(int Medicallog_id ,  String User_id,  String Date, String MedicationName, String Dosage,
								String Frequency) {
							this.Medicallog_id  = Medicallog_id ;
							this.User_id = User_id;
							this.Date = Date;
							this.MedicationName = MedicationName;
							this.Dosage =Dosage;
							this.Frequency = Frequency;
							
						}
						public Medicallogs(String User_id,  String Date, String MedicationName, String Dosage,
								String Frequency) {
							this.User_id = User_id;
							this.Date = Date;
							this.MedicationName = MedicationName;
							this.Dosage =Dosage;
							this.Frequency = Frequency;
						}
					
					
						public int getMedicallog_id() {
							return Medicallog_id;
						}
						public void setMedicallog_id(int medicallog_id) {
							Medicallog_id = medicallog_id;
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
						public String getMedicationName() {
							return MedicationName;
						}
						public void setMedicationName(String medicationName) {
							MedicationName = medicationName;
						}
						public String getDosage() {
							return Dosage;
						}
						public void setDosage(String dosage) {
							Dosage = dosage;
						}
						public String getFrequency() {
							return Frequency;
						}
						public void setFrequency(String frequency) {
							Frequency = frequency;
						}
						//Method to establish database connection
						private Connection getConnection() throws SQLException {
						    String url = "jdbc:mysql://localhost/smart_health_management_system";
						    String User= "222010357";
						    String password = "";
						    return DriverManager.getConnection(url, User, password);
						}
						public void insertData() {
						    String sql = "INSERT INTO medicationlogs (User_id, Date, MedicationName, Dosage, Frequency) VALUES (?, ?, ?, ?, ?)";
						    try (Connection con = getConnection();
						            PreparedStatement statement = con.prepareStatement(sql)) {
						        statement.setString(1, this.User_id);
						        statement.setString(2, this.Date);
						        statement.setString(3, this.MedicationName);
						        statement.setString(4, this.Dosage);
						        statement.setString(5, this.Frequency);
						        int rowsInserted = statement.executeUpdate();
						        if (rowsInserted > 0) {
						            JOptionPane.showMessageDialog(null, "medicationlogs  inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
						        } else {
						            JOptionPane.showMessageDialog(null, "Failed to insert medicationlogs!", "Error", JOptionPane.ERROR_MESSAGE);
						        }
						    } catch (SQLException e) {
						        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
						    }
						}

						

						    public void readWithMedicallog_id (int inputMedicallog_id ) {
						    	
						        String sql = "SELECT * FROM medicationlogs WHERE Medical_id = ?";

						        try (Connection con = getConnection();
						                PreparedStatement statement = con.prepareStatement(sql)) {
						            statement.setInt(1, inputMedicallog_id );

						            ResultSet resultSet = statement.executeQuery();

						            if (resultSet.next()) {
						                this.User_id = resultSet.getString("User_id");
						                this.Date = resultSet.getString("Date");
						                this.MedicationName = resultSet.getString("MedicationName");
						                this.Dosage= resultSet.getString("Dosage");
						                this.Frequency = resultSet.getString("Frequency");
						            } else {
						                JOptionPane.showMessageDialog(null, "No data medicationlogs found with medicationlogs: " + inputMedicallog_id , "Read Error", JOptionPane.ERROR_MESSAGE);
						            }
						        } catch (SQLException e) {
						            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
						        }
						    }
						    public void update(int inputMedical_id) {
						        String sql = "UPDATE medicationlogs SET User_id=?,Date=?,MedicationName=?, Dosage=?, Frequency=? WHERE Medical_id=?";

						        try (Connection con = getConnection();
						             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
						            preparedStatement.setString(1, this.User_id);
						            preparedStatement.setString(2, this.Date);
						            preparedStatement.setString(3, this.MedicationName);
						            preparedStatement.setString(4, this.Dosage);
						            preparedStatement.setString(5, this.Frequency);
						            preparedStatement.setInt(6, inputMedical_id);

						            int rowsAffected = preparedStatement.executeUpdate();

						            if (rowsAffected > 0) {
						                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
						            } else {
						                JOptionPane.showMessageDialog(null, "No data found with ID: " + inputMedical_id, "Update Error", JOptionPane.ERROR_MESSAGE);
						            }
						        } catch (SQLException e) {
						            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
						        }
						    }

						   public void delete(int inputMedicallog_id ) {
						  
						       String sql = "DELETE FROM medicationlogs WHERE Medical_id=?";

						       try (Connection con = getConnection();
						               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
						           preparedStatement.setInt(1, inputMedicallog_id );

						           int rowsAffected = preparedStatement.executeUpdate();

						           if (rowsAffected > 0) {
						               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
						           } else {
						               JOptionPane.showMessageDialog(null, "No data found with  medicationlogs: " + inputMedicallog_id , "Delete Error", JOptionPane.ERROR_MESSAGE);
						           }
						       } catch (SQLException e) {
						           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
						       }
						   }
						}






