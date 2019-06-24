/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Adeleste-ciel
 */
public class FileOperation {
    
    public static ArrayList<String> lire(String fichier) {
		String mot;
		ArrayList<String> keysWords=new ArrayList<>();
                ArrayList<String> keysWord=new ArrayList<>();
		try {
			FileReader file=new FileReader(fichier);
			BufferedReader reader=new BufferedReader(file);
			
			while((mot = reader.readLine()) != null) {
                                if(!keysWord.contains(mot)){
                                    keysWords.add(mot);
                                    keysWord.add(mot);
                                }
			}
			reader.close();
			return keysWords;
			
		}
		catch(Exception e) {
			System.out.println(e.getCause()+"\n"+e.getMessage()+"\t"+e.getClass());
			return null;
		}
	}
//***************************************************************************************
public static void ecrire(ArrayList<String> Words,String namefile) {
	
	try {
		BufferedWriter write=new BufferedWriter(new FileWriter(namefile));
                ArrayList<String> list2= new ArrayList<String>();
		for(String word : Words) {
                    if(!list2.contains(word)){
                        list2.add(word);
			write.write(word);
			write.newLine();
                    }
		}
		write.close();
		
	}
	catch(Exception e) {
		System.out.println(e.getCause()+"\n"+e.getMessage());
		
	}
}

public static void deleteFile(String file) {
	
	File fichier=new File(file);
	boolean exist=fichier.exists();
	if(exist) {
		fichier.delete();
	}
}

}
