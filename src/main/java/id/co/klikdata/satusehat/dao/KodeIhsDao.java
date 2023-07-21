package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.KodeIhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface KodeIhsDao extends JpaRepository<KodeIhs, BigInteger> {
}
