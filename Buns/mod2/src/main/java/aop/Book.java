package aop;

public class Book {

    private String title;
    private String idHuman;

    public Book() {

    }

    public Book(String title, String idHuman) {
        this.title = title;
        this.idHuman = idHuman;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(String idHuman) {
        this.idHuman = idHuman;
    }
}
