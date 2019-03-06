/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdaa1;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


/**
 *
 * @author Haseeb
 */
public class menubar extends JFrame  implements ActionListener,MenuListener  {
      
       GridLayout glayout = new GridLayout(1,3);
         FileOutputStream fout;
    
     JMenuItem who= new JMenuItem("console");
     
     JPanel  mainpanel= new JPanel ();
      JMenu menuTwo;

     JTextArea allfilesarea = new JTextArea ();

     
          
     JTextArea allfilesarea2 = new JTextArea ();
     JLabel fullpath;
     
    JMenuItem OF,CF,Exit;
     
    //formatted text variable for all files
    String allfiles="";
    String javafiles="";
    //formatted text variable for java files
    
    String ext="",name="";
    //
    ArrayList<String> list = new ArrayList<>();
     ArrayList<String> javalist = new ArrayList<>();
    javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK);
 public void  showmenubar(){
allfilesarea.setBorder(border);
allfilesarea2.setBorder(border);
     //
   mainpanel.setLayout(glayout);
     
    fullpath=new JLabel("Full path");
            this.add(mainpanel);
           
            fullpath.setBackground(Color.red);
              
     fullpath.setBounds(0, 0, 400, 50);
     
     mainpanel.add(fullpath);
            mainpanel.setBackground(Color.yellow);
           mainpanel.add(fullpath);
//            allfilesarea.setBounds(2, 50, 250, 250);
//             allfilesarea.setSize(200,600);
          
     mainpanel.add(allfilesarea);
     
     
     
//            allfilesarea2.setBounds(280, 50, 250, 250);
//             allfilesarea2.setSize(200,600); 
     mainpanel.add(allfilesarea2);
   
    
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
             JMenuBar bar = new JMenuBar();
             JMenu menu = new JMenu("File"); 
            menuTwo = new JMenu("About");  
             bar.add(menu);     
             bar.add(menuTwo); 
 
            
            
              OF =new JMenuItem("Open folder");
              CF =new JMenuItem("Close folder");
              Exit =new JMenuItem("Exit");
             OF.addActionListener(this);
             CF.addActionListener(this);
             Exit.addActionListener(this);
             menuTwo.addMenuListener(this);
        menu.add(OF);  
        menu.add(new JSeparator());   
        menu.add(CF);  
        menu.add(new JSeparator());     
        menu.add(Exit); 
 
        setJMenuBar(bar);       
        pack();     
        setSize(600, 700); 
        setVisible(true);     
     
 }


 
     @Override
    public void actionPerformed(ActionEvent ae) {
//        System.out.print("Hello"); //To change body of generated methods, choose Tools | Templates.



if(CF== ae.getSource() ){

allfilesarea.setText("");
allfilesarea2.setText("");
fullpath.setText("File path goes here ....");
    try {
        fout=new FileOutputStream("./logs.txt",true);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date date = new Date(); 
        String s2= dateFormat.format(date)+"\r\n";
        char[] ch =s2.toCharArray();
   
   for(int j=0;j<ch.length;j++){
   
   fout.write(ch[j]);
  } fout.close();
        
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
    }

}

else if(Exit==ae.getSource()){

System.exit(1);
}
else if(ae.getSource()==OF){    
    JFileChooser fc=new JFileChooser(); 
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
     fc.setAcceptAllFileFilterUsed(false);
    int i=fc.showOpenDialog(this);    
       if(i==JFileChooser.APPROVE_OPTION){    
        File f=fc.getSelectedFile();    
        String filepath=f.getPath(); 
        
        System.out.println("+++++++"+f.getParent()+"+++++++++++++++");
        fullpath.setText(filepath);
        
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date date = new Date(); 
            fout=new FileOutputStream("./logs.txt",true);
            String fotxt=" Folder opened: ";
        String at="at: ";
        String closeat=" Closed at: ";
        
        String s="\r\n*"+filepath+ fotxt+at+dateFormat.format(date)+closeat+"";
      
        char[] ch =s.toCharArray();
   
   for(int j=0;j<ch.length;j++){
   
   fout.write(ch[j]);
  
   } fout.close();
   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(menubar.class.getName()).log(Level.SEVERE, null, ex);
        }
//        String fotxt="Folder opened: ";
//        String at="at: ";
//        String closeat="Closed at: ";
//        String s= fotxt+at+dateFormat.format(date)+"*";
//       // System.out.print(filepath);
       
       filesshow(f);
     
    }
    
       //allfilesarea.setText(list.toString());
       int num=1;
       
    for (String list1 : list) {
      allfiles+= num+": "+list1+"\n";
      num++;
    }
    num=1;
     for (String list1 : javalist) {
      javafiles+= num+": "+list1+"\n";
      num++;
    }
    allfilesarea.setText(allfiles);
    allfilesarea2.setText(javafiles);  
    
    
   //System.out.print("\n"+list.toString());
    
    }
    }

//333
    
    
    public  void filesshow(File dir) {
         
         int i;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                //System.out.println("directory:" + file.getCanonicalPath());
                filesshow(file);
             
        
       // System.out.println("Extension: "+ext);
            } else if(file.isFile()) {
                                    // System.out.println(file.getName());
                                    name=file.getName();
                                          i = name.lastIndexOf('.');
//                                          System.out.println("\n"+i);
                              ext = i > 0 ? name.substring(i + 1) : "";
                              list.add(name);

                              //list for java extention files
                                     if("java".equals(ext)){
                                         System.out.println(name);
                                         javalist.add(name);
                                     }
                                        //System.out.println("Extension: "+ext);
            }
        }
	}
    
    //3333

    @Override
    public void menuSelected(MenuEvent me) {
        if(menuTwo==me.getSource()){
        
        JOptionPane.showMessageDialog(this,"Name:Haseeb ur rehman\nReg#: 2868/BSSE/F-15");
        } //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param me
     */
    @Override
    public void menuDeselected(MenuEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void menuCanceled(MenuEvent me) {
       //To change body of generated methods, choose Tools | Templates.
    }
    

}
