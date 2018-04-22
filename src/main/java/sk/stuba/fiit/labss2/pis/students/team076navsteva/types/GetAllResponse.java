
package sk.stuba.fiit.labss2.pis.students.team076navsteva.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="navstevas" type="{http://labss2.fiit.stuba.sk/pis/students/team076navsteva/types}ArrayOfNavstevas"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllResponse", propOrder = {
    "navstevas"
})
public class GetAllResponse {

    @XmlElement(required = true)
    protected ArrayOfNavstevas navstevas;

    /**
     * Gets the value of the navstevas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfNavstevas }
     *     
     */
    public ArrayOfNavstevas getNavstevas() {
        return navstevas;
    }

    /**
     * Sets the value of the navstevas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfNavstevas }
     *     
     */
    public void setNavstevas(ArrayOfNavstevas value) {
        this.navstevas = value;
    }

}
