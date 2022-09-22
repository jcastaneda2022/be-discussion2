package jcastaneda.bediscussion2.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private BigInteger mobileNumber;
}
