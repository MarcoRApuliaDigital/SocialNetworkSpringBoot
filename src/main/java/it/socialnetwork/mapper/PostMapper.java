package it.socialnetwork.mapper;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.PostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
   PostDTO toDto(PostEntity PostEntity);
   PostEntity toEntity (PostDTO PostDTO);
}