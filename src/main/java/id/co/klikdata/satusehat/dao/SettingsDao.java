package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.Settings;

public interface SettingsDao extends JpaRepository<Settings, Integer> {

}
