
package uasprak_pbo;

import java.sql.*;

public class UASPRAK_PBO {
    private String url;
    private String username;
    private String password;

    public UASPRAK_PBO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
        
    public void displaydata(){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM list"; // Ganti "datadiri" dengan nama tabel yang sesuai
            ResultSet resultSet = statement.executeQuery(query);
            
             while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String  todo = resultSet.getString("todo");
                String kategori = resultSet.getString("kategori");
                String tanggal = resultSet.getString("tanggal");
                String status = resultSet.getString("status");

                // Tampilkan data yang diambil
                
                System.out.println("ID               : " + id );
                System.out.println("todo             : " + todo);
                System.out.println("Kategori         : " + kategori);
                System.out.println("Tanggal          : " + tanggal);
                System.out.println("status           : " + status );
                System.out.println("____________________________\n");
            }
 
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }

    void createData(int id, String todo,String kategori, String tanggal, String status) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO list (id, todo, kategori, tanggal, status) VALUES (" + id + ", '" + todo + "', '" + kategori + "', '" +tanggal+"', '" + status+ "')";
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }

     void updateData(int id, String newtodo, String newkategori, String newtanggal, String newstatus) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "UPDATE datadiri SET todo = '" + newtodo + "', kategori = '" + newkategori +"', tanggal = '"+newtanggal+ "', status = '" + newstatus + "' WHERE id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
    }

     void deleteData(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "DELETE FROM datadiri WHERE id = " + id;
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }
     }
}

   
   
    

