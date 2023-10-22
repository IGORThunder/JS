package hibernate.manyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany( cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.DETACH
            }, fetch = FetchType.EAGER)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Children> childs;

    public Section() {}

    public Section(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static Section scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the section: ");
        String name = scanner.nextLine();
        return new Section(name);
    }

    public void addChildren(Children children) {
        childs = childs == null
                ? new ArrayList<Children>()
                : childs;
        childs.add(children);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Children> getChilds() {
        return childs;
    }

    public void setChilds(List<Children> childs) {
        this.childs = childs;
    }
}
