package com.estcium.gemini9.model;

import com.estcium.gemini9.model.base.BaseObservingProgram;

import javax.persistence.*;

@Entity
@Table(name = "observing_programs")
@SequenceGenerator(name = "observing_program_id_seq",sequenceName = "observing_program_id_seq",allocationSize = 1)
@AttributeOverrides({
        @AttributeOverride(name="id",column=@Column(name="program_id")),
        @AttributeOverride(name="isLightDetectorOn",column =@Column(name="isDetectorOn")),
        @AttributeOverride(name="loc",column = @Column(name="loc"))
})
public class ObservingProgram extends BaseObservingProgram {

//
//    private ArrayList<Filter> filters;
//    private ArrayList<Double> exposures;
//    private ArrayList<SpecialEquipment> specialEquipments;
//    private AstronomicalData astroData;
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "observing_program_id_seq")
    public int getId(){return super.getId();}

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="len_id")
    private LensDB lens;

    @ManyToOne()
    @JoinColumn(name="creator_id", nullable = false)
    private User creatorUser;

    @Override
    public LensDB getLens() {
        return lens;
    }

    public void setLens(LensDB lens) {
        this.lens = lens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
