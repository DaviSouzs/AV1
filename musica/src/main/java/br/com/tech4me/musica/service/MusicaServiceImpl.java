package br.com.tech4me.musica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.musica.model.Musica;
import br.com.tech4me.musica.repository.MusicaRepository;
import br.com.tech4me.musica.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repositorio;

    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        Optional<Musica> musica = repositorio.findById(id);

        return musica.map(m -> new MusicaDto(
                                        m.getId(), m.getTitulo(), m.getArtista(),
                                        m.getAlbum(), m.getGenero(), m.getAnoLancamento(),m.getCompositor()
        ));
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<MusicaDto> obterTodas() {
        List<Musica> musicas = repositorio.findAll();
        return musicas.stream()
                      .map(m -> new MusicaDto(
                                            m.getId(), m.getTitulo(), m.getArtista(),
                                            m.getAlbum(), m.getGenero(),m.getAnoLancamento(),
                                            m.getCompositor())).collect(Collectors.toList());
    }

    @Override
    public MusicaDto cadastrar(MusicaDto musicaDto) {
        Musica novaMusica = new Musica(musicaDto);
        Musica musicaSalva = repositorio.save(novaMusica);
        
        return new MusicaDto(
                        musicaSalva.getId(), musicaSalva.getTitulo(),
                        musicaSalva.getArtista(), musicaSalva.getAlbum(),
                        musicaSalva.getGenero(), musicaSalva.getAnoLancamento(),
                        musicaSalva.getCompositor()
        );
    }
    
    @Override
    public List<MusicaDto> listarMusicas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarMusicas'");
    }
}
