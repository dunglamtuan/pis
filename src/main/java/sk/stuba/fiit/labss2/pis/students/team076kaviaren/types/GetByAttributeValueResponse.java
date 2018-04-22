
package sk.stuba.fiit.labss2.pis.students.team076kaviaren.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByAttributeValueResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getByAttributeValueResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kaviarens" type="{http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types}ArrayOfKaviarens"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByAttributeValueResponse", propOrder = {
    "kaviarens"
})
public class GetByAttributeValueResponse {

    @XmlElement(required = true)
    protected ArrayOfKaviarens kaviarens;

    /**
     * Gets the value of the kaviarens property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfKaviarens }
     *     
     */
    public ArrayOfKaviarens getKaviarens() {
        return kaviarens;
    }

    /**
     * Sets the value of the kaviarens property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfKaviarens }
     *     
     */
    public void setKaviarens(ArrayOfKaviarens value) {
        this.kaviarens = value;
    }

}
