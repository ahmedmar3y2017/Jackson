package jsckson;

//-----------------------------------jackson.Employee.java-----------------------------------

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "list" })
public class employee {
  @JsonView(Views.Normal.class)
  @JsonProperty("id")
  private int id;
  @JsonProperty("name")
  @JsonView(Views.Normal.class)
  private String name;
  @JsonProperty("list")
  @JsonView(Views.Manager.class)
  private List<String> list = null;

  @JsonProperty("id")
  public int getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(int id) {
    this.id = id;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("list")
  public List<String> getList() {
    return list;
  }

  @JsonProperty("list")
  public void setList(List<String> list) {
    this.list = list;
  }

}