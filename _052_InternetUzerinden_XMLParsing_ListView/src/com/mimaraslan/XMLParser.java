package com.mimaraslan;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.util.Log;

public class XMLParser {

	// YAPILANDIRICI METOT
	public XMLParser() {

	}

	/*
	  URL'DEKI XML'DEN HTTP request ISTEGI YAPIYOR
	  */
	public String getXmlFromUrl(String url) {
		String xml = null;

		try {
			// VARSAYILAN ISTEMCI
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// GERI DONUS XML
		return xml;
	}
	
	/*
	 XML DOM element ELEMANLARI ALINIYOR
	  */
	public Document getDomElement(String xml){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();

			InputSource is = new InputSource();
		        is.setCharacterStream(new StringReader(xml));
		        doc = db.parse(is); 

			} catch (ParserConfigurationException e) {
				Log.e("HATA: ", e.getMessage());
				return null;
			} catch (SAXException e) {
				Log.e("HATA: ", e.getMessage());
	            return null;
			} catch (IOException e) {
				Log.e("HATA: ", e.getMessage());
				return null;
			}

	        return doc;
	}
	
	/* 
	 XML node KOK ELEMANI DIGER COCUK ELEMANLARI ALINIYOR
	*/
	 public final String getElementValue( Node node ) {
		 
	     Node child;
	     
	     if( node != null){
	    	 
	         if (node.hasChildNodes()){
	             for( child = node.getFirstChild(); child != null; child = child.getNextSibling() ){
	             
	            	 if( child.getNodeType() == Node.TEXT_NODE  ){
	                     return child.getNodeValue();
	                 }
	         
	             }
	         
	         }
	     }
	     
	     return "";
	 }
	 
	 /*
	   BIR ELEMANIN SIRASI VE DEGERI
	 */
	 public String getValue(Element item, String str) {		
	
		NodeList n = item.getElementsByTagName(str);		
		return this.getElementValue(n.item(0));
		
	 }
}
