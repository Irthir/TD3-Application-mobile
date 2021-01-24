package com.example.listepersonnalisedesplantes;

public class Planete {
    private String sNomPlanete;
    private String sDistancePlanete;
    private int nImagePlanete;

    //Les Accesseurs
    public String getNomPlanete()
    {
        return sNomPlanete;
    }

    public String getDistancePlanete()
    {
        return sDistancePlanete;
    }

    public int getImagePlanete()
    {
        return nImagePlanete;
    }

    //Les Mutateurs
    public void setNomPlanete(String sNomPlanete)
    {
        this.sNomPlanete = sNomPlanete;
    }

    public void setDistancePlanete(String sDistancePlanete)
    {
        this.sDistancePlanete = sDistancePlanete;
    }

    public void setImagePlanete(int nImagePlanete)
    {
        this.nImagePlanete=nImagePlanete;
    }

}
