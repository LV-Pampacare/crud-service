package com.unipampa.crudservice.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmostraSintomaId implements Serializable {
    @Column(name="amostra_id")
    private UUID amostraId;

    @Column(name="sintoma_id")
    private UUID sintomaId;
  
    public AmostraSintomaId(UUID amostraId, UUID sintomaId){
        this.amostraId = amostraId;
        this.sintomaId = sintomaId;
    }
    public AmostraSintomaId(){
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amostraId == null) ? 0 : amostraId.hashCode());
        result = prime * result + ((sintomaId == null) ? 0 : sintomaId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AmostraSintomaId other = (AmostraSintomaId) obj;
        if (amostraId == null) {
            if (other.amostraId != null)
                return false;
        } else if (!amostraId.equals(other.amostraId))
            return false;
        if (sintomaId == null) {
            if (other.sintomaId != null)
                return false;
        } else if (!sintomaId.equals(other.sintomaId))
            return false;
        return true;
    }
}
