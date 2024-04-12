package it.spkt.fashionecommercebe.model.entity.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.common.AddressEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @Column(nullable = false,columnDefinition = "nvarchar(21)")
    private String phone;
    @Column(nullable = false,columnDefinition = "nvarchar(21)")
    private String city;
    @Column(nullable = false,columnDefinition = "nvarchar(21)")
    private String district;
    @Column(nullable = false,columnDefinition = "nvarchar(21)")
    private String ward;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String apartment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressEnum status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;


}
