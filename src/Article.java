import java.sql.Date;

public class Article {
    private int id;
    private String title;
    private String  brief;
    private String  content;
    private Date createDate;
    private boolean  isPublished;
    private int user_id;

    public Article(String title, String brief, String content, Date createDate) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
    }

    public Article(int id, String title, String brief) {
        this.id = id;
        this.title = title;
        this.brief = brief;
    }

    public Article(int id, String title, String brief, String content, Date createDate, boolean isPublished, int user_id) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.isPublished = isPublished;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", isPublished=" + isPublished +
                ", user_id=" + user_id +
                '}';
    }
}
