package utility;
import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.WebElement;
import org.w3c.dom.Attr;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import TestCase.diagnostics;



public class xmlWrite {
	public static List<WebElement> List2;
public static void main(String[] args)

{

CreateAXmlFile("TestCases.xml");

}

public static void CreateAXmlFile(String fileName)

{

try {

DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

// root elements for Test Case

Document doc = docBuilder.newDocument();

Element rootElement = doc.createElement("TestCases");

doc.appendChild(rootElement);

// test elements

Element test = doc.createElement("Test");

rootElement.appendChild(test);

// set attribute to test element

Attr attr = doc.createAttribute("id");

attr.setValue("1");

test.setAttributeNode(attr);

// Test Name name elements
 List2 = diagnostics.list1;
 for(WebElement opt:List2)
 {
Element testName = doc.createElement("CityName");

testName.appendChild(doc.createTextNode(opt.getText()));

test.appendChild(testName);
 }

// write the content into xml file

TransformerFactory transformerFactory = TransformerFactory.newInstance();

Transformer transformer = transformerFactory.newTransformer();

//enable indent on the xml file

transformer.setOutputProperty(OutputKeys.INDENT, "yes");

transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

DOMSource source = new DOMSource(doc);

StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+File.separator+fileName));

transformer.transform(source, result);

System.out.println("File saved!");

} catch (ParserConfigurationException pce) {

pce.printStackTrace();

} catch (TransformerException tfe) {

tfe.printStackTrace();

}

}

}
