package jsckson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class start {
  static ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    // 1.1 Convert Java object to JSON, writeValue(...)
    employee employee = new employee();
    employee.setId(10);
    employee.setName("ahmed");
    System.out.println("------------------------------------");
    // Object to JSON in String
    String jsonInString = mapper.writeValueAsString(employee);
    System.out.println(jsonInString);
    // ---------------------------------------------------------------
    List<employee> employee2 = new ArrayList<employee>();
    employee2.add(createDummyObject());
    employee2.add(createDummyObject());
    employee2.add(createDummyObject());
    employee2.add(createDummyObject());

    // Convert object to JSON string
    String json11 = mapper.writeValueAsString(employee2);
    System.out.println(json11);

    // Convert object to JSON string and pretty print
    json11 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee2);
    System.out.println(json11);

    // ---------------------------------------------------------------------
    // Convert JSON string to Object
    System.out.println("------------------------------------");
    // data.json read json from file and convert it to java class
    employee employee3 = mapper.readValue(new File("E:\\data.json"), employee.class);
    System.out.println(employee3.getName());
    String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee3);
    System.out.println(prettyStaff1);

    // ----------------------------------------------------------------------
    System.out.println("------------------------------------");
    // ........... Normal View .............
    // convert class to json
    System.out.println("Normal View  .............");

    employee employee4 = createDummyObject();
    String ssString = mapper.writerWithView(Views.Normal.class).writeValueAsString(employee4);
    System.out.println(ssString);

    // convert json to class employee
    employee employee5 = mapper.readerWithView(Views.Normal.class).withType(employee.class)
        .readValue(new File("E:\\data.json"));
    System.out.println(employee5.getName());

    // ........... Manager View .............
    // convert class to json
    System.out.println("Manager View  .............");
    employee employee6 = createDummyObject();
    String ddString = mapper.writerWithView(Views.Manager.class).writeValueAsString(employee6);
    System.out.println(ddString);

    // convert json to class employee
    employee employee7 = mapper.readerWithView(Views.Manager.class).withType(employee.class)
        .readValue(new File("E:\\data.json"));
    System.out.println(employee5.getName());

  }

  private static employee createDummyObject() {

    employee employee = new employee();
    List<String> list = new ArrayList<String>();
    list.add("list1");
    list.add("list2");

    employee.setId(1);
    employee.setName("eslam");
    employee.setList(list);
    return employee;

  }

  public static void JsonTOList() throws JsonParseException, JsonMappingException, IOException {
    // 7.1 Convert a JSON Array format to a Java List object.

    List<employee> liEmployees = mapper.readValue(new File("E:\\data.json"),
        new TypeReference<List<employee>>() {
        });
    liEmployees.forEach(rr -> {
      System.out.println(rr.getId() + " -- " + rr.getName() + " -- " + rr.getList().toString());
    });

  }

  public static void JsonToMap() throws JsonParseException, JsonMappingException, IOException {
    Map<String, Object> map = mapper.readValue(new File("E:\\data.json"),
        new TypeReference<Map<String, Object>>() {
        });

  }

}
