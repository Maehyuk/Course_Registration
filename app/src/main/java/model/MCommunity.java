package model;

public class MCommunity {

    private String name;
    private String title;
    private String content;


    public MCommunity(String name, String title, String content) {
        this.name=name;
        this.title=title;
        this.content=content;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
