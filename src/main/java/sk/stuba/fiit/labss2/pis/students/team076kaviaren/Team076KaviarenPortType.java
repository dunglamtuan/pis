
package sk.stuba.fiit.labss2.pis.students.team076kaviaren;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviaren;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Team076KaviarenPortType", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Team076KaviarenPortType {


    /**
     * 
     * @param id
     * @return
     *     returns sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviaren
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#getById")
    @WebResult(name = "kaviaren", targetNamespace = "")
    @RequestWrapper(localName = "getById", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetById")
    @ResponseWrapper(localName = "getByIdResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetByIdResponse")
    public Kaviaren getById(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param attributeValue
     * @param ids
     * @param attributeName
     * @return
     *     returns sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#getByAttributeValue")
    @WebResult(name = "kaviarens", targetNamespace = "")
    @RequestWrapper(localName = "getByAttributeValue", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetByAttributeValue")
    @ResponseWrapper(localName = "getByAttributeValueResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetByAttributeValueResponse")
    public ArrayOfKaviarens getByAttributeValue(
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
     *     returns sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#getByNumericCondition")
    @WebResult(name = "kaviarens", targetNamespace = "")
    @RequestWrapper(localName = "getByNumericCondition", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetByNumericCondition")
    @ResponseWrapper(localName = "getByNumericConditionResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetByNumericConditionResponse")
    public ArrayOfKaviarens getByNumericCondition(
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
     *     returns sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#getAll")
    @WebResult(name = "kaviarens", targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.GetAllResponse")
    public ArrayOfKaviarens getAll();

    /**
     * 
     * @param teamId
     * @param kaviaren
     * @param teamPassword
     * @return
     *     returns int
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#insert")
    @WebResult(name = "id", targetNamespace = "")
    @RequestWrapper(localName = "insert", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.InsertResponse")
    public int insert(
        @WebParam(name = "team_id", targetNamespace = "")
        String teamId,
        @WebParam(name = "team_password", targetNamespace = "")
        String teamPassword,
        @WebParam(name = "Kaviaren", targetNamespace = "")
        Kaviaren kaviaren);

    /**
     * 
     * @param teamId
     * @param kaviaren
     * @param entityId
     * @param teamPassword
     * @return
     *     returns int
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#update")
    @WebResult(name = "updates", targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.UpdateResponse")
    public int update(
        @WebParam(name = "team_id", targetNamespace = "")
        String teamId,
        @WebParam(name = "team_password", targetNamespace = "")
        String teamPassword,
        @WebParam(name = "entity_id", targetNamespace = "")
        int entityId,
        @WebParam(name = "Kaviaren", targetNamespace = "")
        Kaviaren kaviaren);

    /**
     * 
     * @param teamId
     * @param entityId
     * @param teamPassword
     * @return
     *     returns boolean
     */
    @WebMethod(action = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/#delete")
    @WebResult(name = "deleted", targetNamespace = "")
    @RequestWrapper(localName = "delete", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types", className = "sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.DeleteResponse")
    public boolean delete(
        @WebParam(name = "team_id", targetNamespace = "")
        String teamId,
        @WebParam(name = "team_password", targetNamespace = "")
        String teamPassword,
        @WebParam(name = "entity_id", targetNamespace = "")
        int entityId);

}
