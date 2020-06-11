package com.estcium.gemini9.model;


import com.estcium.gemini9.model.base.AstroData;
import com.estcium.gemini9.model.base.Filter;
import com.estcium.gemini9.model.base.Lens;
import com.estcium.gemini9.model.base.SpecialEquipment;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "observing_programs")
@SequenceGenerator(name = "observing_program_id_seq",sequenceName = "observing_program_id_seq",allocationSize = 1)
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class ObservingProgram {

    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "observing_program_id_seq")
    private int id;

    @Column(name="is_detector_on")
    public boolean isLightDetectorOn;

    @Type(type = "list-array")
    @Column(name="exposures",columnDefinition = "float8[]")
    @Nullable
    private List<Double> exposures;


    @Access(AccessType.FIELD)
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="len_id",nullable = false)
    private Lens lens;


    @Access(AccessType.FIELD)
    @ManyToOne
    @JoinColumn(name="creator_id", nullable = false)
    private User creatorUser;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "op_filters",
            joinColumns = @JoinColumn(name = "op_id"),
            inverseJoinColumns = @JoinColumn(name = "filter_id")
    )
    private Set<Filter> filters;

    @Access(AccessType.FIELD)
    @OneToMany(mappedBy = "observingProgram",cascade = CascadeType.ALL)
    private Set<SpecialEquipment> specialEquipments;

    @Access(AccessType.FIELD)
    @OneToOne
    @JoinColumn(name="plan_id")
    private SciencePlan sciencePlan;

    @Access(AccessType.FIELD)
    @OneToMany(mappedBy = "observingProgram",cascade = CascadeType.ALL)
    private Set<AstroData> astroData;

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }

    public Lens getLens() {
        return lens;
    }

    public void setLens(Lens lens) {
        this.lens = lens;
    }

    public int getId() {
        return id;
    }

    public List<Double> getExposures() {
        return exposures;
    }

    public void setExposures(List<Double> exposures) {
        this.exposures = exposures;
    }

    public Set<Filter> getFilters() {
        return filters;
    }

    public void setFilters(Set<Filter> filters) {
        this.filters = filters;
    }

    public Set<SpecialEquipment> getSpecialEquipments() {
        return specialEquipments;
    }

    public SciencePlan getSciencePlan() {
        return sciencePlan;
    }

    public void setSciencePlan(SciencePlan sciencePlan) {
        this.sciencePlan = sciencePlan;
    }

    public void addAstroData(AstroData astroData) {
        this.astroData.add(astroData);
    }
//
//    public ArrayList<Integer> getAstroData(){
//        ArrayList<Integer> res= new ArrayList<>();
//        for(AstroData a:astroData){
//            res.add(a.getId());
//        }
//        return res;
//    }
}
