package com.example.ea_final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    private String studentId;
    @ManyToOne
    private RegistrationGroup registrationGroup;
@Embedded
@AttributeOverrides( {
        @AttributeOverride(name="street", column=@Column(name="home_street")),
        @AttributeOverride(name="city", column=@Column(name="home_city")),
        @AttributeOverride(name="postalCode", column=@Column(name="home_postal_code")),
        @AttributeOverride(name="state", column=@Column(name="home_province")),
        @AttributeOverride(name="country", column=@Column(name="home_country"))
})
private Address homeAddress;
    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="street", column=@Column(name="mailing_street")),
            @AttributeOverride(name="city", column=@Column(name="mailing_city")),
            @AttributeOverride(name="postalCode", column=@Column(name="mailing_postal_code")),
            @AttributeOverride(name="state", column=@Column(name="mailing_province")),
            @AttributeOverride(name="country", column=@Column(name="mailing_country"))
    })
    private Address billingAddress;
    @OneToMany(
            fetch = FetchType.EAGER)

    private List<RegistrationRequest> registrationRequests= new ArrayList<>();

    public void addRegistrationRequest(RegistrationRequest request){
        registrationRequests.add(request);
    }


}
