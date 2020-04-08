package com.example.demo.GeneralMessage;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class ParseXml {
    private HashMap<String, String> hashMap;
    public ParseXml(HttpServletRequest request) {
        hashMap = new HashMap<>();
        this.ParseInputStream(request);
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    private void ParseInputStream(HttpServletRequest request) {
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        SAXReader saxReader    = new SAXReader();
        Document  document     = null;
        try {
            document = saxReader.read(inputStream);

        } catch (DocumentException exception) {
            exception.printStackTrace();
        }
        Element   root         =  document.getRootElement();
        List<Element> elements = root.elements();
        for(Element element:elements){
            hashMap.put(element.getName(),element.getStringValue());
        }
    }
}
