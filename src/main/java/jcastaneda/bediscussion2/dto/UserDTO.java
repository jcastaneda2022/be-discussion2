package jcastaneda.bediscussion2.dto;

import lombok.Data;

import java.math.BigInteger;
import java.time.ZonedDateTime;


@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private int totalOrders;
    private int successOrders;
    private String email;
    private BigInteger mobileNumber;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}
