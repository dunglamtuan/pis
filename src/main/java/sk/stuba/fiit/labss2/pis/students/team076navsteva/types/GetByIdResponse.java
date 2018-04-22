
package sk.stuba.fiit.labss2.pis.students.team076navsteva.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="navsteva" type="{http://labss2.fiit.stuba.sk/pis/students/team076navsteva/types}Navsteva"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByIdResponse", propOrder = {
    "navsteva"
})
public class GetByIdResponse {

    @XmlElement(required = true)
    protected Navsteva navsteva;

    /**
     * Gets the value of the navsteva property.
     * 
     * @return
     *     possible object is
     *     {@link Navsteva }
     *     
     */
    public Navsteva getNavsteva() {
        return navsteva;
    }

    /**
     * Sets the value of the navsteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Navsteva }
     *     
     */
    public void setNavsteva(Navsteva value) {
        this.navsteva = value;
    }

}
