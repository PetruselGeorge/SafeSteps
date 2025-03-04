package com.example.SafeStep_be.data.access.layer.Entity.entities;

import com.example.SafeStep_be.data.access.layer.Entity.enums.PackageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "packages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "package_id")
    private UUID id;

    @Column(name = "package_type", nullable = false, length = 15)
    @Enumerated(value = EnumType.STRING)
    private PackageType packageType;

    @Column(name = "expire_date", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime expire_date;

    @OneToOne(mappedBy = "aPackage", cascade = CascadeType.ALL)
    private UserEntity user;

}
