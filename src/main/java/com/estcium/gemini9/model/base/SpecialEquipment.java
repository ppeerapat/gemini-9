package com.estcium.gemini9.model.base;

import com.estcium.gemini9.model.ObservingProgram;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "special_equipment")
@SequenceGenerator(name = "special_equipment_id_seq",sequenceName = "special_equipment_id_seq",allocationSize = 1)
public class SpecialEquipment extends com.estcium.gemini9.ocs.model.SpecialEquipment {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "lens_id_seq")
    private Integer id;

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="name")
    public String getEquipmentName(){return super.getEquipmentName();}

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="owner")
    public String getOwnerName(){return super.getOwnerName();}

    @Access(AccessType.PROPERTY)
    @Override
    @Column(name="date")
    public Date getInstalledDate(){return super.getInstalledDate();}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_id")
    private ObservingProgram observingProgram;

}
