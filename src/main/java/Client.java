import java.util.List;
import org.sql2o.*;
import java.io.Console;

public class Client {
  private int id;
  private String name;
  private String phone;
  private int stylist_id;

  public int getId() {
    return id;
  }

  public String getName() {
    return client_name;
  }

  public String getAddress(){
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public int getStylistId() {
    return stylist_id;
  }

  public Client(String name, String phone, int stylist_id) {
    this.name = name;
    this.phone = phone;
    this.stylist_id = stylist_id;
  }

public static List<Client> all() {
    String sql = "SELECT id, name, phone, stylist_id FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if(!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getId() == newClient.getId() &&
      this.getName().equals(newClient.getName()) &&
      this.getPhone().equals(newClient.getPhone()) &&
      this.getStylistId() == newClient.getStylistId();
    }
  }

   public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO clients (name, phone, stylist_id) VALUES (:name, :phone, :stylist_id)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", name)
      .addParameter("phone", phone)
      .addParameter("stylist_id", stylist_id)
      .executeUpdate()
      .getKey();
    }
  }
  
  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }
  
  public void update(String name, Integer phone, Integer stylist_id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET (name, phone, stylist_id) = 	(:name, :phone, :stylist_id) WHERE id = :id";
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("phone", phone)
        .addParameter("stylist_id", stylist_id)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
  
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  
  public String getStylistName() {
    try(Connection con = DB.sql2o.open()){
      String sql = "SElECT name FROM stylists WHERE id = :id;";
      return con.createQuery(sql)
      .addParameter("id", stylist_id)
      .executeAndFetchFirst(String.class);
    }
  }
}
