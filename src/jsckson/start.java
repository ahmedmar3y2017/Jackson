package jsckson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class start {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    // 1.1 Convert Java object to JSON, writeValue(...)
    ObjectMapper mapper = new ObjectMapper();
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

}
