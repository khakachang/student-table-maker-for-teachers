// ArrayList → dynamic storage
// CRUD operations
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }
    public ArrayList<Student> getStudents(){
        return students;
    }

    public void deleteStudent(int index){
        if(index >= 0 && index <students.size()){
            students.remove(index);
        }
    }


    //Save to file
    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("students.txt");

            for(Student s : students){
                writer.write(s.getName() + "," + s.getAge() + "," + s.getCourse() + "\n"); 
            }

            writer.close();
            System.out.println("Saved successfully!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
