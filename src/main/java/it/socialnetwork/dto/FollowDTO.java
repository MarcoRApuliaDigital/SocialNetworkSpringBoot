package it.socialnetwork.dto;

import lombok.Data;

@Data
public class FollowDTO {

    private Long idFollow;
    private Long followerId;
    private String followerNome;
    private Long seguendoId;
    private String seguendoNome;
    private String dataCreazione;
}
