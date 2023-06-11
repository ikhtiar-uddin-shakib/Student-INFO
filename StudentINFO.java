

import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author bgctub
 */
public class StudentINFO extends Application {
      
    
    @Override
    public void start(Stage primaryStage) {
              
        Label form_title=new Label("Please Enter the Following Information"); 
        Label no_lbl = new Label("            ");
        Label no_lbl_btn = new Label("            ");
        Label no_lbl_tbl = new Label("            ");
        Label first_name=new Label("First Name:     ");  
        Label last_name=new Label("Last Name:    ");  
        TextField tf1=new TextField();  
        TextField tf2=new TextField();  
        
        TableView tableView = new TableView();
        TableColumn<String, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<String, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);        
        Button submit=new Button ("Submit");  
        //ObservableList<Customer> list = FXCollections.<Customer>observableArrayList();
        
        DBConnection con = new DBConnection("STUDENTINFO","root","123456");
        ArrayList<Customer> std = con.readStudent();
        for(Customer c : std){
            tableView.getItems().add(c);
        }
        
        submit.setOnAction((ActionEvent event) -> {
            System.out.println("Submit BUtton Clicked.");
            Customer cust = new Customer();
            cust.setFirstName(tf1.getText());
            cust.setLastName(tf2.getText());
            con.writeStudent(tf1.getText(), tf2.getText());
            //list.add(cust4);
            tableView.getItems().add(cust);        
        }); 
        //tableView.getItems().addAll(list);
        VBox vBox = new VBox(tableView);
        //Scene scene = new Scene(vBox,800,600);
        GridPane root=new GridPane();  
        Scene scene = new Scene(root,800,600);  
        root.addRow(0, no_lbl, form_title);  
        root.addRow(1, first_name,tf1);  
        root.addRow(2, last_name,tf2);  
        root.addRow(3, no_lbl_btn, submit); 
        root.addRow(4, no_lbl_tbl, vBox);  
        primaryStage.setTitle("New Form");
        primaryStage.setScene(scene);  
        primaryStage.show();  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
