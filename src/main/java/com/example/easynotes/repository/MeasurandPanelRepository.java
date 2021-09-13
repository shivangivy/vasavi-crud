/**
 * 
 */
package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.MeasurandPanel;
import com.example.easynotes.model.Metric;

/**
 * @author Electem2
 *
 */
@Repository
public interface MeasurandPanelRepository extends JpaRepository<MeasurandPanel, Integer>{

	@Query(value="SELECT n FROM MeasurandPanel n WHERE n.panelId = :panelId")
	MeasurandPanel findByPanelId(@Param(value="panelId") Integer panelId);
	
	@Query(value="SELECT c FROM MeasurandPanel m join m.metrics c WHERE m.panelId = :panelId ")
	List<Metric> findMetricName(Integer panelId);
	
	@Query(value="SELECT c FROM MeasurandPanel m join m.metrics c WHERE m.panelId = :panelId and c.metricName like CONCAT('%',:metricName,'%') ")
	List<Metric> findMetricName(Integer panelId, String metricName);
	
	@Query(value="SELECT c FROM MeasurandPanel m join m.metrics c WHERE m.panelId = :panelId and c.metricName like :metricName")
	Metric findMetric(Integer panelId, String metricName);
}
