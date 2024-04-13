package it.spkt.fashionecommercebe.model.entity.voucher;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.NameConditionVoucherEnum;
import it.spkt.fashionecommercebe.model.entity.order.Orders;
import it.spkt.fashionecommercebe.model.entity.product.Product;
import it.spkt.fashionecommercebe.model.entity.user.Shop;
import it.spkt.fashionecommercebe.model.entity.user.User;
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
@Check(constraints = "quantity >= 0")
@Check(constraints = "decrease_voucher >= 0")
@Check(constraints = "percent_voucher >= 0")
@Table(name = "Voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String codeVoucher;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NameConditionVoucherEnum nameConditionVoucher;
    @Column(nullable = false)
    private long quantityOrPriceCondition;
    @Column(nullable = true)
    private long decreaseVoucher;
    @Column(nullable = true)
    private double percentVoucher;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date updateDate;
    @Column(nullable = false)
    private Date expiryVoucher;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shopId")
    private Shop shop;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @JsonManagedReference
    @OneToMany(mappedBy="voucher",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Orders> orders;
    @OneToMany(mappedBy="voucher",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<VoucherUser> voucherUserList;

}
