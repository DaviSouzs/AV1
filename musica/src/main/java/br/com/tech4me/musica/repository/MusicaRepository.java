package br.com.tech4me.musica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.musica.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica,String>{
    
}
