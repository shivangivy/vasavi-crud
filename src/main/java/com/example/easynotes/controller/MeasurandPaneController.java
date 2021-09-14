/**
 * 
 */
package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.MeasurandPanel;
import com.example.easynotes.model.Metric;
import com.example.easynotes.service.MeasurandPanelService;

/**
 * @author Electem2
 *
 */
@RestController
@RequestMapping("/measuredpanelapi")
public class MeasurandPaneController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	MeasurandPanelService measuredpanelservice;

	@PostMapping("/measuredpanel")
	public  MeasurandPanel createMeasurandPanel(@Valid @RequestBody MeasurandPanel measurepanel) {

		LOG.info("MeasuredPanelController : createPanel : started");
		MeasurandPanel measuredPanel = new MeasurandPanel();
		try {
			if (measurepanel != null) {
				measuredPanel = measuredpanelservice.save(measurepanel);				
			}

		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("MeasurandPanel", "createPanel", "failed");
		}  
		LOG.info("MeasuredPanelController : createPanel : ended");
	return measuredPanel;

	}

	@GetMapping("/panelName")
	public List<Metric> searchPanel(@RequestParam final Integer panelId, @RequestParam final String metricName) {
		LOG.info("Start of MeasuredPanelController : searchPanel : started :" + panelId);
		List<Metric> metrics = null;
		try {
			if (panelId != null) {
				metrics = measuredpanelservice.searchMetricName(panelId, metricName);
			}
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("searchMetric", metricName, "There is no metric with this name");
		}
		LOG.info("End of MeasuredPanelController : searchPanel : Ended :" + panelId);
		return metrics;
	}

	@PutMapping("/addMetricToPanel/{panelId}")
	public MeasurandPanel addMetric(@PathVariable final Integer panelId, @Valid @RequestBody final Metric metricData) {

		LOG.info("Start of MeasuredPanelController : addMetric to Panel :" + panelId);
		MeasurandPanel measuredPanel = null;
		try {
			if (panelId != null && metricData.getMetricName() != null) {
				measuredPanel = measuredpanelservice.addMetricToPanel(panelId, metricData);
			}
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("MetricPanelController", "addMetric",
					"please add some other metric because with this name another metric is present");
		}
		LOG.info("End of MeasuredPanelController : addMetric to Panel :" + panelId);
		return measuredPanel;
	}
}
