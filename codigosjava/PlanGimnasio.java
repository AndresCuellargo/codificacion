abstract class PlanGimnasio {
    protected String nombre;
    protected double precio;

    public PlanGimnasio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract List<String> getServicios();

    public double getPrecio() {
        return precio;
    }
}

class PlanBasico extends PlanGimnasio {
    public PlanBasico() {
        super("Básico", 100000);
    }

    public List<String> getServicios() {
        return Arrays.asList("Acceso general");
    }
}

class PlanMedio extends PlanGimnasio {
    public PlanMedio() {
        super("Medio", 150000);
    }

    public List<String> getServicios() {
        return Arrays.asList("Acceso general", "Clases dirigidas");
    }
}

class PlanPremium extends PlanGimnasio {
    public PlanPremium() {
        super("Premium", 200000);
    }

    public List<String> getServicios() {
        return Arrays.asList("Acceso general", "Clases dirigidas", "Entrenador personal", "Zona húmeda");
    }
}

class UsuarioGimnasio {
    private String id, nombres, apellidos;
    private double peso, estatura;
    private PlanGimnasio plan;

    public UsuarioGimnasio(String id, String nombres, String apellidos, double peso, double estatura,
            PlanGimnasio plan) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.peso = peso;
        this.estatura = estatura;
        this.plan = plan;
    }

    public void mostrarServicios() {
        System.out.println("Servicios del plan " + plan.nombre + ": " + plan.getServicios());
    }

    public double calcularCosto() {
        return plan.getPrecio();
    }
}
