/**
 * 
 */
package com.example.easynotes.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.MeasurandPanel;
import com.example.easynotes.model.Metric;
import com.example.easynotes.repository.MeasurandPanelRepository;

/**
 * @author Electem2
 *
 */
@Service
public class MeasurandPanelService {

	@Autowired
	MeasurandPanelRepository measurandpanelRepository;

	public MeasurandPanel save(@Valid MeasurandPanel measurepanel) {

		return measurandpanelRepository.save(measurepanel);

	}

	/*
	 * public MeasurandPanel update(Integer panelId, @Valid MeasurandPanel
	 * measuredDetails) { MeasurandPanel
	 * panel=measurandpanelRepository.findById(panelId) .orElseThrow(() -> new
	 * ResourceNotFoundException("MeasurePanel", "id", panelId));
	 * panel.setPanelName(measuredDetails.getPanelName());
	 * panel.setPanelDescription(measuredDetails.getPanelDescription()); 
	 * if(panel.getMetrics().equals(measuredDetails.getMetrics())) // { 
	 * System.out.println(" please add some other metric because with this name another metric is present"
	 * ); return panel;
	 * 
	 * // for(Metric str:panel.getMetrics()) // { //
	 * if(str.getMetricName().equals(measuredDetails.getMetrics().get(0))) // { //
	 * System.out.println("preset change name"); // } // // } // return
	 * measurandpanelRepository.save(measuredDetails);
	 */

	/**
	 * find panel by id
	 * 
	 * @param metricData
	 * 
	 * @param emailId
	 * @return
	 */
	public MeasurandPanel addMetricToPanel(final Integer panelId, final Metric metricData) {
		MeasurandPanel measuredPanel;
		Metric metric;
		measuredPanel = measurandpanelRepository.findByPanelId(panelId);
		if (measuredPanel != null) {
			metric = measurandpanelRepository.findMetric(panelId, metricData.getMetricName());
			if (metric != null && metric.getMetricId() != null) {
				throw new ResourceNotFoundException("addMetricToPanel", "metric",
						"please add some other metric because with this name another metric is present");
			}

			measuredPanel.getMetrics().add(metricData);
			measuredPanel = measurandpanelRepository.save(measuredPanel);
		}
		return measuredPanel;
	}

	public List<Metric> searchMetricName(final Integer panelId, final String metricName) {
		List<Metric> metric;

		if (metricName == null) {
			metric = measurandpanelRepository.findMetricName(panelId);
		} else {
			metric = measurandpanelRepository.findMetricName(panelId, metricName);
		}

		if (metric.isEmpty()) {
			throw new ResourceNotFoundException("MeasuredPanelService", "searchMetricName", metric);
		}
		return metric;
	}

	
}
