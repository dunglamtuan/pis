
package sk.stuba.fiit.labss2.pis.students.team076zakaznik.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfZakazniks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfZakazniks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zakaznik" type="{http://labss2.fiit.stuba.sk/pis/students/team076zakaznik/types}Zakazniks" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfZakazniks", propOrder = {
    "zakaznik"
})
public class ArrayOfZakazniks {

    @XmlElement(nillable = true)
    protected List<Zakazniks> zakaznik;

    /**
     * Gets the value of the zakaznik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zakaznik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZakaznik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zakazniks }
     * 
     * 
     */
    public List<Zakazniks> getZakaznik() {
        if (zakaznik == null) {
            zakaznik = new ArrayList<Zakazniks>();
        }
        return this.zakaznik;
    }

}
