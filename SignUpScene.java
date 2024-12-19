package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SignUpScene extends Application{
	
	
	
	public void start(Stage primaryStage) {
		
		  // Create UI
		  GridPane gridPane = new GridPane();
		  
		  gridPane.setPadding(new Insets(5,5,5,5));
		  gridPane.setAlignment(Pos.CENTER);
		  gridPane.setPadding(new Insets(11.5,12.5,13.5,14.5));
		  gridPane.setHgap(8);
		  gridPane.setVgap(8);
		  gridPane.setId("pane");
		  
		  TextField tfName = new TextField();
		  TextField tfICNum = new TextField();
		  TextField tfGender = new TextField();
		  TextField tfPhoneNum = new TextField();
		  TextField tfNationality = new TextField();
		  TextField tfDLicense = new TextField();
		  TextField tfUsername = new TextField();
		  PasswordField pfPassword = new PasswordField();
		  
		  Label lb1=new Label("Sign up a new account");
		  lb1.setFont(Font.font("Arial Black",FontWeight.BLACK,36));
		  lb1.setTextFill(Color.RED);
		  gridPane.add(lb1,0,0);
		  
		  Label lb2=new Label("Name:");
		  lb2.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb2.setTextFill(Color.WHITE);
		  gridPane.add(lb2,0,1);
		  gridPane.add(tfName, 1, 1);

		  Label lb3=new Label("IC Number:");
		  lb3.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb3.setTextFill(Color.WHITE);
		  gridPane.add(lb3,0,2);
		  gridPane.add(tfICNum, 1, 2);
		  
		  Label lb4=new Label("Gender:");
		  lb4.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb4.setTextFill(Color.WHITE);
		  gridPane.add(lb4,0,3);
		  gridPane.add(tfGender, 1, 3);

		  Label lb5=new Label("Phone Number:");
		  lb5.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb5.setTextFill(Color.WHITE);
		  gridPane.add(lb5,0,4);
		  gridPane.add(tfPhoneNum, 1, 4);

		  Label lb6=new Label("Nationality:");
		  lb6.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb6.setTextFill(Color.WHITE);
		  gridPane.add(lb6,0,5);
		  gridPane.add(tfNationality, 1, 5);


		  Label lb7=new Label("Driving License:");
		  lb7.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb7.setTextFill(Color.WHITE);
		  gridPane.add(lb7,0,6);
		  gridPane.add(tfDLicense, 1, 6);
		  
		  Label lb8=new Label("Username:");
		  lb8.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb8.setTextFill(Color.WHITE);
		  gridPane.add(lb8,0,7);
		  gridPane.add(tfUsername, 1, 7);


		  Label lb9=new Label("Password:");
		  lb9.setFont(Font.font("Arial Black",FontWeight.BLACK,20));
		  lb9.setTextFill(Color.WHITE);
		  gridPane.add(lb9,0,8);
		  gridPane.add(pfPassword, 1, 8);

		  Button btSignUp=new Button("Sign Up");
		  gridPane.add(btSignUp, 1, 10);
		  btSignUp.setId("record-sales");
		  
		  Button btLogin=new Button("Back to Login");
		  gridPane.add(btLogin, 0, 10);
		  GridPane.setHalignment(btLogin, HPos.RIGHT);
		  btLogin.setId("record-sales");

		//Button Action
		    btLogin.setOnAction(e -> {
		    	Login login=new Login();
		    	login.start(primaryStage);
				});
		    
		    btSignUp.setOnAction(e->{
		    	if((tfName.getText().isEmpty())||(tfICNum.getText().isEmpty())||(tfGender.getText().isEmpty())||(tfPhoneNum.getText().isEmpty())||
		    			(tfNationality.getText().isEmpty())||(tfDLicense.getText().isEmpty())||(tfUsername.getText().isEmpty())||(pfPassword.getText().isEmpty())) 
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Make sure to fill all the field");
		    	else {
		    	String nameValue =tfName.getText();
		    	SignUp.setName(nameValue);
		    	String ICValue =tfICNum.getText();
		    	SignUp.setIdNum(ICValue);
		    	String passwordValue =pfPassword.getText();
		    	SignUp.setPassword(passwordValue);
		    	String UsernameValue =tfUsername.getText();
		    	SignUp.setUsername(UsernameValue);
		    	
		    	HashMap<String,String> map = new HashMap<String,String>();
		    	map.put(UsernameValue, passwordValue);
		    	
		    	
		    	File file=new File("Username-Password.txt");
		    	try {
					PrintWriter write =new PrintWriter(file);
					write.println(map);
					System.out.print(map);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    	
		    	Login login=new Login();
		    	login.start(primaryStage);}
		    	
		    });
		  
		  gridPane.setAlignment(Pos.CENTER);
		  
		
		  GridPane.setHalignment(btSignUp, HPos.CENTER);
	
		// Create a scene and place it in the stage
		  Scene scene1 = new Scene(gridPane, 820, 750);
		  scene1.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		  primaryStage.setTitle("Sign up a new account"); // Set title
		  primaryStage.setScene(scene1); // Place the scene in the stage
		  primaryStage.show(); // Display the stage
		
	}
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
	
		  public static void main(String[] args) {
			  launch(args);

			}
			}
