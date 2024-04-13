package it.spkt.fashionecommercebe.model.entity.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.spkt.fashionecommercebe.model.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ImageReview")
public class ImageReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String image;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reviewId",nullable = false)
    private Review review;
}
