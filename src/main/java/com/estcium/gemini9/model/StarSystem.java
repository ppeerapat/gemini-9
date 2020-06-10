package com.estcium.gemini9.model;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import org.hibernate.annotations.TypeDef;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;

@Entity
@Table(name = "star_systems")
@SequenceGenerator(name = "star_system_id_seq", sequenceName = "star_system_id_seq", allocationSize = 1)
@TypeDef(
        typeClass = PostgreSQLIntervalType.class,
        defaultForType = Duration.class
)
public class StarSystem {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "star_system_id_seq")
    private Integer id;

    @Column(name = "central_body")
    @Nullable
    private String centralBody;

    @Column(name = "flattening_factor")
    @Nullable
    private Float flatteningFactor;

    @Column(name = "start_date")
    @Nullable
    private Date startDate;

    @Column(name = "end_date")
    @Nullable
    private Date endDate;

    @Column(name = "period")
    @Nullable
    private Duration period;

    private String name;

    public Integer getId() {
        return id;
    }

    @Nullable
    public String getCentralBody() {
        return centralBody;
    }

    public void setCentralBody(@Nullable String centralBody) {
        this.centralBody = centralBody;
    }

    public Float getFlatteningFactor() {
        return flatteningFactor;
    }

    public void setFlatteningFactor(Float flatteningFactor) {
        this.flatteningFactor = flatteningFactor;
    }

    @Nullable
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@Nullable Date startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable Date endDate) {
        this.endDate = endDate;
    }

    @Nullable
    public Duration getPeriod() {
        return period;
    }

    public void setPeriod(@Nullable Duration period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
