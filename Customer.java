

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author bgctub
 */
public class Customer {
         SimpleStringProperty firstName;   
         SimpleStringProperty lastName;
        
        public Customer(){
            
        }    
        
        public Customer(String firstName, String lastName){
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
        }
        
        public Customer(SimpleStringProperty firstName, SimpleStringProperty lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        
         public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String firstName) {
            this.firstName = new SimpleStringProperty(firstName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String lastName) {
            this.lastName = new SimpleStringProperty(lastName);
        }
     }
