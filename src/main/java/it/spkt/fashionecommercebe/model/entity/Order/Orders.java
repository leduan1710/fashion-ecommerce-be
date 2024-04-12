package it.spkt.fashionecommercebe.model.entity.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.User.Shop;
import it.spkt.fashionecommercebe.model.entity.User.User;
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
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String codeOrder;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date updateDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shopId",nullable = false)
    private Shop shop;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "voucherId")
    private Voucher voucher;

    @JsonManagedReference
    @OneToMany(mappedBy="orders",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList;


}
