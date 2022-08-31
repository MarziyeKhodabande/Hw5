import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static ArticleRepository articleRepository= new ArticleRepository();
  private static   UserRepository userRepository =new UserRepository();
   private static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        System.out.println("press 1 to signup");
        System.out.println("press 2 to signin");
        System.out.println("press 3 to changePassword");
        System.out.println("press 4 to allArticl");
        System.out.println("press 5 to articleById");
        System.out.println("press 6 to seemyarticle");
        System.out.println("press 7 to editpublishd");
        System.out.println("press 8 to newarticle");
        int number=  Integer.parseInt(scanner.nextLine());
        if (number==1)
        signup();
        else if (number==2)
        {signin();
            seemyarticle();
        } else if (number==3) {
            changePassword();
        } else if (number==4) {
            allArticle();
        } else if (number==5) {
            articleById();
        } else if (number == 6) {
            seemyarticle();
        } else if (number == 7) {
            editpublishd();
        } else if (number == 8) {
            newarticle();
        }
    }
    public static void signup() throws SQLException {
        System.out.println("inter user name");
        String username = scanner.nextLine();
        System.out.println("inter user nationalcode");
        String nationalcode = scanner.nextLine();
        System.out.println("inter user  birthday");
        Date birthday = Date.valueOf(scanner.nextLine());

        User user= new User(0,username,nationalcode,birthday,nationalcode);
        userRepository.signup(user);
    }
    public static void signin() throws SQLException {
        System.out.println("enter username");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
       if( userRepository.signin(username,password))
           System.out.println("successfully");
       else  {
           System.out.println("username in not correct");
       }
    }

    public static void changePassword() throws SQLException {
        System.out.println("enter your username");
        String username = scanner.nextLine();
        System.out.println("enter your old password");
        String password = scanner.nextLine();
        System.out.println("enter your new password");
        String newpassword = scanner.nextLine();
        userRepository.changePassword(username,password,newpassword);
    }
    public static void allArticle() throws SQLException {
        List<Article> articleList =  articleRepository.allArticle();
        for (int i = 0; i <articleList.size(); i++) {
            System.out.println(articleList.get(i).getId()+"\n" +articleList.get(i).getTitle()+"\n" +articleList.get(i).getBrief());
        }
    }
    public static void articleById() throws SQLException {
        System.out.println("enter articleId");
       int articleid = Integer.parseInt(scanner.nextLine()) ;
        System.out.println(articleRepository.articleById(articleid));
    }
    public static void seemyarticle() throws SQLException {
        System.out.println("enter id");
        int id = scanner.nextInt();
        List<Article> articleList =  articleRepository.seemyarticle(id);
        for (int i = 0; i < articleList.size(); i++) {
            System.out.println(articleList.get(i).getId()+"\n"+articleList.get(i).getTitle()+"\n"+articleList.get(i).getBrief()+"\n"+articleList.get(i).getContent()+"\n"+articleList.get(i).getCreateDate()+"\n"+articleList.get(i).getIsPublished()+"\n"+articleList.get(i).getUser_id());
        }

    }
    public static void editpublishd() throws SQLException {
        System.out.println("enter your published");
        boolean published = Boolean.valueOf(scanner.nextLine()) ;
        System.out.println("enter your id");
        int id = scanner.nextInt();
        articleRepository.editpublishd(published,id);
    }

    public static void newarticle() throws SQLException {
        System.out.println("inter your title");
        String title = scanner.nextLine();
        System.out.println("inter your Brief");
        String brief = scanner.nextLine();
        System.out.println("inter your Content");
        String content = scanner.nextLine();
        System.out.println("inter your Date");
        Date date = Date.valueOf(scanner.nextLine());
       Article article = new Article(title,brief,content,date);
       articleRepository.newarticle(article);
    }

}
