package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<PlayerEntity, String> {
}