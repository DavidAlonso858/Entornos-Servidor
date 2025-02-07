package org.iesbelen.mapping;
import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    @Mapping(target = "idioma_nombre", source = "idioma_nombre")
    public PeliculaDTO peliculaDTO(Pelicula pelicula, String idioma_nombre);

}
