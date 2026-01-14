package it.socialnetwork.mapper;

import it.socialnetwork.dto.FollowDTO;
import it.socialnetwork.entity.FollowEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FollowMapper {
    FollowDTO toDTO (FollowEntity FollowEntity);
    FollowEntity toEntity (FollowDTO FollowDTO);
}
