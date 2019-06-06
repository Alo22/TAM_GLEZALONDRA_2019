package mx.edu.ittepic.laboratorio_3;

public class Alumnos {

    private String numerocontrol ;
    private String name;
    private String u1;
    private String u2;
    private String u3;
    private String u4;

    public Alumnos() {
    }

    public Alumnos(String numerocontrol, String name, String u1, String u2, String u3, String u4) {
        this.numerocontrol = numerocontrol;
        this.name = name;
        this.u1 = u1;
        this.u2 = u2;
        this.u3 = u3;
        this.u4 = u4;
    }


    public String getNumerocontrol() {
        return numerocontrol;
    }

    public String getName() {
        return name;
    }

    public String getU1() {
        return u1;
    }

    public String getU2() {
        return u2;
    }

    public String getU3() {
        return u3;
    }

    public String getU4() {
        return u4;
    }


    public void setNumerocontrol(String numerocontrol) {
        this.numerocontrol = numerocontrol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setU1(String u1) {
        this.u1= u1;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }

    public void setU3(String u3) {
        this.u3 = u3;
    }

    public void setU4(String u4) {
        this.u4 = u4;
    }


}
