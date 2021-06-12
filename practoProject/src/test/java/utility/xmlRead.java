package utility;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

//public static String category1;

public class xmlRead { 

public static String category1;

public static String category2;

public static String category3;

public static String category4;

public static String category5;
public static String category6;




public static void readxml(String[] args) {
try{

String filePath = "E:\\Java Workspace\\practoProject\\src\\test\\resources\\xmlRead\\NewFile.xml";

File file = new File(filePath);

//These two lines of code create the instance of the DOM architecture of the XML file.

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

DocumentBuilder dBuilder = dbf.newDocumentBuilder();

//These 2 lines of codes parse the XML file and normalize it for test data retrieval.

Document doc = dBuilder.parse(file);

doc.getDocumentElement().normalize();

System.out.println(doc.getDocumentElement().getNodeName());

NodeList nodeList = doc.getElementsByTagName("cities"); 

int tLength = nodeList.getLength();

for(int i=0; i<tLength; i++){

Node node = nodeList.item(i); 

if(node.getNodeType()==Node.ELEMENT_NODE){

Element element = (Element)node;


category1=element.getElementsByTagName("name").item(0).getTextContent();  //retrieve the name from the xml sheet

category2=element.getElementsByTagName("organization").item(0).getTextContent();//retrieve the organization from the xml sheet

category3=element.getElementsByTagName("invalidemail").item(0).getTextContent();//retrieve the invalid emailId from the xml sheet
category4=element.getElementsByTagName("validemail").item(0).getTextContent();//retrieve the valid emailId from the xml sheet

category5=element.getElementsByTagName("contactno").item(0).getTextContent();//retrieve the contact number from the xml sheet
category6=element.getElementsByTagName("url").item(0).getTextContent();
}

}

}catch (Exception e){

e.printStackTrace();

}

}

}



