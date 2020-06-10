package com.estcium.gemini9.model;

import com.estcium.gemini9.model.base.Lens;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "lens_id_seq",sequenceName = "lens_id_seq",allocationSize = 1)
@AttributeOverrides({
        @AttributeOverride(name="make",column=@Column(name="make")),
        @AttributeOverride(name="model",column=@Column(name="model")),
        @AttributeOverride(name="manufacturer",column=@Column(name="manufacturer")),
        @AttributeOverride(name="year",column=@Column(name="year"))
})
public class LensDB extends Lens {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "lens_id_seq")
    private Integer id;

}
