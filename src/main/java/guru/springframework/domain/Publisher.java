package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String addressLine1;
  private String city;
  private String state;
  private String zip;

  @OneToMany
  @JoinColumn(name = "publisher_id")
  @Fetch(value = FetchMode.JOIN)
  private Set<Book> books = new HashSet<>();

  public Publisher() {
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(final Set<Book> books) {
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(final String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(final String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(final String zip) {
    this.zip = zip;
  }

  @Override
  public String toString() {
    return "Publisher{" + "id=" + id + ", name='" + name + '\'' + ", addressLine1='" +
        addressLine1 + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip='" +
        zip + '\'' + '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Publisher publisher = (Publisher) o;

    return id != null ? id.equals(publisher.id) : publisher.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
