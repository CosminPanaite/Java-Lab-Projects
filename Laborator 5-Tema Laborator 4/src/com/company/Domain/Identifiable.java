package com.company.Domain;


public interface Identifiable<Tid>{
    Tid getID();
    void setID(Tid id);
}
