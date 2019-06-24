/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse1;

/**
 *
 * @author Adeleste-ciel
 */
import java.util.ArrayList;

public class ExecuteQuery {

    static int code=500;
    static String message="null";
    static ArrayList<String> list=new ArrayList<>();
    
public static String query(String requetteX) {
    
    int decode=ExecuteQuery.decodeurInitial(requetteX);
    if(decode!=-1 && decode>0) {
	switch(decode) {
            case 1:
		message="Alter ne pas encore fini";
		break;
            case 2:
		try {
                    message=Create.CreateDataBaseOrTable(requetteX);
                    break;
		}
		catch(Exception e) {
			message="error";
			break;
		}
		case 3:
                    message=Insertion.delete(requetteX);
                    break;
		case 4:
                    message=Create.dropDataBaseOrTable(requetteX);
                    break;
                case 5:
                	message=Insertion.insertInTable(requetteX);
			break;
                case 6:
			list.addAll(UpdatAndSelect.select(requetteX));
			break;
		case 7:
			message="Update ne pas encore fini";
			break;
                default:
			message="Excpeted ';' ";
                    }
		}
		else {
                    message="Respectez la syntax svp !";
		}
            return message;
	}
       
	
public static int decodeurInitial(String requette) {
		
		
		String[] query=requette.split(" ");
		
		ArrayList<String> begin=new ArrayList<>();
		ArrayList<String> keyWords=new ArrayList<>();
		
		begin.addAll(FileOperation.lire("File\\service\\begin.txt"));
		keyWords.addAll(FileOperation.lire("File\\service\\keys.txt"));
		boolean bool=requette.endsWith(";");
		
		for(int zero=0; zero<begin.size();zero++) {
			boolean reponse=query[0].toUpperCase().equals(begin.get(zero));
			if(reponse && bool) {
				int value=zero+1;
				code=value;
			}
		}
		return code;
	}

	public static int count(String chaine,char caractere) {
		char[] chars=chaine.toCharArray();
		int count=0;
		for(char a : chars) {
			if(a==caractere)
				count++;
		}
		return count;
	}
}
