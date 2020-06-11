package com.estcium.gemini9.model;

import com.estcium.gemini9.model.base.Enumerator;
import jparsec.ephem.Target;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "science_plans")
@SequenceGenerator(name = "plan_id_seq", sequenceName = "plan_id_seq", allocationSize = 1)
public class SciencePlan{

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }

    @Nullable
    public User getSubmitterUser() {
        return submitterUser;
    }

    public void setSubmitterUser(@Nullable User submitterUser) {
        this.submitterUser = submitterUser;
    }

    @Nullable
    public User getValidatorUser() {
        return validatorUser;
    }

    public void setValidatorUser(@Nullable User validatorUser) {
        this.validatorUser = validatorUser;
    }

    @Nullable
    public Double getFunding() {
        return funding;
    }

    public void setFunding(@Nullable Double funding) {
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

    @Nullable
    public Enumerator.TELESCOPELOC getTelescopeLoc() {
        return telescopeLoc;
    }

    public void setTelescopeLoc(@Nullable Enumerator.TELESCOPELOC telescopeLoc) {
        this.telescopeLoc = telescopeLoc;
    }

    public Enumerator.STATUS getStatus() {
        return status;
    }

    public void setStatus(Enumerator.STATUS status) {
        this.status = status;
    }

    public DataProcRequirement getDpr() {
        return dpr;
    }

    public void setDpr(DataProcRequirement dpr) {
        this.dpr = dpr;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
        this.starSystem = Target.TARGET.valueOf(target);
    }

    @Id
    @Column(name = "plan_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "plan_id_seq")
    private Integer id;

    @Nullable
    private String name;

    @ManyToOne()
    @JoinColumn(name="creator_id", nullable = false)
    private User creatorUser;

    @ManyToOne()
    @JoinColumn(name="submitter_id")
    @Nullable
    private User submitterUser;

    @ManyToOne()
    @JoinColumn(name="validator_id")
    @Nullable
    private User validatorUser;

    @Nullable
    private Double funding;

    private String annotations;

    private String objectives;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="telescope_loc")
    @Enumerated(EnumType.STRING)
    @Nullable
    private Enumerator.TELESCOPELOC telescopeLoc;

    @Enumerated(EnumType.STRING)
    private Enumerator.STATUS status = Enumerator.STATUS.DRAFT;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dpr_id")
    private DataProcRequirement dpr;

    private String target;

    @Transient
    private Target.TARGET starSystem;

    public Target.TARGET getStarSystem() {
        return Target.TARGET.valueOf(target);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean validate(){
        if(target==null||name==null||objectives==null||endDate==null||funding==null||startDate==null||telescopeLoc==null||dpr==null)
            return false;
        return true;
    }
}
