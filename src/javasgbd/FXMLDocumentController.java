/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasgbd;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import analyse1.ExecuteQuery;
/**
 *
 * @author Adeleste-ciel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea result;

    @FXML
    private Button slctrun;

    @FXML
    private TextArea code;

    @FXML
    private Button data;

    @FXML
    private TextArea listdb;

    @FXML
    private Button actualise;

    @FXML
    private Button save;

    @FXML
    private Button run;

    @FXML
    private ComboBox<?> combodb;

    @FXML
    private Button delete;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if(event.getSource()==save){
            code.getText();
        }
        if(event.getSource()==data){
            ArrayList<String> list= new ArrayList<String>();
           ArrayList<String> list2= new ArrayList<String>();
           list.addAll(analyse1.FileOperation.lire("File\\service\\database.txt"));
           int count=1;
           String data="";
           for (String a : list){
               if(!list2.contains(a)){
                    list2.add(a);
                    data+=count+" "+a;
                    data+="\n";
                    count++;
               }
           }
           listdb.setText(data);
        }
        if(event.getSource()==slctrun){
             String requetteX=code.getSelectedText();
             if(!requetteX.isEmpty()){
                String message="";
                message=ExecuteQuery.query(requetteX);
                /*String[] query=requetteX.split(";");
                for(int i=0;i<query.length;i++){
                    query[i]+=query[i]+";";
                    message+=ExecuteQuery.query(query[i]);
                    message+="\n";
                    
                }*/
            result.setText(" ");
            result.setText(message); }
        }
             else
                result.setText("Il faudrait bien écrire quelque chose");
        if(event.getSource()==run){
          
            String requette=code.getText();
       
            if(!requette.isEmpty()){
                String message="";
                message=ExecuteQuery.query(requette);
                /*String[] query=requette.split(";");
                for(int i=0;i<query.length;i++){
                    query[i]+=query[i]+";";
                    message+=ExecuteQuery.query(query[i]);
                    message+="\n";
                    System.out.println(i);
                    
                }*/
                result.setText(" ");
                result.setText(message);
            }
            else
                result.setText("Il faudrait bien écrire quelque chose");
        }
        if(event.getSource()==delete){
            code.setText(" ");
        }
        if(event.getSource()==actualise){
           
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
