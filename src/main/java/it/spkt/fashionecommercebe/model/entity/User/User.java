package it.spkt.fashionecommercebe.model.entity.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.RankEnum;
import it.spkt.fashionecommercebe.common.RoleEnum;
import it.spkt.fashionecommercebe.model.entity.Order.Orders;
import it.spkt.fashionecommercebe.model.entity.Product.ProductDetail;
import it.spkt.fashionecommercebe.model.entity.Voucher.Voucher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Column(unique = true,nullable = false,columnDefinition = "nvarchar(14)")
    private String username;

    @Column(nullable = false,columnDefinition = "nvarchar(14)")
    private String password;

    @Column(columnDefinition = "nvarchar(14)")
    private String name;
    private String image;

    @Column(unique = true, nullable = false,columnDefinition = "nvarchar(100)")
    private String email;

    @Column(unique = true,nullable = false,columnDefinition = "nvarchar(14)")
    private String phone;

    private Boolean sex;
    private Date birthDay;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date updateDate;

    @Column(nullable = false)
    private Boolean active;

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
    private List<Address> addressList;

    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Shop> shopList;

    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Orders> orders;

    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<Voucher> voucherList;

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
