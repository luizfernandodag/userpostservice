package com.luiz.jpa.userpostservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*@Getter
@Builder
public class Widget {
    private final String name;
    private final int id;
}
Copy
Lombok does all the work for us. We can now build a Widget and test it:

Widget testWidget = Widget.builder()
  .name("foo")
  .id(1)
  .build();

assertThat(testWidget.getName())
  .isEqualTo("foo");
assertThat(testWidget.getId())
  .isEqualTo(1);*/ 
@Table(name="users")
@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;

private String email;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Post> posts;



}
