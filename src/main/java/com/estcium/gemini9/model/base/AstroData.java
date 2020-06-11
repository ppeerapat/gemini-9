package com.estcium.gemini9.model.base;

import com.estcium.gemini9.model.ObservingProgram;

import javax.persistence.*;

@Entity
@Table(name = "astros")
@SequenceGenerator(name = "astros_id_seq",sequenceName = "astros_id_seq",allocationSize = 1)
public class AstroData {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "astros_id_seq")
    private Integer id;

    private String name;

    private String type;

    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_id")
    private ObservingProgram observingProgram;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ObservingProgram getObservingProgram() {
        return observingProgram;
    }

    public void setObservingProgram(ObservingProgram observingProgram) {
        this.observingProgram = observingProgram;
    }

    public Integer getId() {
        return id;
    }
}