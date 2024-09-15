package EMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice  choiceEMP ;
    JButton searchB ,print , update,back;

    ViewEmployee(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(200,20,150,20);
        add(choiceEMP);

        try {

            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("empID"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,640);
        add(jp);

        searchB = new JButton("SEARCH");
        searchB.setBounds(20,70,100,20);
        searchB.addActionListener(this);
        add(searchB);

        print = new JButton("PRINT");
        print.setBounds(140,70,100,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("UPDATE");
        update.setBounds(260,70,100,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back .setBounds(380,70,100,20);
        back .addActionListener(this);
        add(back );

            setSize(900,640);
            setLocation(160,20);
            setLayout(null);
            setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== searchB){
            String query = "select * from employee where empID ='"+choiceEMP.getSelectedItem()+"'";
            try{
                Con c = new Con();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {

            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource()== update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());

        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
