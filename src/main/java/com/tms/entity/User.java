package com.tms.entity;

import com.tms.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Pattern(regexp = Constants.REGEX_USERNAME, message = "Username input incorrect, please read Rules")
    private String username;

    @Pattern(regexp = Constants.REGEX_PASSWORD, message = "Password input incorrect, please read Rules")
    private String password;

}
