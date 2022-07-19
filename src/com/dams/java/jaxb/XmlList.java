package com.dams.java.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "list")
public class XmlList {
    @XmlElement(name = "smart-phone")
    private SmartPhoneTag[] smartPhoneTags;

    public SmartPhoneTag[] getSmartPhoneTags() {
        return smartPhoneTags;
    }

    public void setSmartPhoneTags(SmartPhoneTag[] smartPhoneTags) {
        this.smartPhoneTags = smartPhoneTags;
    }
}
