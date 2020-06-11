package com.estcium.gemini9.model.base;

import javax.persistence.*;

@Entity
@Table(name="lens")
@SequenceGenerator(name = "lens_id_seq",sequenceName = "lens_id_seq",allocationSize = 1)
public class Lens extends edu.gemini.app.ocs.model.Lens {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "lens_id_seq")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Lens(){
    }
}
