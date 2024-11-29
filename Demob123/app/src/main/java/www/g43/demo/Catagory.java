package www.g43.demo;

public class Catagory {
    int icon;
    String title;
    String author;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Catagory(int icon, String title, String author) {
        this.icon = icon;
        this.title = title;
        this.author = author;
    }
}
