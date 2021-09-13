/**
 * 
 */
package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Metric;

/**
 * @author Electem2
 *
 */
@Repository
public interface MetricRepository {
	@Query(value="SELECT c FROM MeasuredPanel m join m.metrics c WHERE m.panelId = :panelId and c.metricName like CONCAT('%',:metricName,'%') ")
	List<Metric> findMetricName(@Param(value="panelId") Integer panelId, @Param(value="metricName") String metricName);

	@Query(value="SELECT c FROM MeasuredPanel m join m.metrics c WHERE m.panelId = :panelId ")
	List<Metric> findMetricName(@Param(value="panelId") Integer panelId);

	@Query(value="SELECT c FROM MeasuredPanel m join m.metrics c WHERE m.panelId = :panelId and c.metricName like :metricName")
	Metric findMetric(@Param(value="panelId") Integer panelId, @Param(value="metricName") String metricName);

}
