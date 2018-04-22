
package sk.stuba.fiit.labss2.pis.students.team076zakaznik.types;

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
 *         &lt;element name="zakaznik" type="{http://labss2.fiit.stuba.sk/pis/students/team076zakaznik/types}Zakaznik"/>
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
    "zakaznik"
})
public class GetByIdResponse {

    @XmlElement(required = true)
    protected Zakaznik zakaznik;

    /**
     * Gets the value of the zakaznik property.
     * 
     * @return
     *     possible object is
     *     {@link Zakaznik }
     *     
     */
    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    /**
     * Sets the value of the zakaznik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zakaznik }
     *     
     */
    public void setZakaznik(Zakaznik value) {
        this.zakaznik = value;
    }

}
