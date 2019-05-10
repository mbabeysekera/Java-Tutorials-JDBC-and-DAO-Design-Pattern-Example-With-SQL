/*
THIS TUTORIAL IS AN EXAMPLE FOR USING "DATA ACCESS OBJECTS (DAO)" FOR DATA BASE ACCESS.
HERE DATA FETCHING AND STORING IS DONE THROUGH THE JAVA SQL PACKAGE APIs. 
FOR MORE DETAILS ON "JAVA DATA BASE CONNECTIVITY" PLEASE GO THROUGH MY JAVA TUTORIAL 
FOR JDBC CONNECTIVITY.

Software versions       : MySQL - 8.0
MySQL Java Connector/J  : 8.0.15 (Latest Version at the tutorial is created)

Author @ BUDDHIKA ABEYSEKERA
Check out me on: LinkedIn: https://www.linkedin.com/in/babey/
                 GitHub: https://github.com/mbabeysekera/
*/

package javadao;
import java.sql.*;//import all from java sql package
public class JavaDAO {

    public static void main(String[] args) {
		//this part of the main class is responsible for managing all the 
		//objects and methods for the process.
        DataBaseCon mysqlDB = new DataBaseCon();
        mysqlDB.configureDB("jdbc:mysql://localhost:3306/sql_students", "root",
                            "1234");
        mysqlDB.createCon();
        mysqlDB.insertData("Amali", "Abeysekera", 90);
        mysqlDB.createCon();
        System.out.println(mysqlDB.fetchData());
    }
}
class DataBaseCon {
	//This is the DAO (Data Access Object) for the SQL package
    Connection con; //Create connection object (**Connection is not actually a Class. it is an Interface.)
	//create necessary variables for storing SQL settings.
    private String url;
    private String user;
    private String psw;
	//Create the connection based on the connection settings
    public void createCon() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(this.url, this.user, this.psw);

        } catch (Exception sqlException) {
            System.out.println(sqlException);
        }
    }
	//Data access method is used to fetch the Data from the Data Base.
    public String fetchData() {
        String data = new String();
        try {
            String query = "SELECT * FROM students WHERE indexNo = 8";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(query);
            res.next();
            data = res.getString(2);
            st.close();
            con.close();
        } catch (Exception sqlException) {
            System.out.println(sqlException);
        }
        
        return data;
    }
	//This method is used to store data on to the Data Base.
    public void insertData(String firstName, String secondName, int marks) {
        try {
            String insertQ = "INSERT INTO students VALUES (NULL, '" + firstName +
                             "', '" + secondName + "', '" + marks + "')"; 
            Statement st = con.createStatement();
            st.executeUpdate(insertQ);
            st.close();
            con.close();
        } catch (Exception sqlException) {
            System.out.println(sqlException);
        }
        
    }
	//Connection configuration method is used to store the related connection parameters.
    public void configureDB(String url, String user, String psw) {
        this.url = url;
        this.user = user;
        this.psw = psw;
    }
}