package com.company;

public class Tyres {
    enum  TyresCompound {
        NOT_INSTALLED,
        SOFT,
        MEDIUM,
        HARD
    };

    TyresCompound installedTyres;
    int tyreWear;

    Tyres() {
        installedTyres = TyresCompound.NOT_INSTALLED;
    }

    int GetTyreWear() {
        return tyreWear;
    }

    void SetTyres(TyresCompound newTyres) {
        installedTyres = newTyres;
        tyreWear = 0;
    }

    TyresCompound GetTyres() {
        return installedTyres;
    }
}
