package br.com.banco.data.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Mappings;

import br.com.banco.data.TransferenciaDto;
import br.com.banco.models.Transferencia;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TransferenciaMapper {

    @Mappings({})
    public TransferenciaDto map(Transferencia entity);
}
