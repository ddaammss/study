package com.dams.java.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestClass {

    public static void main(String[] args) throws IOException, JAXBException {
        //xml=<device_list_pa><device_list><device_pa><tx_id>1</tx_id><dev_type>AP</dev_type><add_type>2</add_type><mgm_type>AU</mgm_type><mac>01:23:45:67:89:AC</mac><ssid>iptime2</ssid><grant_code>99</grant_code></device_pa></device_list></device_list_pa>
        FileInputStream fileInputStream = new FileInputStream("data.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        XmlList xmlListTag = (XmlList) unmarshaller.unmarshal(fileInputStream);
        fileInputStream.close();
        for(SmartPhoneTag var : xmlListTag.getSmartPhoneTags()){
            System.out.println("model = " + var.getModel());
            System.out.println("price = " + var.getPrice());
            System.out.println("firmware = " + var.getFirmware());
            System.out.println(" ================================================ ");
        }
    }
}
