package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Appointments {

			private int Appointments_id;
			private  String User_id;
			private  String DoctorName;
			private String AppointmentDate;
			private String AppointmentTime;
			private String Purpose;
			
			 public Appointments()  {}
			public Appointments(int Appointments_id,  String User_id,  String DoctorName, String AppointmentDate, String AppointmentTime,
					String Purpose) {
				this.Appointments_id = Appointments_id;
				this.User_id = User_id;
				this.DoctorName = DoctorName;
				this.AppointmentDate = AppointmentDate;
				this.AppointmentTime =AppointmentTime;
				this.Purpose = Purpose;
				
			}
			public int getAppointments_id() {
				return Appointments_id;
			}
			public void setAppointments_id(int appointments_id) {
				Appointments_id = appointments_id;
			}
			public String getUser_id() {
				return User_id;
			}
			public void setUser_id(String user_id) {
				User_id = user_id;
			}
			public String getDoctorName() {
				return DoctorName;
			}
			public void setDoctorName(String doctorName) {
				DoctorName = doctorName;
			}
			public String getAppointmentDate() {
				return AppointmentDate;
			}
			public void setAppointmentDate(String appointmentDate) {
				AppointmentDate = appointmentDate;
			}
			public String getAppointmentTime() {
				return AppointmentTime;
			}
			public void setAppointmentTime(String appointmentTime) {
				AppointmentTime = appointmentTime;
			}
			public String getPurpose() {
				return Purpose;
			}
			public void setPurpose(String purpose) {
				Purpose = purpose;
			}
			public Appointments(String User_id,  String DoctorName, String AppointmentDate, String AppointmentTime,
					String Purpose) {
				this.User_id = User_id;
				this.DoctorName = DoctorName;
				this.AppointmentDate = AppointmentDate;
				this.AppointmentTime =AppointmentTime;
				this.Purpose = Purpose;
			}
			
		
			//Method to establish database connection
			private Connection getConnection() throws SQLException {
			    String url = "jdbc:mysql://localhost/HITIMANA_Fabrice_222010357";
			    String User= "222010357";
			    String password = "";
			    return DriverManager.getConnection(url, User, password);
			}
			public void insertData() {
			    String sql = "INSERT INTO appointment (User_id, Doctor_name, Appointment_date, Appointment_time, Purpose) VALUES (?, ?, ?, ?, ?)";
			    try (Connection con = getConnection();
			            PreparedStatement statement = con.prepareStatement(sql)) {
			        statement.setString(1, this.User_id);
			        statement.setString(2, this.DoctorName);
			        statement.setString(3, this.AppointmentDate);
			        statement.setString(4, this.AppointmentTime);
			        statement.setString(5, this.Purpose);
			        int rowsInserted = statement.executeUpdate();
			        if (rowsInserted > 0) {
			            JOptionPane.showMessageDialog(null, "appointment  inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			        } else {
			            JOptionPane.showMessageDialog(null, "Failed to insert appointment!", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    } catch (SQLException e) {
			        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
			    }
			}


			    public void readWithAppointments_id(int inputAppointments_id) {
			    	
			        String sql = "SELECT * FROM appointment WHERE Appointment_id = ?";

			        try (Connection con = getConnection();
			                PreparedStatement statement = con.prepareStatement(sql)) {
			            statement.setInt(1, inputAppointments_id);

			            ResultSet resultSet = statement.executeQuery();

			            if (resultSet.next()) {
			                this.User_id = resultSet.getString("User_id");
			                this.DoctorName = resultSet.getString("Doctor_name");
			                this.AppointmentDate = resultSet.getString("Appointment_date");
			                this.AppointmentTime= resultSet.getString("Appointment_time");
			                this.Purpose = resultSet.getString("Purpose");
			               
			            } else {
			                JOptionPane.showMessageDialog(null, "No appointment found with Resume: " + inputAppointments_id, "Read Error", JOptionPane.ERROR_MESSAGE);
			            }
			        } catch (SQLException e) {
			            JOptionPane.showMessageDialog(null, "Failed to read data: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			    public void update(int inputAppointments_id) {
			        String sql = "UPDATE appointment SET User_id=?, Doctor_name=?, Appointment_date=?, Appointment_time=?, Purpose=? WHERE Appointment_id=?";

			        try (Connection con = getConnection();
			             PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			            preparedStatement.setString(1, this.User_id);
			            preparedStatement.setString(2, this.DoctorName);
			            preparedStatement.setString(3, this.AppointmentDate);
			            preparedStatement.setString(4, this.AppointmentTime);
			            preparedStatement.setString(5, this.Purpose);
			            preparedStatement.setInt(6, inputAppointments_id);

			            int rowsAffected = preparedStatement.executeUpdate();

			            if (rowsAffected > 0) {
			                JOptionPane.showMessageDialog(null, "Data updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
			            } else {
			                JOptionPane.showMessageDialog(null, "No data found with ID: " + inputAppointments_id, "Update Error", JOptionPane.ERROR_MESSAGE);
			            }
			        } catch (SQLException e) {
			            JOptionPane.showMessageDialog(null, "Failed to update data: " + e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }


			   public void delete(int inputAppointments_id) {
			  
			       String sql = "DELETE FROM appointment WHERE Appointment_id=?";

			       try (Connection con = getConnection();
			               PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			           preparedStatement.setInt(1, inputAppointments_id);

			           int rowsAffected = preparedStatement.executeUpdate();

			           if (rowsAffected > 0) {
			               JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
			           } else {
			               JOptionPane.showMessageDialog(null, "No data found with Appointment_id: " + inputAppointments_id, "Delete Error", JOptionPane.ERROR_MESSAGE);
			           }
			       } catch (SQLException e) {
			           JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Delete Error", JOptionPane.ERROR_MESSAGE);
			       }
			   }
			}





