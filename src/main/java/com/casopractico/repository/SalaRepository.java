
package com.casopractico.repository;

import com.casopractico.entity.Sala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends CrudRepository<Sala,Long>{
    
}
