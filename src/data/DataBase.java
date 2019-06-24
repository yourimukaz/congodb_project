package data;

import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class DataBase {

    
    static DocumentBuilderFactory DBF;
    static DocumentBuilder DocBuild;
    static Document document;
    static TransformerFactory transformerFactory;
    static Transformer transformer;
    static DOMSource source;
    static StreamResult sortie;
    static Element champElement;
    static Element bdd,tableElement;
    
    static ArrayList<Champ> champs=new ArrayList<Champ>();
    static ArrayList<Table> tab=new ArrayList<Table>();
	
public String getName() {
		return name;
	}
public void setName(String name) {
		this.name = name;
	}
    private String name;


public static void createDataBase(String namedb, ArrayList<Table> table) {
	DomCopy data=new DomCopy();
	data.newDataBase(namedb,table);
	System.out.println("création Data Base "+namedb+" à réussie");}

public static void createDataBase(String namedb) {
    try{
        
        DBF=DocumentBuilderFactory.newInstance();
        DocBuild=DBF.newDocumentBuilder();
        document=DocBuild.newDocument();
        
        Text text=document.createTextNode("Null");
        bdd=document.createElement("DataBase");
        bdd.setAttribute("name",namedb);
        bdd.appendChild(text);
        document.appendChild(bdd);
    	
    	transformerFactory =TransformerFactory.newInstance();
        transformer =transformerFactory.newTransformer();
        source = new DOMSource(document);
        sortie = new StreamResult(new File("File\\database\\"+namedb+".xml"));
       
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indentamount", "2");
        transformer.transform(source, sortie);
        System.out.println("Creation database "+namedb+" réeussie");
    	}
   catch(Exception e) {
	   System.out.println(e.getMessage()+"\n"+e.getCause());
   }
}

public static void dropDataBase(String namefile) {
	try {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document documentModify=builder.newDocument();
		
		transformerFactory =TransformerFactory.newInstance();
        transformer =transformerFactory.newTransformer();
        source = new DOMSource(documentModify);
        String file=new String("File\\database\\"+namefile+".xml");
        System.out.println(file);
        sortie = new StreamResult(new File(file));
       
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indentamount", "2");
        transformer.transform(source, sortie);
	}
	catch(Exception e) {
		System.out.println(e.getMessage()+"\n"+e.getCause());
		}
}

}
