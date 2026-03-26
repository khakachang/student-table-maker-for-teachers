import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class UI {
    private StudentManager manager = new StudentManager();

    public UI(){
        JFrame frame = new JFrame("Student Table Maker for Teachers");
        frame.setSize(700, 500);
        frame.setLayout(null);

        //Labels
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50,50,100,25);;
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150,50,150,25);
        frame.add(nameField);

        JLabel rollLabel = new JLabel("Roll.No: ");
        rollLabel.setBounds(50, 90, 100, 25);
        frame.add(rollLabel);

        JTextField rollField = new JTextField();
        rollField.setBounds(150,90,150,25);
        frame.add(rollField);

        JLabel markLabel = new JLabel("Mark:");
        markLabel.setBounds(50, 130,100,25);
        frame.add(markLabel);

        JTextField markField = new JTextField();
        markField.setBounds(150,130,150,25);
        frame.add(markField);

        //Table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Roll.No");
        model.addColumn("Mark");

        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(50, 200, 600, 200);
        frame.add(scroll);

        //Buttons
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(350, 50, 100, 30);
        frame.add(addBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(350, 100,100,30);
        frame.add(deleteBtn);

        //Add Save Button
        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(350, 150, 100,30);
        frame.add(saveBtn);
        
        //Add Button Action
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String rollno = rollField.getText();
            float mark = Float.parseFloat(markField.getText());
            
            Student s = new Student(name, rollno, mark);
            manager.addStudent(s);

            model.addRow(new Object[]{name, rollno, mark});
        });

        //Save Button Action
        saveBtn.addActionListener(e -> {
            manager.saveToFile();;
            JOptionPane.showMessageDialog(frame, "Saved to file!");
        });
        
        
        //Delete Button Action
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row != -1) {
                manager.deleteStudent(row);
                model.removeRow(row);
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
