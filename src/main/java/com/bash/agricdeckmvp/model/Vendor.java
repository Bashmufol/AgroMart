package com.bash.agricdeckmvp.model;

import jakarta.persistence.*;
import lombok.Data;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    private User user;
    @Column(name = "business_name", nullable = false, unique = true)
    private String businessName;
    @Column(name = "whatsapp_url", nullable = false, unique = true)
    private String whatsappURL;
    @Column(name = "facebook_url")
    private String facebookURL;
    @Column(name = "twitter_url")
    private String twitterURL;
    @Column(name = "business_name")
    private String instagramURL;
//    @Column(columnDefinition = "json")
//    @Type(JsonType.class)
//    private SocialMediaLinks socialMediaLinks;
    private boolean isApproved;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
