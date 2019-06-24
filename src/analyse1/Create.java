/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse1;

import data.Champ;
import data.Message;
import data.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Adeleste-ciel
 */
public class Create {
    
        static String message="Erreur de syntaxe";
        static ArrayList<String> keyWords=new ArrayList<>();
	static ArrayList<String> databaseExists=new ArrayList<>();
	static ArrayList<String> ElementType=new ArrayList<String>();
	static ArrayList<String> alphabet=new ArrayList<String>();
	
public static String CreateDataBaseOrTable(String requette1) {
	
	keyWords.addAll((Collection<? extends String>) FileOperation.lire("File\\service\\keys.txt"));
	databaseExists.addAll((Collection<? extends String>) FileOperation.lire("File\\service\\database.txt"));
	alphabet.addAll((Collection<? extends String>) FileOperation.lire("File\\service\\alphabet.txt"));
	
	boolean start=true;
	boolean and=requette1.endsWith(";");
	String[] query=requette1.split(" ");
	if(query.length>=3 && and) {
		
		if(query[1].toUpperCase().equals("DATABASE")) {
			String namedb=query[2].replace(";", "");
			namedb.trim();
			String car=namedb.substring(0);
			if(keyWords.contains(namedb) || databaseExists.contains(namedb) || alphabet.contains(car.toLowerCase())) 
				start=false;
		
			if(start) {
				data.DataBase.createDataBase(namedb);
				databaseExists.add(namedb);
				FileOperation.ecrire(databaseExists, "File\\service\\database.txt");
                                message="la base de donne ";
                                message+=namedb;
                                message+=" est crée avec succès";
			}
			else 
				message="La base de donnée  "+namedb+" existe déjà";                                
		}
       //----------------*********----------- TABLE ----------------******-------------//
		
		else if(query[1].equals("TABLE")) {
			
			int count1=ExecuteQuery.count(requette1,'(');
			int count2=ExecuteQuery.count(requette1,')');
			
			ElementType.addAll((Collection<? extends String>) FileOperation.lire("File\\service\\type.txt"));
			
			boolean cond4= (count1==count2) ? true : false;
			
			int point =query[2].indexOf(".");
			String 	namedatabase=query[2].substring(0, point);
			String  nametable=query[2].substring(point+1);
			if(nametable.contains("("))
				nametable=nametable.substring(0,nametable.indexOf("("));
			
			boolean Column=false;
			boolean Type=false;
			ArrayList<String> colonnes=new ArrayList<>();
			ArrayList<String> types=new ArrayList<>();
			boolean value=false;
			boolean val=false;
				String[] mots= requette1.split(" ");
				if(requette1.contains("(") && requette1.contains(";") && cond4){
						int indexe=requette1.indexOf("( ");
						int indiceF=requette1.lastIndexOf(")");
						String trans=requette1.substring(indexe+1,indiceF);
						Message.Alert(trans);
						trans=trans.trim();
						String[] Mots=trans.split(" ");
						value=mots[2].contains("(");
						val=mots[3].contains("(");
				
				for(String mot : Mots) {
					//CREATE TABLE Gestion45.Java( nameTable varchar(30), age int);
					if(value || val) {
						
						Column=true;
						value=false;
						val=false;
					}
					else if(Column) {
						String colonne=mot;
						String stop=null;
						if(colonne.contains("(")) {
							String index=colonne.substring(0, colonne.indexOf("("));
							if(!ElementType.contains(index)) {
                                                            message="Le type "+colonne+" est invalide";
									break;
							}
						}
						else {
							if(!ElementType.contains(colonne)) {
								message="Le type "+colonne+" est invalide";
									break;
							}
						}
						Column=false;
						Type=true;
						
					}
					else if(Type) {
						String type=mot;
						String initial=type.substring(0);
						if(alphabet.contains(initial.toLowerCase())) {
							Column=true;
							Type=false;
						}
						else 
							break;
					}
					else {
						message="Aucun";
					}
					if(Column) {
						int indice=mot.indexOf(",");
						if(indice != -1)
							colonnes.add(mot.substring(0,indice));
						else
							colonnes.add(mot);
					}
					if(Type) {
						int indice=mot.indexOf(",");
						if(indice != -1) 
							types.add(mot.substring(0,indice));
						else
							types.add(mot);
						
					}
				}
			ArrayList<data.Champ> Colonnes=new ArrayList<Champ>();
			ArrayList<data.Table> Table=new ArrayList<Table>();
			
			if(types.size()==colonnes.size()) {
				
				for(int i=0; i<types.size();i++) {
					Colonnes.add(new Champ(types.get(i),colonnes.get(i),"NULL"));
				}
				Table.add(new Table(nametable,Colonnes));
				data.Table.addTable(namedatabase,Table);
                              
				message="la table est "+nametable+" est créee avec succès";
			}
			else 
                               message="nombre colonne != nombre type *** nom incorrecte";
                    }
                }
            }
            else {
		message="Erreur de syntaxe";
            }
     return message;
}
	
public static String dropDataBaseOrTable(String requette) {
		
		databaseExists.addAll((Collection<? extends String>) FileOperation.lire("File\\service\\database.txt"));
		
		boolean start=false;
		String[] query=requette.split(" ");
		if(query.length>=3) {
			
			if(query[1].toUpperCase().equals("DATABASE")) {
				
				String namedb=query[2].replace(";", "");
				if(databaseExists.contains(namedb)) 
					start=true;
				if(start) {
					namedb.trim();
					data.DataBase.dropDataBase (namedb);
					databaseExists.remove(namedb);
					FileOperation.ecrire(databaseExists, "File\\service\\database.txt");
					FileOperation.deleteFile("File\\database\\"+namedb+".xml");
                                        message="Suppression de la base de donnée "+namedb+" est reussie";
				}
				else 
					message="Erreur SQL";
			}
		//----------*********---------- TABLE --------***********-----------//
			
			else if(query[1].toUpperCase().equals("TABLE")) {
				String namedatabase="";
				String nametable="";
				int 	pointY =query[2].indexOf(".");
				int 	pointX =query[2].indexOf(";");
				
				if( pointX!=-1 && pointY!=-1 ) {
					namedatabase=query[2].substring(0, pointY);
					nametable=query[2].substring(pointY+1,pointX);
					Message.Alert(nametable);
				}
				if(databaseExists.contains(namedatabase)) 
					start=true;
				if(start) {
					data.Table.dropTable(namedatabase, nametable);
                                        message="Table "+nametable+" créée avec succes";
				}
				else 
					message="Table "+nametable+" n'existe pas";
	
			}
			
			else
				message="Syntax error";
                        
		}
            return message;
	}
}
