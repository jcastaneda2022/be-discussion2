package jcastaneda.bediscussion2.repository;

import jcastaneda.bediscussion2.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, BigInteger> {
    List<UsersEntity> findAll();
    UsersEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
