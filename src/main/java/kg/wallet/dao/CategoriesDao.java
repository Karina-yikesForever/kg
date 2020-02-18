package kg.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

class Category{
    String name;
    Integer userId;
    Integer  categoryId;
    boolean isActive;
    Date createdDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public java.sql.Date getCreatedDate() {
        return (java.sql.Date) createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void Category() {
    }

}

class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "55555555k";


    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}


 public class CategoriesDao{
    public boolean addCategories(Category category) throws SQLException{
        String SQL= "insert into categories(name,user_id,category_id,is_active, create_date)" + "values (?,?,?,?,?);";
        try(Connection connection=DB.connect();
        PreparedStatement statement=connection.prepareStatement(SQL)){
            statement.setString(1, category.getName());
            statement.setInt(2, category.getUserId());
            statement.setInt(2, category.getCategoryId());
            statement.setBoolean(4, category.isActive());
            statement.setDate(5, category.getCreatedDate());
            statement.executeUpdate();
            return true;
}catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
 }



