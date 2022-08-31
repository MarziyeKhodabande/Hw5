import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    public List<Article> allArticle() throws SQLException {//select title, brif from article where ispublished=true
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from article where ispublished=true");
        ResultSet resultSet= preparedStatement.executeQuery();
        Article article;
        List<Article> articleList = new ArrayList<>();
        while (resultSet.next()) {
            article = new Article(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            articleList.add(article);
        }
        return articleList;

    }
    public Article articleById(int id) throws SQLException {//select * from article where id=?
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from article where id=? ");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
         Article article = new Article(resultSet.getInt(1),
                 resultSet.getString(2),
                 resultSet.getString(3),
                 resultSet.getString(4),
                 resultSet.getDate(5),
                 resultSet.getBoolean(6),
                 resultSet.getInt(7));
         return article;
    }

    public List<Article> seemyarticle(int id) throws SQLException {//select * from article where user_id=?
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from article where user_id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Article> articleList = new ArrayList<>();
        while (resultSet.next()){
            Article article = new Article(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getBoolean(6),
                    resultSet.getInt(7));
           articleList.add(article);
        }
        return articleList;
    }
    public void editpublishd(boolean ispublished,int id) throws SQLException {//update article Set ispublishd =? where user_id=?
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("update article Set ispublishd =? where user_id=?");
        preparedStatement.setBoolean(1, ispublished);
        preparedStatement.setInt(2, id);
        int resultSet = preparedStatement.executeUpdate();

    }
    public void newarticle(Article article) throws SQLException {//insert
        Connection connection = MyConnection.connectGet();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into artile values (?,?,?,?,?,)");
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getBrief());
        preparedStatement.setString(3, article.getContent());
        preparedStatement.setDate(4, article.getCreateDate());
        preparedStatement.setBoolean(5, article.getIsPublished());
        preparedStatement.executeUpdate();

    }
}
