
package sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types;

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
 *         &lt;element name="hodnotenie" type="{http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie/types}Hodnotenie"/>
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
    "hodnotenie"
})
public class GetByIdResponse {

    @XmlElement(required = true)
    protected Hodnotenie hodnotenie;

    /**
     * Gets the value of the hodnotenie property.
     * 
     * @return
     *     possible object is
     *     {@link Hodnotenie }
     *     
     */
    public Hodnotenie getHodnotenie() {
        return hodnotenie;
    }

    /**
     * Sets the value of the hodnotenie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hodnotenie }
     *     
     */
    public void setHodnotenie(Hodnotenie value) {
        this.hodnotenie = value;
    }

}
