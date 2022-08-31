import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {        //insert into user

    public void signup(User user) throws SQLException {
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into usertable(username,nationalcode,birthday,password) values (?,?,?,?)");
        {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getNationalCode());
            preparedStatement.setDate(3, user.getBirthday());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }


    public boolean signin(String username,String password) throws SQLException {//selec* from user Where id=? and password=?
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT* from usertable Where username=? and password=?" );
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultset= preparedStatement.executeQuery();
       if(resultset.next())
           return true;
            return false;
    }


    public void changePassword(String username ,String password,String newpassword) throws SQLException {
        // update User Set password=new password
        //where password=password and uername=usename
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usertable  SET password =? WHERE password=? and username=?");
       preparedStatement.setString(1,newpassword);
       preparedStatement.setString(2,password);
       preparedStatement.setString(3,username);
       preparedStatement.executeUpdate();
    }
}
