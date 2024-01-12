package groupid.artifactid;

public class Course {
    private Long id;
    private String name;
    private String deparment;

    public Course(String name, String deparment) {
        this.name = name;
        this.deparment = deparment;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }
}
