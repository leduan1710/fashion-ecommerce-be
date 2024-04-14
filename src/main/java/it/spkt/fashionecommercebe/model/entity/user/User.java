package it.spkt.fashionecommercebe.model.entity.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.RankEnum;
import it.spkt.fashionecommercebe.common.RoleEnum;
import it.spkt.fashionecommercebe.common.SexEnum;
import it.spkt.fashionecommercebe.common.StatusEnum;
import it.spkt.fashionecommercebe.model.entity.order.Orders;
import it.spkt.fashionecommercebe.model.entity.product.Product;
import it.spkt.fashionecommercebe.model.entity.product.ProductOptionDetail;
import it.spkt.fashionecommercebe.model.entity.report.ReportProduct;
import it.spkt.fashionecommercebe.model.entity.report.ReportReview;
import it.spkt.fashionecommercebe.model.entity.review.Review;
import it.spkt.fashionecommercebe.model.entity.voucher.Voucher;
import it.spkt.fashionecommercebe.model.entity.voucher.VoucherUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String password;

    @Column(columnDefinition = "nvarchar(14)")
    private String name;
    private String image;

    @Column(unique = true, nullable = true,columnDefinition = "nvarchar(100)")
    private String email;

    @Column(unique = true,nullable = true,columnDefinition = "nvarchar(14)")
    private String phone;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;
    private Date birthDay;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date updateDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RankEnum rankUser;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(nullable = false)
    private int point;

    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Address> addressList;

    @JsonManagedReference
    @OneToOne(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Shop shop;

    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Orders> ordersList;

    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Review> reviewList;
    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ReportProduct> reportProductList;
    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ReportReview> reportReviewList;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<VoucherUser> voucherUserList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "Favorite",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_product"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_user", "id_product"}))
    private List<Product> productList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "Follow",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_shop"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_user", "id_shop"}))
    private List<Shop> shopFollowList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
