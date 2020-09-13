package ParserHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class parser {
	public static void main(String[] args)throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
	
		Document document = builder.parse(new File("C:/Users/tetal/Desktop/CNWTLAB/Experiment-3/WebContent/User.xml"));
		
		Element root = document.getDocumentElement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter User Id");
		String id=br.readLine();
		
		NodeList nList = document.getElementsByTagName("user");
		System.out.println(root.getNodeName());
		System.out.println("============================");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node node = nList.item(temp);
			System.out.println(""); 
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				
				Element eElement = (Element) node;
				if(eElement.getAttribute("id").equals(id))
				{
					System.out.println("User id : " + eElement.getAttribute("id"));
					System.out.println("Name : " +
							eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Branch : " +
							eElement.getElementsByTagName("branch").item(0).getTextContent());
					System.out.println("CGPA : " +
							eElement.getElementsByTagName("cgpa").item(0).getTextContent());
					System.out.println("Date Of Birth : " +
							eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent());
					System.out.println("Age : " +
							eElement.getElementsByTagName("age").item(0).getTextContent());
					System.out.println("MobileNo : " +
							eElement.getElementsByTagName("mobileno").item(0).getTextContent());
					System.out.println("Address : " +
							eElement.getElementsByTagName("address").item(0).getTextContent());
				}
			}
		}
	}

}