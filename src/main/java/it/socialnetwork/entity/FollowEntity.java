package it.socialnetwork.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "follow")
@Data
@RequiredArgsConstructor
public class FollowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFollow;  // ID unico per ogni follow

    @ManyToOne
    @JoinColumn(name = "id_follower", nullable = false)
    private UtentiEntity follower;  // chi segue

    @ManyToOne
    @JoinColumn(name = "id_seguendo", nullable = false)
    private UtentiEntity seguendo;  // chi è seguito

    private LocalDateTime dataCreazione;
}