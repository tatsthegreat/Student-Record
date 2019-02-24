package student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableRow {
    
    
    
    public static void main (String [] args)
    {
        JFrame frame = new JFrame();
        JTable table = new JTable();
        
        Object[]columns = {"Name", "Email", "Birthday", "Contact"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        table.setModel(model);
        
        table.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        Font font = new Font("",4,14);
        table.setFont(font);
        table.setRowHeight(20);
        
        //Text Fields
        JTextField textName = new JTextField();
        JTextField textEmail = new JTextField();
        JTextField textBday = new JTextField();
        JTextField textContact = new JTextField();
         
        textName.setBounds(120, 220, 110, 25);
        textEmail.setBounds(290, 220, 110, 25);
        textBday.setBounds(470, 220, 110, 25);
        textContact.setBounds(650, 220, 110, 25);
       
        //Text Labels
        JLabel nameLabel = new JLabel ("Name: ");
        JLabel emailLabel = new JLabel ("Email: ");
        JLabel bdayLabel = new JLabel ("Birthday: ");
        JLabel contactLabel = new JLabel ("Contact: ");
        
        nameLabel.setBounds(80,230,90,15);
        emailLabel.setBounds(250,230,90,15);
        bdayLabel.setBounds(415,230,90,15);
        contactLabel.setBounds(595,230,90,15);
        
        //Buttons
        JButton btnAdd = new JButton ("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnExit = new JButton ("Exit");
        JButton btnClear = new JButton ("Clear");
       
        btnAdd.setBounds(100, 290, 120, 30);
        btnUpdate.setBounds(250, 290, 120, 30);
        btnDelete.setBounds(400, 290, 120, 30);
        btnClear.setBounds (550, 290, 120, 30);
        btnExit.setBounds (700, 290, 120, 30);
        
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        //Label Frame
        frame.add(nameLabel);
        frame.add(emailLabel);
        frame.add(bdayLabel);
        frame.add(contactLabel);
        
        //Text Frame
        frame.add(textName);
        frame.add(textEmail);
        frame.add(textBday);
        frame.add(textContact);
        
        //Button Frame
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnExit);
        frame.add (btnClear);
        
        
        Object[] row = new Object[4];
        
        
        btnAdd.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent ae) {
                
                String Name = textName.getText();
                String Email = textEmail.getText();
                String Birthday = textBday.getText();
                String Contacts = textContact.getText();
                
              
                if(Name.equals(""))
                { 
                    JOptionPane.showMessageDialog (null, "Name field is Empty");
                } else if(Email.equals(""))
                {
                    JOptionPane.showMessageDialog (null, "Email field is Empty");
                } else if(Birthday.equals(""))
                {
                    JOptionPane.showMessageDialog (null, "Birthday field is Empty");
                } else if(Contacts.equals(""))
                {
                    JOptionPane.showMessageDialog (null, "Contact field is Empty");
                } 
                else
                {
                    row[0] = textName.getText();
                    row[1] = textEmail.getText();
                    row[2] = textBday.getText();
                    row[3] = textContact.getText();

                    model.addRow(row);
                }
            }           
        });
        
        btnDelete.addActionListener(new ActionListener()
        {
            @Override 
            public void actionPerformed (ActionEvent ae)
            {
                int i = table.getSelectedRow();
                if (i >= 0)
                {
                    model.removeRow(i);
                }
                else
                {
                    System.out.println("Delete Error");
                }
            }
        });
        
        table.addMouseListener (new MouseAdapter()
        {
            @Override
            
            public void mouseClicked(MouseEvent ae)
            {
                int i = table.getSelectedRow();
                
                textName.setText(model.getValueAt(i,0).toString());
                textEmail.setText(model.getValueAt(i,1).toString());
                textBday.setText(model.getValueAt(i,2).toString());
                textContact.setText(model.getValueAt(i,3).toString());
            }
            
        });
        
        
        btnUpdate.addActionListener(new ActionListener()
        {
            @Override
            
            public void actionPerformed(ActionEvent ae)
            {
                int i = table.getSelectedRow();
                
                if (i >= 0)
                {
                    model.setValueAt(textName.getText(), i, 0);
                    model.setValueAt(textEmail.getText(), i, 1);
                    model.setValueAt(textBday.getText(), i, 2);
                    model.setValueAt(textContact.getText(), i, 3);
                }
                else
                {
                    System.out.println("Update Error");
                }
                
            }
        });
        
        btnExit.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });
        
        btnClear.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                textName.setText("");
                textEmail.setText("");
                textBday.setText("");
                textContact.setText("");
            }
        });
              
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      
    }
    
}
