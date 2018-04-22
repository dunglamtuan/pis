
package sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHodnotenies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHodnotenies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hodnoteny" type="{http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie/types}Hodnotenies" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHodnotenies", propOrder = {
    "hodnoteny"
})
public class ArrayOfHodnotenies {

    @XmlElement(nillable = true)
    protected List<Hodnotenies> hodnoteny;

    /**
     * Gets the value of the hodnoteny property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hodnoteny property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHodnoteny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hodnotenies }
     * 
     * 
     */
    public List<Hodnotenies> getHodnoteny() {
        if (hodnoteny == null) {
            hodnoteny = new ArrayList<Hodnotenies>();
        }
        return this.hodnoteny;
    }

}
