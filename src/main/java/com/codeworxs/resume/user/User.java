package com.codeworxs.resume.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false,name = "is_verified", columnDefinition = "TINYINT(1)")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean emailVerified = false;
    
    @Column(name = "created_date_time")
	private LocalDateTime createdDateTime;

	@Column(name = "is_active", columnDefinition = "TINYINT(1)")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean isActive = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;
    
    @Column(name = "user_type_id")
    private Integer userTypeId;

}
