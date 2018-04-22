
package sk.stuba.fiit.labss2.pis.students.team076kaviaren.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfKaviarens complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfKaviarens">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kaviaren" type="{http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types}Kaviarens" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfKaviarens", propOrder = {
    "kaviaren"
})
public class ArrayOfKaviarens {

    @XmlElement(nillable = true)
    protected List<Kaviarens> kaviaren;

    /**
     * Gets the value of the kaviaren property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kaviaren property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKaviaren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Kaviarens }
     * 
     * 
     */
    public List<Kaviarens> getKaviaren() {
        if (kaviaren == null) {
            kaviaren = new ArrayList<Kaviarens>();
        }
        return this.kaviaren;
    }

}
