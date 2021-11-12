package com.library.api.converter;

import java.util.List;

/**
 *
 * @param <S> Class Entity
 * @param <D> Class DTO
 */
public interface ConverterService<S, D> {
  D entityToDto(S source);

  S dtoToEntity(D dto);

  List<D> entityToDto(List<S> sources);

  List<S> dtoToEntity(List<D> dto);
}
