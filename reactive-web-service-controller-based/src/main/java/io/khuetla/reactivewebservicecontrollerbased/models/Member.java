package io.khuetla.reactivewebservicecontrollerbased.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("member")
public class Member {

    @Id
    private int id;
    private String name;
    private int age;
    private double salary;
}
