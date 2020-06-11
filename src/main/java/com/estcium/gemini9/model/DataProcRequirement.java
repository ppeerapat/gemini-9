package com.estcium.gemini9.model;

import com.estcium.gemini9.model.base.Enumerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="dpr")
@SequenceGenerator(name = "dpr_id_seq", sequenceName = "dpr_id_seq", allocationSize = 1)
public class DataProcRequirement {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "dpr_id_seq")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Nullable
    public Enumerator.TYPE getFileType() {
        return fileType;
    }

    public void setFileType(@Nullable Enumerator.TYPE fileType) {
        this.fileType = fileType;
    }

    @Nullable
    public Double getFileQuality() {
        return fileQuality;
    }

    public void setFileQuality(@Nullable Double fileQuality) {
        this.fileQuality = fileQuality;
    }

    @Nullable
    public Enumerator.COLOR_TYPE getColorType() {
        return colorType;
    }

    public void setColorType(@Nullable Enumerator.COLOR_TYPE colorType) {
        this.colorType = colorType;
    }

    @Nullable
    public Double getContrast() {
        return contrast;
    }

    public void setContrast(@Nullable Double contrast) {
        this.contrast = contrast;
    }

    @Nullable
    public Double getBrightness() {
        return brightness;
    }

    public void setBrightness(@Nullable Double brightness) {
        this.brightness = brightness;
    }

    @Nullable
    public Double getSaturation() {
        return saturation;
    }

    public void setSaturation(@Nullable Double saturation) {
        this.saturation = saturation;
    }

    @Column(name="file_type")
    @Enumerated(EnumType.STRING)
    @Nullable
    private Enumerator.TYPE fileType;

    @Column(name="file_quality")
    @Nullable
    private Double fileQuality;

    @Column(name="color_type")
    @Enumerated(EnumType.STRING)
    @Nullable
    private Enumerator.COLOR_TYPE colorType;

    @Nullable
    private Double contrast;

    @Nullable
    private Double brightness;

    @Nullable
    private Double saturation;

    @OneToOne(mappedBy = "dpr")
    private SciencePlan sciencePlan;
}
