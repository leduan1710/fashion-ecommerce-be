package it.spkt.fashionecommercebe.model.entity.product;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.StatusEnum;
import it.spkt.fashionecommercebe.model.entity.category.*;
import it.spkt.fashionecommercebe.model.entity.report.ReportProduct;
import it.spkt.fashionecommercebe.model.entity.review.ImageReview;
import it.spkt.fashionecommercebe.model.entity.review.Review;
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
@Check(constraints = "price > 0")
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Column(nullable = true,columnDefinition = "nvarchar(100)")
    private String brandOther;
    @Column(nullable = true,columnDefinition = "nvarchar(100)")
    private String originOther;
    @Column(nullable = true,columnDefinition = "nvarchar(100)")
    private String styleOther;
    @Column(nullable = true,columnDefinition = "nvarchar(100)")
    private String materialOther;
    @Column(nullable = false,columnDefinition = "nvarchar(1000)")
    private String describeProduct;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false)
    private Date updateDate;
    @Column(nullable = false)
    private long price;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shopId",nullable = false)
    private Shop shop;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "materialId")
    private Material material;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "styleId")
    private Style style;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "originId")
    private Origin origin;

    @JsonManagedReference
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductDetail> productDetailList;

    @JsonManagedReference
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ImageProduct> imageProductList;

    @JsonManagedReference
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductOption> productOptionList;

    @JsonManagedReference
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Review> reviewList;

    @JsonManagedReference
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Voucher> voucherList;
    @JsonManagedReference
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ReportProduct> reportProductList;

    @ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<User> userList;

}
