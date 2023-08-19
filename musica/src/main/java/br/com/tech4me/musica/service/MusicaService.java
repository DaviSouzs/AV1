package br.com.tech4me.musica.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.musica.shared.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodas();
    Optional<MusicaDto> obterPorId(String id);
    MusicaDto cadastrar(MusicaDto musicaDto);
    void excluirPorId(String id);
    List<MusicaDto> listarMusicas();
}
