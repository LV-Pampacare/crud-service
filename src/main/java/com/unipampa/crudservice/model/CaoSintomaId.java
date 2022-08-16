package com.unipampa.crudservice.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CaoSintomaId implements Serializable {
    @Column(name="cao_id")
    private UUID caoId;

    @Column(name="sintoma_id")
    private UUID sintomaId;
  
    public CaoSintomaId(UUID caoId, UUID sintomaId){
        this.caoId = caoId;
        this.sintomaId = sintomaId;
    }
    public CaoSintomaId(){
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caoId == null) ? 0 : caoId.hashCode());
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
        CaoSintomaId other = (CaoSintomaId) obj;
        if (caoId == null) {
            if (other.caoId != null)
                return false;
        } else if (!caoId.equals(other.caoId))
            return false;
        if (sintomaId == null) {
            if (other.sintomaId != null)
                return false;
        } else if (!sintomaId.equals(other.sintomaId))
            return false;
        return true;
    }
}
