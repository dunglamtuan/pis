
package sk.stuba.fiit.labss2.pis.students.team076majitel.types;

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
 *         &lt;element name="majitel" type="{http://labss2.fiit.stuba.sk/pis/students/team076majitel/types}Majitel"/>
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
    "majitel"
})
public class GetByIdResponse {

    @XmlElement(required = true)
    protected Majitel majitel;

    /**
     * Gets the value of the majitel property.
     * 
     * @return
     *     possible object is
     *     {@link Majitel }
     *     
     */
    public Majitel getMajitel() {
        return majitel;
    }

    /**
     * Sets the value of the majitel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Majitel }
     *     
     */
    public void setMajitel(Majitel value) {
        this.majitel = value;
    }

}
