package com.mavespringtest.controller;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.json.JSONObject;
import org.json.XML;


@Controller
@RequestMapping("/webservices")
public class WebServicesClientController {
	
	
	public static String toPrettyString(String xml, int indent) {
	    try {
	        // Turn xml string into a document
	        Document document = DocumentBuilderFactory.newInstance()
	                .newDocumentBuilder()
	                .parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));

	        // Remove whitespaces outside tags
	        document.normalize();
	        XPath xPath = XPathFactory.newInstance().newXPath();
	        NodeList nodeList = (NodeList) xPath.evaluate("//text()[normalize-space()='']",
	                                                      document,
	                                                      XPathConstants.NODESET);

	        for (int i = 0; i < nodeList.getLength(); ++i) {
	            Node node = nodeList.item(i);
	            node.getParentNode().removeChild(node);
	        }

	        // Setup pretty print options
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", indent);
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        // Return pretty print xml string
	        StringWriter stringWriter = new StringWriter();
	        transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
	        return stringWriter.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	public static String prettyPrint(Document document)
            throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(document);
        StringWriter strWriter = new StringWriter();
        StreamResult result = new StreamResult(strWriter);
 
        transformer.transform(source, result);
 
        return strWriter.getBuffer().toString();
 
    }
 
   	public static Document toXmlDocument(String str)
            throws ParserConfigurationException, SAXException, IOException {
 
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new InputSource(new StringReader(
                str)));
 
        return document;
    }
	
	
	
	
	
	@GetMapping(value= {""})
	public String showWebServices(Model model) {
		return "webservices";
	}
	
	@PostMapping(value= {""})
	public String executeApiCall(@RequestParam("apirequest")String apirequest,Model model) {
		System.out.println(apirequest);
		final ClientConfig clientConfig = new DefaultClientConfig();
		final Client client = Client.create(clientConfig);
		
		final WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/api/"+ apirequest).build());
		System.out.println(apirequest);
		
		String xmlString=webResource.accept(MediaType.APPLICATION_XML).get(String.class);
		Document xmlDoc = null;
        String formattedXML="/n";
        try {
            xmlDoc = toXmlDocument(xmlString);
            formattedXML = prettyPrint(xmlDoc);
        } catch (ParserConfigurationException | SAXException | IOException
                | TransformerException e) {
            e.printStackTrace();
        } 
        
        String newformattedXML="\n"+formattedXML;
		//JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
		//String jsonPrettyPrintString = xmlJSONObj.toString(4);
		
		//String check= toPrettyString(check1,4);
		//System.out.println(webResource.path("api").path(apirequest).accept(MediaType.APPLICATION_XML).get(String.class));
		System.out.println(newformattedXML);
        model.addAttribute("result",newformattedXML);
		
		System.out.println(apirequest);
		return "webservices";
	}
	
	
}
