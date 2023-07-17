package br.com.banco.data.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.MappingConstants.ComponentModel;

import br.com.banco.data.ContaDto;
import br.com.banco.models.Conta;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ContaMapper {

    @Mappings({
        @Mapping(target = "saldoTotal", ignore = true)
    })
    ContaDto map(Conta entity);
}
