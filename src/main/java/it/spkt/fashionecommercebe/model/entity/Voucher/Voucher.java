package it.spkt.fashionecommercebe.model.entity.Voucher;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.model.entity.Order.Orders;
import it.spkt.fashionecommercebe.model.entity.Product.Product;
import it.spkt.fashionecommercebe.model.entity.Product.ProductOptionDetail;
import it.spkt.fashionecommercebe.model.entity.User.Shop;
import it.spkt.fashionecommercebe.model.entity.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Columns;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "quantity >= 0")
@Check(constraints = "decrease >= 0")
@Table(name = "Voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String code;
    @Column(nullable = false)
    private String condition;
    @Column(nullable = false)
    private long decrease;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date updateDate;
    @Column(nullable = false)
    private Date expiry;
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

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_voucher"),
            inverseJoinColumns = @JoinColumn(name = "id_user"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_voucher", "id_user"}))
    private List<User> userList;
}
