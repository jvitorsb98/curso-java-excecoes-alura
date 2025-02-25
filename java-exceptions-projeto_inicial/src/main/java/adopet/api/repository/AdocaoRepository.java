package adopet.api.repository;

import adopet.api.model.Adocao;
import adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao,Long> {


    int countByTutorIdAndStatus(Long aLong, StatusAdocao statusAdocao);

    boolean existsByPetIdAndStatus(Long aLong, StatusAdocao statusAdocao);
}
