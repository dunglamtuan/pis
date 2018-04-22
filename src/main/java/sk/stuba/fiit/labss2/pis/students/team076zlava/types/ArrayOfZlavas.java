
package sk.stuba.fiit.labss2.pis.students.team076zlava.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfZlavas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfZlavas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zlava" type="{http://labss2.fiit.stuba.sk/pis/students/team076zlava/types}Zlavas" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfZlavas", propOrder = {
    "zlava"
})
public class ArrayOfZlavas {

    @XmlElement(nillable = true)
    protected List<Zlavas> zlava;

    /**
     * Gets the value of the zlava property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zlava property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZlava().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zlavas }
     * 
     * 
     */
    public List<Zlavas> getZlava() {
        if (zlava == null) {
            zlava = new ArrayList<Zlavas>();
        }
        return this.zlava;
    }

}
