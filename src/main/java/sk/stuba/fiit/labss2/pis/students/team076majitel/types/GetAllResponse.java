
package sk.stuba.fiit.labss2.pis.students.team076majitel.types;

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
 *         &lt;element name="majitels" type="{http://labss2.fiit.stuba.sk/pis/students/team076majitel/types}ArrayOfMajitels"/>
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
    "majitels"
})
public class GetAllResponse {

    @XmlElement(required = true)
    protected ArrayOfMajitels majitels;

    /**
     * Gets the value of the majitels property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMajitels }
     *     
     */
    public ArrayOfMajitels getMajitels() {
        return majitels;
    }

    /**
     * Sets the value of the majitels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMajitels }
     *     
     */
    public void setMajitels(ArrayOfMajitels value) {
        this.majitels = value;
    }

}
