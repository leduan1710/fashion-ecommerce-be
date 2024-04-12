package it.spkt.fashionecommercebe.model.entity.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.Order.Orders;
import it.spkt.fashionecommercebe.model.entity.Product.Product;
import it.spkt.fashionecommercebe.model.entity.Voucher.Voucher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String describeShop;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date updateDate;
    @Column(nullable = false)
    private Boolean status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy="shop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> productList;

    @JsonManagedReference
    @OneToMany(mappedBy="shop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Orders> orders;


    @JsonManagedReference
    @OneToMany(mappedBy="shop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Voucher> voucherList;


}
