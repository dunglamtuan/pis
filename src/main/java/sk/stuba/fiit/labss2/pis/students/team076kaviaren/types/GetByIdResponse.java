
package sk.stuba.fiit.labss2.pis.students.team076kaviaren.types;

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
 *         &lt;element name="kaviaren" type="{http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types}Kaviaren"/>
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
    "kaviaren"
})
public class GetByIdResponse {

    @XmlElement(required = true)
    protected Kaviaren kaviaren;

    /**
     * Gets the value of the kaviaren property.
     * 
     * @return
     *     possible object is
     *     {@link Kaviaren }
     *     
     */
    public Kaviaren getKaviaren() {
        return kaviaren;
    }

    /**
     * Sets the value of the kaviaren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kaviaren }
     *     
     */
    public void setKaviaren(Kaviaren value) {
        this.kaviaren = value;
    }

}
