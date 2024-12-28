package com.rh.userservice.model;

import com.rh.userservice.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "follows")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Follow extends BaseEntity {
    @EmbeddedId
    private FollowId id;

    @MapsId("followerId")
    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    private User follower;

    @MapsId("followeeId")
    @ManyToOne
    @JoinColumn(name = "followee_id", referencedColumnName = "id")
    private User followee;

    @CreatedDate
    private LocalDateTime createdAt;
}
