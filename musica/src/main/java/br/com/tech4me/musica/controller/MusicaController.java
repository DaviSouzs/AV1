package br.com.tech4me.musica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.musica.service.MusicaService;
import br.com.tech4me.musica.shared.MusicaDto;

@RestController
@RequestMapping("/musicas")
public class MusicaController { 

    @Autowired
    private MusicaService servico;
    
    @GetMapping
    public ResponseEntity<List<MusicaDto>> obterMusicas() {
        return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaDto> obterMusicaPorId(@PathVariable String id) {
        Optional<MusicaDto> musica = servico.obterPorId(id);
        
        if (musica.isPresent()) {
            return new ResponseEntity<>(musica.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> cadastrarMusica(@RequestBody MusicaDto musica) {
        return new ResponseEntity<>(servico.cadastrar(musica), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMusicaPorId(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
