
package sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types;

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
 *         &lt;element name="hodnotenies" type="{http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie/types}ArrayOfHodnotenies"/>
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
    "hodnotenies"
})
public class GetByAttributeValueResponse {

    @XmlElement(required = true)
    protected ArrayOfHodnotenies hodnotenies;

    /**
     * Gets the value of the hodnotenies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHodnotenies }
     *     
     */
    public ArrayOfHodnotenies getHodnotenies() {
        return hodnotenies;
    }

    /**
     * Sets the value of the hodnotenies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHodnotenies }
     *     
     */
    public void setHodnotenies(ArrayOfHodnotenies value) {
        this.hodnotenies = value;
    }

}
