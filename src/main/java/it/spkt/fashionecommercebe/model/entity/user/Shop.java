package it.spkt.fashionecommercebe.model.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.StatusEnum;
import it.spkt.fashionecommercebe.model.entity.order.Orders;
import it.spkt.fashionecommercebe.model.entity.product.Product;
import it.spkt.fashionecommercebe.model.entity.voucher.Voucher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy="shop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> productList;

    @JsonManagedReference
    @OneToMany(mappedBy="shop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Orders> orders;


    @JsonManagedReference
    @OneToMany(mappedBy="shop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Voucher> voucherList;

    @ManyToMany(mappedBy = "shopFollowList", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<User> userList;


}
