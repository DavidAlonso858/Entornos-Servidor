package org.iesbelen.mapping;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    // nombre del atributo del DTO
    @Mapping(target = "nombre_cliente", source = "nombre_cliente")
    public PedidoDTO pedidoDTO(Pedido pedido, String nombre_cliente);


    public Pedido pedidoDTOAPedido(PedidoDTO pedido);

}