package model;


public class MDirectory {


    private String name;
    private String fileName;

    public MDirectory(String name, String SelectedfileName) {
        this.name=name;
        this.fileName=SelectedfileName;
    }

    public String getName() {
        return name;
    }
    public String getFileName() {
        return fileName;
    }
}
