
package sk.stuba.fiit.labss2.pis.students.team076majitel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.ArrayOfMajitels;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.Majitel;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Team076MajitelPortType", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Team076MajitelPortType {


    /**
     * 
     * @param id
     * @return
     *     returns sk.stuba.fiit.labss2.pis.students.team076majitel.types.Majitel
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#getById")
    @WebResult(name = "majitel", targetNamespace = "")
    @RequestWrapper(localName = "getById", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetById")
    @ResponseWrapper(localName = "getByIdResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetByIdResponse")
    public Majitel getById(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param attributeValue
     * @param ids
     * @param attributeName
     * @return
     *     returns sk.stuba.fiit.labss2.pis.students.team076majitel.types.ArrayOfMajitels
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#getByAttributeValue")
    @WebResult(name = "majitels", targetNamespace = "")
    @RequestWrapper(localName = "getByAttributeValue", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetByAttributeValue")
    @ResponseWrapper(localName = "getByAttributeValueResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetByAttributeValueResponse")
    public ArrayOfMajitels getByAttributeValue(
        @WebParam(name = "attribute_name", targetNamespace = "")
        String attributeName,
        @WebParam(name = "attribute_value", targetNamespace = "")
        String attributeValue,
        @WebParam(name = "ids", targetNamespace = "")
        ArrayOfIds ids);

    /**
     * 
     * @param attributeValue
     * @param mathCondition
     * @param ids
     * @param attributeName
     * @return
     *     returns sk.stuba.fiit.labss2.pis.students.team076majitel.types.ArrayOfMajitels
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#getByNumericCondition")
    @WebResult(name = "majitels", targetNamespace = "")
    @RequestWrapper(localName = "getByNumericCondition", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetByNumericCondition")
    @ResponseWrapper(localName = "getByNumericConditionResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetByNumericConditionResponse")
    public ArrayOfMajitels getByNumericCondition(
        @WebParam(name = "attribute_name", targetNamespace = "")
        String attributeName,
        @WebParam(name = "attribute_value", targetNamespace = "")
        String attributeValue,
        @WebParam(name = "math_condition", targetNamespace = "")
        String mathCondition,
        @WebParam(name = "ids", targetNamespace = "")
        ArrayOfIds ids);

    /**
     * 
     * @return
     *     returns sk.stuba.fiit.labss2.pis.students.team076majitel.types.ArrayOfMajitels
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#getAll")
    @WebResult(name = "majitels", targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.GetAllResponse")
    public ArrayOfMajitels getAll();

    /**
     * 
     * @param teamId
     * @param teamPassword
     * @param majitel
     * @return
     *     returns int
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#insert")
    @WebResult(name = "id", targetNamespace = "")
    @RequestWrapper(localName = "insert", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.InsertResponse")
    public int insert(
        @WebParam(name = "team_id", targetNamespace = "")
        String teamId,
        @WebParam(name = "team_password", targetNamespace = "")
        String teamPassword,
        @WebParam(name = "Majitel", targetNamespace = "")
        Majitel majitel);

    /**
     * 
     * @param teamId
     * @param entityId
     * @param teamPassword
     * @param majitel
     * @return
     *     returns int
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#update")
    @WebResult(name = "updates", targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.UpdateResponse")
    public int update(
        @WebParam(name = "team_id", targetNamespace = "")
        String teamId,
        @WebParam(name = "team_password", targetNamespace = "")
        String teamPassword,
        @WebParam(name = "entity_id", targetNamespace = "")
        int entityId,
        @WebParam(name = "Majitel", targetNamespace = "")
        Majitel majitel);

    /**
     * 
     * @param teamId
     * @param entityId
     * @param teamPassword
     * @return
     *     returns boolean
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/#delete")
    @WebResult(name = "deleted", targetNamespace = "")
    @RequestWrapper(localName = "delete", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076majitel/types", className = "sk.stuba.fiit.labss2.pis.students.team076majitel.types.DeleteResponse")
    public boolean delete(
        @WebParam(name = "team_id", targetNamespace = "")
        String teamId,
        @WebParam(name = "team_password", targetNamespace = "")
        String teamPassword,
        @WebParam(name = "entity_id", targetNamespace = "")
        int entityId);

}
