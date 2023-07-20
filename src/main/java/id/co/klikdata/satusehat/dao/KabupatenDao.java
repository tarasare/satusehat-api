package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.Kabupaten;
import org.springframework.data.jpa.repository.Query;

public interface KabupatenDao extends JpaRepository<Kabupaten, Integer> {

    Kabupaten findByIdProv(Integer idProv);

    @Query(value = "SELECT * FROM tbl_mst_kabkota WHERE id_prov = :id AND nama_kabkota = :nama", nativeQuery = true)
    Kabupaten findByNamaKabkota(Integer id ,String nama);
}
