package it.spkt.fashionecommercebe.model.entity.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.spkt.fashionecommercebe.common.StatusEnum;
import it.spkt.fashionecommercebe.model.entity.product.Product;
import it.spkt.fashionecommercebe.model.entity.report.ReportReview;
import it.spkt.fashionecommercebe.model.entity.user.User;
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
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Double rate;
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
    @JoinColumn(name = "productId",nullable = false)
    private Product product;

    @JsonManagedReference
    @OneToMany(mappedBy="review",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ImageReview> imageReviewList;

    @JsonManagedReference
    @OneToMany(mappedBy="review",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ReportReview> reportReviewList;
}
