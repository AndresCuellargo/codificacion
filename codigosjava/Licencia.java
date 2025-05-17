abstract class Licencia {
    protected String tipo;
    protected double costo;
    protected int duracion;

    public double getCosto() {
        return costo;
    }

    public int getDuracion() {
        return duracion;
    }
}

class LicenciaA extends Licencia {
    public LicenciaA() {
        tipo = "A";
        costo = 500000;
        duracion = 4;
    }
}

class LicenciaB extends Licencia {
    public LicenciaB() {
        tipo = "B";
        costo = 700000;
        duracion = 6;
    }
}

class LicenciaC extends Licencia {
    public LicenciaC() {
        tipo = "C";
        costo = 900000;
        duracion = 8;
    }
}

class Estudiante {
    private String id, nombres, apellidos, direccion, telefono, rh;
    private Licencia licencia;

    public Estudiante(String id, String nombres, String apellidos, String direccion, String telefono, String rh,
            Licencia licencia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rh = rh;
        this.licencia = licencia;
    }

    public double calcularValorPagar() {
        return licencia.getCosto();
    }

    public int getDuracionCurso() {
        return licencia.getDuracion();
    }
}
