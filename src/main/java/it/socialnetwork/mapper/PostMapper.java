package it.socialnetwork.mapper;

import it.socialnetwork.dto.PostDTO;
import it.socialnetwork.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UtentiMapper.class, CommentiMapper.class})
public interface PostMapper {
   PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

   PostDTO toDTO(PostEntity entity);
   PostEntity toEntity(PostDTO dto);
}