package jcastaneda.bediscussion2.entity;

import jcastaneda.bediscussion2.config.SchemaConfiguration;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "users")
public class UsersEntity {

    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private BigInteger mobileNumber;
    private int totalOrders;
    private int successOrders;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}
