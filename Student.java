//OOP (Encapsulation)
public class Student{
    private String name;
    private String rollno;
    private float mark;

    public Student(String name, String rollno, float mark){
        this.name = name;
        this.rollno = rollno;
        this.mark = mark;
    }

    public String getName(){return name;}
    public String getAge(){return rollno;}
    public float getCourse(){return mark;}

}