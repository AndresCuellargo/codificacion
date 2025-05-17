abstract class HoraExtra {
    protected int cantidadHoras;
    protected double porcentajePago;

    public HoraExtra(int cantidadHoras, double porcentajePago) {
        this.cantidadHoras = cantidadHoras;
        this.porcentajePago = porcentajePago;
    }

    public double calcularPago(double salarioBase) {
        double valorHora = salarioBase / 160;
        return cantidadHoras * valorHora * porcentajePago;
    }
}

class HoraDiurna extends HoraExtra {
    public HoraDiurna(int cantidadHoras) {
        super(cantidadHoras, 1.25);
    }
}

class HoraNocturna extends HoraExtra {
    public HoraNocturna(int cantidadHoras) {
        super(cantidadHoras, 1.75);
    }
}

class HoraFestiva extends HoraExtra {
    public HoraFestiva(int cantidadHoras) {
        super(cantidadHoras, 2.00);
    }
}

class Empleado {
    private String nombre;
    private double salarioBase;
    private int nivelRiesgo;
    private List<HoraExtra> horasExtras = new ArrayList<>();
    private static final double SMMLV = 1300000;

    public Empleado(String nombre, double salarioBase, int nivelRiesgo) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.nivelRiesgo = nivelRiesgo;
    }

    public void agregarHoraExtra(HoraExtra h) {
        horasExtras.add(h);
    }

    public double calcularSubsidio() {
        return salarioBase < 2 * SMMLV ? SMMLV : 0;
    }

    public double calcularPagoExtras() {
        double total = 0;
        for (HoraExtra h : horasExtras) {
            total += h.calcularPago(salarioBase);
        }
        return total;
    }

    public double calcularDeducciones() {
        double salud = salarioBase * 0.04;
        double pension = salarioBase * 0.04;
        double arl = salarioBase * (0.005 * nivelRiesgo);
        return salud + pension + arl;
    }

    public double calcularPagoTotal() {
        return salarioBase + calcularSubsidio() + calcularPagoExtras() - calcularDeducciones();
    }

    public String getResumenPago() {
        return "Empleado: " + nombre + "\nSalario Base: " + salarioBase +
                "\nSubsidio: " + calcularSubsidio() +
                "\nExtras: " + calcularPagoExtras() +
                "\nDeducciones: " + calcularDeducciones() +
                "\nPago Total: " + calcularPagoTotal();
    }
}
