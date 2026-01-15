package it.socialnetwork.mapper;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.PostEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CommentiMapper.class})
public interface PostMapper {
   PostDTO toDto(PostEntity postEntity);
   PostEntity toEntity(PostDTO postDTO);
}