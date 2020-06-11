package com.estcium.gemini9.model.base;

import javax.persistence.*;

@Entity
@Table(name="filters")
@SequenceGenerator(name = "filters_id_seq",sequenceName = "filters_id_seq",allocationSize = 1)
public class Filter extends edu.gemini.app.ocs.model.Filter {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "filters_id_seq")
    private Integer id;

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="make")
    public String getMake(){return super.getMake();};

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="model")
    public String getModel(){return super.getModel();};

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="manufacturer")
    public String getManufacturer(){return super.getManufacturer();};

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="year")
    public int getYear(){return super.getYear();};

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="size")
    public double getSize(){return super.getSize();};

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="weight")
    public double getWeight(){return super.getWeight();};

    public Filter(){
    }


    public Integer getId() {
        return id;
    }
}
