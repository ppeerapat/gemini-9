package com.estcium.gemini9.model.request;

import com.estcium.gemini9.model.base.Enumerator;

import java.io.Serializable;
import java.util.Date;

public class SciencePlanRequest implements Serializable {

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Double getFunding() {
        return funding;
    }

    public void setFunding(Double funding) {
        this.funding = funding;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Enumerator.TELESCOPELOC getTelescopeLoc() {
        return telescopeLoc;
    }

    public void setTelescopeLoc(Enumerator.TELESCOPELOC telescopeLoc) {
        this.telescopeLoc = telescopeLoc;
    }

    public Enumerator.TYPE getFileType() {
        return fileType;
    }

    public void setFileType(Enumerator.TYPE fileType) {
        this.fileType = fileType;
    }

    public Double getFileQuality() {
        return fileQuality;
    }

    public void setFileQuality(Double fileQuality) {
        this.fileQuality = fileQuality;
    }

    public Enumerator.COLOR_TYPE getColorType() {
        return colorType;
    }

    public void setColorType(Enumerator.COLOR_TYPE colorType) {
        this.colorType = colorType;
    }

    public Double getContrast() {
        return contrast;
    }

    public void setContrast(Double contrast) {
        this.contrast = contrast;
    }

    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(Double brightness) {
        this.brightness = brightness;
    }

    public Double getSaturation() {
        return saturation;
    }

    public void setSaturation(Double saturation) {
        this.saturation = saturation;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    private String name;

    private Integer creator;

    private Double funding;

    private String annotations;

    private String objectives;

    private Date startDate;
    private Date endDate;

    private Enumerator.TELESCOPELOC telescopeLoc;

    private Enumerator.TYPE fileType;

    private Double fileQuality;

    private Enumerator.COLOR_TYPE colorType;

    private Double contrast;

    private Double brightness;

    private Double saturation;

    private String target;

    public SciencePlanRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
