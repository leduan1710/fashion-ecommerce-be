package it.spkt.fashionecommercebe.model.entity.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.OrderStatusEnum;
import it.spkt.fashionecommercebe.model.entity.user.Shop;
import it.spkt.fashionecommercebe.model.entity.user.User;
import it.spkt.fashionecommercebe.model.entity.voucher.Voucher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "price_total > 0")
@Check(constraints = "price_ship >= 0")
@Check(constraints = "price_decrease_voucher >= 0")
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String codeOrder;
    @Column(nullable = false)
    private long priceTotal;
    @Column(nullable = false)
    private long priceShip;
    @Column(nullable = true)
    private long priceDecreaseVoucher;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date updateDate;
    @Column(nullable = false)
    private Date dateDelivery;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "buyerId",nullable = false)
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderDetail> orderDetailList;


}
